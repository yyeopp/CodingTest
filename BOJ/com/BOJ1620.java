package todo;

import java.io.*;
import java.util.*;

public class BOJ1620 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] names = new String[N + 1];
		Map<String, Integer> nums = new HashMap<String, Integer>();
		for (int i = 1; i <= N; i++) {
			String pokemon = br.readLine();
			names[i] = pokemon;
			nums.put(pokemon, i);
		}

		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			try {
				int num = Integer.parseInt(temp);
				sb.append(names[num]);

			} catch (NumberFormatException e) {
				sb.append(nums.get(temp));
			} finally {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
