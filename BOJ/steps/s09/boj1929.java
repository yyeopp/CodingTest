package steps.s09;

import java.io.*;

public class boj1929 {
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

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] temp = br.readLine().split(" ");
			int[] tc = new int[2];
			int count = 0;
			for (int i = 0; i < tc.length; i++) {
				tc[i] = Integer.parseInt(temp[i]);
				if (boj1929.isPrimeNo(tc[i]) == true) {
					count++;
				}
			}
			System.out.println(count);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
