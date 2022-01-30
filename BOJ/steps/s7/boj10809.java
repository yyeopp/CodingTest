package steps.s7;

import java.io.*;

public class boj10809 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] result = new int[26];
		try {
			char[] tc = br.readLine().toCharArray();
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < tc.length; j++) {
					if ((int) (tc[j]) == i + 97) {
						result[i] = j;
						break;
					}
					result[i] = -1;
				}
				sb.append(result[i] + " ");
			}
			System.out.println(sb);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
