package todo;

import java.io.*;
import java.util.*;

public class BOJ1931 {

	static class Conf {
		int start;
		int end;

		public Conf(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Conf> queue = new PriorityQueue<>(new Comparator<Conf>() {

			@Override
			public int compare(Conf o1, Conf o2) {
				if (o1.end != o2.end) {
					return o1.end - o2.end;
				} else {
					return o1.start - o2.start;
				}

			}

		});
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue.add(new Conf(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int result = 1;

		Conf init = queue.poll();
		int end = init.end;

		for (int i = 1; i < N; i++) {
			Conf c = queue.poll();
			if (end <= c.start) {
				result++;
				end = c.end;
			}
		}
		System.out.println(result);
	}

}
