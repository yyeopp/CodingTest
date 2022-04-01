package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum=0;
		
		for (int i = 0; i < 5; i++) {
			sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		System.out.println(sum % 10);
	}

}
