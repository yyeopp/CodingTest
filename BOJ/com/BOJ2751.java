package todo;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		for (int i = 0; i < N; i++) {
			sb.append(pq.poll()).append("\n");
		}

		System.out.println(sb);
	}

}
