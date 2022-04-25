import java.io.*;
import java.util.*;

public class BOJ1755 {

	// "정렬"과 "출력"을 모두 효과적으로 수행하기 위한 custom class
	static class Ssafy {

		// 숫자를 영어로 표현한 String
		String word;

		// 원래 숫자
		int num;

		// 생성자
		public Ssafy(String word, int num) {
			this.word = word;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// 빠른 정렬을 위해 pQueue를 사용
		PriorityQueue<Ssafy> pq = new PriorityQueue<>(new Comparator<Ssafy>() {

			// Comparator 구현: Ssafy 객체가 가지고 있는 String인 word 간의 비교
			@Override
			public int compare(Ssafy o1, Ssafy o2) {

				// Ssafy 객체를 입력받아 word를 사전순으로 정렬하도록.
				return o1.word.compareTo(o2.word);
			}
		});

		// M에서 N까지 pQueue에 입력
		for (int i = M; i <= N; i++) {

			// 자릿수가 한 자리에 불과한 경우,
			if (i < 10) {

				// pQueue에 그대로 입력.
				pq.add(new Ssafy(inWord(i), i));

			} else {

				// 자릿수가 두 자리인 경우에는 String을 새로 만들어야 함.
				// 10의자릿수 word와 1의자릿수 word를 "+"로 조합함
				String w = inWord(i / 10) + inWord(i % 10);
				// ex) 89 -> eightnine

				// 그 상태로 원래 수와 함께 pQueue에 입력
				pq.add(new Ssafy(w, i));
			}
		}

		// pQueue에 있는 원소들을 하나씩 꺼냄
		int idx = 0;
		for (int i = M; i <= N; i++) {

			// poll()하고 해당 객체가 가진 본래의 num값을 SB에 추가
			sb.append(pq.poll().num).append(" ");
			idx++;

			if(idx==10) {
				sb.append("\n");
				idx=0;
			}
		}

		// 출력
		System.out.println(sb);
	}

	// 숫자를 입력받아 그에 부합하는 word String을 리턴하는 함수
	private static String inWord(int n) {
		switch (n) {
		case 0:
			return "zero";
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		}
		// 에러값
		return "*";
	}
}
