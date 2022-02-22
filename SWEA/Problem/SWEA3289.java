package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA3289 {

	static int n, m;
	static int[] parents;

	static void makeSet() {
		parents = new int[n+1];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {

		if (a == parents[a]) {
			return a;
		} else {
			return parents[a] = findSet(parents[a]);
		}
	}

	static boolean union(int a, int b) {

		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		} else {
			parents[bRoot] = aRoot;
			return true;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st1.nextToken());
			m = Integer.parseInt(st1.nextToken());
			makeSet();

			for (int i = 0; i < m; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st2.nextToken());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				if (cal == 0) {
					union(a, b);
				} else if (cal == 1) {
					if (findSet(a) == findSet(b)) {
						sb.append(1);
					} else if (findSet(a) != findSet(b)) {
						sb.append(0);
					}
				}

			}
			sb.append("\n");

		}
		System.out.println(sb);
	}

}
