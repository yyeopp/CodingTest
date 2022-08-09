package todo;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2580 {

	static int[][] map;
	static boolean[][] fixed;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		map = new int[9][9];
		fixed = new boolean[9][9];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					fixed[i][j] = true;
				}
			}
		}
		sudoku(0, 0);

	}

	private static void sudoku(int x, int y) {

		if (x == 9) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		if (!fixed[x][y]) {
			for (int i = 1; i <= 9; i++) {
				map[x][y] = i;
				if (isAble(x, y)) {
					if (y >= 8) {
						sudoku(x + 1, 0);
					} else {
						sudoku(x, y + 1);
					}
				}
				map[x][y] = 0;
			}
		} else {
			if (y >= 8) {
				sudoku(x + 1, 0);
			} else {
				sudoku(x, y + 1);
			}
		}

	}

	private static boolean isAble(int x, int y) {
		boolean result = checkX(x) && checkY(y) && checkZ(x, y);
		return result;
	}

	private static boolean checkX(int x) {
		boolean result = true;
		boolean[] check = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (map[x][i] != 0) {
				if (check[map[x][i]]) {
					result = false;
					break;
				}
				check[map[x][i]] = true;
			}
		}
		return result;
	}

	private static boolean checkY(int y) {
		boolean result = true;
		boolean[] check = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (map[i][y] != 0) {
				if (check[map[i][y]]) {
					result = false;
					break;
				}
				check[map[i][y]] = true;
			}
		}
		return result;
	}

	private static boolean checkZ(int x, int y) {
		int a = (x / 3) * 3;
		int b = (y / 3) * 3;

		boolean result = true;
		boolean[] check = new boolean[10];

		for (int i = a; i < a + 3; i++) {
			for (int j = b; j < b + 3; j++) {
				if (map[i][j] != 0) {
					if (check[map[i][j]]) {
						result = false;
						break;
					}
					check[map[i][j]] = true;
				}
			}
		}
		return result;

	}

}
