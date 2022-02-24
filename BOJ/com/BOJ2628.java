package com;

import java.io.*;
import java.util.*;

public class BOJ2628 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st1.nextToken());
		int Y = Integer.parseInt(st1.nextToken());

		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> xIdx = new ArrayList<>();
		ArrayList<Integer> yIdx = new ArrayList<>();

		xIdx.add(0);
		yIdx.add(0);
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st2.nextToken());
			int idx = Integer.parseInt(st2.nextToken());

			switch (direction) {
			case 0:
				xIdx.add(idx);
				break;
			case 1:
				yIdx.add(idx);
				break;
			}

		}
		xIdx.add(Y);
		yIdx.add(X);

		Collections.sort(xIdx);
		Collections.sort(yIdx);

		int maxV = 0;
		for (int i = 0; i < xIdx.size() - 1; i++) {
			for (int j = 0; j < yIdx.size() - 1; j++) {
				int temp = (xIdx.get(i + 1) - xIdx.get(i)) * (yIdx.get(j + 1) - yIdx.get(j));
				if (temp > maxV) {
					maxV = temp;
				}
			}
		}

		System.out.println(maxV);

	}

}
