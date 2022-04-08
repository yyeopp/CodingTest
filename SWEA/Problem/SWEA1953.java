package todo;

import java.io.*;
import java.util.*;

public class SWEA1953 {

	private static class Tunel {
		int x;
		int y;
		int type;

		public Tunel(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}

		@Override
		public String toString() {
			return "Tunel [x=" + x + ", y=" + y + "]";
		}

	}

	private static boolean able(int type, int direction) {
		if (type == 1) {
			return true;
		} else {
			if (direction == 0) {
				if (type == 2 || type == 4 || type == 7)
					return true;
				else
					return false;
			}
			if (direction == 1) {
				if (type == 2 || type == 5 || type == 6)
					return true;
				else
					return false;
			}
			if (direction == 2) {
				if (type == 3 || type == 6 || type == 7)
					return true;
				else
					return false;

			} else {
				if (type == 3 || type == 4 || type == 5)
					return true;
				else
					return false;
			}
		}

	}

	private static boolean ableNext(int next, int direction) {
		if (next == 0) {
			return false;
		} else if (next == 1) {
			return true;
		} else {
			if (direction == 0) {
				if (next == 2 || next == 5 || next == 6)
					return true;
				else
					return false;
			}
			if (direction == 1) {
				if (next == 2 || next == 4 || next == 7)
					return true;
				else
					return false;
			}
			if (direction == 2) {
				if (next == 3 || next == 4 || next == 5)
					return true;
				else
					return false;
			} else {
				if (next == 3 || next == 6 || next == 7)
					return true;
				else
					return false;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];
			boolean[][] checked = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = 0;
			Queue<Tunel> queue = new LinkedList<Tunel>();
			queue.offer(new Tunel(R, C, map[R][C]));
			checked[R][C] = true;
			result++;

			int hour = 0;
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };

			while (!queue.isEmpty()) {
				if (hour == L - 1)
					break;

				int size = queue.size();

				while (size-- > 0) {
					Tunel tunel = queue.poll();
					for (int j = 0; j < 4; j++) {
						int x = tunel.x + dx[j];
						int y = tunel.y + dy[j];
						if (x < 0 || x >= N || y < 0 || y >= M || !able(tunel.type, j)) {
							continue;
						} else {
							if (ableNext(map[x][y], j) && !checked[x][y]) {
								queue.offer(new Tunel(x, y, map[x][y]));
								result++;
								checked[x][y] = true;
							}
						}
					}
				}
				hour++;

			}

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
