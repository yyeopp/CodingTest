package com;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] tc = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> idxst = new Stack<>();
		int maxV = 0;
		for (int i = 0; i < tc.length; i++) {
			tc[i] = Integer.parseInt(st.nextToken());
			stack.push(tc[i]);
			idxst.push(i + 1);

			if (tc[i] > maxV) {
				stack.clear();
				maxV = tc[i];
				stack.push(tc[i]);
				sb.append(0).append(" ");

				idxst.clear();
				idxst.push(i + 1);

				continue;
			}

			stack.pop();
			idxst.pop();

			if (tc[i] <= maxV) {
				int a = idxst.size();
				for (int j = 0; j < a; j++) {

					int k = stack.peek();

					if (k >= tc[i]) {

						sb.append(idxst.peek()).append(" ");
						stack.push(tc[i]);
						idxst.push(i + 1);
						break;
					} else {
						stack.pop();
						idxst.pop();

					}
				}
			}

		}
		System.out.println(sb);

	}

}
