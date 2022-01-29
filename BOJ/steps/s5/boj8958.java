package steps.s5;

import java.io.*;

public class boj8958 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] tc = br.readLine().split("");
				int result = 0;
				int count = 0;

				for (int j = 0; j < tc.length; j++) {

					if (tc[j].equals("O")) {
						count++;
						result += count;
					} else if (tc[j].equals("X")) {
						count = 0;
					}

				}
				bw.write(result + "\n");
			}
			bw.flush();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
