package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		int[][] max = new int[N][3];
		int[][] min = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			max[0][i] = map[0][i];
			min[0][i] = map[0][i];
		}

		int idx = 1;

		while (true) {

			if (idx == N)
				break;

			// 0
			int tmp1 = max[idx - 1][0] + map[idx][0];
			int tmp2 = max[idx - 1][1] + map[idx][0];
			max[idx][0] = Math.max(tmp1, tmp2);
			tmp1 = min[idx - 1][0] + map[idx][0];
			tmp2 = min[idx - 1][1] + map[idx][0];
			min[idx][0] = Math.min(tmp1, tmp2);

			// 1
			int tmp3 = max[idx - 1][0] + map[idx][1];
			int tmp4 = max[idx - 1][1] + map[idx][1];
			int tmp5 = max[idx - 1][2] + map[idx][1];
			max[idx][1] = Math.max(Math.max(tmp3, tmp4), tmp5);
			tmp3 = min[idx - 1][0] + map[idx][1];
			tmp4 = min[idx - 1][1] + map[idx][1];
			tmp5 = min[idx - 1][2] + map[idx][1];
			min[idx][1] = Math.min(Math.min(tmp3, tmp4), tmp5);

			// 2
			int tmp6 = max[idx - 1][1] + map[idx][2];
			int tmp7 = max[idx - 1][2] + map[idx][2];
			max[idx][2] = Math.max(tmp6, tmp7);
			tmp6 = min[idx - 1][1] + map[idx][2];
			tmp7 = min[idx - 1][2] + map[idx][2];
			min[idx][2] = Math.min(tmp6, tmp7);

			idx++;
		}
		int maxResult = Math.max(Math.max(max[N - 1][0], max[N - 1][1]), max[N - 1][2]);
		int minResult = Math.min(Math.min(min[N - 1][0], min[N - 1][1]), min[N - 1][2]);
		System.out.println(maxResult + " " + minResult);

	}

}
