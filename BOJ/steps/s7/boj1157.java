package steps.s7;

import java.io.*;

public class boj1157 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int[] result = new int[26];
			char[] tc = br.readLine().toCharArray();
			for (int i = 0; i < tc.length; i++) {

				for (int j = 0; j < result.length; j++) {
					if ((int) (Character.toLowerCase(tc[i])) == j + 97) {
						result[j]++;
						break;
					}

				}
			}

			int ans = 0;
			int ansW = 0;
			int count = 0;
			for (int i = 0; i < result.length; i++) {

				if (result[i] == 0 || result[i] < ans) {
					continue;
				}

				if (result[i] == ans) {
					count++;
				}
				if (result[i] > ans) {
					ans = result[i];
					ansW = i;
					count = 0;
				}
			}
			if (count == 0) {
				System.out.println(Character.toChars(ansW + 65));
			} else if (count != 0) {
				System.out.println("?");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
