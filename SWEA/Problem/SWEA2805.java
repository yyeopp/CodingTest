package swea;

import java.io.*;

public class SWEA2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());

			int[][] map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
			// 여기까지 맵 완성

			int result = 0;
			for (int i = 0; i < map.length; i++) {

				if (i <= N / 2) {
					for (int j = N / 2 - i; j <= N / 2 + i; j++) {
						result += map[i][j];
					}
				}
				if (i > N / 2) {
					for (int j = N / 2 - (N - i - 1); j <= N / 2 + (N - i - 1); j++) {
						result += map[i][j];
					}

				}
			}
			sb.append(result).append("\n");

		}
		System.out.println(sb);

	}

}
