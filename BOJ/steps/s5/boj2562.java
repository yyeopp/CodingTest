package steps.s5;

import java.io.*;

public class boj2562 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int[] tc = new int[9];
			int max = 0;
			int idx = 0;
			for (int i = 0; i < tc.length; i++) {

				tc[i] = Integer.parseInt(br.readLine());
				if (max <= tc[i]) {
					max = tc[i];
					idx = i+1;
				}
			}
			bw.write(max + "\n" + idx);
			bw.flush();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
