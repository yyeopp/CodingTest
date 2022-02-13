package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj10157 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); // 가로
		int R = Integer.parseInt(st.nextToken()); // 세로

		int K = Integer.parseInt(br.readLine());

		int[][] map = new int[R + 1][C + 1];
		// (0,n)이랑 (n,0)은 싹 날리고 (1,1)부터 (n,n)까지 사용
		// 배열 상 시작점은 R,1 -> 1,1 -> 1,C -> R,C -> ...

		int[] pos = { R + 1, 1 };
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int count = 1;
		int idx = 0;

		if (K > C * R) {
			System.out.println(0);
		} else {
			while (count <= K) {
				int dir = idx % 4;

				pos[0] += dx[dir];
				pos[1] += dy[dir];
				if (pos[0] < 1 || pos[0] > R || pos[1] < 1 || pos[1] > C || map[pos[0]][pos[1]] != 0) {
					pos[0] -= dx[dir];
					pos[1] -= dy[dir];
					idx++;
					continue;
				}
				map[pos[0]][pos[1]] = count;
				count++;

			}

			System.out.print(pos[1] + " " + (R - pos[0] + 1));
		}
	}

}
