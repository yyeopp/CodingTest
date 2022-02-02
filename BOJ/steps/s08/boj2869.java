package steps.s08;

import java.io.*;

public class boj2869 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] temp = br.readLine().split(" ");
			double [] tc = new double [3];
			for (int i = 0; i < temp.length; i++) {
				tc[i] = Double.parseDouble(temp[i]);
			}
			
			long result = (long) Math.ceil((tc[2]-tc[1]) / (tc[0]-tc[1]));
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
