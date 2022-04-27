package todo;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				if (pQueue.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				} else {
					sb.append(pQueue.poll()).append("\n");
					continue;
				}
			} else {
				pQueue.add(n);
			}
		}
		System.out.println(sb);
	}

}
