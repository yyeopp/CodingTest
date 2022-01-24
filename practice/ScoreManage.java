
public class ScoreManage {

	public static void main(String[] args) {

		double[] su = { 45, 80, 68, 19, 34, 55, 27, 60, 27, 18 };

		double total = 0;

		for (int i = 0; i < su.length; i++) {
			total += su[i];
		}

		double avg = total / su.length;
		double near = 0;

		for (int i = 0; i < su.length; i++) {
			if (near <= Math.abs(avg - su[i])) {
				near = su[i];
			}
		}

		System.out.printf("%.1f %.0f", avg, near);

	}
}
