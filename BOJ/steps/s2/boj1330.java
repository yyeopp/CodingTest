package steps.s2;

import java.util.Scanner;

public class boj1330 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = {sc.nextInt(), sc.nextInt()};
		if (a[0] < a[1]) {System.out.println("<");}
		if (a[0] > a[1]) {System.out.println(">");}
		if (a[0] == a[1]) {System.out.println("==");}
		sc.close();
	}
}
