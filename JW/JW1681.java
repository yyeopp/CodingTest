package jw;

import java.io.*;
import java.util.StringTokenizer;

public class JW1681 {


	static boolean cut(int cost, int minCost) {
		if (cost >= minCost) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int [] order = new int[N];
		for (int i = 1; i < order.length; i++) {
			order[i] = i;
		}

		int minimumCost = Integer.MAX_VALUE;
		do {
			boolean valid = true;
			int cost = 0;

			for (int i = -1; i < N - 1; i++) {
				if(!cut(cost,minimumCost)) break;

				if (i == -1) {
					if (matrix[0][order[0]] == 0) {
						valid = false;
						break;
					}
					cost += matrix[0][order[0]];
					continue;
				}
				if (i == N - 2) {
					if (matrix[N - 2][0] == 0) {
						valid = false;
						break;
					}
					cost += matrix[N - 2][0];
					continue;
				}
				if (matrix[order[i]][order[i + 1]] == 0) {
					valid = false;
					break;
				}
				cost += matrix[order[i]][order[i + 1]];
			}

			if (valid && cut(cost, minimumCost)) {

				minimumCost = cost;

			}

		} while (np(N,order));

		System.out.println(minimumCost);
	}

	private static boolean np(int N, int [] order) {

		int i = N - 1;

		while (i > 0 && order[i - 1] >= order[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = N - 1;
		while (order[i - 1] >= order[j]) {
			j--;
		}

		swap(i - 1, j, order);

		int k = N - 1;
		while (i < k) {
			swap(i, k, order);
			i++;
			k--;
		}

		return true;
	}

	public static void swap(int i, int j, int [] order) {
		int temp = order[i];
		order[i] = order[j];
		order[j] = temp;
	}

}
