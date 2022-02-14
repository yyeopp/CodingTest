package com;

import java.io.*;

public class boj3040 {

	static int[] key = new int[9];
	static int[] choose = new int[7];
	static int[] answer = new int[7];
	static int sum;
	static final int MAX = 100;

	static void combination(int count, int start) {
		if (count == 7) {
			if (sum == MAX) {
				for (int i = 0; i < answer.length; i++) {
					answer[i] = choose[i];
				}

			}
			return;

		}
		for (int i = start; i < key.length; i++) {
			choose[count] = key[i];
			sum += key[i];
			combination(count + 1, i + 1);
			sum -= key[i];

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			key[i] = Integer.parseInt(br.readLine());

		}
		combination(0, 0);

		for (int i = 0; i < 7; i++) {
			System.out.println(answer[i]);
		}

	}

}
