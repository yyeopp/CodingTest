package steps.s8;

import java.io.*;

public class boj2292 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			long N = Integer.parseInt(br.readLine());

			if (N == 1) {
				System.out.println(1);
			}
			if (N > 1) {
				long result = (long) Math.floor(((3 + Math.sqrt(12 * N - 15)) / 6)) + 1;

				System.out.println(result);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
