package steps.s01;

import java.util.Scanner;

public class boj10430 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		
		System.out.println((a[0]+a[1])%a[2]);
		System.out.println(((a[0]%a[2])+(a[1]%a[2]))%a[2]);
		System.out.println((a[0]*a[1])%a[2]);
		System.out.println(((a[0]%a[2])*(a[1]%a[2]))%a[2]);
		sc.close();
	}

}
