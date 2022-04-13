package todo;

import java.io.*;
import java.util.Stack;

public class BOJ1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int idx = 1;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (idx <= x) {
				for (int j = idx; j <= x; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				stack.pop();
				sb.append("-").append("\n");
				idx = x + 1;
				continue;
			} else {
				if (stack.peek() == x) {
					stack.pop();
					sb.append("-").append("\n");
					continue;
				} else {
					sb.setLength(0);
					sb.append("NO");
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
