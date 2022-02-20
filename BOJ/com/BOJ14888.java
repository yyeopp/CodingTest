package com;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14888 {

	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] A, count;

	static ArrayList<Integer> selected;

	static int calculator(ArrayList<Integer> selected, int c, int res) {
		if (c == N - 1) {
			return res;
		}

		int temp = selected.get(c);

		switch (temp) {
		case 0:
			res = res + A[c + 1];
			break;
		case 1:
			res = res - A[c + 1];
			break;
		case 2:
			res = res * A[c + 1];
			break;
		case 3:
			res = res / A[c + 1];
			break;
		}
		return calculator(selected, c + 1, res);

	}

	static void permutation(int start, int cnt) {
		if (cnt == N - 1) {
			int result = calculator(selected, 0, A[0]);
			if (result >= max) {
				max = result;
			}
			if (result <= min) {
				min = result;
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (count[i] == 0) {
				continue;
			}
			selected.add(i);
			count[i]--;
			permutation(start, cnt + 1);
			selected.remove(selected.size()-1);
			count[i]++;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		count = new int[4];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
		}

		selected = new ArrayList<>();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int temp = Integer.parseInt(st2.nextToken());
			count[i] = temp;
		}

		for (int i = 0; i < 4; i++) {
			if (count[i] == 0) {
				continue;
			}
			selected.add(i);
			count[i]--;

			permutation(i, 1);
			selected.remove(0);
			count[i]++;
		}
		System.out.println(max);
		System.out.println(min);

	}

}
