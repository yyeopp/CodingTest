package todo;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2407 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BigInteger[] factorial = new BigInteger[n + 1];

		factorial[1] = BigInteger.valueOf(1);
		for (int i = 2; i <= n; i++) {
			factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
		}

		BigInteger result = factorial[n].divide(factorial[n - m].multiply(factorial[m]));

		System.out.println(result);
	}

}