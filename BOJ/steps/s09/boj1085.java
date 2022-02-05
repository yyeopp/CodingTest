package steps.s09;

import java.io.*;
import java.util.StringTokenizer;

public class boj1085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] pos = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		int [] rect = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		
		int result = rect[0]*rect[1];
		int [] tc = {pos[0], pos[1], rect[0]-pos[0], rect[1]-pos[1]};
		for (int i = 0; i < tc.length; i++) {
			if(tc[i] <= result) {
				result = tc[i];
			}
		}
		System.out.println(result);
	}

}
