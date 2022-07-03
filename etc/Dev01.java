
public class Dev01 {

	public static void main(String[] args) {

		int[] grade = { 2, 1, 3 };

		int seed = grade[grade.length - 1];
		int answer = 0;

		for (int i = grade.length - 2; i >= 0; i--) {
			if (grade[i] > seed) {
				answer += (grade[i] - seed);
			} else {
				seed = grade[i];
			}
		}

		System.out.println(answer);

	}

}
