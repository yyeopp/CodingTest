package steps.s10;

import java.io.*;

public class boj2447 {
	static void blank() {
		System.out.print("   "+"\n"+"   "+"\n"+"   ");
	}

	static void star(int N) {
		int idx = N / 3;

		if (N == 3) {
			for (int i = 0; i < N; i++) {
				if (i / idx == 0) {
					for (int j = 0; j < N; j++) {
						System.out.print('*');
					}
				 	System.out.println();
				}

				if (i / idx == 1) {
					for (int j = 0; j < N; j++) {
						if (j / idx == 0) {
							System.out.print('*');
						}
						if (j / idx == 1) {
							System.out.print(' ');
						}
						if (j / idx == 2) {
							System.out.print('*');
						}
					}
					System.out.println();
				}

				if (i / idx == 2) {
					for (int j = 0; j < N; j++) {
						System.out.print('*');
					}
				}
			}
//			System.out.print("***");
//			System.out.println();
//			System.out.print("* *");
//			System.out.println();
//			System.out.print("***");
			return;
		}

		if (N > 3) {
			for (int i = 0; i < idx; i++) {
				if (i / idx == 0) {
					star(N / 3);
				}
				

				if (i / idx == 1) {
					for (int j = 0; j < idx; j++) {
						if (j / idx == 0) {
							star(N / 3);
						}
						if (j / idx == 1) {
							blank();
						}
						if (j / idx == 2) {
							star(N / 3);
						}
					}
					
				}

				if (i / idx == 2) {
					star(N / 3);
				}
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		star(N);

	}

}
/*
 * // if (N >3) { for (int i = 0; i < N; i++) { if (i / idx == 0) { for (int j =
 * 0; j < N; j++) { System.out.print('*'); } System.out.println(); }
 * 
 * if (i / idx == 1) { for (int j = 0; j < N; j++) { if (j / idx == 0) {
 * System.out.print('*'); } if (j / idx == 1) { System.out.print(' '); } if (j /
 * idx == 2) { System.out.print('*'); } } System.out.println(); }
 * 
 * if (i / idx == 2) { for (int j = 0; j < N; j++) { System.out.print('*'); } }
 * } }
 */
