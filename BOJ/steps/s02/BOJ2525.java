package steps.s02;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int C = Integer.parseInt(br.readLine());
		
		int min = (B+C)%60;
		int hou = (A+(B+C)/60)%24;
		
		System.out.println(hou + " "+min);
		
	}

}
