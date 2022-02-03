package steps.s08;

import java.io.*;

public class boj2775{

	public static int sum(int k, int n) {
		int[][] set = new int[k + 1][n];

		for (int i = 0; i < n; i++) {
			set[0][i] = i + 1;
		}
		for (int i = 0; i < k; i++) {

			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 <= j; j2++) {

					set[i + 1][j] += set[i][j2];
				}
			}
		}

		return set[k][n - 1];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		try {
			int T = Integer.parseInt(br.readLine());

			for (int i = 0; i < T; i++) {
				int k = Integer.parseInt(br.readLine());
				int n = Integer.parseInt(br.readLine());
				sb.append(boj2775.sum(k, n) + "\n");

			}
			System.out.println(sb);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
