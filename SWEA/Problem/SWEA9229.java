package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA9229 {

	static int N, M, result, answer;
	static int[] data;

	public static void spot(int cnt, int start) {
		if (cnt == 2) {
			if (result > M) {
				return;
			}
			if (result >= answer) {
				answer = result;

			}
			return;

		}

		for (int i = start; i < N; i++) {
			result += data[i];
			spot(cnt + 1, i + 1);

			result -= data[i];
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			M = Integer.parseInt(st1.nextToken());
			data = new int[N];
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st2.nextToken());

			}
			spot(0, 0);

			if (answer != 0) {
				sb.append(answer).append("\n");
			}
			if (answer == 0) {
				sb.append(-1).append("\n");
			}
			result = 0;
			answer = 0;

		}
		System.out.println(sb);
	}

}
