import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yabawi {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int X = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());

			// 인덱스 혼동 방지를 위해 한 칸 크게
			boolean [] yabawi = new boolean[N+1];
			
			// 간식 위치만 true
			yabawi[X] = true;
			
			// 현재 간식 위치
			int idx = X;		
			
			for (int i = 0; i < K; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				
				// 읽은 숫자 둘 중에 현재 간식 위치가 있으면 알고리즘 작동
				
				if(a!=idx && b!=idx) {
					continue;
				}
				
				if(a==idx) {
					yabawi[idx] = false;
					yabawi[b] = true;
					idx = b;
					continue;
				}
				if(b==idx) {
					yabawi[idx] = false;
					yabawi[a] = true;
					idx = a;
					continue;
				}
				
			}
			sb.append(idx).append("\n");
		}

		System.out.println(sb);
	}
	

}
