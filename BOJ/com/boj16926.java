package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj16926 {

	static int N, M, R, b;
	static int[][] map;

	public static void spin(int a) {
		if (a == b) {
			return;
		}

		int temp = map[a][a];
		int[] pos = { a, a };
		while (pos[1] != map[a].length - a - 1) {
			map[pos[0]][pos[1]] = map[pos[0]][pos[1] + 1];
			pos[1]++;
		}
		while (pos[0] != map.length - a - 1) {
			map[pos[0]][pos[1]] = map[pos[0] + 1][pos[1]];
			pos[0]++;
		}
		while (pos[1] != a) {
			map[pos[0]][pos[1]] = map[pos[0]][pos[1] - 1];
			pos[1]--;
		}
		while (pos[0] != a + 1) {
			map[pos[0]][pos[1]] = map[pos[0] - 1][pos[1]];
			pos[0]--;
		}
		map[pos[0]][pos[1]] = temp;

		spin(a + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		b = Math.min(N, M) / 2;

		for (int i = 0; i < R; i++) {
			spin(0);
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
