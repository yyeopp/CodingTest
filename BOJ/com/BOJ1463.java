package todo;

import java.io.*;
import java.util.Arrays;

public class BOJ1463 {

	static int N;
	static int[] record;

	static int result;

	private static void makeOne(int x, int time) {

		if (time > result) {
			return;
		}
		if (x < 1) {
			return;
		}
		if (x == 1) {
			result = time;
			return;
		}

		if (x % 3 == 0 && record[x / 3] > time + 1) {
			record[x / 3] = time + 1;
			makeOne(x / 3, time + 1);
		}
		if (x % 2 == 0 && record[x / 2] > time + 1) {
			record[x / 2] = time + 1;
			makeOne(x / 2, time + 1);
		}
		if (record[x - 1] > time + 1) {
			record[x - 1] = time + 1;
			makeOne(x - 1, time + 1);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		record = new int[N + 1];
		Arrays.fill(record, Integer.MAX_VALUE);
		record[N] = 0;
		result = Integer.MAX_VALUE;
		makeOne(N, 0);
		System.out.println(result);

	}

}
