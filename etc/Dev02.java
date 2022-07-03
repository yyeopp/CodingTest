import java.util.*;

public class Dev02 {

	public static void main(String[] args) {

		int n = 5;
		boolean horizontal = false;

		int[][] answer = new int[n][n];

		answer = cleaning(n, horizontal, answer);

		for (int i = 0; i < answer.length; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}

	}

	static int[] hDx = { 0, 1, 0, -1 };
	static int[] hDy = { 1, 0, -1, 0 };

	static int[] vDx = { 1, 0, -1, 0 };
	static int[] vDy = { 0, 1, 0, -1 };

	private static int[][] cleaning(int n, boolean horizontal, int[][] map) {

		int[] dx, dy;

		if (horizontal) {
			dx = hDx;
			dy = hDy;
		} else {
			dx = vDx;
			dy = vDy;
		}

		int finish = n * n;
		int idx = 2;
		int size = 1;

		boolean[][] checked = new boolean[n][n];

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0 });
		checked[0][0] = true;
		map[0][0] = 1;

		while (idx <= finish) {

			int[] pos = queue.poll();

			boolean up = true;

			for (int i = 0; i < 4; i++) {
				int x = pos[0] + dx[i];
				int y = pos[1] + dy[i];

				if (x < 0 || x > size || y < 0 || y > size || checked[x][y]) {
					continue;
				}
				queue.add(new int[] { x, y });
				checked[x][y] = true;
				map[x][y] = idx;
				up = false;
				break;
			}
			idx++;
			if (up) {
				idx--;
				size++;
				queue.add(pos);
			}

		}
		return map;

	}

}
