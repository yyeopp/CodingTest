package todo;

import java.io.*;
import java.util.*;

public class BOJ11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int count = N;
		Queue<Integer> queue = new LinkedList<Integer>();

		sb.append("<");
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while (count > 0) {
			for (int i = 1; i < K; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
			count--;
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);

	}

}
