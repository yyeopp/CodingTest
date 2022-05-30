package pro;

public class PRO2_멀쩡한사각형 {
	
	public long solution(int w, int h) {
		int a = Math.max(w, h);
		int b = Math.min(w, h);

		long init = (long) w * (long) h;

		long gcd = GCD(a, b);

		long spliced = (w / gcd + h / gcd - 1) * gcd;

		return init - spliced;
	}

	private static long GCD(long a, long b) {

		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return (long) a;
	}

}