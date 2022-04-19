package todo;

import java.io.*;
import java.util.*;

public class BOJ11650 {

	static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Coordinate> pqueue = new PriorityQueue<>(new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				if (o1.x != o2.x) {
					return o1.x - o2.x;
				} else {
					return o1.y - o2.y;
				}
			}

		});

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pqueue.offer(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for (int i = 0; i < N; i++) {
			Coordinate c = pqueue.poll();
			sb.append(c.x).append(" ").append(c.y).append("\n");
		}
		System.out.println(sb);
	}

}
