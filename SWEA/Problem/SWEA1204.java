package swea;

import java.io.*;

public class SWEA1204 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int[] com = new int[101];

				int idx = Integer.parseInt(br.readLine());

				String[] temp = br.readLine().split(" ");
				int[] tc = new int[temp.length];

				for (int j = 0; j < temp.length; j++) {
					tc[j] = Integer.parseInt(temp[j]);
					com[tc[j]]++;
				}

				int resultIdx = 0;

				int result = 0;

				for (int j = 0; j < com.length; j++) {
					if (com[j] >= result && j >= resultIdx) {		// com[j] >= com[result]
						result = com[j];
						resultIdx = j;
					}
				}

				sb.append(String.format("#%d %d\n", idx, resultIdx));

			}

			System.out.println(sb);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
