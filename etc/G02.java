import java.util.Arrays;
import java.util.Stack;

public class G02 {
	
	public int solution(int[] bricks, int n, int k) {

		int[] p = new int[bricks.length];
		for (int i = 0; i < k - 1; i++) {
			p[p.length - 1 - i] = 1;
		}
		int answer = Integer.MAX_VALUE;
		do {
			int result = 0;
			int[] check = Arrays.copyOf(bricks, bricks.length);
			for (int i = 0; i < bricks.length; i++) {
				if (p[i] == 1) {
					result += n - check[i];
					check[i] = n;
				}
			}
			if (checkPool(check, n, k)) {
				if (result < answer) {
					answer = result;
				}
			}

		} while (np(p));
		return answer;
	}

	private static boolean checkPool(int[] check, int n, int k) {
		int pool = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < check.length; i++) {
			if (check[i] == n) {
				if (stack.isEmpty()) {
					continue;
				}
				pool++;
				stack.clear();
			} else {
				stack.add(check[i]);
			}
		}
		if (!stack.isEmpty()) {
			pool++;
		}
		if (pool == k) {
			return true;
		} else {
			return false;
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