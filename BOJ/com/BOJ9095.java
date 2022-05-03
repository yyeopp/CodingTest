package com;

import java.io.*;

public class BOJ9095 {

	static int T, n;

	static int[] ways;

	private static void makeWays(int x) {

		if (x > n) {
			return;
		}

		if (x == n) {
			ways[n]++;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			makeWays(x + i);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ways = new int[11];
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			if (ways[n] == 0) {
				makeWays(0);
				sb.append(ways[n]);
			} else {
				sb.append(ways[n]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
