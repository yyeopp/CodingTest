package todo;

import java.io.*;
import java.util.Stack;

public class BOJ1259 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n = br.readLine();

		while (!n.equals("0")) {

			char[] temp = n.toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean pal = true;

			if (temp.length % 2 == 0) {

				int mid = temp.length / 2 - 1;
				for (int i = 0; i <= mid; i++) {
					stack.add(temp[i]);
				}
				for (int i = mid + 1; i < temp.length; i++) {
					char c = stack.pop();
					if (c != temp[i]) {
						pal = false;
						break;
					}
				}

			} else {

				int mid = temp.length / 2;
				for (int i = 0; i < mid; i++) {
					stack.add(temp[i]);
				}
				for (int i = mid + 1; i < temp.length; i++) {
					char c = stack.pop();
					if (c != temp[i]) {
						pal = false;
						break;
					}
				}

			}

			if (pal) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");

			n = br.readLine();

		}
		System.out.println(sb);

	}

}
