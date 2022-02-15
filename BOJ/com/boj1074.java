package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj1074 {

	static int N, r, c, count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);
		int max = N*N;

		Z(size, 1, max);
		System.out.println(count);
	}

	public static void Z(int size, int start, int end) {
		int idx = size / 2;

		if (idx == 0) {
			return;
		}

		if (r < idx && c < idx) {
			Z(idx, start, idx*idx);

		}
		if (r < idx && c >= idx) {
			c -= idx;
			count += idx*idx;
			Z(idx, idx*idx, idx*idx*2);

		}
		if (r >= idx && c < idx) {
			r -= idx;
			count += idx*idx*2;
			Z(idx, idx*idx*2, idx*idx*3);

		}
		if (r >= idx && c >= idx) {
			r -= idx;
			c -= idx;
			count += idx*idx*3;
			Z(idx, idx*idx*3, end);
		}

	}

}
