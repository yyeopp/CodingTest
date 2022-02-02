package steps.s03;

import java.util.Scanner;

public class boj10950 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int [][] set = new int[T][2];
		
		for (int i = 0; i < set.length; i++) {
			for (int j = 0; j < set[i].length; j++) {
				set[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		for (int i = 0; i < set.length; i++) {
			System.out.println(set[i][0] + set[i][1]);
		}
		
	}

}
