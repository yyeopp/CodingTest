import java.util.Arrays;
import java.util.PriorityQueue;

public class N4 {

	public static void main(String[] args) {
		int[][] A = { { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 3 }, { 3, 2 }, { 4, 2 }, { 5, 1 } };

		int N = A.length;

		int[] p = new int[N];

		int cnt = 0;
		while (++cnt <= 3) {

			p[N - cnt] = 1;
		}

		int result = 0;

		double[][] dp = new double[N][N];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();

		do {
			for (int i = 0; i < N; i++) {
				if (p[i] == 1) {
					pQueue.add(i);

				}
			}

			int a = pQueue.poll();
			int b = pQueue.poll();
			int c = pQueue.poll();

			if (dp[a][b] == -1) {
				dp[a][b] = gradient(A[a][0], A[a][1], A[b][0], A[b][1]);
			}
			if (dp[b][c] == -1) {
				dp[b][c] = gradient(A[b][0], A[b][1], A[c][0], A[c][1]);
			}

			if (dp[a][b] == dp[b][c]) {
				result++;
			}

		} while (np(p));

		System.out.println(result);

	}

	private static double gradient(int a, int b, int c, int d) {
		return ((double) (c - a)) / ((double) (d - b));
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
