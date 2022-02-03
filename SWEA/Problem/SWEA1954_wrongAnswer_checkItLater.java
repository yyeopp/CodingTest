package swea;

import java.io.*;

public class SWEA1954_wrongAnswer_checkItLater {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int T = Integer.parseInt(br.readLine());

			int[] dir_x = { -1, 0, 1, 0 };
			int[] dir_y = { 0, 1, 0, -1 };

			for (int i = 0; i < T; i++) { // TC에 해당
				int N = Integer.parseInt(br.readLine()); // 크기
				int[][] map = new int[N][N]; // 채워야 할 맵
				map[0][0] = 1;		// 초기값 설정
				int[] init = { 0, 0 };		// 탐색할 좌표
				int idx = 2;
				for (int k = 0; k < N * N; k++) {

					for (int j = 0; j < 4; j++) {
						int x = init[0] + dir_x[j];
						int y = init[1] + dir_y[j];
						if (x < 0 || y < 0 || x >= N || y >= N) {
							continue;
						} else {
							if (map[x][y] != 0) {
								continue;
							}
							if (map[x][y] == 0) {
								map[x][y] = idx;
								idx++;
								init[0] += dir_x[j];
								init[1] += dir_y[j];
								break;
							}

						}
					}
				}
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						sb.append(map[j][k] + " ");
					}
					sb.append("\n");
				}

			}
			System.out.println(sb);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
