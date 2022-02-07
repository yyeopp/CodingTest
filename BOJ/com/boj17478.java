package com;

import java.io.*;

public class boj17478 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		N = Integer.parseInt(br.readLine());
		JH(N);
		System.out.print("라고 답변하였지.");
	}

	public static void JH(int n) {
	
		if (n > 0) {
			
			String q = "\"재귀함수가 뭔가요?\"" + "\n";
			String a1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어." + "\n";
			String a2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지." + "\n";
			String a3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" + "\n";

			underbar(n);
			System.out.print(q);
			underbar(n);
			System.out.print(a1);
			underbar(n);
			System.out.print(a2);
			underbar(n);
			System.out.print(a3);
		
			JH(n - 1);
			underbar(n);
			System.out.print("____라고 답변하였지." + "\n");

			return;

		}

		underbar(n);
		System.out.print("\"재귀함수가 뭔가요?\""+"\n");
		underbar(n);
		System.out.print("\"재귀함수는 자기 자신을 호출하는 함수라네\"" + "\n");

	}

	public static void underbar(int n) {

		for (int i = n; i <N; i++) {
			System.out.print("____");
		}
	}
}