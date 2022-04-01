package com;

import java.io.*;

public class BOJ1003 {

	static int[][] call;
	static int[] result;

	private static int fibonacci(int start, int present) {

		if (present == 0) {
			call[start][0]++;
			return 0;
		} else if (present == 1) {
			call[start][1]++;
			return 1;
		} else {
			if (call[present][0] != 0 || call[present][1] != 0) {
				if (call[present][0] != 0) {
					call[start][0] += call[present][0];
				}
				if (call[present][1] != 0) {
					call[start][1] += call[present][1];
				}
				return 0;
			} else {
				return fibonacci(start, present - 1) + fibonacci(start, present - 2);
			}
		}

	}

	private static void fill(int N) {
		for (int i = 0; i <= N; i++) {
			if (call[i][0] == 0 && call[i][1] == 0) {
				fibonacci(i, i);
			} else {
				continue;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		call = new int[41][2];
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			fill(N);
			sb.append(call[N][0]).append(" ").append(call[N][1]).append("\n");
		}
		System.out.println(sb);
	}

}
