package steps.s09;

import java.io.*;

public class boj3053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double R = Double.parseDouble(br.readLine());
		System.out.println(R*R*Math.PI);
		System.out.println(2*R*R);
	}

}
