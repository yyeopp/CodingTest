package steps.s08;

import java.io.*;

public class boj1712 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] temp = br.readLine().split(" ");
			long[] tc = new long[3];
			for (int i = 0; i < temp.length; i++) {
				tc[i] = Long.parseLong(temp[i]);
			}

			if (tc[2] <= tc[1]) {
				System.out.println(-1);
			}

			else {
				long q = (tc[0] / (tc[2] - tc[1])) + 1;

				System.out.println(q);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
