package todo;

import java.io.*;
import java.util.*;

public class BOJ7662 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {

			TreeMap<Integer, Integer> map = new TreeMap<>();

			int k = Integer.parseInt(br.readLine());

			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String order = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (order.equals("I")) {
					if (map.containsKey(num)) {
						map.put(num, map.get(num) + 1);
					} else {
						map.put(num, 0);
					}
				} else {
					if (map.size() == 0) {
						continue;
					}

					if (num == 1) {
						if (map.get(map.lastKey()) != 0) {
							map.put(map.lastKey(), map.get(map.lastKey()) - 1);
						} else {
							map.remove(map.lastKey());
						}
					} else {
						if (map.get(map.firstKey()) != 0) {
							map.put(map.firstKey(), map.get(map.firstKey()) - 1);
						} else {
							map.remove(map.firstKey());
						}
					}
				}
			}
			if (map.isEmpty()) {
				sb.append("EMPTY");
			} else {
				sb.append(map.lastKey());
				sb.append(" ");
				sb.append(map.firstKey());
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}

}
