package todo;

import java.io.*;

public class BOJ9663 {

	static int N;
	static int result;

	static boolean[][] map;

	private static void NQueen(int row) {

		if (row >= N) {
			result++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (able(row, i)) {
				map[row][i] = true;
				NQueen(row + 1);
				map[row][i] = false;
			}
		}

	}

	private static boolean able(int x, int y) {
		return ableY(x, y) && ableZ(x, y);
	}

	private static boolean ableY(int x, int y) {
		boolean ableY = true;
		for (int i = 0; i < N; i++) {
			if (map[i][y]) {
				ableY = false;
				break;
			}
		}
		return ableY;
	}

	static int[] dx = { -1, -1, 1, 1 };
	static int[] dy = { -1, 1, -1, 1 };

	private static boolean ableZ(int x, int y) {
		boolean ableZ = true;

		loop: for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			while (true) {

				if (cx < 0 || cx >= N || cy < 0 || cy >= N) {
					continue loop;
				}

				if (map[cx][cy]) {
					ableZ = false;
					break loop;
				}
				cx += dx[i];
				cy += dy[i];
			}

		}
		return ableZ;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new boolean[N][N];
		NQueen(0);
		System.out.println(result);
	}

}
