package com;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2493_MemoryOver {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] tc = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> st2 = new Stack<>();

		int maxV = 0;
		int idx = 0;

		for (int i = 0; i < tc.length; i++) {
			tc[i] = Integer.parseInt(st.nextToken());
			stack.push(tc[i]); // 일단 스택에 추가

			if (tc[i] >= maxV) { // 혹시 가장 크면 스택 초기화하고 0 출력하고 continue
				stack.clear();
				maxV = tc[i];
				idx = i;
				stack.push(tc[i]);
				sb.append(0).append(" ");
				continue;
			}

			st2 = (Stack<Integer>) stack.clone();

			stack.pop();
			st2.pop();

			if (tc[i] < maxV) {
				for (int j = i; j > idx; j--) {
					int k = st2.pop();
					if (k >= tc[i]) {
						sb.append(j).append(" ");
						stack.push(tc[i]);
						break;
					}
				}
			}

		}
		System.out.println(sb);

	}

}
