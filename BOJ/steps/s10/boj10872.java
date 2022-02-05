package steps.s10;

import java.io.*;

public class boj10872 {
	
	static int factorial(int n) {
		if(n<1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));
	}

}
