package steps.s02;

import java.util.Scanner;

public class boj2753 {

	public static void main(String[] args) {
		boolean yun=false;
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		if ((a%4==0 && a%100!=0) || a%400==0) {
			yun = true;
			
		}
		if (yun == false) System.out.println(0);
		if (yun == true) System.out.println(1);
		sc.close();
	}

}
