import java.io.*;
import java.util.StringTokenizer;

public class KE4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] results = new int[M][2];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int win = Integer.parseInt(st.nextToken());
			int los = Integer.parseInt(st.nextToken());

			results[i][0] = win;
			results[i][1] = los;

		}

		int answer = 0;
		int[][] graph = new int[N + 1][N + 1];

		for (int i = 0; i < results.length; i++) {
			graph[results[i][0]][results[i][1]] = 1;
		}

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				for (int z = 0; z <= N; z++) {
					if (graph[j][i] == 1 && graph[i][z] == 1)
						graph[j][z] = 1;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			int game = 0;
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 1 || graph[j][i] == 1)
					game++;
			}
			if (game == N - 1)
				answer++;
		}

		System.out.println(answer);
	}

}
