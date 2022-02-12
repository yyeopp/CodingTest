package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj2564 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int width = Integer.parseInt(st1.nextToken());
		int length = Integer.parseInt(st1.nextToken());

		int T = Integer.parseInt(br.readLine());
		int[][] tc = new int[T][2];

		for (int i = 0; i < T; i++) {

			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				tc[i][j] = Integer.parseInt(st2.nextToken());
			}

		}

		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int[] dong = { Integer.parseInt(st3.nextToken()), Integer.parseInt(st3.nextToken()) };
		int result = 0;

		for (int i = 0; i < T; i++) {
			if (dong[0] == tc[i][0]) {
				result += Math.abs(dong[1] - tc[i][1]);
				continue;
			}

			if (dong[0] + tc[i][0] == 3) {
				if (dong[1] + tc[i][1] > width) {
					result += width * 2 - dong[1] - tc[i][1] + length;
					continue;
				} else if (dong[1] + tc[i][1] <= width) {
					result += dong[1] + tc[i][1] + length;
					continue;
				}

			}
			if (dong[0] + tc[i][0] == 7) {
				if (dong[1] + tc[i][1] > length) {
					result += length * 2 - dong[1] - tc[i][1] + width;
					continue;
				} else if (dong[1] + tc[i][1] <= length) {
					result += dong[1] + tc[i][1] + width;
					continue;
				}

			}

			if (dong[0] == 1) {
				if (tc[i][0] == 3) {
					result += dong[1] + tc[i][1];
					continue;
				}
				if (tc[i][0] == 4) {
					result += width - dong[1] + tc[i][1];
					continue;
				}
			}
			if (dong[0] == 2) {
				if (tc[i][0] == 3) {
					result += dong[1] + length - tc[i][1];
					continue;
				}
				if (tc[i][0] == 4) {
					result += width - dong[1] + length - tc[i][1];
					continue;
				}
			}
			if (dong[0] == 3) {
				if (tc[i][0] == 1) {
					result += dong[1] + tc[i][1];
					continue;
				}
				if (tc[i][0] == 2) {
					result += length - dong[1] + tc[i][1];
					continue;

				}
			}
			if (dong[0] == 4) {
				if (tc[i][0] == 1) {
					result += dong[1] + width - tc[i][1];
					continue;
				}
				if (tc[i][0] == 2) {
					result += length - dong[1] + width - tc[i][1];
					continue;
				}
			}

		}
		System.out.println(result);
	}

}
