package todo;

import java.io.*;

public class BOJ11726 {

	static int n;
	static int[] dp;

	private static void square(int x) {
		dp[x] = (dp[x - 1] + dp[x - 2]) % 10007;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		if (n == 1) {
			System.out.println(1);
		} else {
			dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				square(i);
			}
			System.out.println(dp[n]);
		}
	}

}
