package steps.s02;

import java.util.Scanner;

public class boj2884 {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] time = {sc.nextInt(), sc.nextInt()};
		
		
		
		if (time[1] >= 45) System.out.println(time[0] + " " + (time[1]-45));
		if (time[1] < 45) {
			if (time[0]!=0) {
				System.out.println((time[0]-1) + " " + (time[1]+15));
			}
			if (time[0]==0) {
				System.out.println(23 + " "  + (time[1]+15));
			}
		}
		sc.close();
	}
}
