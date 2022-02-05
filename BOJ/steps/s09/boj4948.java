package steps.s09;

import java.io.*;

public class boj4948 {
	public static boolean isPrimeNo(int n) {

		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		} else {
			if (n % 2 == 0) {
				return false;
			} else {

				for (int i = 3; i <= n / 2; i++) {
					if (n % i == 0) {

						return false;
					}
				}
				return true;

			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int count = 0;
			for (int i = n; i <= 2 * n; i++) {
				if (isPrimeNo(i) == true) {
					count++;
				}

			}
			sb.append(count+"\n");
		}
		System.out.println(sb);

	}
}
