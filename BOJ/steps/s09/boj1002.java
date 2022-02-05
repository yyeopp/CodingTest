package steps.s09;

import java.io.*;
import java.util.StringTokenizer;

public class boj1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] test = new int[6];
			for (int i = 0; i < 6; i++) {
				test[i] = Integer.parseInt(st.nextToken());
			}
			double uni = Math.sqrt(Math.pow(test[3] - test[0], 2) + Math.pow(test[4] - test[1], 2));
			double rsum = Math.abs(test[5] + test[2]);
			double rcha = Math.abs(test[5] - test[2]);

			if (uni == 0) {
				if (test[2] == test[5]) {
					sb.append(-1).append("\n");

				}
				if (test[2] != test[5]) {
					sb.append(0).append("\n");
				}
			}

			if (uni > 0) {
				if (uni > rsum) {
					sb.append(0).append("\n");

				}
				if (uni == rsum) {
					sb.append(1).append("\n");

				}
				if (uni < rsum) {
					if (uni > rcha) {
						sb.append(2).append("\n");
					}
					if (uni == rcha) {
						sb.append(1).append("\n");
					}
					if (uni < rcha) {
						sb.append(0).append("\n");

					}
				}
			}

		}
		System.out.println(sb);

	}

}
