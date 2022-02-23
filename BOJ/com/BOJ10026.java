package com;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {

	static int N;
	static boolean[][] division;
	static boolean[][] division2;
	static char[][] map;

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	static void divide(char color, int[] start) {

		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] checked = new boolean[N][N];

		queue.offer(start);
		checked[start[0]][start[1]] = true;
		division[start[0]][start[1]] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = current[0] + dx[i];
				int y = current[1] + dy[i];

				if (x < 0 || x >= N || y < 0 || y >= N || checked[x][y] == true || map[x][y] != color) {
					continue;
				} else {
					queue.offer(new int[] { x, y });
					checked[x][y] = true;
					division[x][y] = true;
				}

			}
		}
	}

	static void divide2(char color, int[] start) {

		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] checked = new boolean[N][N];

		queue.offer(start);
		checked[start[0]][start[1]] = true;
		division2[start[0]][start[1]] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = current[0] + dx[i];
				int y = current[1] + dy[i];

				if (x < 0 || x >= N || y < 0 || y >= N || checked[x][y] == true) {
					continue;
				}
				if (color == 'R' || color == 'G') {
					if (map[x][y] == 'B') {
						continue;
					} else {
						queue.offer(new int[] { x, y });
						checked[x][y] = true;
						division2[x][y] = true;
					}
				}
				if (color == 'B') {
					if (map[x][y] == color) {
						queue.offer(new int[] { x, y });
						checked[x][y] = true;
						division2[x][y] = true;
					}
				}

			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		division = new boolean[N][N];
		division2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int count = 0;
		int count2 = 0;
		for (int i = 0; i < division.length; i++) {
			for (int j = 0; j < division[i].length; j++) {

				if (!division[i][j]) {
					divide(map[i][j], new int[] { i, j });
					count++;
				}
				if (!division2[i][j]) {
					divide2(map[i][j], new int[] { i, j });
					count2++;
				}

			}
		}
		System.out.println(count + " " + count2);

	}

}
