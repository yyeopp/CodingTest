package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int init = Integer.parseInt(st.nextToken());
		if (init != 1 && init != 8) {
			System.out.println("mixed");
		} else if (init == 1) {
			boolean mix = false;
			int temp = 1;
			for (int i = 0; i < 7; i++) {
				int temp2 = Integer.parseInt(st.nextToken());
				if (temp + 1 != temp2) {
					System.out.println("mixed");
					mix = true;
					break;
				}
				temp = temp2;
			}
			if (!mix) {
				System.out.println("ascending");
			}
		} else if (init == 8) {
			boolean mix = false;
			int temp = 8;
			for (int i = 0; i < 7; i++) {
				int temp2 = Integer.parseInt(st.nextToken());
				if (temp - 1 != temp2) {
					System.out.println("mixed");
					mix = true;
					break;
				}
				temp = temp2;
			}
			if (!mix) {
				System.out.println("descending");
			}
		}

	}

}
