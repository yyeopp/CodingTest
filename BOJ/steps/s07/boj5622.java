package steps.s07;

import java.io.*;

public class boj5622 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result=0;
		try {
			char [] tc = br.readLine().toCharArray();
			
			for (int i = 0; i < tc.length; i++) {
				if ( tc[i] >64 && tc[i] <= 67) {
					result += 3;
				}
				if ( tc[i] >67 && tc[i] <= 70) {
					result += 4;
				}
				if ( tc[i] >70 && tc[i] <= 73) {
					result += 5;
				}
				if ( tc[i] >73 && tc[i] <= 76) {
					result += 6;
				}
				if ( tc[i] >76 && tc[i] <= 79) {
					result += 7;
				}
				if ( tc[i] >79 && tc[i] <= 83) {
					result += 8;
				}
				if ( tc[i] >83 && tc[i] <= 86) {
					result += 9;
				}
				if ( tc[i] >86 && tc[i] <= 90) {
					result += 10;
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
	}

}
