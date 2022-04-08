package todo;

import java.io.*;
import java.util.*;

public class BOJ14502 {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] fixed;
	static List<int[]> virus;
	static List<int[]> space;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		fixed = new boolean[N][M];
		virus = new ArrayList<int[]>();
		space = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					fixed[i][j] = true;
					if (map[i][j] == 2) {
						virus.add(new int[] { i, j });
					}
				} else {
					space.add(new int[] { i, j });
				}
			}
		}

		int[] idx = new int[space.size()];
		for (int i = 0; i < idx.length; i++) {
			idx[i] = i;
		}
		int[] p = new int[space.size()];

		int cnt = 0;
		while (++cnt <= 3) {
			p[space.size() - cnt] = 1;
		}

		int[] test = new int[3];
		int result = 0;
		int max = 0;

		do {
			cnt = 0;
			for (int i = 0; i < idx.length; i++) {
				if (p[i] == 1) {
					test[cnt] = idx[i];
					cnt++;
				}

			}
			result = spread(test);
			if (result > max) {
				max = result;
			}

		} while (np(p));

		System.out.println(max);
	}

	private static int spread(int[] wall) {
		for (int i = 0; i < wall.length; i++) {
			int[] newWallPos = space.get(wall[i]);
			map[newWallPos[0]][newWallPos[1]] = 1;
		}

		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < virus.size(); i++) {
			queue.offer(virus.get(i));
		}

		boolean[][] checked = new boolean[N][M];

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			checked[temp[0]][temp[1]] = true;
			for (int i = 0; i < 4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;
				if (map[x][y] != 0) {
					checked[x][y] = true;
					continue;
				}
				if (!checked[x][y]) {
					queue.offer(new int[] { x, y });
					map[x][y] = 2;
					checked[x][y] = true;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					result++;
				}
			}
		}
		clear();
		return result;

	}

	private static void clear() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (!fixed[i][j]) {
					map[i][j] = 0;
				}
			}
		}
	}

	private static boolean np(int[] p) {

		int N = p.length;
		int i = N - 1;

		while (i > 0 && p[i - 1] >= p[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}
		int j = N - 1;
		while (p[i - 1] >= p[j]) {
			j--;
		}
		swap(p, i - 1, j);
		int k = N - 1;
		while (i < k) {
			swap(p, i, k);
			i++;
			k--;
		}

		return true;
	}

	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
