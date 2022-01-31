package steps.s7;

import java.io.*;

public class boj2908 {
	static int sangsu(int n) {
		
		int ss = (n%10) * 100 + ((n/10)%10)*10 + (n/100);
		return ss;
		
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		try {
			String[] temp;
			int[] tc = new int[2];
			temp = br.readLine().split(" ");
			for (int i = 0; i < temp.length; i++) {
				tc[i] = boj2908.sangsu(Integer.parseInt(temp[i]));
			}
			
			if(tc[0] < tc[1]) {
				System.out.println(tc[1]);
			}
			else {
				System.out.println(tc[0]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
