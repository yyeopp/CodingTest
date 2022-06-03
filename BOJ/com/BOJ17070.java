package todo;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17070 {

	static int N;
	static int result;

	static class Pipe {
		int x;
		int y;
		int direction;

		public Pipe(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move(map, new Pipe(0, 1, 0));
		System.out.println(result);

	}

	private static void move(int[][] map, Pipe pipe) {

		if (pipe.x == N - 1 && pipe.y == N - 1) {
			result++;
			return;
		}

		int[] direction = direction(pipe.direction);

		for (int i = 0; i < direction.length; i++) {
			int forward = direction[i];
			if (ableToMove(map, pipe, forward)) {
				move(map, generatePipe(pipe, forward));
			}

		}
	}

	private static Pipe generatePipe(Pipe pipe, int forward) {
		if (forward == 0) {
			return new Pipe(pipe.x, pipe.y + 1, 0);
		} else if (forward == 1) {
			return new Pipe(pipe.x + 1, pipe.y + 1, 1);
		} else {
			return new Pipe(pipe.x + 1, pipe.y, 2);
		}
	}

	private static int[] direction(int direction) {

		if (direction == 0) {
			return new int[] { 0, 1 };
		} else if (direction == 1) {
			return new int[] { 0, 1, 2 };
		} else {
			return new int[] { 1, 2 };
		}

	}

	private static boolean ableToMove(int[][] map, Pipe pipe, int direction) {

		boolean able = true;

		int[] dx = generateDx(direction);
		int[] dy = generateDy(direction);

		for (int i = 0; i < dy.length; i++) {

			int x = pipe.x + dx[i];
			int y = pipe.y + dy[i];

			if (x < 0 || x >= N || y < 0 || y >= N || map[x][y] == 1) {
				able = false;
				break;
			}

		}

		return able;

	}

	private static int[] generateDx(int direction) {
		if (direction == 0) {
			return new int[] { 0 };
		} else if (direction == 1) {
			return new int[] { 0, 1, 1 };
		} else {
			return new int[] { 1 };
		}
	}

	private static int[] generateDy(int direction) {
		if (direction == 0) {
			return new int[] { 1 };
		} else if (direction == 1) {
			return new int[] { 1, 1, 0 };
		} else {
			return new int[] { 0 };
		}
	}

}
