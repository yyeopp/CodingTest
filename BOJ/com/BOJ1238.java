package todo;

import java.io.*;
import java.util.*;

public class BOJ1238 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int X = Integer.parseInt(st.nextToken()); // 지정된 도착점 (왕복할 예정)

		ArrayList[] list = new ArrayList[N + 1];
		ArrayList[] reverse = new ArrayList[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<int[]>();
			reverse[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new int[] { finish, weight });
			reverse[finish].add(new int[] { start, weight });
		}

		// solve: 각 정점에서 X로 가는 최소비용과 X에서 각 정점으로 가는 최소비용을 각각 산출해 더해야한다.
		// 전자의 경우 DFS로 푸는게 직관적이지만, 시간초과를 유발한다.
		// 이를 해결하기 위해, 간선정보를 역으로 기록한 reverse 배열을 만들어놓고
		// reverse와 list에 대해 각기 다익스트라 알고리즘을 활용한다.

		int[] go = new int[N + 1];
		Arrays.fill(go, Integer.MAX_VALUE);
		go[X] = 0;

		PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		pQ.add(new int[] { X, 0 });
		while (!pQ.isEmpty()) {
			int[] temp = pQ.poll();
			if (temp[1] > go[temp[0]]) {
				continue;
			}
			// 이걸 통과한 시점에서, temp[0] 정점으로 가는 최단경로는 수정됨

			for (int i = 0; i < reverse[temp[0]].size(); i++) {
				int[] next = (int[]) reverse[temp[0]].get(i);
				if (go[next[0]] > go[temp[0]] + next[1]) {
					// 수정된 최단경로 (temp[0]을 거치는)를 반영해서,
					// 다른 정점(next[0])으로의 최단경로도 수정될 가능성이 있다면
					go[next[0]] = go[temp[0]] + next[1];
					pQ.add(new int[] { next[0], go[next[0]] });
					// 수정하면서 pQ에 새롭게 추가. next[0]을 "고려하기" 시작.
				}
			}

		}
		pQ.clear();

		int[] back = new int[N + 1];
		Arrays.fill(back, Integer.MAX_VALUE);
		back[X] = 0;

		pQ.add(new int[] { X, 0 });
		while (!pQ.isEmpty()) {
			int[] temp = pQ.poll();
			if (temp[1] > back[temp[0]]) {
				continue;
			}

			for (int i = 0; i < list[temp[0]].size(); i++) {
				int[] next = (int[]) list[temp[0]].get(i);
				if (back[next[0]] > back[temp[0]] + next[1]) {
					back[next[0]] = back[temp[0]] + next[1];
					pQ.add(new int[] { next[0], back[next[0]] });
				}
			}

		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (go[i] + back[i] > max) {
				max = go[i] + back[i];
			}
		}
		System.out.println(max);

	}

}
