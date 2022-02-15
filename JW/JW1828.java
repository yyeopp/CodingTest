package jw;

import java.io.*;
import java.util.*;

public class JW1828 {

	static class Chem implements Comparable<Chem> {

		int x, y;

		public Chem(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Chem o) {
			if (this.y < o.y) {
				return -1;
			}

			if (this.y == o.y) {
				if (this.x - this.y == o.x - o.y) {
					return 0;
				}
				if (this.x - this.y < o.x - o.y) {
					return 1;
				}
				if (this.x - this.y > o.x - o.y) {
					return -1;
				}
			}

			return 1;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Chem[] chems = new Chem[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Chem c = new Chem(x, y);
			chems[i] = c;

		}

		Arrays.sort(chems);

		int count = 1;
		int max = chems[0].y;

		for (int i = 1; i < chems.length; i++) {
			if (chems[i].x <= max) {
				continue;
			} else {
				count++;
				max = chems[i].y;
			}
		}
		System.out.println(count);

	}

}
