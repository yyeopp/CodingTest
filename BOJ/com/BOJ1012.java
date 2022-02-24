package com;

import java.io.*;
import java.util.*;

public class BOJ1012 {

	static boolean[][] map, checked;

	static int M, N, count;

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, 1, -1, 0 };

	static void worm(int[] start) {

		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(start);
		checked[start[0]][start[1]] = true;

		while (!queue.isEmpty()) {

			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = current[0] + dx[i];
				int y = current[1] + dy[i];

				if (x < 0 || x >= M || y < 0 || y >= N || !map[x][y] || checked[x][y]) {
					continue;
				}
				queue.offer(new int[] { x, y });
				checked[x][y] = true;
			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st1.nextToken());
			N = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());

			map = new boolean[M][N];
			checked = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st2.nextToken());
				int Y = Integer.parseInt(st2.nextToken());
				map[X][Y] = true;

			}
			int count = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] && !checked[i][j]) {
						worm(new int[] { i, j });
						count++;
					}
				}
			}
			sb.append(count).append("\n");

		}
		System.out.println(sb);
	}

}
