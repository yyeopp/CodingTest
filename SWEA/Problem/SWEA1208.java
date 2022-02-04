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
			// 박스는 100개의 칸
			
			int result = 0;
			for (int i = 0; i < d; i++) {		// 덤프 시작 - 300번쯤 함.
				
				
				int idxMax = 0;
				int idxMin = 0;
				int max = 1;
				int min = 100;	
				
				for (int j = 0; j < 100; j++) {		// 덤프 1회 당 박스를 1번씩 순회
					if (box[j] >= max) {		// 박스 속 숫자랑 맥스값 비교
						max = box[j];
						idxMax = j;			// 맥스값이 바뀐 경우 idx를 저장
					}
					if (box[j] <= min) {
						min = box[j];
						idxMin = j;
					}
				}
				result = max-min;
				
				if(result == 0 || result == 1) {
					sb.append(result + "\n");
					break;
				}
				box[idxMax] --;
				box[idxMin] ++;
				
				
			}
			sb.append(result + "\n");
			
			
		}
		System.out.println(sb);

	}

}
