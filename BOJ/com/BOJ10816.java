package todo;

import java.io.*;
import java.util.*;

public class BOJ10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> cards = new HashMap<Integer, Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			if (cards.get(idx) == null) {
				cards.put(idx, 1);
			} else {
				cards.put(idx, cards.get(idx) + 1);
			}
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			if (cards.get(idx) == null) {
				sb.append(0);
			} else {
				sb.append(cards.get(idx));
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
