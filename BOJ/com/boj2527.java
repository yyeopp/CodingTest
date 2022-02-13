package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj2527 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[][] r1 = new int[2][2];
			for (int i = 0; i < r1.length; i++) {
				for (int j = 0; j < r1.length; j++) {
					r1[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] r2 = new int[2][2];
			for (int i = 0; i < r2.length; i++) {
				for (int j = 0; j < r2.length; j++) {
					r2[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// solve
			// 1. x좌표가 아예 어긋난 경우
			if (r1[1][0] < r2[0][0] || r1[0][0] > r2[1][0]) {
				System.out.println("d");
			}

			// 2. x좌표가 하나만 같은 경우
			if (r1[1][0] == r2[0][0] || r1[0][0] == r2[1][0]) {
				// 2.1. 점에서 만나는 경우
				if (r1[1][1] == r2[0][1] || r1[0][1] == r2[1][1]) {
					System.out.println("c");
				}
				// 2.2. 선분으로 만나는 경우

				if (r1[0][1] < r2[1][1] && r1[1][1] > r2[0][1]) {
					System.out.println("b");
				}
				// 2.3. 아예 만나지 않는 경우 (y좌표가 멀어서)

				if (r1[1][1] < r2[0][1] || r1[0][1] > r2[1][1]) {
					System.out.println("d");
				}

			}

			// 3. x좌표가 겹치는 경우

			if (r1[1][0] > r2[0][0] && r1[0][0] < r2[1][0]) {
				// 3.1. 아예 만나지 않는 경우
				if (r1[1][1] < r2[0][1] || r1[0][1] > r2[1][1]) {
					System.out.println("d");
				}
				// 3.2. 선분으로 만나는 경우
				if (r1[0][1] == r2[1][1] || r1[1][1] == r2[0][1]) {
					System.out.println("b");
				}
				// 3.3. 사각형으로 만나는 경우
				if (r1[0][1] < r2[1][1] && r1[1][1] > r2[0][1]) {
					System.out.println("a");
				}

			}

		}
	}

}
