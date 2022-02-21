package com;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {

	static int L, C;
	static String[] letter;
	static String[] selected;
	static StringBuilder sb;

	static boolean able() {
		int ja = 0;
		int mo = 0;

		for (int i = 0; i < selected.length; i++) {
			if (selected[i].equals("a") || selected[i].equals("e") || selected[i].equals("i") || selected[i].equals("o")
					|| selected[i].equals("u")) {
				mo++;
			} else {
				ja++;
			}
			if (ja >= 2 && mo >= 1) {
				return true;
			}
		}

		return false;
	}

	static void password(int count, int start) {

		if (count == L) {
			if (able()) {
				for (int i = 0; i < L; i++) {
					sb.append(selected[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			selected[count] = letter[i];
			password(count + 1, i + 1);

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st1.nextToken());
		C = Integer.parseInt(st1.nextToken());

		letter = br.readLine().split(" ");
		selected = new String[L];
		Arrays.sort(letter);

		password(0, 0);
		System.out.println(sb);

	}

}
