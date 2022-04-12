package steps.s09;

import java.io.*;

public class boj4948 {
	public static boolean isPrimeNo(int n) {
		boolean prime = true;
		if (n == 1) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				prime = false;
				break;
			}
		}
		return prime;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			int count = 0;
			for (int i = n+1; i <= 2 * n; i++) {
				if (isPrimeNo(i) == true) {
					count++;
				}

			}
			sb.append(count + "\n");
		}
		System.out.println(sb);

	}
}
