package steps.s09;

import java.io.*;

public class boj11653 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		try {
			int N = Integer.parseInt(br.readLine());
			int tc = N;
			if(N==1) {}
			else if(N>1) {
				for (int i = 2; i <= N/2 +1; i++) {
					if(tc==1) {
						break;
					}
					if(tc%i != 0) {
						continue;
					}
					if(tc%i ==0) {
						sb.append(i).append("\n");
						tc /= i;
						i--;
					}
				}
				if(tc == N) {
					sb.append(tc);
				}
				
			}
			
			System.out.println(sb);
			
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
