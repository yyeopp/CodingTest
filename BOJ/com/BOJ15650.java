package todo;

import java.io.*;
import java.util.*;

public class BOJ15650 {

	static StringBuilder sb;

	static int N, M;

	static int[] input, numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] input = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			input[i] = i + 1;
		}

		int[] p = new int[N];
		int cnt = 0;
		while (++cnt <= M) {
			p[N - cnt] = 1;
		}

		Stack<String> stack = new Stack<>();

		do {
			sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				if (p[i] == 1) {
					sb.append(input[i]).append(" ");
				}

			}
			stack.add(sb.toString());

		} while (np(p));
		sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append("\n");

		}
		System.out.println(sb);
	}

	private static boolean np(int[] p) {
		int N = p.length;

		int i = N - 1;

		while (i > 0 && p[i - 1] >= p[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = N - 1;
		while (p[i - 1] >= p[j]) {
			j--;
		}

		swap(p, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(p, i, k);
			i++;
			k--;
		}

		return true;
	}

	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
