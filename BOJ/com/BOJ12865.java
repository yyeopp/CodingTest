package todo;

import java.io.*;
import java.util.*;

public class BOJ12865 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][K + 1];

		PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			pQueue.add(new int[] { W, V });

		}

		for (int t = 1; t <= N; t++) {

			int[] stuff = pQueue.poll();

			for (int i = 1; i <= K; i++) {
				if (stuff[0] > K) {
					dp[t][i] = dp[t - 1][i];
				} else if (stuff[0] > i) {
					dp[t][i] = dp[t - 1][i];
				} else {
					dp[t][i] = Math.max(dp[t - 1][i], dp[t - 1][i - stuff[0]] + stuff[1]);
				}
			}

		}
		System.out.println(dp[N][K]);
	}

}
