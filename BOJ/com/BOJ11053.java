package todo;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] length = new int[N];

		for (int i = 0; i < nums.length; i++) {
			length[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					length[i] = Math.max(length[i], length[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < length.length; i++) {
			if (max < length[i]) {
				max = length[i];
			}
		}
		System.out.println(max);

	}

}
