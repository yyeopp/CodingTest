package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1210 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			sb.append("#").append(tc).append(" ");
			int [][] map = new int[100][100];
			int idx = 0;
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			for (int i = 0; i < map.length; i++) {
				if(map[99][i] == 2) {
					idx = i;
					break;
				}
			}
			
			
			int[] pos = {98,idx};
			boolean left = false;
			boolean right = false;
			while(pos[0] > 0) {
				
				// 왼쪽 체크
				if(pos[1]!=0) {
					if(map[pos[0]][pos[1]-1] == 1 && !right) {
						pos[1] --;
						left = true;
						continue;
					}
				}
				
				// 오른쪽 체크
				if(pos[1]!=99) {
					if(map[pos[0]][pos[1]+1] == 1 && !left) {
						pos[1] ++;
						right = true;
						continue;
					}
				}
				// 위로 전진
				pos[0] --;
				left = false;
				right = false;
				
				
			}
			sb.append(pos[1]).append("\n");
			
			
			
			
		}
		System.out.println(sb);
	}

}
