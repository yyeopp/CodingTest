package todo;

import java.io.*;
import java.util.*;

public class BOJ11724 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList[] list = new ArrayList[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		int[] startPoints = new int[M];
		boolean[] appeared = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			startPoints[i] = u;
			list[v].add(u);
			appeared[u] = true;
			appeared[v] = true;
		}

		boolean[] checked = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		int result = 0;

		for (int i = 0; i < M; i++) {

			if (checked[startPoints[i]]) {
				continue;
			}

			queue.add(startPoints[i]);

			checked[startPoints[i]] = true;

			while (!queue.isEmpty()) {
				int x = queue.poll();
				for (int j = 0; j < list[x].size(); j++) {
					int n = (int) list[x].get(j);
					if (!checked[n]) {
						queue.add(n);
						checked[n] = true;
					}
				}
			}
			result++;
		}

		for (int i = 1; i <= N; i++) {
			if (!appeared[i]) {
				result++;
			}
		}

		System.out.println(result);

	}

}
