package steps.s07;

import java.io.*;

public class boj1152 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String [] tc = br.readLine().trim().split(" ");
			if (tc[0].equals("")) {
				System.out.println(0);
			}
			else {System.out.println(tc.length);}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
