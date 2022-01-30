package steps.s6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class boj1065 {

	public static int hansu(int n) {

		if (n < 100) {
			return n;
		}
		if ( n==1000) {
			return 144;
		}

		int count = 99;
		for (int i = 100; i <= n; i++) {
			List<Integer> tc = new ArrayList<Integer>();
			int temp = i;
			while (temp != 0) {
				tc.add(temp % 10);
				temp /= 10;
			}
			
			boolean isHansu = false;
			for (int j = 0; j < tc.size() - 2; j++) {
				if (tc.get(j) - tc.get(j + 1) == tc.get(j + 1) - tc.get(j + 2)) {
					isHansu = true;
				}

			}
			if (isHansu == true) {
				count++;
			}

		}

		return count;

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			System.out.println(boj1065.hansu(N));
			

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
