package todo;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1780 {

	static int[][] map;
	static int a, b, c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);
		sb.append(a).append("\n").append(b).append("\n").append(c);
		System.out.println(sb);
	}

	private static void divide(int x, int y, int size) {

		if (identical(x, y, size)) {
			countPaper(map[x][y]);
		} else {
			divide(x, y, size / 3);
			divide(x, y + size / 3, size / 3);
			divide(x, y + size * 2 / 3, size / 3);
			divide(x + size / 3, y, size / 3);
			divide(x + size / 3, y + size / 3, size / 3);
			divide(x + size / 3, y + size * 2 / 3, size / 3);
			divide(x + size * 2 / 3, y, size / 3);
			divide(x + size * 2 / 3, y + size / 3, size / 3);
			divide(x + size * 2 / 3, y + size * 2 / 3, size / 3);
		}
	}

	private static boolean identical(int x, int y, int size) {

		boolean result = true;
		int temp = map[x][y];
		loop: for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] != temp) {
					result = false;
					break loop;
				}
			}
		}
		return result;
	}

	private static void countPaper(int n) {
		if (n == -1) {
			a++;
		} else if (n == 0) {
			b++;
		} else {
			c++;
		}
	}

}
