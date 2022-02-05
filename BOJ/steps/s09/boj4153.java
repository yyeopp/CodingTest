package steps.s09;

import java.io.*;
import java.util.StringTokenizer;

public class boj4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] tc = new int[3];
			boolean finish = true;
			int big = 0;
			int [] small = new int [3];
			for (int i = 0; i < tc.length; i++) {
				tc[i] = Integer.parseInt(st.nextToken());
				if (tc[i] != 0) {
					finish = false;
				}
				if (tc[i] >= big) {
					small[i] = big;
					big = tc[i];
				}
				if (tc[i] < big) {
					small[i] = tc[i];
				}
			}
			if (finish == true) {
				break;
			}
			int sum = small[0]*small[0] + small[1]*small[1] + small[2]*small[2];
			if(big*big == sum) {
				sb.append("right").append("\n");
			}
			if(big*big != sum) {
				sb.append("wrong").append("\n");
			}

		}
		System.out.println(sb);
	}

}
