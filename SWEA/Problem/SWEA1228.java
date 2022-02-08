package swea;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			
			LinkedList<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int R = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < R; i++) {
				st2.nextToken();
				int idx = Integer.parseInt(st2.nextToken());
				int order = Integer.parseInt(st2.nextToken());
				int [] nums = new int[order];
				for (int j = 0; j < order; j++) {
					nums[j] = Integer.parseInt(st2.nextToken());
				}
				for (int j = nums.length-1; j >=0; j--) {
					list.add(idx, nums[j]);
				}
				
			}
			for (int i = 0; i < 10; i++) {
				sb.append(list.pop()).append(" ");
			}
			sb.append("\n");
			
			
		}
		System.out.println(sb);
		
	}

}
