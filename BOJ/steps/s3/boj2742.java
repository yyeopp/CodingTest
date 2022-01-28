package steps.s3;

import java.io.*;


public class boj2742 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int a = Integer.parseInt(br.readLine());
			for (int i = a; i > 0; i--) {
				bw.write(i+"\n");
			}
			bw.flush();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
