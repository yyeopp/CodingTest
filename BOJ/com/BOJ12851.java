package todo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12851 {

	static int N, K;
	static int result;
	static int count;

	static int[] seek;

	private static void hideAndSeek(int x, int time) {

		if (time > result) {
			return;
		}

		if (x == K) {

			seek[K] = time;

			if (time < result) {
				count = 1;
			} else {
				count++;
			}

			result = time;
			return;
		}

		if (x != 0 && x * 2 < K * 2 && x * 2 <= 100000 && seek[x * 2] >= time + 1) {
			seek[x * 2] = time + 1;
			hideAndSeek(x * 2, time + 1);
		}

		if (x + 1 <= 100000 && seek[x + 1] >= time + 1 && x < K) {
			seek[x + 1] = time + 1;
			hideAndSeek(x + 1, time + 1);
		}

		if (x - 1 >= 0 && seek[x - 1] >= time + 1) {
			seek[x - 1] = time + 1;
			hideAndSeek(x - 1, time + 1);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		seek = new int[100001];
		Arrays.fill(seek, Integer.MAX_VALUE);
		seek[N] = 0;
		result = Integer.MAX_VALUE;
		count = 0;

		if (N <= K) {
			hideAndSeek(N, 0);
		} else {
			result = N - K;
			count = 1;
		}
		System.out.println(result);
		System.out.println(count);
	}

}
