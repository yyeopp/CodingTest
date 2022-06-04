package todo;

import java.io.*;
import java.util.*;

public class BOJ16935 {

	static int A, B;

	static Map<Long, Integer> dp;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		dp = new HashMap<Long, Integer>();

		result = Integer.MAX_VALUE;

		calculate(A, 1);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

	private static void calculate(long x, int count) {

		if (count >= result) {
			return;
		}

		if (x == B) {
			if (result > count) {
				result = count;
			}
			return;
		}

		if (2 * x <= B && (!dp.containsKey(2 * x) || count + 1 < dp.get(2 * x))) {
			dp.put(2 * x, count + 1);
			calculate(2 * x, count + 1);
		}
		if (10 * x + 1 <= B && (!dp.containsKey(10 * x + 1) || count + 1 < dp.get(10 * x + 1))) {
			dp.put(10 * x + 1, count + 1);
			calculate(10 * x + 1, count + 1);
		}

	}

}
