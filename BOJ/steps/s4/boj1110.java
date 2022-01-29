package steps.s4;

import java.io.*;

public class boj1110 {

	public static void main(String[] args) {

		int count = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			final int N = Integer.parseInt(br.readLine());
			int changed = 0;
			if (N >= 10) {

				int ten = N / 10;
				int one = N % 10;
				changed = 10 * one + (ten + one) % 10;

			} else if (N < 10) {
				changed = N * 11;

			}

			while (N != changed) {
				int ten = changed / 10;
				int one = changed % 10;
				changed = 10 * one + (ten + one) % 10;
				count ++;
			}
			System.out.println(count);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
