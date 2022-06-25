import java.util.Arrays;

public class NHN2 {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0 }, { 0, 1, 0, 1, 0, 0 },
				{ 0, 0, 0, 1, 0, 0 }, { 1, 1, 1, 1, 0, 0 } };
		int[] arrows = { 19, 16, 15 };
		int threshold = 5;

		for (int i = 0; i < arrows.length; i++) {
			board = push(board, arrows[i], threshold);
		}
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

	}

	private static int[][] push(int[][] board, int arrow, int threshold) {
		int[][] result = Arrays.copyOf(board, board.length);
		if (arrow <= board.length) {
			result = down(board, arrow - 1, threshold);
		} else if (arrow <= board.length * 2) {
			result = left(board, arrow - board.length - 1, threshold);
		} else if (arrow <= board.length * 3) {
			result = up(board, 3 * board.length - arrow, threshold);
		} else {
			result = right(board, 4 * board.length - arrow, threshold);
		}
		return result;
	}

	private static int[][] down(int[][] board, int idx, int threshold) {
		for (int i = board.length - 1; i >= 0; i--) {
			if (board[i][idx] == 1) {
				if (downMoveable(board, i, idx)) {
					board[i + 1][idx] = 1;
					board[i][idx] = 0;
				} else if (downCheck(board, i, idx, threshold)) {
					board[i][idx] = 0;
				}
			}
		}

		return board;
	}

	private static boolean downMoveable(int[][] board, int x, int idx) {
		boolean result = true;
		if (x == board.length - 1) {
			result = false;
		} else if (board[x + 1][idx] == 1) {
			result = false;
		}
		return result;

	}

	private static boolean downCheck(int[][] board, int x, int idx, int threshold) {
		int num = 0;
		boolean result = false;
		for (int i = x - 1; i >= 0; i--) {
			if (board[i][idx] == 1) {
				num++;
			} else {
				break;
			}
		}
		if (num >= threshold) {
			result = true;
		}
		return result;
	}

	private static int[][] left(int[][] board, int idx, int threshold) {
		for (int i = 0; i < board.length; i++) {
			if (board[idx][i] == 1) {
				if (leftMoveable(board, i, idx)) {
					board[idx][i - 1] = 1;
					board[idx][i] = 0;
				} else if (leftCheck(board, i, idx, threshold)) {
					board[idx][i] = 0;
				}
			}
		}

		return board;
	}

	private static boolean leftMoveable(int[][] board, int x, int idx) {
		boolean result = true;
		if (x == 0) {
			result = false;
		} else if (board[idx][x - 1] == 1) {
			result = false;
		}
		return result;

	}

	private static boolean leftCheck(int[][] board, int x, int idx, int threshold) {
		int num = 0;
		boolean result = false;
		for (int i = x - 1; i >= 0; i--) {
			if (board[idx][i] == 1) {
				num++;
			} else {
				break;
			}
		}
		if (num >= threshold) {
			result = true;
		}
		return result;
	}

	private static int[][] up(int[][] board, int idx, int threshold) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][idx] == 1) {
				if (upMoveable(board, i, idx)) {
					board[i - 1][idx] = 1;
					board[i][idx] = 0;
				} else if (upCheck(board, i, idx, threshold)) {
					board[i][idx] = 0;
				}
			}
		}

		return board;
	}

	private static boolean upMoveable(int[][] board, int x, int idx) {
		boolean result = true;
		if (x == 0) {
			result = false;
		} else if (board[x - 1][idx] == 1) {
			result = false;
		}
		return result;

	}

	private static boolean upCheck(int[][] board, int x, int idx, int threshold) {
		int num = 0;
		boolean result = false;
		for (int i = x - 1; i >= 0; i--) {
			if (board[i][idx] == 1) {
				num++;
			} else {
				break;
			}
		}
		if (num >= threshold) {
			result = true;
		}
		return result;
	}

	private static int[][] right(int[][] board, int idx, int threshold) {
		for (int i = board.length - 1; i >= 0; i--) {
			if (board[idx][i] == 1) {
				if (rightMoveable(board, i, idx)) {
					board[idx][i + 1] = 1;
					board[idx][i] = 0;
				} else if (rightCheck(board, i, idx, threshold)) {
					board[idx][i] = 0;
				}
			}
		}

		return board;
	}

	private static boolean rightMoveable(int[][] board, int x, int idx) {
		boolean result = true;
		if (x == board.length - 1) {
			result = false;
		} else if (board[idx][x + 1] == 1) {
			result = false;
		}
		return result;

	}

	private static boolean rightCheck(int[][] board, int x, int idx, int threshold) {
		int num = 0;
		boolean result = false;
		for (int i = x - 1; i >= 0; i--) {
			if (board[idx][i] == 1) {
				num++;
			} else {
				break;
			}
		}
		if (num >= threshold) {
			result = true;
		}
		return result;
	}
}
