package com;

import java.io.*;
import java.util.*;

public class BOJ1043 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st2.nextToken());

		if (T == 0) {
			System.out.println(M);

		} else {

			Queue<Integer> queue = new LinkedList<Integer>(); // 진실을 아는 사람을 집어넣는 큐
			boolean[] know = new boolean[N + 1]; // 진실을 아는 사람인지 여부
			boolean[] lie = new boolean[M]; // 진실을 말한 파티인지 여부

			for (int i = 0; i < T; i++) {
				int temp = Integer.parseInt(st2.nextToken());
				queue.offer(temp);
				know[temp] = true;
			}

			int[][] party = new int[M][N];
			for (int i = 0; i < M; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st3.nextToken());
				for (int j = 0; j < p; j++) {
					party[i][j] = Integer.parseInt(st3.nextToken());

				}
			}

			while (!queue.isEmpty()) {
				int t = queue.poll(); // 큐에서 하나씩 뽑아서
				know[t] = true; // 진실을 안다고 표시한 뒤
				for (int i = 0; i < party.length; i++) {
					for (int j = 0; j < party[i].length; j++) {
						// party[][]를 완탐해서 t가 속해있는지 여부를 확인
						if (party[i][j] == 0)
							break;
						if (party[i][j] == t) {
							lie[i] = true; // t가 들어있는 파티는 진실을 아는 파티이므로 표시
							for (int k = 0; k < party[i].length; k++) {
								if (party[i][k] == 0)
									break;
								if (party[i][k] != t && know[party[i][k]] == false) {
									queue.offer(party[i][k]); // 해당 파티에 있는 사람 큐에 추가
								}
							}
						}
					}
				}
			}
			int result = 0;

			for (int i = 0; i < lie.length; i++) {
				if (lie[i] == false)
					result++;
			}

			System.out.println(result);
		}
	}

}
