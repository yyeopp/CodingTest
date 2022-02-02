package steps.s07;

import java.io.*;


public class boj2675 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String [] temp = br.readLine().split(" ");
				int R = Integer.parseInt(temp[0]);
				String [] tc = temp[1].split("");
				
				for (int j = 0; j < tc.length; j++) {
					for (int k = 0; k< R; k++) {
						sb.append(tc[j]);
					}
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
