package steps.s07;

import java.io.*;

public class boj2941 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			char[] tc = br.readLine().toCharArray();
			int count = tc.length;
			for (int i = 0; i < tc.length; i++) {

				if (tc[i] == '=' && i > 0) {
					if (tc[i - 1] == 'c' || tc[i - 1] == 's') {
						count--;
						continue;
					}
					if (i > 1 && tc[i - 1] == 'z' && tc[i - 2] != 'd') {
						count--;
						continue;
					}
					if (i > 1 && tc[i - 1] == 'z' && tc[i - 2] == 'd') {
						count -= 2;
						continue;
					}
					else {count --;}
				}
				if (tc[i] == '-' && i > 0) {
					if (tc[i - 1] == 'c' || tc[i - 1] == 'd') {
						count--;
						continue;
					}
					else { count --; }
				}
				if (tc[i] == 'j' && i > 0) {
					if (tc[i - 1] == 'l' || tc[i - 1] == 'n') {
						count--;
						continue;
					}
				}

			}
			System.out.println(count);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
