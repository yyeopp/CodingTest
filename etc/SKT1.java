import java.util.Arrays;

public class SKT1 {

	public static void main(String[] args) {
		int[] p = { 3, 2, 6, 7, 4, 9, 8, 1, 5 };
		int[] answer = new int[p.length];

		for (int i = 0; i < p.length; i++) {

			if (p[i] == i + 1) {
				continue;
			}

			for (int j = i + 1; j < p.length; j++) {
				if (p[j] == i + 1) {
					p[j] = p[i];
					p[i] = i + 1;
					answer[i]++;
					answer[j]++;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(answer));

	}

}
