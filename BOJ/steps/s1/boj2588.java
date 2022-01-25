package steps.s1;

import java.util.Scanner;

public class boj2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] a = {sc.nextInt(), sc.nextInt()};
		int one = a[1]%10;
		int ten = (a[1]%100 - one)/10;
		int hun = (a[1] - ten*10 - one)/100;
		System.out.println(a[0]*one);
		System.out.println(a[0]*ten);
		System.out.println(a[0]*hun);
		System.out.println(a[0]*a[1]);
		sc.close();
	}

}
