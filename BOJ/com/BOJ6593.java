package todo;

import java.io.*;
import java.util.*;

public class BOJ6593 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());
			if (L == 0) {
				break;
			}
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			char[][][] building = new char[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					building[i][j] = br.readLine().toCharArray();
				}
				br.readLine();
			}

			int[] pos = new int[4];

			boolean[][][] checked = new boolean[L][R][C];

			loop: for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					for (int k = 0; k < C; k++) {
						if (building[i][j][k] == 'S') {
							pos[0] = i;
							pos[1] = j;
							pos[2] = k;
							pos[3] = 0;
							checked[i][j][k] = true;
							break loop;
						}
					}
				}
			}

			int[] dl = { 0, 0, 0, 0, 1, -1 };
			int[] dr = { -1, 1, 0, 0, 0, 0 };
			int[] dc = { 0, 0, -1, 1, 0, 0 };

			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(pos);
			int time = -1;

			while (!queue.isEmpty()) {
				pos = queue.poll();

				if (building[pos[0]][pos[1]][pos[2]] == 'E') {
					time = pos[3];
					break;
				}

				for (int i = 0; i < 6; i++) {
					int l = pos[0] + dl[i];
					int r = pos[1] + dr[i];
					int c = pos[2] + dc[i];

					if (l < 0 || l >= L || r < 0 || r >= R || c < 0 || c >= C || checked[l][r][c]
							|| building[l][r][c] == '#') {
						continue;
					}

					queue.add(new int[] { l, r, c, pos[3] + 1 });
					checked[l][r][c] = true;

				}
			}

			if (time == -1) {
				sb.append("Trapped!");
			} else {
				sb.append("Escaped in ").append(time).append(" minute(s).");
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}

}
