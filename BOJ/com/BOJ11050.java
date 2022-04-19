package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11050 {

	static int N, K;
	static int[][] binomial;

	static int find(int n, int k) {

		if (binomial[n][k] != 0) {
			return binomial[n][k];
		} else {
			return find(n - 1, k - 1) + find(n - 1, k);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		binomial = new int[11][11];
		for (int i = 1; i < binomial.length; i++) {
			binomial[i][1] = i;
			binomial[i][i] = 1;
		}
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K == 0) {
			System.out.println(1);
		} else {
			int result = find(N, K);
			System.out.println(result);
		}
	}

}
