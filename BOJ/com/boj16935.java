package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj16935 {

	static int N, M, R;
	static int[][] map;
	static int[] order;

	static void order1() {
		for (int i = 0; i < N / 2; i++) {
			int[] temp = map[i];
			map[i] = map[N - i - 1];
			map[N - i - 1] = temp;
		}
	}

	static void order2() {
		for (int i = 0; i < M / 2; i++) {
			int[] temp = new int[N];
			for (int j = 0; j < N; j++) {
				temp[j] = map[j][i];
				map[j][i] = map[j][M - i - 1];
				map[j][M - i - 1] = temp[j];
			}

		}
	}

	static void order3() {
		int[][] newMap = new int[M][N];
		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap[i].length; j++) {
				newMap[i][j] = map[N-j-1][i];
			}
		}
		map = newMap;
		int temp = N;
		N = M;
		M = temp;
	}

	static void order4() {
		int[][] newMap = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				newMap[i][j] = map[j][M-i-1];
			}
		}
		map = newMap;
		int temp = N;
		N = M;
		M = temp;
	}
	static void order5() {
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				newMap[i][j] = map[N/2+i][j];
			}
			for (int j = M/2; j < M; j++) {
				newMap[i][j] = map[i][j-M/2];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				newMap[i][j] = map[i][j+M/2];
			}
			for (int j = M/2; j < M; j++) {
				newMap[i][j] = map[i-N/2][j];
			}
		}
		map = newMap;
	}

	static void order6() {
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				newMap[i][j] = map[i][j+M/2];
			}
			for (int j = M/2; j < M; j++) {
				newMap[i][j] = map[i+N/2][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				newMap[i][j] = map[i-N/2][j];
			}
			for (int j = M/2; j < M; j++) {
				newMap[i][j] = map[i][j-M/2];
			}
		}
		map = newMap;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		R = Integer.parseInt(st1.nextToken());

		map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		order = new int[R];
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			order[i] = Integer.parseInt(st3.nextToken());
			switch (order[i]) {
			case 1:
				order1();
				break;
			case 2:
				order2();
				break;
			case 3:
				order3();
				break;
			case 4:
				order4();
				break;
			case 5:
				order5();
				break;
			case 6:
				order6();
				break;
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
