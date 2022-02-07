package steps.s11;

import java.io.*;
import java.util.StringTokenizer;

public class boj2798 {

	static int[] tc;
	static int N, M;
	static int result;
	static int answer = 0;

	public static void blackjack(int cnt, int start) {
		if (cnt == 3) {
			if (result > M) {
				return;
			}
			if (result >= answer) {
				answer = result;
			}
			return;
		}

		for (int i = start; i < N; i++) {
			result += tc[i];
			blackjack(cnt + 1, start + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken()); // 맥시멈
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		tc = new int[N];
		for (int i = 0; i < N; i++) {
			tc[i] = Integer.parseInt(st2.nextToken());
		} // tc에 있는 숫자들 조합으로 더해야 함

		blackjack(0, 0);
		System.out.println(answer);

	}

}
