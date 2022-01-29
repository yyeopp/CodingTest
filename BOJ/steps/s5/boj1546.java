package steps.s5;

import java.io.*;

public class boj1546 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			double N = Double.parseDouble(br.readLine());
			double[] tc = new double[(int) N];
			String temp[] = br.readLine().split(" ");
			double max = 0;
			for (int i = 0; i < (int) N; i++) {
				tc[i] = Double.parseDouble(temp[i]);
				if (max <= tc[i]) {
					max = tc[i];
				}
			}
			double[] newTc = new double[(int) N];
			double sum = 0;
			for (int i = 0; i < (int) N; i++) {

				newTc[i] = (tc[i] / max) * 100;

				sum += newTc[i];
			}
			double avg = sum / N;
			bw.write(Double.toString(avg));
			bw.flush();

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
