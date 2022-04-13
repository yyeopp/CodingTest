package com;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (st.countTokens() == 2) {
				st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				stack.push(a);
				continue;
			} else {
				String o = st.nextToken();
				if (o.equals("top")) {
					if (stack.size() == 0) {
						sb.append(-1);
					} else {
						sb.append(stack.peek());
					}
				} else if (o.equals("size")) {
					sb.append(stack.size());
				} else if (o.equals("empty")) {
					if (stack.isEmpty()) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				} else if (o.equals("pop")) {
					if (stack.size() == 0) {
						sb.append(-1);
					} else {
						sb.append(stack.pop());
					}
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);

	}

}
