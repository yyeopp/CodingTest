package todo;

import java.io.*;
import java.util.*;

public class BOJ1753 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());

		ArrayList[] list = new ArrayList[V + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new int[] { v, w });
		}

		// solve

		int[] distance = new int[V + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;

		PriorityQueue<int[]> pqueue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});
		pqueue.add(new int[] { K, 0 });

		
		// 간선정보를 저장한 list는 원본 데이터. 건들지 않는다.
		// 출발점을 pqueue에 넣고 시작한다.
		
		while (!pqueue.isEmpty()) {

			int[] temp = pqueue.poll();
			// temp[0]은, queue에서 뽑힌 정점이 가리키는 정점의 번호
			// temp[1]은, 해당 정점으로의 weight
			// list[temp[0]]은 arrayList, 얘가 들고있는 간선들을 검토

			if (temp[1] > distance[temp[0]])
				continue;
			// distance[temp[0]]은 현재시점에서 K에서 temp[0] 정점까지 도달하는 최단거리를 담고있다
			// temp[1]은 distance[temp[0]]가 될 후보. 그게 더 크면 그냥 거름

			for (int i = 0; i < list[temp[0]].size(); i++) {
				int[] next = (int[]) list[temp[0]].get(i);
				if (distance[next[0]] > distance[temp[0]] + next[1]) {
					distance[next[0]] = distance[temp[0]] + next[1];
					pqueue.add(new int[] { next[0], distance[next[0]] });
				}
			}

		}
		for (int i = 1; i < distance.length; i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(distance[i]).append("\n");
			}
		}
		System.out.println(sb);
	}

}
