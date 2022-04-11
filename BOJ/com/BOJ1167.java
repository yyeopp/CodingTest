package todo;

import java.io.*;
import java.util.*;

public class BOJ1167 {

	static int V;
	@SuppressWarnings("rawtypes")
	static ArrayList[] list;
	static boolean[] checked;
	static int result;
	static int max;
	static int idx;

	private static void dfs(int v) {

		checked[v] = true;

		for (int i = 0; i < list[v].size(); i++) {
			int[] g = (int[]) list[v].get(i);
			if (!checked[g[0]]) {
				result += g[1];
				dfs(g[0]);
				result -= g[1];
				checked[g[0]] = false;
			}
		}

		if (result > max) {
			max = result;
			idx = v;
			return;
		}

	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			while (g != -1) {
				int w = Integer.parseInt(st.nextToken());
				list[v].add(new int[] { g, w });
				g = Integer.parseInt(st.nextToken());
			}
		}

		checked = new boolean[V + 1];
		result = 0;
		max = 0;
		dfs(1);

		// DFS 두번. 아무거나 잡고 한번 늘리고, 그 끝에서 잡고 한번 늘리고.
		Arrays.fill(checked, false);
		result = 0;
		max = 0;
		dfs(idx);
		System.out.println(max);
	}

}
