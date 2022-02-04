package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());	// tc 읽는 처음 한번
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());	// 5
			int M = Integer.parseInt(st1.nextToken());	// 2
			
			int [][] map = new int [N][N];
			
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			// N과 M의 크기를 비교하면, M의 왼쪽 끝 지점만 움직여서 탐색이 가능
			int result = 0;
			
			for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					int compare = 0;
					// 여기까지 왼쪽 위 기준점, 밑에서 탐색해서 result값 도출
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							compare += map[i+k][j+l];
						}
					}
					if(compare >= result) {
						result = compare;
					}
				}
			}
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);
	}

}
