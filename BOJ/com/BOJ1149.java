package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1149 {

	static int N;
	static int[][] house;
	static int[][] optimal;

	private static void RGB(int r) {
		for (int i = 0; i < 3; i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < 3; j++) {
				if (optimal[r - 1][j] < temp && i != j) {
					temp = optimal[r - 1][j];
				}
			}

			optimal[r][i] = house[r][i] + temp;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		house = new int[N][3];
		optimal = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());

		}
		for (int i = 0; i < 3; i++) {
			optimal[0][i] = house[0][i];
		}
		for (int i = 1; i < N; i++) {
			RGB(i);
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (result > optimal[N - 1][i]) {
				result = optimal[N - 1][i];
			}
		}
		System.out.println(result);

	}

}
