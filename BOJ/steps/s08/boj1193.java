package steps.s08;

import java.io.*;

public class boj1193 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long X;
		try {
			X = Long.parseLong(br.readLine());
				long n = (long) Math.ceil((-1 + Math.sqrt(1 + 8 * X)) / 2);
				long index = (n * (n - 1)) / 2 +1;
				long pos = X % index+1;
				if (n % 2 == 1) {
					System.out.printf("%d/%d", n - (pos - 1), pos);
				}
				if (n % 2 == 0) {
					System.out.printf("%d/%d", pos, n - (pos - 1));
				}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
