package todo;

import java.io.*;
import java.util.*;

public class BOJ9205 {

	private static int distance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean sad = true;
			int prevX = Integer.parseInt(st.nextToken());
			int prevY = Integer.parseInt(st.nextToken());

			int[][] con = new int[n + 1][2];
			boolean[] checked = new boolean[n + 1];
			for (int i = 0; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				con[i][0] = Integer.parseInt(st.nextToken());
				con[i][1] = Integer.parseInt(st.nextToken());
			}

			// solve: BFS
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] { prevX, prevY });
			while (!queue.isEmpty()) {
				int[] pos = queue.poll();
				if (pos == con[n]) {
					sad = false;
					break;
				}

				for (int i = 0; i < con.length; i++) {
					if (distance(pos, con[i]) <= 1000 && !checked[i]) {
						queue.add(con[i]);
						checked[i] = true;
					}
				}
			}

			if (sad) {
				sb.append("sad");
			} else {
				sb.append("happy");
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}

}
