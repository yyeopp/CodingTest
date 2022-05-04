package todo;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pQ.add(Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int p = pQ.poll();
			sum += p * (N - i);
		}
		System.out.println(sum);
	}

}
