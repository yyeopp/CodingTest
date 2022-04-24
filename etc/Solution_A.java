import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_10_강성엽 {

	// DFS 풀이법.

	// 지도의 가로, 세로
	static int M, N;
	// 지도
	static int[][] map;
	// 무한반복 막기 위한 boolean 지도
	static boolean[][] checked;
	// 결과
	static int result;

	// 델타 활용
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// DFS가 이루어질 메서드. "돼지의 현재 위치"인 px,py가 파라미터로 입력
	private static void mushroom(int px, int py) {

		// 목적지에 도착하면
		if (px == M - 1 && py == N - 1) {

			// 결과 +1 하고 return
			result++;
			return;
		}

		// 델타 활용
		for (int i = 0; i < 4; i++) {

			// 새로운 목적지 후보인 x,y
			int x = px + dx[i];
			int y = py + dy[i];

			// 배열 이탈했거나, 현재 시점(DFS)에 지나온 길이면 continue
			if (x < 0 || x >= M || y < 0 || y >= N || checked[x][y]) {
				continue;
			}

			// 돼지가 갈 수 없는 길 (내리막이 아니면) 이면 continue
			if (map[x][y] - map[px][py] >= 0) {
				continue;
			}

			// 지나온 길임을 체크하고
			checked[x][y] = true;

			// 재귀를 돌림
			mushroom(x, y);

			// 목적지에 도달했거나, 길이 막혀서 return된 경우 다시 체크를 해제하여 다른 길 찾기
			// (다시 for문이 돌아가도록 유도)
			checked[x][y] = false;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		// 테케만큼 반복
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// 출력형식
			sb.append("#").append(tc).append(" ");

			// M,N 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			// 지도 구성
			map = new int[M][N];
			checked = new boolean[M][N];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 결과값 초기화
			result = 0;

			// 시작점 0,0에서 DFS를 돌리기 시작
			mushroom(0, 0);
			// 다녀오면 result에 결과값이 쌓여있다

			// 출력
			sb.append(result).append("\n");

		}
		System.out.println(sb);
	}

}
