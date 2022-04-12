package steps.s09;

import java.io.*;

public class BOJ9020 {

	static boolean[][] primeSet;

	private static boolean isPrime(int n) {

		if (primeSet[n][1] == true) {
			return primeSet[n][0];
		}

		boolean prime = true;
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				prime = false;
				break;
			}
		}
		primeSet[n][0] = prime;
		primeSet[n][1] = true;
		return prime;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		primeSet = new boolean[10001][2];
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int a = 0;
			int b = 0;

			for (int i = 2; i <= n / 2; i++) {
				if (isPrime(i) && isPrime(n - i)) {
					a = i;
					b = n - i;
				}
			}
			sb.append(a).append(" ").append(b).append("\n");

		}
		System.out.println(sb);

	}

}
