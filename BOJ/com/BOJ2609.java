package todo;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int x = Math.max(a, b);
		int y = Math.min(a, b);

		while (true) {
			if (x % y == 0) {
				break;
			}
			int temp = y;
			y = x % y;
			x = temp;
		}
		System.out.println(y);
		System.out.println(y * (a / y) * (b / y));

	}

}
