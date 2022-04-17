package todo;

import java.io.*;
import java.util.Stack;

public class BOJ9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		loop: for (int tc = 0; tc < T; tc++) {
			char[] ca = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < ca.length; i++) {
				if (ca[i] == '(') {
					stack.push(ca[i]);
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
					} else {
						sb.append("NO").append("\n");
						continue loop;
					}
				}
			}
			if (stack.isEmpty()) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
