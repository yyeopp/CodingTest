package steps.s5;

import java.io.*;

public class boj10818 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int N = Integer.parseInt(br.readLine());
			int[] tc = new int[N];
			String[] temp;

			temp = br.readLine().split(" ");

			int max = -1000000;
			int min = 1000000;
			for (int i = 0; i < N; i++) {
				tc[i] = Integer.parseInt(temp[i]);
				if (max <= tc[i]) {
					max = tc[i];
				}
				if (min >= tc[i]) {
					min = tc[i];
				}

			}
			bw.write(min + " " + max);
			bw.flush();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
