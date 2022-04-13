package todo;

import java.io.*;
import java.util.*;

public class BOJ10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();

		int N = Integer.parseInt(br.readLine());
		int temp = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (st.countTokens() != 1) {
				st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				queue.offer(a);
				temp = a;
				continue;
			}
			String o = st.nextToken();
			if (o.equals("front")) {
				if (queue.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(queue.peek());
				}
			} else if (o.equals("back")) {
				if (queue.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(temp);
				}
			} else if (o.equals("size")) {
				sb.append(queue.size());
			} else if (o.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1);
				} else {
					sb.append(0);
				}
			} else if (o.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(queue.poll());
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
