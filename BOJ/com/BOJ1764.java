package todo;

import java.io.*;
import java.util.*;

public class BOJ1764 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		int result = 0;
		PriorityQueue<String> names = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (set.contains(temp)) {
				result++;
				names.add(temp);
			}
		}
		sb.append(result).append("\n");
		int s = names.size();
		for (int i = 0; i < s; i++) {
			sb.append(names.poll()).append("\n");
		}
		System.out.println(sb);
	}

}
