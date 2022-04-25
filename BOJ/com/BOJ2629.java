import java.io.*;
import java.util.*;

public class BOJ2629 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		// 추의 개수 M
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// "확인이 가능한 무게"가 모여있는 자료구조로 Set을 사용.
		// 기본적으로 "존재하는 추들 간의 +, - 사칙연산 결과물"과
		// "입력되는 구슬의 무게"가 동일할 때 구슬의 무게를 확인할 수 있다.
		Set<Integer> set = new HashSet<>();

		// Set에 입력된, "확인 가능한 무게"를 순회하기 위한 자료구조로 ArrayList 사용.
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < M; i++) {

			// 추의 무게 c를 하나씩 입력받는다.
			int c = Integer.parseInt(st.nextToken());

			// 그 전까지의 list size를 저장한다.
			// (당장의 c를 고려하지 않은, 지금까지 확인 가능했던 무게들)
			int s = list.size();

			// 기존 list를 순회
			for (int j = 0; j < s; j++) {

				// 기존에 확인 가능했던 무게들 전부와 + 연산을 수행하고,
				if (set.add(list.get(j) + c)) {

					// set.add의 결과물로 true가 리턴되면
					// (중복되지 않는 새로운 값이라 입력이 성공하면)
					// list에 add한다.
					list.add(list.get(j) + c);
				}

				// 마찬가지로 전부와 -연산을 수행하고, (절대값으로 변환)
				if (set.add(Math.abs(list.get(j) - c))) {

					// 새로운 값이면 list에 add한다.
					list.add(Math.abs(list.get(j) - c));
				}
			}

			// 마지막으로 추 자체의 무게를 list에 입력
			if (set.add(c)) {
				list.add(c);
			}

		}

		// 구슬들 입력
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {

			// 구슬의 무게 g 입력
			int g = Integer.parseInt(st.nextToken());

			// g가 set에 들어있는 원소면 Y, 아니면 N을 출력
			// set에 들어있다는 건 확인 가능한 무게라는 뜻
			if (set.contains(g)) {
				sb.append("Y");
			} else {
				sb.append("N");
			}
			sb.append(" ");
		}

		// 마무리
		System.out.println(sb);

	}

}
