package pro;

import java.util.*;

public class PRO3_N으로표현 {

	@SuppressWarnings("rawtypes")
	static HashSet[] dp;

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {

		int N = 2;
		int number = 11;

		dp = new HashSet[9];

		int answer = -1;

		for (int i = 1; i < 9; i++) {
			dp[i] = new HashSet<Integer>();
			dp[i].add(generateFirst(N, i));

			explore(i);

			if (inHear(number, dp[i])) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);

	}

	private static void explore(int idx) {
		for (int i = 1; i < idx; i++) {
			int j = idx - i;
			cartesian(i, j, idx);
		}

	}

	@SuppressWarnings("unchecked")
	private static void cartesian(int a, int b, int idx) {
		HashSet<Integer> dpA = dp[a];
		HashSet<Integer> dpB = dp[b];

		for (int n : dpA) {
			for (int m : dpB) {
				calculate(n, m, idx, dpA, dpB);
			}
		}

	}

	@SuppressWarnings("unchecked")
	private static void calculate(int n, int m, int idx, HashSet<Integer> dpA, HashSet<Integer> dpB) {

		int temp = n + m;
		if (!inHear(temp, dpA) & !inHear(temp, dpB)) {
			dp[idx].add(temp);
		}
		temp = n - m;
		if (!inHear(temp, dpA) & !inHear(temp, dpB)) {
			dp[idx].add(temp);
		}
		temp = n * m;
		if (!inHear(temp, dpA) & !inHear(temp, dpB)) {
			dp[idx].add(temp);
		}
		if (m != 0) {
			temp = n / m;
			if (!inHear(temp, dpA) & !inHear(temp, dpB)) {
				dp[idx].add(temp);
			}
		}

	}

	private static boolean inHear(int temp, HashSet<Integer> list) {
		boolean result = false;
		if (list.contains(temp)) {
			result = true;
		}
		return result;
	}

	private static int generateFirst(int N, int i) {
		int result = N;
		for (int j = 1; j < i; j++) {
			result += N * Math.pow(10, j);
		}
		return result;

	}

}
