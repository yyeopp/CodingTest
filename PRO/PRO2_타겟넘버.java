package pro;

public class PRO2_타겟넘버 {

	static int answer;
	static int sum;

	public static void main(String[] args) {

		int[] numbers = { 4, 1, 2, 1 };
		int target = 4;

		dfs(numbers, target, 0);
		System.out.println(answer);
	}

	private static void dfs(int[] numbers, int target, int idx) {

		if (idx == numbers.length) {
			if (sum == target) {
				answer++;
			}
			return;
		}

		sum += numbers[idx];
		dfs(numbers, target, idx + 1);
		sum -= 2 * numbers[idx];
		dfs(numbers, target, idx + 1);
		sum += numbers[idx];
	}

}
