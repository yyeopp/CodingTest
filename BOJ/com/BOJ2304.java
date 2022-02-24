package com;

import java.io.*;
import java.util.*;

public class BOJ2304 {

	static class Column implements Comparable<Column> {
		int L, H;

		public Column(int l, int h) {
			L = l;
			H = h;
		}

		@Override
		public int compareTo(Column o) {
			return this.L - o.L;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Column[] cols = new Column[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Column c = new Column(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			cols[i] = c;
		}

		Arrays.sort(cols);

		Stack<Column> beforeP = new Stack<>();
		Stack<Column> afterP = new Stack<>();

		ArrayList<Column> peaks = new ArrayList<>();

		for (Column c : cols) {

			if (peaks.isEmpty()) {
				peaks.add(c);
				continue;
			}

			if (c.H > peaks.get(0).H) {
				beforeP.add(peaks.get(0));
				peaks.clear();
				afterP.clear();
				peaks.add(c);
				continue;
			}
			if (c.H == peaks.get(0).H) {
				peaks.add(c);
				afterP.clear();
				continue;
			}
			if (c.H < peaks.get(0).H) {
				if (afterP.isEmpty()) {
					afterP.add(c);
					continue;
				}
				if (afterP.peek().H > c.H) {
					afterP.add(c);
					continue;
				}
				while (!afterP.isEmpty() && afterP.peek().H <= c.H) {
					afterP.pop();
				}
				afterP.add(c);
			}

		}

		int sum = 0;

		if (beforeP.size() > 0) {
			for (int i = 0; i < beforeP.size() - 1; i++) {
				sum += (beforeP.get(i + 1).L - beforeP.get(i).L) * beforeP.get(i).H;
			}
			sum += (peaks.get(0).L - beforeP.get(beforeP.size() - 1).L) * beforeP.get(beforeP.size() - 1).H;
		}
		if (peaks.size() != 1) {
			sum += (peaks.get(peaks.size() - 1).L - peaks.get(0).L + 1) * peaks.get(0).H;
		}
		if (peaks.size() == 1) {
			sum += peaks.get(0).H;
		}
		if (afterP.size() > 0) {
			Column temp = afterP.pop();
			while (!afterP.isEmpty()) {
				sum += (temp.L - afterP.peek().L) * temp.H;
				temp = afterP.pop();
			}
			sum += (temp.L - peaks.get(peaks.size() - 1).L) * temp.H;
		}
		System.out.println(sum);

	}

}
