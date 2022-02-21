package swea;

import java.io.*;
import java.util.*;

public class SWEA1238 {
	static int N;
	static int[] depth;

	static class Node {

		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	static void bfs(Node[] adjList, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];
		queue.offer(start);
		visited[start] = true;
		depth = new int[101];

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
					depth[temp.vertex] = depth[current] + 1;
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st1 = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st1.nextToken());
			int start = Integer.parseInt(st1.nextToken());

			Node[] list = new Node[101];

			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st2.nextToken());
				int to = Integer.parseInt(st2.nextToken());

				list[from] = new Node(to, list[from]);
			}
			bfs(list, start);
			int result = 0;
			int idx = 0;
			for (int i = 0; i < depth.length; i++) {
				if (depth[i] >= result) {
					result = depth[i];
					idx = i;
				}
			}

			sb.append(idx).append("\n");

		}
		System.out.println(sb);
	}

}
