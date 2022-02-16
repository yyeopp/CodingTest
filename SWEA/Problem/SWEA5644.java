package swea;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5644 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			sb.append("#").append(tc).append(" ");

			StringTokenizer st1 = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st1.nextToken()); // 사용자 이동 횟수
			int N = Integer.parseInt(st1.nextToken()); // BC 개수

			int[] A = new int[M]; // 사용자 A의 오더 목록
			int[] B = new int[M]; // 사용자 B의 오더 목록

			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < A.length; i++) {
				A[i] = Integer.parseInt(st2.nextToken());
			}
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for (int i = 0; i < B.length; i++) {
				B[i] = Integer.parseInt(st3.nextToken());
			}

			int[][] BC = new int[N][4]; // BC에 대한 정보

			for (int i = 0; i < N; i++) {
				StringTokenizer st4 = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st4.nextToken()); // x
				BC[i][1] = Integer.parseInt(st4.nextToken()); // y
				BC[i][2] = Integer.parseInt(st4.nextToken()); // C
				BC[i][3] = Integer.parseInt(st4.nextToken()); // P
			}

			// solve

			int[] posA = { 1, 1 };
			int[] posB = { 10, 10 };

			boolean[][] checkBC = new boolean[N][2];

			int pA = 0; // A 충전된 양
			int pB = 0; // B 충전된 양

			for (int i = 0; i <= M; i++) {

				int bcA = 0; // A가 만나는 BC 개수
				int bcB = 0; // B가 만나는 BC 개수

				for (int j = 0; j < BC.length; j++) {
					// 거리 측정
					int dA = Math.abs(BC[j][0] - posA[0]) + Math.abs(BC[j][1] - posA[1]);
					int dB = Math.abs(BC[j][0] - posB[0]) + Math.abs(BC[j][1] - posB[1]);

					// N개의 BC에 대해 영향권인지 조회
					if (dA <= BC[j][2]) {
						checkBC[j][0] = true;
						bcA++;
					} else if (dA > BC[j][2]) {
						checkBC[j][0] = false;
					}
					if (dB <= BC[j][2]) {
						checkBC[j][1] = true;
						bcB++;
					} else if (dB > BC[j][2]) {
						checkBC[j][1] = false;
					}

				}

				// bcA와 bcB가 둘다 0인 경우면 그냥 pass

				if (bcA != 0 && bcB == 0) { // A만 조회
					int temp = 0;
					for (int j = 0; j < N; j++) {
						if (checkBC[j][0] == true) {
							if (temp <= BC[j][3]) {
								temp = BC[j][3];
							}
						}
					}
					pA += temp;
				}
				if (bcA == 0 && bcB != 0) { // B만 조회
					int temp = 0;
					for (int j = 0; j < N; j++) {
						if (checkBC[j][1] == true) {
							if (temp <= BC[j][3]) {
								temp = BC[j][3];
							}
						}
					}
					pB += temp;

				}
				if (bcA != 0 && bcB != 0) { // 둘다 조회해야 함
					int dup = 0; // 겹치는 BC 개수

					for (int j = 0; j < N; j++) { // boolean 배열 순회하면서 확인
						if (checkBC[j][0] == true && checkBC[j][1] == true) {
							dup++;
						}
					}

					if (dup == 0) { // 겹치는 게 아예 없는 경우 - 그냥 각자 조회
						int tmpA = 0;
						int tmpB = 0;
						for (int j = 0; j < N; j++) {
							if (checkBC[j][0] == true) {
								if (tmpA <= BC[j][3]) {
									tmpA = BC[j][3];
								}
							}
							if (checkBC[j][1] == true) {
								if (tmpB <= BC[j][3]) {
									tmpB = BC[j][3];
								}
							}
						}
						pA += tmpA;
						pB += tmpB;
					}

					if (dup != 0) { // 겹치는 게 있는 경우
						if (dup == bcA && dup == bcB) { // 전부 겹친 경우.
							if (dup == 1) {
								int temp = 0;
								for (int j = 0; j < N; j++) {
									if (checkBC[j][0] == true) {
										if (temp <= BC[j][3]) {
											temp = BC[j][3];
										}
									}
								}
								pA += (temp / 2);
								pB += (temp / 2);
							}
							if (dup != 1) {
								int[] w = new int[N];
								for (int j = 0; j < N; j++) {
									if (checkBC[j][0] == true) {
										w[j] = BC[j][3];
									}
								}
								Arrays.sort(w);
								pA += w[N - 1];
								pB += w[N - 2];
							}
						}
						if (dup != bcA || dup != bcB) { // 전부 겹치지는 않은 경우.
							int[] dups = new int[N];

							int tmpA = 0;
							int tmpB = 0;

							for (int j = 0; j < N; j++) {
								if (checkBC[j][0] == true && checkBC[j][1] == true) {
									dups[j] = BC[j][3];
								}
								if (checkBC[j][0] == true && checkBC[j][1] == false) {
									if (tmpA <= BC[j][3]) {
										tmpA = BC[j][3];
									}
								}
								if (checkBC[j][0] == false && checkBC[j][1] == true) {
									if (tmpB <= BC[j][3]) {
										tmpB = BC[j][3];
									}
								}
							}
							Arrays.sort(dups);

							int dup1 = dups[N - 1];
							int dup2 = dups[N - 2];

							int[] w = { tmpA, tmpB, dup1, dup2 };
							Arrays.sort(w);

							pA += w[3];
							pB += w[2];

						}

					}

				}

				if (i == M) {
					break;
				}

				switch (A[i]) {

				case 1: // 상
					posA[1]--;
					break;
				case 2:// 우
					posA[0]++;
					break;
				case 3:// 하
					posA[1]++;
					break;
				case 4:// 좌
					posA[0]--;
					break;
				}

				switch (B[i]) {

				case 1:
					posB[1]--;
					break;
				case 2:
					posB[0]++;
					break;
				case 3:
					posB[1]++;
					break;
				case 4:
					posB[0]--;
					break;
				}

			}

			int result = pA + pB;
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
