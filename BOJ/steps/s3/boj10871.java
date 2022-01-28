package steps.s3;

import java.io.*;

public class boj10871 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {

			int[] tc = new int[2];

			String[] temp = br.readLine().split(" ");

			for (int j = 0; j < temp.length; j++) {
				tc[j] = Integer.parseInt(temp[j]);

			}

			int[] arr = new int[tc[0]];

			String[] temp2 = br.readLine().split(" ");

			for (int i = 0; i < temp2.length; i++) {
				arr[i] = Integer.parseInt(temp2[i]);
			}
			
			
			for (int i = 0; i < tc[0]; i++) {

				if (arr[i] < tc[1]) {
					bw.write(String.valueOf(arr[i])+" ");
					
				}
			}
			bw.flush();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
