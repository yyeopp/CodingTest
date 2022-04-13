package todo;

import java.io.*;
import java.util.*;

public class BOJ1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			words[i] = word;
		}
		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});

		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		String w = words[0];
		sb.append(w).append("\n");
		for (int i = 1; i < words.length; i++) {
			if (!w.equals(words[i])) {
				sb.append(words[i]).append("\n");
				w = words[i];
			}
		}

		System.out.println(sb);
	}

}
