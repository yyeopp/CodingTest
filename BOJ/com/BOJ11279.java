package todo;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pQ.isEmpty()) {
					sb.append(0);
				} else {
					sb.append(pQ.poll());
				}
				sb.append("\n");
			} else {
				pQ.add(x);
			}
		}
		System.out.println(sb);
	}

}
