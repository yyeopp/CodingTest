package todo;

import java.io.*;
import java.util.*;

public class BOJ1238_timeout {

	static int min;

	@SuppressWarnings("rawtypes")
	private static void goParty(int n, int X, ArrayList[] list, boolean[] checked, int result) {

		if (n == X) {
			if (result < min) {
				min = result;
			}
			return;
		}
		checked[n] = true;

		for (int i = 0; i < list[n].size(); i++) {
			int[] temp = (int[]) list[n].get(i);
			if (!checked[temp[0]]) {
				result += temp[1];
				goParty(temp[0], X, list, checked, result);
				result -= temp[1];
				checked[temp[0]] = false;

			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int X = Integer.parseInt(st.nextToken()); // 지정된 도착점 (왕복할 예정)

		ArrayList[] list = new ArrayList[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new int[] { finish, weight });
		}

		// solve

		// 1. 개별 N에 대해 X로 향하는 최단경로를 도출하는 건 DFS.

		int[] go = new int[N + 1]; // 가는 비용
		boolean[] checked = new boolean[N + 1];

		// 각 정점에 대해 DFS
		for (int i = 1; i < list.length; i++) {
			int result = 0;
			min = Integer.MAX_VALUE;
			goParty(i, X, list, checked, result);
			go[i] = min;
			Arrays.fill(checked, false);
		}
//		System.out.println(Arrays.toString(go));

		// 2. X에서 개별 N으로 돌아가는 최단경로를 도출하는 건 다익스트라.

		int[] back = new int[N + 1];
		Arrays.fill(back, Integer.MAX_VALUE);
		back[X] = 0;

		PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		pQ.add(new int[] { X, 0 });
		while (!pQ.isEmpty()) {
			int[] temp = pQ.poll();
			if (temp[1] > back[temp[0]]) {
				continue;
			}
			// 이걸 통과한 시점에서, temp[0] 정점으로 가는 최단경로는 수정됨

			for (int i = 0; i < list[temp[0]].size(); i++) {
				int[] next = (int[]) list[temp[0]].get(i);
				if (back[next[0]] > back[temp[0]] + next[1]) {
					// 수정된 최단경로 (temp[0]을 거치는)를 반영해서,
					// 다른 정점(next[0])으로의 최단경로도 수정될 가능성이 있다면
					back[next[0]] = back[temp[0]] + next[1];
					pQ.add(new int[] { next[0], back[next[0]] });
					// 수정하면서 pQ에 새롭게 추가. next[0]을 "고려하기" 시작.
				}
			}

		}
//		System.out.println(Arrays.toString(back));

		// 3. 둘을 합치자!
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (go[i] + back[i] > max) {
				max = go[i] + back[i];
			}
		}
		System.out.println(max);

	}

}
