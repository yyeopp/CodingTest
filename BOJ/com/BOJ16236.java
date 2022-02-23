package com;

import java.io.*;
import java.util.*;

public class BOJ16236 {
	static int N, size;
	static int[][] map;

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	static int findD(int[] shark, int[] fish) {

		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] checked = new boolean[N][N];
		int[][] depth = new int[N][N];

		queue.offer(shark);
		checked[shark[0]][shark[1]] = true;
		int temp = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (current[0] == fish[0] && current[1] == fish[1]) {
				temp = depth[current[0]][current[1]];

				break;
			}

			for (int i = 0; i < 4; i++) {
				int x = current[0] + dx[i];
				int y = current[1] + dy[i];

				if (x < 0 || x >= N || y < 0 || y >= N || map[x][y] > size || checked[x][y] == true) {
					continue;
				} else {
					queue.offer(new int[] { x, y });
					depth[x][y] = depth[current[0]][current[1]] + 1;
					checked[x][y] = true;
				}

			}
		}
		return temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int M = 0;
		ArrayList<int[]> fish = new ArrayList<>(); // 좌표 + size가 들어감
		int[] shark = new int[2];

		map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
					map[i][j] = 0;
				}
				if (map[i][j] != 0 && map[i][j] != 9) {
					fish.add(new int[] { i, j, map[i][j] });
					M++;
				}
			}
		}
		if (M == 0) {
			System.out.println(0);
		} else {
			size = 2;
			int eat = 0;
			int cnt = 0;
			int time = 0;
			int idx = 0;
			while (eat < M) { 
				int minimumD = Integer.MAX_VALUE;
				int[] minimumP = new int[2];
				for (int i = 0; i < fish.size(); i++) {
					if (fish.get(i)[2] < size) {
						int distance = findD(shark, fish.get(i));
						
						if (distance < minimumD && distance != 0) {
							minimumD = distance;
							minimumP[0] = fish.get(i)[0];
							minimumP[1] = fish.get(i)[1];
							idx = i;
						}
					}
				}

				if (minimumD == Integer.MAX_VALUE || minimumD == 0) {
					break;
				} else {
					eat++;
					cnt++;
					time += minimumD;
					shark[0] = minimumP[0];
					shark[1] = minimumP[1];
					fish.remove(idx);

					map[minimumP[0]][minimumP[1]] = 0;

					if (cnt == size) {
						size++;
						cnt = 0;
					}
				}
			}

			System.out.println(time);

		}

	}

}
