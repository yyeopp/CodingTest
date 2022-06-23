package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		for (int i = coins.length - 1; i >= 0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		int sum = 0;
		int idx = 0;
		int num = 0;

		while (sum != K) {

			if (sum + coins[idx] > K) {
				idx++;
			} else {
				sum += coins[idx];
				num++;
			}

		}
		System.out.println(num);

	}
}