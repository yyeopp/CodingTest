package todo;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1018 {

	static int N, M;

	static char[][] map;

	private static char[][] makeBoard(int x, int y) {

		char[][] board = new char[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = map[x + i][y + j];
			}
		}
		return board;
	}

	private static int chessBoard(int x, int y, char start) {

		char idx = opposite(start);

		char[][] board = makeBoard(x, y);

		int resultA = examineBoard(board, idx);
		board[0][0] = idx;
		int resultB = examineBoard(board, start) + 1;

		return Math.min(resultA, resultB);
	}

	private static char opposite(char temp) {
		if (temp == 'B') {
			return 'W';
		} else {
			return 'B';
		}
	}

	private static int examineBoard(char[][] board, char idx) {

		int result = 0;
		char temp = idx;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == temp) {
					result++;
				}
				temp = opposite(temp);
			}
			temp = opposite(temp);
		}
		return result;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int min = Integer.MAX_VALUE;

		for (int p = 0; p <= map.length - 8; p++) {
			for (int q = 0; q <= map[p].length - 8; q++) {
				int result = chessBoard(p, q, map[p][q]);
				if (result < min) {
					min = result;
				}
			}
		}
		System.out.println(min);
	}

}
