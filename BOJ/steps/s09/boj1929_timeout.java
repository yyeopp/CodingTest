package steps.s09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class boj1929_timeout {
	static ArrayList<Integer> primeList() {
		ArrayList<Integer> pL = new ArrayList<Integer>();
		return pL;
	}
	

	public static boolean isPrimeNo(int n) {
		ArrayList<Integer> pL = primeList();
		if (n == 1) {
			return false;

		}
		if (n == 2) {
			return true;
		}
		else {
			System.out.println("size"+pL.size());
			for (int i = 0; i < pL.size(); i++) {
				if (n % pL.get(i) == 0) {
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> pL = primeList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		pL.add(2);
		String[] temp = br.readLine().split(" ");
		int[] tc = new int[Integer.parseInt(temp[1]) - Integer.parseInt(temp[0]) + 1];
		for (int i = 0; i < tc.length; i++) {
			tc[i] = Integer.parseInt(temp[0]) + i;
			if (isPrimeNo(tc[i]) == true) {
				sb.append(tc[i]).append("\n");
				pL.add(tc[i]);
			}
		}

		System.out.println(sb);

	}

}
