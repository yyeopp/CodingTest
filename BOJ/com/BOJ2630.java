package todo;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2630 {

	static int N;
	static int[][] map;
	static int white;
	static int blue;

	private static int check(int[] top, int size) {

		boolean check = true;
		int color = map[top[0]][top[1]];

		for (int i = top[0]; i < top[0] + size; i++) {
			for (int j = top[1]; j < top[1] + size; j++) {
				if (map[i][j] != color) {
					check = false;
					break;
				}
			}
		}
		if (check) {
			return color;
		} else {
			return 9;
		}

	}

	private static void divide(int[] top, int size) {

		int color = check(top, size);

		if (color > 1) {
			divide(new int[] { top[0], top[1] }, size / 2);
			divide(new int[] { top[0], top[1] + size / 2 }, size / 2);
			divide(new int[] { top[0] + size / 2, top[1] }, size / 2);
			divide(new int[] { top[0] + size / 2, top[1] + size / 2 }, size / 2);
		} else {
			if (color == 0) {
				white++;
			} else if (color == 1) {
				blue++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		white = 0;
		blue = 0;
		divide(new int[] { 0, 0 }, N);
		System.out.println(white);
		System.out.println(blue);

	}

}
