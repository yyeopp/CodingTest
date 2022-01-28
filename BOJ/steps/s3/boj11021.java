package steps.s3;

import java.io.*;

public class boj11021 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T;
		try {
			T = Integer.parseInt(br.readLine());

			for (int i = 1; i <= T; i++) {

				int[] inputNo = new int[2];

				String[] temp = br.readLine().split(" ");

				for (int j = 0; j < 2; j++) {
					inputNo[j] = Integer.parseInt(temp[j]);

				}
				int result = inputNo[0] + inputNo[1];
				bw.write("Case #"+i+": " + result + "\n");
			}
			bw.flush();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
