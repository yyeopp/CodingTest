package todo;

import java.io.*;
import java.util.*;

public class BOJ18870 {

	static class Edge {
		int pos;
		int ord;

		public Edge(int pos, int ord) {
			this.pos = pos;
			this.ord = ord;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> pQ = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.pos - o2.pos;
			}
		});

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			pQ.add(new Edge(n, i));
		}
		int[] result = new int[N];

		Edge prev = pQ.poll();
		result[prev.ord] = 0;
		int order = 1;

		while (!pQ.isEmpty()) {
			Edge next = pQ.poll();
			if (next.pos == prev.pos) {
				order--;
				result[next.ord] = order;
			} else {
				result[next.ord] = order;
			}
			prev = next;
			order++;
		}

		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);

	}

}
