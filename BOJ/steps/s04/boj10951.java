package steps.s04;

import java.util.Scanner;

public class boj10951 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sb.append(a+b+"\n");
		}
		sc.close();
		System.out.println(sb);

	}

}
