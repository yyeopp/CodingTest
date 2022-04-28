package todo;

import java.io.*;
import java.util.*;

public class BOJ2606 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		ArrayList[] list = new ArrayList[N + 1];
		boolean[] checked = new boolean[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		checked[1] = true;
		int result = -1;

		while (!queue.isEmpty()) {
			int c = queue.poll();
			result++;
			for (int i = 0; i < list[c].size(); i++) {
				int d = (int) list[c].get(i);
				if (!checked[d]) {
					queue.offer(d);
					checked[d] = true;
				}
			}
		}
		System.out.println(result);
	}

}
