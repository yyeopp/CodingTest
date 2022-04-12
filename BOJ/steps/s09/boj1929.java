package steps.s09;

import java.io.*;
import java.util.StringTokenizer;

public class boj1929 {
	public static boolean isPrimeNo(int n) {
		if (n == 1)
			return false;
		boolean prime = true;
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			// 에라토스테네스의 체 원리 상, 특정 자연수 n에 대한 소수 여부 검증은 
			// sqrt(n) 까지 수에 대해 mod 연산을 수행해보는 것으로 충분하다.
			if (n % i == 0) {
				prime = false;
				break;
			}
		}

		return prime;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		for (int i = M; i <= N; i++) {
			if (isPrimeNo(i)) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);

	}
}