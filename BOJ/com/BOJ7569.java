package todo;

import java.io.*;
import java.util.*;

public class BOJ7569 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] container = new int[N][M][H];

		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][][] checked = new boolean[N][M][H];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					container[j][k][i] = Integer.parseInt(st.nextToken());
					if (container[j][k][i] == 1) {
						queue.add(new int[] { j, k, i });
						checked[j][k][i] = true;
					}
				}
			}
		}

		int[] dx = { -1, 1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, -1, 1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, 1, -1 };

		int prev = queue.size();
		int next = 0;
		int depth = 0;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			prev--;

			for (int i = 0; i < 6; i++) {
				int x = pos[0] + dx[i];
				int y = pos[1] + dy[i];
				int z = pos[2] + dz[i];

				if (x < 0 || x >= N || y < 0 || y >= M || z < 0 || z >= H || container[x][y][z] != 0
						|| checked[x][y][z]) {
					continue;
				}

				queue.add(new int[] { x, y, z });
				container[x][y][z] = 1;
				checked[x][y][z] = true;
				next++;
			}

			if (prev == 0) {
				prev = next;
				next = 0;
				depth++;
			}
		}

		boolean finish = true;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (container[j][k][i] == 0) {
						finish = false;
					}
				}
			}
		}

		if (!finish) {
			System.out.println(-1);
		} else {
			System.out.println(depth - 1);
		}

	}

}
