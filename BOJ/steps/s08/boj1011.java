package steps.s08;

import java.io.*;

public class boj1011 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] temp = br.readLine().split(" ");
				long N = Long.parseLong(temp[1]) - Long.parseLong(temp[0]);
			    long idx = (long) Math.floor((-1 + Math.sqrt(1 + 4 * N)) / 2);
				long res = N - idx * (idx + 1);
				long count = 0;
				if (res == 0) {
					sb.append(2 * idx);
				}
				else if (res != 0) {
					if(res>(idx+1)) {
						count = res/(idx+1);
						res -= count*(idx+1);
					}
					
					count++;
					sb.append(2 * idx + count);
				}
				sb.append("\n");
				
			}
			System.out.println(sb);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
