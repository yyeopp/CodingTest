package ws0203;

import java.io.*;

public class SWEA1289 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				
				String [] temp = br.readLine().split("");
				int[] tc = new int[temp.length];
				int count = 0;
				int tmp = 0;
				for (int j = 0; j < tc.length; j++) {
					tc[j] = Integer.parseInt(temp[j]);
					
					if(tc[j] == tmp) {
						continue;
					}
					if(tc[j] != tmp) {
						tmp = tc[j];
						count++;
					}
				}
				sb.append(String.format("#%d %d", i+1,count)).append("\n");
			}
			System.out.println(sb);
			
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
