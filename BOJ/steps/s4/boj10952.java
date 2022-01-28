package steps.s4;

import java.io.*;

public class boj10952 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			while (true) {
				int[] tc = new int[2];

				String[] temp;

				temp = br.readLine().split(" ");

				for (int j = 0; j < temp.length; j++) {
					tc[j] = Integer.parseInt(temp[j]);

				}
				if (tc[0] == 0 && tc[1] == 0)
					break;
				bw.write(tc[0] + tc[1] + "\n");

			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
