package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1244 {
	
	static int change(int k) {
		if(k == 0) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int[] status = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			status[i] = Integer.parseInt(st1.nextToken());
		}

		int students = Integer.parseInt(br.readLine());
		for (int i = 0; i < students; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st2.nextToken());
			int pos = Integer.parseInt(st2.nextToken());

			switch (g) {
			case 1:
				int temp = pos;
				while (pos <= N) {
					status[pos] = change(status[pos]);
					pos += temp;
				}
				break;
			case 2:
				int j = 0;
				while (true) {
					status[pos + j] = change(status[pos + j]);
					status[pos - j] = change(status[pos - j]);
					j++;

					if (pos - j < 1 || pos + j > N) {
						break;
					}
					if (status[pos - j] != status[pos + j]) {
						break;
					}

				}
				status[pos] = change(status[pos]);
				break;
			}

		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			sb.append(status[i]).append(" ");
			count++;
			if(count%20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
