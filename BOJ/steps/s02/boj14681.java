package steps.s02;

import java.util.Scanner;

public class boj14681 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] dir = {sc.nextInt(), sc.nextInt()};
		
		if (dir[0]>0 && dir[1]>0) System.out.println(1);
		if (dir[0]<0 && dir[1]>0) System.out.println(2);
		if (dir[0]<0 && dir[1]<0) System.out.println(3);
		if (dir[0]>0 && dir[1]<0) System.out.println(4);
		sc.close();
		
	}

}
