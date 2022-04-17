package todo;

import java.io.*;
import java.util.*;

public class BOJ10814 {

	static class Member {
		int age;
		String name;
		int order;

		public Member(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Member> pq = new PriorityQueue<>(new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				if (o1.age != o2.age) {
					return o1.age - o2.age;
				} else {
					return o1.order - o2.order;
				}
			}
		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i));
		}
		for (int i = 0; i < N; i++) {
			sb.append(pq.peek().age).append(" ").append(pq.peek().name).append("\n");
			pq.poll();
		}
		System.out.println(sb);
	}

}
