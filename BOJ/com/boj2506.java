package com;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] tc = new int[N];
		LinkedList<Integer> list = new LinkedList<>();
		st.nextToken();
		list.add(1);
		int j = 2;
		for (int i = 1; i < tc.length; i++) {
			tc[i] = Integer.parseInt(st.nextToken());
			list.add(list.size() - tc[i], j);
			j++;

		}
		for (int i = 0; i < N; i++) {
			System.out.print(list.poll()+" ");
		}

	}

}
