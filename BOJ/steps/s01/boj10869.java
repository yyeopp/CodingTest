package steps.s01;

import java.util.Scanner;

public class boj10869 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] inputNo = {sc.nextInt(),sc.nextInt()};
		
		System.out.println(inputNo[0]+inputNo[1]);
		System.out.println(inputNo[0]-inputNo[1]);
		System.out.println(inputNo[0]*inputNo[1]);
		System.out.println(inputNo[0]/inputNo[1]);
		System.out.println(inputNo[0]%inputNo[1]);
		
		
		
		sc.close();
	}

}
