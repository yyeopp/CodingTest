package todo;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA7193 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			char[] num = st.nextToken().toCharArray();

			long sum = 0;
			for (int i = 0; i < num.length; i++) {
				sum += (num[i] - '0');
			}
			long result = sum % (N - 1);
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}
}
