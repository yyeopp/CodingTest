package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1208 {

	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int d = Integer.parseInt(br.readLine());  // 덤프횟수
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] box = new int[100];	// 박스 나열
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());	// 박스 채우기
			}
			int max = 1;
			int min = 100;
			for (int i = 0; i < d; i++) {		// 덤프 시작
				
				for (int j = 0; j < 100; j++) {
					if (box[j] >= max) {
						max = box[j];
						System.out.println(max);
						
					}
					if (box[j] <= min) {
						min = box[j];
					}
				}
				if(max-min == 0 || max-min == 1) {
					sb.append(max-min + "\n");
					System.out.println("breaked");
					break;
				}
				max--;
				min++;
			}
			
		}
		System.out.println(sb);

	}

}
