package steps.s09;

import java.io.*;
import java.util.StringTokenizer;

public class boj3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] tc = new int[3][2];
		int[] xdata = new int[2];
		int[] ydata = new int[2];
		int[] result = new int[2];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				tc[i][j] = Integer.parseInt(st.nextToken());
			}
			if (i < 2) {
				xdata[i] = tc[i][0];
				ydata[i] = tc[i][1];
			}
			if (i == 2) {
				if (tc[i][0] == xdata[0]) {
					result[0] = xdata[1];
				}
				if (tc[i][0] == xdata[1]) {
					result[0] = xdata[0];
				}
				if (tc[i][0] != xdata[0] && tc[i][0] != xdata[1]) {
					result[0] = tc[i][0];
				}
			}
			if (i == 2) {
				if (tc[i][1] == ydata[0]) {
					result[1] = ydata[1];
				}
				if (tc[i][1] == ydata[1]) {
					result[1] = ydata[0];
				} if(tc[i][1] != ydata[0] && tc[i][1] != ydata[1]) {
					result[1] = tc[i][1];
				}

			}

		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

}
