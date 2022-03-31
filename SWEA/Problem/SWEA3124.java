package swea;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3124 {

	static int V;
	static int[] parents;
	static Edge[] list;

	private static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {

			return this.weight - o.weight;
		}

	}

	private static void makeSet() {
		parents = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}

	}

	private static int findSet(int n) {

		if (n == parents[n]) {
			return n;
		} else {
			return parents[n] = findSet(parents[n]);
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		} else {
			parents[aRoot] = bRoot;
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
			V = Integer.parseInt(st1.nextToken());
			int E = Integer.parseInt(st1.nextToken());
			list = new Edge[E];
			for (int i = 0; i < E; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st2.nextToken());
				int to = Integer.parseInt(st2.nextToken());
				int weight = Integer.parseInt(st2.nextToken());
				list[i] = new Edge(from, to, weight);
			}

			Arrays.sort(list);

			makeSet();
			int count = 0;
			long result = 0;

			for (Edge edge : list) {
				if (union(edge.from, edge.to)) {
					count++;
					result += edge.weight;
					if (count == V - 1) {
						break;
					}
				}
			}
			sb.append(result).append("\n");

		}
		System.out.println(sb);

	}

}
