package pro;

public class PRO3_자물쇠와열쇠 {

	static int keySize;
	static int lockHeight;
	static int lockWidth;

	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		keySize = key.length;
		lockHeight = lock.length;
		lockWidth = lock[0].length;

		int[][] board = new int[lockHeight + (keySize - 1) * 2][lockWidth + (keySize - 1) * 2];

		int x = 0;
		for (int i = keySize - 1; i < keySize + lockHeight - 1; i++) {
			int y = 0;
			for (int j = keySize - 1; j < keySize + lockWidth - 1; j++) {
				board[i][j] = lock[x][y];
				y++;
			}
			x++;
		}

		boolean answer = false;
		loop: for (int n = 0; n < 4; n++) {

			for (int i = 0; i <= board.length - keySize; i++) {
				for (int j = 0; j <= board[i].length - keySize; j++) {
					int[][] test = generateTest(board);

					test = insert(test, key, i, j);

					if (matched(test)) {
						answer = true;
						break loop;
					}
				}
			}
			key = rotateKey(key);
		}
		System.out.println(answer);

	}

	private static int[][] generateTest(int[][] board) {
		int[][] result = new int[board.length][board[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = board[i][j];
			}
		}
		return result;
	}

	private static int[][] rotateKey(int[][] lock) {
		int n = lock.length;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = lock[i][j];
				lock[i][j] = lock[n - i - 1][j];
				lock[n - i - 1][j] = temp;

			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = lock[i][j];
				lock[i][j] = lock[j][i];
				lock[j][i] = temp;
			}
		}
		return lock;
	}

	private static int[][] insert(int[][] board, int[][] key, int x, int y) {
		int n = 0;
		for (int i = x; i < x + keySize; i++) {
			int m = 0;
			for (int j = y; j < y + keySize; j++) {
				board[i][j] += key[n][m];
				m++;
			}
			n++;
		}
		return board;
	}

	private static boolean matched(int[][] board) {

		boolean result = true;
		loop: for (int i = keySize - 1; i < keySize + lockHeight - 1; i++) {
			for (int j = keySize - 1; j < keySize + lockWidth - 1; j++) {
				if (board[i][j] != 1) {
					result = false;
					break loop;
				}

			}
		}
		return result;

	}

}
