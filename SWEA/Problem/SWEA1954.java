package swea;

import java.io.*;

public class SWEA1954 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int T = Integer.parseInt(br.readLine());

			int[] dir_x = { 0, 1, 0, -1 };
			int[] dir_y = { 1, 0, -1, 0 };

			for (int i = 0; i < T; i++) {
				sb.append(String.format("#%d \n", i+1));
				int N = Integer.parseInt(br.readLine());
				int[][] map = new int[N][N];
				map[0][0] = 1;
				int[] init = { 0, 0 };
				int idx = 2;
				int d = 0;
				while (idx<=N*N) {

					int x = init[0] + dir_x[d];
					int y = init[1] + dir_y[d];
					if (x < 0 || y < 0 || x >= N || y >= N || map[x][y] != 0) {
						d = (d+1) %4;
						
					} 
					else {
						map[x][y] = idx;
						idx++;
						init[0] += dir_x[d];
						init[1] += dir_y[d];
						
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
