package todo;

import java.io.*;
import java.util.*;

public class BOJ11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (st.countTokens() > 1) {
				String o = st.nextToken();
				if (o.equals("add")) {
					int n = Integer.parseInt(st.nextToken());
					set.add(n);
				}

				else if (o.equals("check")) {
					int n = Integer.parseInt(st.nextToken());
					if (set.contains(n)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					sb.append("\n");
				}

				else if (o.equals("remove")) {
					int n = Integer.parseInt(st.nextToken());
					set.remove(n);
				}

				else if (o.equals("toggle")) {
					int n = Integer.parseInt(st.nextToken());
					if (set.contains(n)) {
						set.remove(n);
					} else {
						set.add(n);
					}
				}
			} else {
				String o = st.nextToken();
				if (o.equals("all")) {
					set.clear();
					for (int j = 1; j <= 20; j++) {
						set.add(j);
					}
				} else if (o.equals("empty")) {
					set.clear();
				}
			}

		}
		System.out.println(sb);
	}

}
