package todo;

import java.io.*;
import java.util.*;

public class BOJ17144 {

	static class Dust {
		int x;
		int y;
		int d;

		public Dust(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int R;
	static int C;

	static int[] ac;
	static ArrayList<Dust> dusts;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		ac = new int[2];
		boolean acFlag = false;

		dusts = new ArrayList<>();

		int[][] map = new int[R][C];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1 && !acFlag) {
					ac[0] = i;
					ac[1] = i + 1;
					acFlag = true;
				}

				if (map[i][j] > 0) {
					dusts.add(new Dust(i, j, map[i][j]));
				}
			}
		}
		for (int i = 0; i < T; i++) {
			map = spread(map);
			map = flow(map);
			checkDust(map);
		}

		int answer = 0;

		for (Dust dust : dusts) {
			answer += dust.d;
		}

		System.out.println(answer);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int[][] spread(int[][] map) {

		int[][] result = new int[R][C];

		for (Dust dust : dusts) {
			int count = 0;
			for (int i = 0; i < 4; i++) {
				int x = dx[i] + dust.x;
				int y = dy[i] + dust.y;

				if (x < 0 || x >= R || y < 0 || y >= C || (y == 0 && (x == ac[0] || x == ac[1]))) {
					continue;
				}
				result[x][y] += dust.d / 5;

				count++;
			}

			result[dust.x][dust.y] += dust.d - (dust.d / 5) * count;
		}

		return result;
	}

	static int[] tdx = { 0, -1, 0, 1 };
	static int[] tdy = { 1, 0, -1, 0 };

	static int[] bdx = { 0, 1, 0, -1 };
	static int[] bdy = { 1, 0, -1, 0 };

	private static int[][] flow(int[][] map) {

		int[][] result = new int[R][C];

		for (int i = 1; i < ac[0]; i++) {
			for (int j = 1; j < C - 1; j++) {
				result[i][j] = map[i][j];
			}
		}

		for (int i = ac[1] + 1; i < R - 1; i++) {
			for (int j = 1; j < C - 1; j++) {
				result[i][j] = map[i][j];
			}
		}

		int[] top = { ac[0], 0 };

		top: for (int i = 0; i < 4; i++) {

			while (true) {

				int tx = tdx[i] + top[0];
				int ty = tdy[i] + top[1];

				if (tx == ac[0] && ty == 0) {
					break top;
				}

				if (tx < 0 || tx >= R || ty < 0 || ty >= C) {
					break;
				}

				result[tx][ty] = map[top[0]][top[1]];
				top[0] = tx;
				top[1] = ty;

			}
		}

		int[] bot = { ac[1], 0 };

		bot: for (int i = 0; i < 4; i++) {

			while (true) {

				int bx = bdx[i] + bot[0];
				int by = bdy[i] + bot[1];

				if (bx == ac[1] && by == 0) {
					break bot;
				}

				if (bx < 0 || bx >= R || by < 0 || by >= C) {
					break;
				}

				result[bx][by] = map[bot[0]][bot[1]];
				bot[0] = bx;
				bot[1] = by;

			}
		}
		return result;

	}

	private static void checkDust(int[][] map) {
		dusts.clear();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] > 0) {
					dusts.add(new Dust(i, j, map[i][j]));
				}
			}
		}
	}

}
