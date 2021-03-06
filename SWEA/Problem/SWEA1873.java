package swea;

import java.io.*;

public class SWEA1873 {
	static char shape = 'X'; // 차의 형태
	static char[] car = { '^', 'v', '<', '>' };
	static char[] dir = { 'U', 'D', 'L', 'R' };
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map = null;

	static void move(int[] carPos, char dir) {
		if (dir == 'U') {
			shape = car[0];

			carPos[0] += dx[0];
			carPos[1] += dy[0];

			if (carPos[0] < 0 || carPos[1] < 0 || carPos[0] >= map.length || carPos[1] >= map[0].length) {
				carPos[0] -= dx[0];
				carPos[1] -= dy[0];
				return;
			}
			if (map[carPos[0]][carPos[1]] == '*' || map[carPos[0]][carPos[1]] == '#'
					|| map[carPos[0]][carPos[1]] == '-') {
				carPos[0] -= dx[0];
				carPos[1] -= dy[0];
				return;
			}

		}
		if (dir == 'D') {
			shape = car[1];

			carPos[0] += dx[1];
			carPos[1] += dy[1];
			if (carPos[0] < 0 || carPos[1] < 0 || carPos[0] >= map.length || carPos[1] >= map[0].length) {
				carPos[0] -= dx[1];
				carPos[1] -= dy[1];
				return;
			}
			if (map[carPos[0]][carPos[1]] == '*' || map[carPos[0]][carPos[1]] == '#'
					|| map[carPos[0]][carPos[1]] == '-') {
				carPos[0] -= dx[1];
				carPos[1] -= dy[1];
				return;
			}

		}
		if (dir == 'L') {
			shape = car[2];

			carPos[0] += dx[2];
			carPos[1] += dy[2];
			if (carPos[0] < 0 || carPos[1] < 0 || carPos[0] >= map.length || carPos[1] >= map[0].length) {
				carPos[0] -= dx[2];
				carPos[1] -= dy[2];
				return;
			}
			if (map[carPos[0]][carPos[1]] == '*' || map[carPos[0]][carPos[1]] == '#'
					|| map[carPos[0]][carPos[1]] == '-') {
				carPos[0] -= dx[2];
				carPos[1] -= dy[2];
				return;
			}

		}
		if (dir == 'R') {
			shape = car[3];

			carPos[0] += dx[3];
			carPos[1] += dy[3];
			if (carPos[0] < 0 || carPos[1] < 0 || carPos[0] >= map.length || carPos[1] >= map[0].length) {
				carPos[0] -= dx[3];
				carPos[1] -= dy[3];
				return;
			}
			if (map[carPos[0]][carPos[1]] == '*' || map[carPos[0]][carPos[1]] == '#'
					|| map[carPos[0]][carPos[1]] == '-') {
				carPos[0] -= dx[3];
				carPos[1] -= dy[3];
				return;
			}

		}

	}

	static void shoot(int[] carPos, char dir) {

		int[] fire = { carPos[0], carPos[1] };

		if (shape == car[0]) { // 상

			while (fire[0] > 0) {
				fire[0] += dx[0];
				if (map[fire[0]][fire[1]] == '.' || map[fire[0]][fire[1]] == '-') {
					continue;
				}
				if (map[fire[0]][fire[1]] == '#') {
					break;
				}
				if (map[fire[0]][fire[1]] == '*') {
					map[fire[0]][fire[1]] = '.';
					break;
				}
			}

		}
		if (shape == car[1]) { // 하
			while (fire[0] < map.length - 1) {
				fire[0] += dx[1];
				if (map[fire[0]][fire[1]] == '.' || map[fire[0]][fire[1]] == '-') {
					continue;
				}
				if (map[fire[0]][fire[1]] == '#') {
					break;
				}
				if (map[fire[0]][fire[1]] == '*') {
					map[fire[0]][fire[1]] = '.';
					break;
				}
			}
		}
		if (shape == car[2]) { // 좌
			while (fire[1] > 0) {
				fire[1] += dy[2];
				if (map[fire[0]][fire[1]] == '.' || map[fire[0]][fire[1]] == '-') {
					continue;
				}
				if (map[fire[0]][fire[1]] == '#') {
					break;
				}
				if (map[fire[0]][fire[1]] == '*') {
					map[fire[0]][fire[1]] = '.';
					break;
				}
			}
		}
		if (shape == car[3]) { // 우
			while (fire[1] < map[fire[0]].length - 1) {
				fire[1] += dy[3];
				if (map[fire[0]][fire[1]] == '.' || map[fire[0]][fire[1]] == '-') {
					continue;
				}
				if (map[fire[0]][fire[1]] == '#') {
					break;
				}
				if (map[fire[0]][fire[1]] == '*') {
					map[fire[0]][fire[1]] = '.';
					break;
				}
			}
		}

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int T = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= T; tc++) {
				sb.append("#").append(tc).append(" ");
				String temp = br.readLine();
				int H = Integer.parseInt(temp.split(" ")[0]);
				int W = Integer.parseInt(temp.split(" ")[1]);

				map = new char[H][W]; // 전체 맵

				for (int i = 0; i < map.length; i++) {
					map[i] = br.readLine().toCharArray();
				}

				int[] carPosition = new int[2]; // 차의 위치

				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j] == car[0] || map[i][j] == car[1] || map[i][j] == car[2] || map[i][j] == car[3]) {
							carPosition[0] = i;
							carPosition[1] = j;
							shape = map[i][j];
							map[i][j] = '.';
						}
					}
				}

				int N = Integer.parseInt(br.readLine());
				char[] order = br.readLine().toCharArray();
				for (int i = 0; i < N; i++) {
					if (order[i] == 'S') {

						shoot(carPosition, order[i]);
					} else {
						move(carPosition, order[i]);
					}

				}
				map[carPosition[0]][carPosition[1]] = shape;
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						sb.append(map[i][j]);
					}
					sb.append("\n");
				}
			}
			System.out.println(sb);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
