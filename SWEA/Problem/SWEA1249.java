package swea;

import java.io.*;
import java.util.*;

public class SWEA1249 {

	static class Position implements Comparable<Position> {
		int x;
		int y;
		int time;

		@Override
		public int compareTo(Position o) {
			return time - o.time;
		}

		public Position(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + ", time=" + time + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());

			char[][] map = new char[N][];
			boolean[][] checked = new boolean[N][N];

			int[] dx = { 1, -1, 0, 0 };
			int[] dy = { 0, 0, 1, -1 };

			for (int i = 0; i < map.length; i++) {
				map[i] = br.readLine().toCharArray();
			}

			PriorityQueue<Position> queue = new PriorityQueue<Position>();
			queue.offer(new Position(0, 0, 0));
			checked[0][0] = true;

			while (!queue.isEmpty()) {
				Position position = queue.poll();

				if (position.x == N - 1 && position.y == N - 1) {
					sb.append(position.time).append("\n");
					break;
				}

				for (int i = 0; i < 4; i++) {
					int x = position.x + dx[i];
					int y = position.y + dy[i];

					if (x < 0 || x >= N || y < 0 || y >= N || checked[x][y]) {
						continue;
					}
					queue.offer(new Position(x, y, map[x][y] + position.time - '0'));
					checked[x][y] = true;

				}

			}

		}
		System.out.println(sb);

	}

}
