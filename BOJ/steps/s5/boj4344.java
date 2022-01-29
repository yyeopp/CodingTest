package steps.s5;

import java.io.*;

public class boj4344 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int C = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < C; i++) {
				String[] tc = br.readLine().split(" ");
				
				double sum = 0;
				for (int j = 1; j < tc.length; j++) {
					sum += Double.parseDouble(tc[j]);
				}
				double avg = sum/(tc.length-1.0);
				double count = 0;
				for (int j = 1; j < tc.length; j++) {
					if(avg<Double.parseDouble(tc[j])) count++;
				}
				double result = count/(tc.length-1)*100;
				bw.write(String.format("%.3f%%\n",result));
			}
			bw.flush();
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
