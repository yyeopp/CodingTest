package steps.s06;

public class boj15596 {
	int[] a = new int[3000000];

	public long sum(int[] a) {
		long sum = 0;
		for (int i = 0; i < a.length; i++) {

			sum += a[i];

		}
		return sum;

	}
}
