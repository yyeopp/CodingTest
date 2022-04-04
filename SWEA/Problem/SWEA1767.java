package swea;

import java.io.*;
import java.util.*;

public class SWEA1767 {
	static int N;
	static int[][] map;
	static List<int[]> focusedCores;
	static int numOfCores;
	static int connected;
	static int result;

	static int optConnect;
	static int optResult;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void processor(int idx) {
		if (idx == numOfCores) {
			if (optConnect == connected) {
				if (optResult > result) {
					optResult = result;
				}
				return;
			} else if (optConnect < connected) {
				optConnect = connected;
				optResult = result;
				return;
			}
		}

		int[] temp = focusedCores.get(idx);
		for (int i = 0; i < 4; i++) {
			if (check(temp, i)) {
				connected++;
				mark(temp, i);
				processor(idx + 1);
				deMark(temp, i);
				connected--;
			}
		}
	}

	private static boolean check(int[] core, int direction) {
		int x = core[0] + dx[direction];
		int y = core[1] + dy[direction];
		while (true) {
			if (x < 0 || x >= N || y < 0 || y >= N)
				break;
			else {
				if (map[x][y] == 1) {
					return false;
				}
				x += dx[direction];
				y += dy[direction];
			}
		}
		return true;

	}

	private static void mark(int[] core, int direction) {
		int x = core[0] + dx[direction];
		int y = core[1] + dy[direction];
		while (true) {
			if (x < 0 || x >= N || y < 0 || y >= N)
				break;
			else {
				result++;
				map[x][y] = 1;
				x += dx[direction];
				y += dy[direction];
			}
		}
	}

	private static void deMark(int[] core, int direction) {
		int x = core[0] + dx[direction];
		int y = core[1] + dy[direction];
		while (true) {
			if (x < 0 || x >= N || y < 0 || y >= N)
				break;
			else {
				result--;
				map[x][y] = 0;
				x += dx[direction];
				y += dy[direction];
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			focusedCores = new ArrayList<int[]>();
			connected = 0;
			result = 0;
			optConnect = 0;
			optResult = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (!(i == 0 || i == N - 1 || j == 0 || j == N - 1)) {
							focusedCores.add(new int[] { i, j });
						}
					}
				}
			}
			for (int i = focusedCores.size() - 1; i >= 0; i--) {
				int[] temp = focusedCores.get(i);
				int count = 0;
				dir: for (int k = 0; k < 4; k++) {

					int x = temp[0] + dx[k];
					int y = temp[1] + dy[k];
					while (true) {
						if (x < 0 || x >= N || y < 0 || y >= N)
							continue dir;
						else {
							if (map[x][y] == 1) {
								count++;
								continue dir;
							}
							x += dx[k];
							y += dy[k];
						}
					}
				}
				if (count == 4) {
					focusedCores.remove(i);
				}
			}
			numOfCores = focusedCores.size();

			processor(0);
			sb.append(optResult).append("\n");

		}
		System.out.println(sb);
	}

}
