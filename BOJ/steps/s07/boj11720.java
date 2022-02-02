package steps.s07;

import java.io.*;

public class boj11720 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			String [] temp = br.readLine().split("");
			int sum = 0;
			for (int i = 0; i < temp.length; i++) {
				sum += Integer.parseInt(temp[i]);
			}
			System.out.println(sum);
			
			
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
