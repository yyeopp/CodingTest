package com;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2559 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		
		int [] nums = new int [N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st2.nextToken());
		}
		
		int temp = 0;
		for (int i = 0; i < K; i++) {
			temp += nums[i];
		}
		
		int result = temp;
		
		for (int i = 1; i <= N-K; i++) {
			temp = temp-nums[i-1]+nums[i+K-1];
			if(result < temp) {
				result = temp;
			}
		}
		System.out.println(result);
		
	}

}
