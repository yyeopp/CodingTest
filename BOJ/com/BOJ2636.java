package com;

import java.io.*;
import java.util.*;

public class BOJ2636 {
	static int H, W;
	static int[][] map;
	static boolean[][] checked;
	static boolean[][] cheese;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void checkOutside(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { x, y });
		checked[x][y] = true;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = pos[0] + dx[i];
				int b = pos[1] + dy[i];
				if (a < 0 || a >= H || b < 0 || b >= W) {
					continue;
				}
				if (map[a][b] == 0 && checked[a][b] == false) {
					checked[a][b] = true;
					queue.offer(new int[] { a, b });
				}
				if (map[a][b] == 1) {
					map[a][b] = 4;
				}
			}
		}
	}

	private static int removeCheese(int cnt) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 4) {
					map[i][j] = 0;
					cnt--;
				}
			}
		}
		for (int i = 0; i < checked.length; i++) {
			Arrays.fill(checked[i], false);
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st1.nextToken());
		W = Integer.parseInt(st1.nextToken());

		map = new int[H][W];
		checked = new boolean[H][W];
		cheese = new boolean[H][W];
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				if (Integer.parseInt(st2.nextToken()) == 1) {
					cheese[i][j] = true;
					map[i][j] = 1;
					count++;
				}

			}
		}
		int temp = 0;
		int time = 0;
		while (count > 0) {
			temp = count;
			check: for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 0 && checked[i][j] == false) {
						checkOutside(i, j);
						break check;
					}

				}
			}

			count = removeCheese(count);
			time++;
		}
		System.out.println(time);
		System.out.println(temp);
	}
}