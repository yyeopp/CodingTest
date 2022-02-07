package swea;

import java.io.*;
import java.util.Stack;

public class SWEA1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());
			char[] list = new char[N];
			list = br.readLine().toCharArray();
			boolean breaked = false;

			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < list.length; i++) {

				if (list[i] == '(' || list[i] == '{' || list[i] == '[' || list[i] == '<') {
					stack.push(list[i]);
					continue;
				}

				if (list[i] == ')') {
					if (stack.peek() == '(') {
						stack.pop();
						continue;
					} else {
						sb.append(0 + "\n");
						breaked = true;
						break;
					}

				}
				if (list[i] == '}') {
					if (stack.peek() == '{') {
						stack.pop();
						continue;
					} else {
						sb.append(0 + "\n");
						breaked = true;
						break;
					}

				}
				if (list[i] == ']') {
					if (stack.peek() == '[') {
						stack.pop();
						continue;
					} else {
						sb.append(0 + "\n");
						breaked = true;
						break;
					}

				}
				if (list[i] == '>') {
					if (stack.peek() == '<') {
						stack.pop();
						continue;
					} else {
						sb.append(0 + "\n");
						breaked = true;
						break;
					}

				}

			}
			if (stack.size() == 0) {
				sb.append(1 + "\n");
			}
			if (stack.size() != 0 && breaked == false) {
				sb.append(0 + "\n");
			}

		}

		System.out.print(sb);
	}

}
