package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10163 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[1001][1001];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = a; j < a + x; j++) {
				for (int k = b; k < b + y; k++) {
					map[j][k] = i;
				}
			}
		}

		int[] result = new int[N + 1];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				result[map[i][j]]++;
			}
		}

		for (int i = 1; i < result.length; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}

}
