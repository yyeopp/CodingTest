package steps.s03;

import java.io.*;


public class boj15552 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			int[] inputNo = new int[2];

			String[] temp = br.readLine().split(" ");
			
			

			for (int j = 0; j < 2; j++) {
				inputNo[j] = Integer.parseInt(temp[j]);
				
				
			}
			int result = inputNo[0] + inputNo[1];
			bw.write(result + "\n");
		}
		bw.flush();

	}

}