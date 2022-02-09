package com;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2578 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[5][5];
		boolean[][] check = new boolean[5][5];
		boolean[][] spin = new boolean[5][5];
		boolean[] degak = new boolean[5];
		boolean[] bingo = { true, true, true, true, true };

		for (int i = 0; i < 5; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}

		
		
		int[][] order = new int[5][5];
		int count = 0;
		
		
		bingo: for (int i = 0; i < 5; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				order[i][j] = Integer.parseInt(st2.nextToken());
				count++;
				check: for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (order[i][j] == map[k][l]) {
							check[k][l] = true;
							break check;
						}
					}
				}

				if (count >= 12) {
					int bingoCnt = 0;
					// 가로
					for (int k = 0; k < 5; k++) {
						if (Arrays.equals(check[k], bingo)) {
							bingoCnt++;
						}
					}

					if (bingoCnt >= 3)
						break bingo;
					
					// 세로
					for (int k = 0; k < 5; k++) {
						for (int l = 0; l < 5; l++) {
							spin[k][l] = check[4 - l][k];
						}
					}
					
					for (int k = 0; k < 5; k++) {
						if (Arrays.equals(spin[k], bingo)) {
							bingoCnt++;
						}
					}

					if (bingoCnt >= 3)
						break bingo;
					
					// 대각
					for (int k = 0; k < 5; k++) {
						degak[k] = check[k][k];
					}
					if (Arrays.equals(degak, bingo)) {
						bingoCnt++;
					}

					if (bingoCnt >= 3)
						break bingo;
					
					// 대각
					for (int k = 0; k < 5; k++) {
						degak[k] = check[k][4 - k];
					}
					if (Arrays.equals(degak, bingo)) {
						bingoCnt++;
					}

					if (bingoCnt >= 3)
						break bingo;

				}

			}
		}
		System.out.println(count);

	}

}
