package steps.s3;

import java.util.Scanner;

public class boj2739 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			int result = a * i;
			System.out.printf("%d * %d = %d\n",a,i,result);
		}
		sc.close();
	}

}
