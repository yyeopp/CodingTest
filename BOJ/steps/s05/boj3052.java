package steps.s05;

import java.io.*;

public class boj3052 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int[] tc = new int[10];
			int[] nmg = new int[10];
			int count = 1;
			for (int i = 0; i < tc.length; i++) { // 0,1,2 들어감

				tc[i] = Integer.parseInt(br.readLine());
				nmg[i] = tc[i] % 42;

				for (int j = 0; j < i; j++) { // 0, 1만 돌아감. i=2
					if (j != i - 1) {
						if (nmg[i] != nmg[j]) {
							
							continue;
						}
						if (nmg[i] == nmg[j]) {
							break;
						}
					}

					if (j == i - 1 && nmg[i] != nmg[j]) {
						count++;
					}
				}
			}

			System.out.println(count);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
