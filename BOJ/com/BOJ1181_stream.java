package com;

import java.io.*;
import java.util.*;

public class BOJ1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		List<String> words = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			words.add(br.readLine());
		}

		words.stream().distinct().sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
				.forEach((String s) -> sb.append(s).append("\n"));
		System.out.println(sb);
	}

}
