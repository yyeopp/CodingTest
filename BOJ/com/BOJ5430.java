package todo;

import java.io.*;
import java.util.*;

public class BOJ5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			char[] orders = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String line = br.readLine();
			String[] nums = line.substring(1, line.length() - 1).split(",");
			Deque<Integer> deque = new LinkedList<Integer>();
			boolean reverse = false;
			String result = null;

			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(nums[i]));
			}

			for (int i = 0; i < orders.length; i++) {
				if (orders[i] == 'R') {
					reverse = !reverse;
				} else {
					if (reverse) {
						if (deque.pollLast() == null) {
							result = "error";
							break;
						}
					} else {
						if (deque.pollFirst() == null) {
							result = "error";
							break;
						}
					}
				}
			}

			if (result == null) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				while (!deque.isEmpty()) {
					if (reverse) {
						sb.append(deque.pollLast()).append(",");
					} else {
						sb.append(deque.pollFirst()).append(",");
					}
				}
				if (sb.length() > 1) {
					sb.setLength(sb.length() - 1);
				}
				sb.append("]");
				result = sb.toString();
			}
			answer.append(result).append("\n");

		}
		System.out.println(answer);
	}

}
