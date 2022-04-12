package todo;

import java.io.*;
import java.util.*;

public class BOJ2458 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList[] nodes = new ArrayList[N + 1];
		ArrayList[] reverse = new ArrayList[N + 1];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new ArrayList<Integer>();
			reverse[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nodes[start].add(end);
			reverse[end].add(start);
		}

		int result = 0;

		for (int i = 1; i < nodes.length; i++) {
			int count = 0;
			boolean[] checked = new boolean[N + 1];
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(i);

			// 아래로
			while (!queue.isEmpty()) {
				int temp = queue.poll();
				checked[temp] = true;
				count++;

				for (int j = 0; j < nodes[temp].size(); j++) {
					int c = (int) nodes[temp].get(j);
					if (checked[c] == false) {
						checked[c] = true;
						queue.offer(c);
					}
				}
			}

			// 위로
			queue.clear();
			Arrays.fill(checked, false);
			queue.offer(i);

			while (!queue.isEmpty()) {
				int temp = queue.poll();
				checked[temp] = true;
				count++;

				for (int j = 0; j < reverse[temp].size(); j++) {
					int c = (int) reverse[temp].get(j);
					if (checked[c] == false) {
						checked[c] = true;
						queue.offer(c);
					}
				}

			}

			if (count == N + 1) {
				result++;
			}
		}
		System.out.println(result);

	}

}
