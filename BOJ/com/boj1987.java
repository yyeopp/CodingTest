package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj1987 {

	static int R, C, count;
	static int result = 0;
	static char[][] map;
	static boolean[] check;

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	static void move(int cx, int cy) {

		for (int i = 0; i < 4; i++) {
			int x = cx + dx[i];
			int y = cy + dy[i];

			if (x < 0 || x >= R || y < 0 || y >= C) {
				continue;
			}

			if (!able(x, y)) {
				continue;
			}

			if (able(x, y)) {
				check[(int) map[x][y] - 65] = true;
				count++;
				move(x, y);

			}
			if (result <= count) {
				result = count;
			}
			check[(int) map[x][y] - 65] = false;
			count--;
		}

	}

	static boolean able(int x, int y) {

		if (check[(int) map[x][y] - 65]) {
			return false;
		}

		return true;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		check = new boolean[26];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// solve
		count = 1;
		check[(int) map[0][0] - 65] = true;

		move(0, 0);
		if (result >= 1) {
			System.out.println(result);
		}
		else {
			System.out.println(1);
		}
	}

}
