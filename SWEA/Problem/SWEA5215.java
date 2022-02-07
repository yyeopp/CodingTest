package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA5215 {
	static int N, L, R;

	static int[][] input;
	static int[][] results;
	static boolean[] select;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken()); // 재료 수
			L = Integer.parseInt(st1.nextToken()); // 맥스 칼로리
			
			input = new int[N][2];
			results = new int[(int) Math.pow(2, N)][2];
			select = new boolean[N];

			for (int i = 0; i < input.length; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					input[i][j] = Integer.parseInt(st2.nextToken());

				}
			} // 인풋값 입력 완료 -- 여기까지는 별 문제 없다.
			
			R=0;
			subset(0);		// 부분집합 추출, results 배열 완성

			int result = 0;
			for (int i = 0; i < results.length; i++) {
				if(results[i][1] > L) {
					continue;
				}
				if(results[i][0] >= result) {
					result = results[i][0];
				}
			}
			sb.append(result+"\n");
		}
		
		System.out.println(sb);
	}

	public static void subset(int cnt) {

		if (cnt == N) {
			sum(R);
			R++;
			return;
		}

		select[cnt] = true;
		subset(cnt + 1);
		select[cnt] = false;
		subset(cnt + 1);

	}

	public static void sum(int R) {
		for (int i = 0; i < N; i++) {
			if (select[i]) {
				results[R][0] += input[i][0];
				results[R][1] += input[i][1];
			}
		}
	}

}
