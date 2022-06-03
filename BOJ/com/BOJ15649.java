package todo;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15649 {

	static StringBuilder sb;

	static int N, M;

	static int[] input, numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		numbers = new int[M];

		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}

		permutation(0, 0);
		System.out.println(sb);

	}

	public static void permutation(int cnt, int flag) {

		if (cnt == M) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			numbers[cnt] = input[i];

			permutation(cnt + 1, flag | 1 << i);

		}
	}
}
