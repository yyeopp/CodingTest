package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj2669 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[101][101];

		int[] start = new int[2];
		int[] end = new int[2];

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());

			for (int j = start[0]; j < end[0]; j++) {
				for (int j2 = start[1]; j2 < end[1]; j2++) {
					map[j][j2]++;
				}
			}

		}
		
		
		int result = 0;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] > 0) {
					result ++;
				}
			}
		}
		System.out.println(result);

	}

}
