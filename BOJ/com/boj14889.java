package com;

import java.io.*;
import java.util.*;

public class boj14889 {

	static int N, result;
	static int min = 40000;
	static boolean[] idx;
	static int[][] map;

	static void Comb(int count, int start) {

		if (count == N / 2 - 1) {
			int[] tmp = new int[N / 2], tmp2 = new int[N / 2];
			int j = 0, k = 0;

			for (int i = 0; i < N; i++) {

				if (idx[i] == true) {
					tmp[j] = i;
					j++;
				}
				if (idx[i] == false) {
					tmp2[k] = i;
					k++;
				}
			}

			int sum = 0;
			int sum2 = 0;

			for (int i = 0; i < tmp.length; i++) {
				for (int l = 0; l < tmp.length; l++) {
					sum += map[tmp[i]][tmp[l]];
					sum2 += map[tmp2[i]][tmp2[l]];
				}
			}

			result = Math.abs(sum - sum2);

			if (result < min) {
				min = result;
			}

			return;
		}
		for (int i = start; i < N; i++) {

			idx[i] = true;

			Comb(count + 1, i + 1);
			idx[i] = false;
			if (min == 0) {
				break;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		idx = new boolean[N];
		idx[0] = true;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		for (int i = 1; i <= N - 1; i++) {
			Comb(0, 1);

		}
		sb.append(min).append("\n");
		min = 40000;
		System.out.println(sb);

	}

}
