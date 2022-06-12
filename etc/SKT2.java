import java.util.Arrays;

public class SKT2 {

	public static void main(String[] args) {

		int[] periods = { 20, 23, 24 };
		int[][] payments = {
				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 } };
		int[] estimates = { 100000, 100000, 100000 };

		int[] answer = new int[2];

		for (int i = 0; i < estimates.length; i++) {

			if (isVIP(periods[i], payments[i])) {
				if (!willBeVIP(periods[i], payments[i], estimates[i])) {
					answer[1]++;
				}
			} else {
				if (willBeVIP(periods[i], payments[i], estimates[i])) {
					answer[0]++;
				}
			}
		}

		System.out.println(Arrays.toString(answer));

	}

	private static int total(int[] payment) {
		int total = 0;
		for (int i = 0; i < payment.length; i++) {
			total += payment[i];
		}
		return total;
	}

	private static int nextTotal(int[] payment, int estimate) {
		int total = estimate;
		for (int i = 1; i < payment.length; i++) {
			total += payment[i];
		}
		return total;
	}

	private static boolean isVIP(int period, int[] payment) {
		if (period < 24) {
			return false;
		}
		int total = total(payment);
		if (period < 60 && total < 900000) {
			return false;
		}
		if (total < 600000) {
			return false;
		}
		return true;

	}

	private static boolean willBeVIP(int period, int[] payment, int estimate) {
		if (period + 1 < 24) {
			return false;
		}
		int total = nextTotal(payment, estimate);
		if (period + 1 < 60 && total < 900000) {
			return false;
		}
		if (total < 600000) {
			return false;
		}
		return true;
	}

}
