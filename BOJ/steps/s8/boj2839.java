package steps.s8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class boj2839 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int orgN = N;
			int count5 = 0;
			int count3 = 0;
			List<Integer> candid = new ArrayList<Integer>();
			List<Integer> index = new ArrayList<Integer>();
			while (N >= 0) {
				if (N >= 5) {
					N -= 5;
					count5++;
					if (N != 0 && N % 3 == 0) {
						candid.add(N);
						index.add(count5);
					}

				}
				if (N < 5) {
					if (N == 3) {
						count3++;
					}
					break;
					
				}

			}
			if (count3 != 0) {
				System.out.println(count5 + count3);
			}
			if (count3 == 0) {

				if (candid.size() == 0) {
					if (N != 0) {
						if (orgN % 3 != 0 ) {
							System.out.println(-1);
						}
						
						if (orgN % 3 == 0) {
							System.out.println(orgN / 3);
						}
					}
					if (N == 0) {
						System.out.println(count5);
					}
				}
				if (candid.size() > 0) {
					if(N!=0) {
						count3 = candid.get(candid.size() - 1) / 3;
						System.out.println(index.get(index.size() - 1) + count3);
					}
					if(N==0) {
						System.out.println(count5);
					}
				}

			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
