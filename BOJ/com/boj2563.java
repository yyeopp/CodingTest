package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[][] map = new int[100][100];
		int result = 0;
		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] pos = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			for (int j = pos[0]; j < pos[0] + 10; j++) {
				if (j > 99) {
					break;
				}
				for (int k = pos[1]; k < pos[1] + 10; k++) {
					if (k > 99) {
						break;
					}
					map[j][k]++;
				}
			}

		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] > 0) {
					result ++;
				}
			}
		}
		System.out.println(result);
	}

}
