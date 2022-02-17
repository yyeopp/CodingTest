package com;

import java.io.*;

public class boj1992 {

	static int N;
	static int[][] map;
	static StringBuilder sb;

	static void quad(int size, int x, int y) {
		int temp = 0;

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				temp += map[i][j];
			}
		}

		if (temp == 0) {
			sb.append(0);
			return;
		}
		if (temp == size * size) {
			sb.append(1);
			return;
			
		} else {
			sb.append("(");
			int half = size / 2;
			quad(half, x, y);
			quad(half, x, y + half);
			quad(half, x + half, y);
			quad(half, x + half, y + half);

		}
		sb.append(")");

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}

		// solve
		
		quad(N,0,0);
		System.out.println(sb);

	}

}
