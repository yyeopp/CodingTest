package steps.s04;

import java.io.*;

public class boj10951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		while (input != null){
			int[] tc = new int[2];

			String[] temp = input.split(" ");
			for (int j = 0; j < temp.length; j++) {
				tc[j] = Integer.parseInt(temp[j]);

			}
			int result = tc[0] + tc[1];
			bw.write(result);
			bw.newLine();
			input = br.readLine();
		}
		bw.flush();

	}

}
