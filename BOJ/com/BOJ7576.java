package todo;

import java.io.*;
import java.util.*;

public class BOJ7576 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] checked = new boolean[N][M];

		Queue<int[]> queue = new LinkedList<int[]>();

		int seed = 0;
		int next = 0;

		int sum = 0;
		int space = 0;

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.add(new int[] { i, j });
					seed++;
					checked[i][j] = true;
				} else if (map[i][j] == -1) {
					space++;
				}
			}
		}
		int time = 0;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {

			int[] tomato = queue.poll();
			sum++;

			if (seed == 0) {
				time++;
				seed = next;
				next = 0;
			}

			for (int i = 0; i < 4; i++) {
				int x = tomato[0] + dx[i];
				int y = tomato[1] + dy[i];

				if (x < 0 || x >= N || y < 0 || y >= M || checked[x][y]) {
					continue;
				}
				if (map[x][y] == 0) {
					queue.add(new int[] { x, y });
					checked[x][y] = true;

					next++;
				}

			}
			seed--;

		}
		if (sum == N * M - space) {
			System.out.println(time);
		} else {
			System.out.println(-1);
		}

	}

}
