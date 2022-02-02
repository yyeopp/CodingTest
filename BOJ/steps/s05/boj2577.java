package steps.s05;

import java.io.*;

public class boj2577 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int[] tc = new int[3];
			for (int i = 0; i < tc.length; i++) {

				tc[i] = Integer.parseInt(br.readLine());
				
			}
			int result = tc[0]*tc[1]*tc[2];
			int [] count = new int [10];
			String [] ts = new String [Integer.toString(result).length()];
			for (int i = 0; i < ts.length; i++) {
				ts[i] = Integer.toString(result).split("")[i];
				for (int j = 0; j < count.length; j++) {
					if (Integer.parseInt(ts[i]) == j) {
						count[j] ++;
						break;
					}
				}
			}
			for (int i = 0; i < count.length; i++) {
				bw.write(count[i]+"\n");
			}
			bw.flush();
		
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
