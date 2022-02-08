package swea;

import java.io.*;
import java.util.*;

public class SWEA1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			sb.append("#").append(T).append(" ");

			Queue<Integer> q = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}

			loop: while (true) {

				for (int i = 1; i <= 5; i++) {

					if (q.peek() - i <= 0) {
						q.poll();
						q.offer(0);

						break loop;
						
					} else {
						q.offer(q.poll() - i);
					}

				}
				
			}
			for (int i = 0; i < 8; i++) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}

}
