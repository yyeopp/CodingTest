package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			String[] result = new String[N];
			for (int i = 0; i < N; i += 2) {
				result[i] = st.nextToken();
			}

			for (int i = 1; i < N; i += 2) {
				result[i] = st.nextToken();
			}

			for (int i = 0; i < result.length; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
