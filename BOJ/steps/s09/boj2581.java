package steps.s09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class boj2581 {
	public static boolean isPrimeNo(int n) {

		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		} else {
			if (n % 2 == 0) {
				return false;
			} else {

				for (int i = 3; i <= n / 2; i++) {
					if (n % i == 0) {

						return false;
					}
				}
				return true;

			}

		}

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		try {
			int M = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			List<Integer> pN = new ArrayList<Integer>();
			int sum = 0;
			for (int i = M; i <= N; i++) {
				if (boj2581.isPrimeNo(i) == true) {
					pN.add(i);
					sum += i;
				}

			}
			if (pN.size() != 0) {
				sb.append(sum).append("\n").append(pN.get(0));
			}
			else if(pN.size() == 0){
				sb.append(-1);
			}
			System.out.println(sb);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
