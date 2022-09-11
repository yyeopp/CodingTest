package todo;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14503 {

	static int N, M;
	static int[][] map;
	static boolean[][] cleaned;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cleaned = new boolean[N][M];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cleaned[r][c] = true;

		int left = getLeft(d);
		int count = 0;
		int status = 1;
		int result = 1;

		while (status != 4) {
			if (status == 1) {
				if (checkLeft(r, c, d)) {
					count = 0;
					result++;
					d = left;
					left = getLeft(left);
					r += dx[d];
					c += dy[d];
					cleaned[r][c] = true;
					status = 1;
				} else {
					count++;
					status = 2;
				}
			} else if (status == 2) {
				d = left;
				left = getLeft(left);
				if (count == 4) {
					status = 3;
					count = 0;
				} else {
					status = 1;
				}
			} else if (status == 3) {
				if (checkBack(r, c, d)) {
					int back = getBack(d);
					r += dx[back];
					c += dy[back];
					status = 1;
				} else {
					status = 4;
				}
			}
		}

		System.out.println(result);

	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static int getLeft(int d) {
		return (d + 3) % 4;
	}

	private static int getBack(int d) {
		return (d + 2) % 4;
	}

	private static boolean checkLeft(int r, int c, int d) {

		int left = getLeft(d);

		int x = r + dx[left];
		int y = c + dy[left];

		if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 1 || cleaned[x][y]) {
			return false;
		}
		return true;
	}

	private static boolean checkBack(int r, int c, int d) {

		int back = getBack(d);
		int x = r + dx[back];
		int y = c + dy[back];

		if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 1) {
			return false;
		}
		return true;

	}

}
