package todo;

import java.io.*;

public class BOJ1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();

		int result = 0;
		boolean isMinus = false;
		int stackMinus = 0;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != '+' && arr[i] != '-') {
				sb.append(arr[i]);
			} else {
				int temp = Integer.parseInt(sb.toString());
				sb.setLength(0);

				if (arr[i] == '-') {
					if (isMinus) {
						stackMinus += temp;
						result -= stackMinus;
						stackMinus = 0;
					} else {
						isMinus = true;
						result += temp;
					}
					System.out.println(result);
				} else {
					if (isMinus) {
						stackMinus += temp;
					} else {
						result += temp;
					}
					System.out.println(result);
				}
			}

		}
		int fin = Integer.parseInt(sb.toString());

		for (int i = arr.length - 1; i >= 0; i--) {
			if (isMinus) {
				if (arr[i] == '+') {
					stackMinus += fin;
					result -= stackMinus;
					break;
				} else if (arr[i] == '-') {
					result -= fin;
					break;
				}
			} else {
				result += fin;
				break;
			}
		}
		System.out.println(result);

	}

}
