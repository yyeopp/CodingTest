package com;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
		}
		//solve
		
		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int t = Integer.parseInt(st2.nextToken());
			sb.append(binarySearch(A, 0, N - 1, t)).append("\n");
		}
		System.out.println(sb);

	}

	public static int binarySearch(int[] A, int start, int end, int key) {

		int idx = (end + start) / 2;
		
		if (start > end) {
			return 0;
		}

		if (A[idx] == key) {
			return 1;
		} else if (A[idx] < key) {
			return binarySearch(A, idx + 1, end, key);
		}
		return binarySearch(A, start, idx - 1, key);

	}

}
