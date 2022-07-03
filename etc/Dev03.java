import java.util.*;

public class Dev03 {

	public static void main(String[] args) {
		int rows = 9;
		int columns = 7;
		int[][] lands = { { 2, 2 }, { 2, 3 }, { 2, 5 }, { 3, 2 }, { 3, 4 }, { 3, 5 }, { 3, 6 }, { 4, 3 }, { 4, 6 },
				{ 5, 2 }, { 5, 5 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 6 }, { 7, 2 }, { 7, 6 }, { 8, 3 }, { 8, 4 },
				{ 8, 5 } };

		int[][] map = new int[rows][columns];

		for (int i = 0; i < lands.length; i++) {
			map[lands[i][0] - 1][lands[i][1] - 1] = 1;
		}

		boolean[][] checked = new boolean[rows][columns];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		checked[0][0] = true;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = pos[0] + dx[i];
				int y = pos[1] + dy[i];
				if (x < 0 || x >= rows || y < 0 || y >= columns || map[x][y] == 1 || checked[x][y]) {
					continue;
				}
				queue.add(new int[] { x, y });
				checked[x][y] = true;

			}

		}
		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0 && !checked[i][j]) {
					int sum = 1;
					queue.add(new int[] { i, j });
					checked[i][j] = true;

					while (!queue.isEmpty()) {
						int[] pos = queue.poll();
						for (int k = 0; k < 4; k++) {
							int x = pos[0] + dx[k];
							int y = pos[1] + dy[k];
							if (x < 0 || x >= rows || y < 0 || y >= columns || map[x][y] == 1 || checked[x][y]) {
								continue;
							}
							queue.add(new int[] { x, y });
							checked[x][y] = true;
							sum++;
						}

					}
					if (sum < min) {
						min = sum;
					}
					if (sum > max) {
						max = sum;
					}
				}
			}
		}
		if (min == Integer.MAX_VALUE && max == 0) {
			min = -1;
			max = -1;
		}
		int[] answer = { min, max };
		System.out.println(Arrays.toString(answer));
	}

}
