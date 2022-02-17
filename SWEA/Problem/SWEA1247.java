package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1247 {

	static int N, sum, result;
	static int[] com, home;
	static int[][] client;
	static int[][] selected;

	static int distance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	static void permutation(int cnt, int flag) {

		if (cnt == N) {

			sum += distance(com, selected[0]);
			for (int i = 0; i < N - 1; i++) {
				sum += distance(selected[i], selected[i + 1]);
			}
			sum += distance(selected[N - 1], home);

			if (sum <= result) {

				result = sum;
			}
			sum = 0;

			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			selected[cnt] = client[i];

			permutation(cnt + 1, flag | 1 << i);

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			com = new int[2];
			home = new int[2];

			com[0] = Integer.parseInt(st.nextToken());
			com[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			client = new int[N][2];
			selected = new int[N][2];

			for (int i = 0; i < N; i++) {
				client[i][0] = Integer.parseInt(st.nextToken());
				client[i][1] = Integer.parseInt(st.nextToken());
			}

			// solve
			sum = 0;
			result = Integer.MAX_VALUE;

			permutation(0, 0);
			sb.append(result).append("\n");

		}
		System.out.println(sb);
	}

}
