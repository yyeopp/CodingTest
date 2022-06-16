package pro;

// 매우 간단한 DFS 문제
public class PRO2_타겟넘버 {

	static int answer;
	static int sum;

	public static void main(String[] args) {

		int[] numbers = { 4, 1, 2, 1 };
		int target = 4;

		// dfs
		dfs(numbers, target, 0);
		System.out.println(answer);
	}

	private static void dfs(int[] numbers, int target, int idx) {

		// 기저조건
		if (idx == numbers.length) {
			if (sum == target) {
				answer++;
			}
			return;
		}

		// 기존 sum에 numbers 배열의 원소를 '더하고'
		sum += numbers[idx];
		dfs(numbers, target, idx + 1);
		// 그 다음은 '빼고' (아까 더했으므로 -2*numbers[idx] 해줘야 빼는 효과)
		sum -= 2 * numbers[idx];
		dfs(numbers, target, idx + 1);
		// 갖다 왔으니까 원상복귀시킴
		sum += numbers[idx];
	}

}
