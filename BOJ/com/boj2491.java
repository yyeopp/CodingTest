package com;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2491 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = 0;
		boolean init = true;
		boolean up = false;
		boolean down = false;
		Stack<Integer> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			
			
			int temp = Integer.parseInt(st.nextToken());
			if (stack.isEmpty()) {
				stack.add(temp);
				continue;
			}
			if (init) {
				if (temp == stack.peek()) {
					stack.add(temp);
					continue;
				}
				if (temp > stack.peek()) {
					up = true;
					init = false;
					stack.add(temp);
					continue;
				}
				if (temp < stack.peek()) {
					down = true;
					init = false;
					stack.add(temp);
					continue;
				}
			}
			if (!init && up) {
				if (temp >= stack.peek()) {
					stack.add(temp);
					continue;
				}
				if (temp < stack.peek()) {
					if (result <= stack.size()) {
						result = stack.size();

					}
					int count = 1;
					int temp2 = stack.pop();
					while(stack.size() != 0) {
						if(stack.pop() == temp2) {
							count++;
							continue;
						}
						break;
					}
					stack.clear();
					for (int j = 0; j < count; j++) {
						stack.add(temp2);
					}
					stack.add(temp);
					up = false;
					down = true;
					continue;
				}

			}
			if (!init && down) {
				if (temp <= stack.peek()) {
					stack.add(temp);
					continue;
				}
				if (temp > stack.peek()) {
					if (result <= stack.size()) {
						result = stack.size();

					}
					int count = 1;
					int temp2 = stack.pop();
					while(stack.size() != 0) {
						if(stack.pop() == temp2) {
							count++;
							continue;
						}
						break;
					}
					stack.clear();
					for (int j = 0; j < count; j++) {
						stack.add(temp2);
					}
					stack.add(temp);

					down = false;
					up = true;
					continue;
				}

			}
		}
		if (result <= stack.size()) {
			result = stack.size();
		}
		System.out.println(result);
	}

}
