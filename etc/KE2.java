import java.io.*;
import java.util.*;

public class KE2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] map = new char[10][10];
		boolean[][] checked = new boolean[10][10];

		for (int i = 0; i < 10; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[] home = new int[2];
		int[] rock = new int[2];
		int[] quest = new int[2];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'H') {
					home[0] = i;
					home[1] = j;
				} else if (map[i][j] == 'R') {
					rock[0] = i;
					rock[1] = j;
				} else if (map[i][j] == 'M') {
					quest[0] = i;
					quest[1] = j;
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(home);
		checked[home[0]][home[1]] = true;
		int depth = -1;
		int prev = 1;
		int next = 0;
		boolean up = false;

		int result = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {

			prev--;

			if (prev == 0) {
				depth++;
				up = true;
			}

			int[] pos = queue.poll();

			if (pos[0] == quest[0] && pos[1] == quest[1]) {
				if (queue.isEmpty()) {
					depth--;
				} else if (up) {
					depth--;
				}
				if (depth < result) {
					result = depth;
				}
			}

			for (int i = 0; i < 4; i++) {

				int x = pos[0] + dx[i];
				int y = pos[1] + dy[i];

				if (x < 0 || x >= 10 || y < 0 || y >= 10 || checked[x][y] || (x == rock[0] && y == rock[1])) {
					continue;
				}
				next++;
				queue.add(new int[] { x, y });
				checked[x][y] = true;
			}
			if (up) {
				prev = next;
				next = 0;
				up = false;
			}

		}
		System.out.println(result);

	}

}
