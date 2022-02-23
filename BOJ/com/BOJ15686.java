package com;

import java.io.*;
import java.util.*;

public class BOJ15686 {
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static int[] idx;
	static int[] selected;
	static ArrayList<int[]> house;
	static ArrayList<int[]> chicken;

	static void combination(int cnt, int start) {
		if (cnt == M) {
			int distance = getDistance();
			if (result > distance) {
				result = distance;
			}
			return;
		}

		for (int i = start; i < idx.length; i++) {
			selected[cnt] = idx[i];
			combination(cnt + 1, i + 1);
		}
	}

	static int getDistance() {

		int totalD = 0;

		for (int i = 0; i < house.size(); i++) {
			int eachD = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				int temp = Math.abs(house.get(i)[0] - chicken.get(selected[j])[0])
						+ Math.abs(house.get(i)[1] - chicken.get(selected[j])[1]);
				if (eachD > temp) {
					eachD = temp;
				}
			}
			totalD += eachD;
		}

		return totalD;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());

		int[][] map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if (map[i][j] == 1) {
					house.add(new int[] { i, j });
				}
				if (map[i][j] == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}
		idx = new int[chicken.size()];
		selected = new int[M];
		for (int i = 0; i < idx.length; i++) {
			idx[i] = i;
		}
		combination(0, 0);
		System.out.println(result);

	}

}
