package com;

import java.io.*;
import java.util.ArrayList;

public class BOJ2635 {

	static int N;

	static ArrayList<Integer> temp, result;

	static void numbers(int a, int b) {

		if (a-b < 0) {
			if (temp.size() > result.size()) {
				result.clear();
				for (int i = 0; i < temp.size(); i++) {
					result.add(temp.get(i));
				}
			}
			temp.clear();
			return;
			
		}
		temp.add(a - b);
		numbers(b, a - b);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());

		temp = new ArrayList<>();
		result = new ArrayList<>();
		
		for (int i = N/2; i <= N; i++) {
			temp.add(N);
			temp.add(i);
			numbers(N,i);
		}
		sb.append(result.size()).append("\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append(" ");
		}
		System.out.println(sb);
	}

}
