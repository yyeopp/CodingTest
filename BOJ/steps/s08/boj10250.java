package steps.s08;

import java.io.*;

public class boj10250 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// H층, W호, N번째손님

		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int[] tc = new int[3];
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < temp.length; j++) {
					tc[j] = Integer.parseInt(temp[j]);
				}
				int h = tc[2] % tc[0];
				int w = tc[2] / tc[0] + 1;
				if (h == 0) {
					h = tc[0];
					w--;
				}

				if (w < 10) {
					sb.append(String.format("%d0%d", h, w));
				}
				if (w >= 10) {
					sb.append(String.format("%d%d", h, w));
				}
				sb.append("\n");
			}
			System.out.println(sb);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
