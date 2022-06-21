package pro;

import java.util.*;

// 완전탐색에 가까운 듯한 DP 문제

public class PRO3_N으로표현 {

	@SuppressWarnings("rawtypes")
	static HashSet[] dp;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int N = 3;
		int number = 2112;

		// dp 배열의 1번 인덱스 dp[1]에는, N을 하나만 써서 만들 수 있는 숫자들의 HashSet이 들어간다.
		// ex) 5

		// dp[2]에는 N을 두 개 써서 만들 수 있는 숫자들의 HashSet이 들어간다.
		// ex) 55, 10, 0, 1

		dp = new HashSet[9];

		int answer = -1;

		// N을 사용하는 개수를 하나씩 늘려가다가, dp[i] 에서 목표로 하는 number 값을 발견하면 종료.
		// N을 8개 사용하는 경우까지만 탐색하고 그 때까지 발견되지 않으면 기본 answer 값인 -1을 return
		for (int i = 1; i < 9; i++) {
			dp[i] = new HashSet<Integer>();

			// 첫값 (5, 55, 555, 5555 등)은 직접 입력
			dp[i].add(generateFirst(N, i));

			// dp[i] 채워오기
			explore(i);

			// dp[i]에 number가 들어있다면
			if (inHear(number, dp[i])) {

				// answer에 N을 몇 번 사용했는 지 기록하고 break
				answer = i;
				break;
			}
		}
		System.out.println(answer);

	}

	// idx = 4, 즉 dp[4]를 채우는 경우라면
	// dp[1]에 있는 원소들과 dp[3]에 있는 원소들의 모든 조합 + dp[2]와 dp[2]의 조합 + dp[3]과 dp[1]의 조합을 모두
	// 고려해서 dp[4]를 만들어야 한다.
	// 이 때 연산결과가 이미 dp[1~3]에 들어있다면 dp[4]에 추가하지 않는다. (그러기 위해 Set을 사용함)

	private static void explore(int idx) {
		for (int i = 1; i < idx; i++) {
			int j = idx - i;
			// idx가 5면 1-4, 2-3, 3-2, 4-1 이런식으로 들어감
			cartesian(i, j, idx);
		}

	}

	@SuppressWarnings("unchecked")
	private static void cartesian(int a, int b, int idx) {
		HashSet<Integer> dpA = dp[a];
		HashSet<Integer> dpB = dp[b];

		// A set과 B set을 가져다가 그 원소들을 모두 짝지어본다.
		for (int n : dpA) {
			for (int m : dpB) {
				calculate(n, m, idx, dpA, dpB);
			}
		}

	}

	@SuppressWarnings("unchecked")
	private static void calculate(int n, int m, int idx, HashSet<Integer> dpA, HashSet<Integer> dpB) {

		// A set과 B set에서 뽑아온 두 수, n과 m에 대해 사칙연산 네 가지를 모두 돌리고
		int temp = n + m;

		// 그 결과인 temp가 A set과 B set에 모두 없다면 dp[idx]에 add하는 방식.
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

		// 0으로 나누는 경우를 방지.
		if (m != 0) {
			temp = n / m;
			if (!inHear(temp, dpA) & !inHear(temp, dpB)) {
				dp[idx].add(temp);
			}
		}

	}

	// 연산된 숫자 (dp[i]에 들어갈 후보)가 이미 Set 안에 존재하는 지 여부 확인
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
