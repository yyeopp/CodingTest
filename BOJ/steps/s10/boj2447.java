package steps.s10;

import java.io.*;

public class BOJ2447 {

	static int N;
	static char[][] map;

	static void star(int size, int x, int y) {

		if (size == 1) {
			map[x][y] = '*';
			return;
		}

		star(size / 3, x, y);
		star(size / 3, x, y + size / 3);
		star(size / 3, x, y + 2 * size / 3);
		star(size / 3, x + size / 3, y);
		star(size / 3, x + size / 3, y + 2 * size / 3);
		star(size / 3, x + 2 * size / 3, y);
		star(size / 3, x + 2 * size / 3, y + size / 3);
		star(size / 3, x + 2 * size / 3, y + 2 * size / 3);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		star(N, 0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != '*') {
					sb.append(' ');
				} else {
					sb.append(map[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}