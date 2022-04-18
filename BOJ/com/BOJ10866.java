package todo;

import java.io.*;
import java.util.*;

public class BOJ10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (st.countTokens() > 1) {
				String order = st.nextToken();
				if (order.equals("push_front")) {
					deque.addFirst(Integer.parseInt(st.nextToken()));
					continue;
				} else if (order.equals("push_back")) {
					deque.addLast(Integer.parseInt(st.nextToken()));
					continue;
				}
			} else {
				String order = st.nextToken();
				if (order.equals("front")) {
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.peekFirst()).append("\n");
					}
				} else if (order.equals("back")) {
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.peekLast()).append("\n");
					}
				} else if (order.equals("size")) {
					sb.append(deque.size()).append("\n");
				} else if (order.equals("pop_front")) {
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.pollFirst()).append("\n");
					}
				} else if (order.equals("pop_back")) {
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(deque.pollLast()).append("\n");
					}
				} else if (order.equals("empty")) {
					if (deque.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
				}
			}
		}
		System.out.println(sb);

	}

}
