package steps.s02;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2480 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] tc = new int[3];
		int count = 0;
		int temp = 0;

		for (int i = 0; i < tc.length; i++) {
			tc[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < i; j++) {
				if (tc[i] == tc[j]) {
					count++;
					temp = tc[i];
				}
			}
		}

		Arrays.sort(tc);
		if (count == 0) {
			System.out.println(tc[2] * 100);
		}
		if (count == 1 || count == 2) {
			System.out.println(1000 + temp * 100);

		}
		if (count == 3) {
			System.out.println(10000 + temp * 1000);
		}

	}

}
