package todo;

import java.io.*;
import java.util.*;

public class BOJ2638 {

	static int N, M;
	static int[][] map;
	static boolean[][] checked;
	static boolean[][] cheese;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void checkMap() {

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0 });
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			checked[temp[0]][temp[1]] = true;

			for (int i = 0; i < 4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];

				if (x < 0 || x >= N || y < 0 || y >= M) {
					continue;
				}
				if (cheese[x][y]) {
					map[x][y]++;
				} else {
					if (checked[x][y])
						continue;
					queue.offer(new int[] { x, y });
					checked[x][y] = true;
				}
			}
		}
	}

	private static int removeCheese(int remain) {

		int count = remain;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] >= 3) {
					map[i][j] = 0;
					cheese[i][j] = false;
					count--;
				} else if (map[i][j] > 1) {
					map[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < checked.length; i++) {
			Arrays.fill(checked[i], false);
		}
		return count;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		checked = new boolean[N][M];
		cheese = new boolean[N][M];

		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheese[i][j] = true;
					count++;
				}

			}
		}
		int time = 0;

		while (count > 0) {
			checkMap();
			count = removeCheese(count);
			time++;
		}
		System.out.println(time);

	}

}
