package steps.s07;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class boj1316 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			for (int i = 0; i < N; i++) {
				char[][] tc = new char[N][];
				tc[i] = br.readLine().toCharArray();
				boolean isGroup = true;
				Set<Character> cs = new HashSet<Character>();
				for (int j = 0; j < tc[i].length; j++) {
					int count = cs.size();
					cs.add(tc[i][j]);
					if (cs.size() != count) {
						continue;
					}
					if (j > 0 && cs.size() == count) {
						if (tc[i][j] == tc[i][j - 1]) {
							continue;
						}
						if (tc[i][j] != tc[i][j - 1]) {
							isGroup = false;
						}
					}
				}
				if (isGroup == true) {
					result++;
				}
			}
			System.out.println(result);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
