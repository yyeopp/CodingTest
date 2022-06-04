package com;

import java.io.*;
import java.util.*;

public class BOJ1916 {

	static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	static int N, C;
	static List<Node>[] nodeList;
	static int[] distance;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		nodeList = new ArrayList[N + 1];
		distance = new int[N + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		for (int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList[from].add(new Node(to, weight));

		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);

		System.out.println(distance[end]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		queue.add(new Node(start, 0));
		distance[start] = 0;

		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			int cur = curNode.to;

			if (check[cur] == true)
				continue;
			check[cur] = true;

			for (Node node : nodeList[cur]) {
				if (distance[node.to] > distance[cur] + node.weight) {
					distance[node.to] = distance[cur] + node.weight;
					queue.add(new Node(node.to, distance[node.to]));
				}
			}
		}
	}

}
