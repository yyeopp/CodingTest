package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3109 {

	static int R, C, result;
	static char[][] map;

	static int[] dx = { -1, 0, 1 }; // 우상, 우, 우하 순서 (우선순위)
	static int[] dy = { 1, 1, 1 };
	static boolean flag = false;

	static void pipe(int cx, int cy) {

		if (cy >= C - 1) {
			result++;
			flag = true;
			return;
		}

		for (int i = 0; i < 3; i++) {

			int x = cx + dx[i];
			int y = cy + dy[i];

			if (x < 0 || x >= R || y < 0 || y >= C) {
				continue;
			}

			if (map[x][y] == 'x') {
				continue;
			}
			if (map[x][y] == '.') {
				map[x][y] = 'x';
				pipe(x, y);
			}
			if (flag) {
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			flag = false;
			map[i][0] = 'x';
			pipe(i, 0);

		}
		System.out.println(result);

	}

}
