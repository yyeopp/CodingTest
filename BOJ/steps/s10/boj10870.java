package steps.s10;

import java.io.*;

public class boj10870 {

	public static int fibo(int n) {

		if (n == 0) {
			return 0;

		}
		if (n == 1) {
			return 1;
		}

		return fibo(n - 1) + fibo(n - 2);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(N));
	}

}
