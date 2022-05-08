package steps.s11;

import java.io.*;
import java.util.*;

public class BOJ7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] person = new int[N][2];
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
			result[i] = 1;
			for (int j = 0; j < i; j++) {
				if (person[j][0] > person[i][0] && person[j][1] > person[i][1]) {
					result[i]++;
				} else if (person[j][0] < person[i][0] && person[j][1] < person[i][1]) {
					result[j]++;
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);

	}

}
