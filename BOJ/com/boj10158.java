package com;

import java.io.*;
import java.util.StringTokenizer;

public class boj10158 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken()); // 가로
		int h = Integer.parseInt(st.nextToken()); // 세로

		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st2.nextToken());
		int q = Integer.parseInt(st2.nextToken()); // 개미 좌표 (p,q)

		int t = Integer.parseInt(br.readLine()); // t번 이동

		// solve

		int wT = t % (2 * w); // w에 대해서는 이것만 유의미
		int hT = t % (2 * h); // h에 대해서는 이것만 유의미

		int[] pos = { p, q }; // 배열 필요 없음

		if (wT <= w - p) {
			pos[0] = p + wT;
		}
		if (wT > (w - p) && wT <= (2 * w - p)) {
			pos[0] = 2 * w - wT - p;
		}

		if (wT > 2 * w - p && wT < 2 * w) {
			pos[0] = wT - 2 * w + p;
		}

		if (hT <= (h - q)) {
			pos[1] += hT;
		}
		if (hT > (h - q) && hT <= (2 * h - q)) {
			pos[1] = 2 * h - hT - q;
		}

		if (hT > 2 * h - q && hT < 2 * h) {
			pos[1] = hT - 2 * h + q;
		}

		System.out.println(pos[0] + " " + pos[1]);

	}

}
