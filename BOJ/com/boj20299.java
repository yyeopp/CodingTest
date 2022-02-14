import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int S = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		// 개인의 능력치를 저장할 리스트 - 사이즈가 불명확하므로 ArrayList 사용
		ArrayList<Integer> students = new ArrayList<>();
		
		// 기준을 만족하는 동아리 개수
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st2.nextToken());
			int x2 = Integer.parseInt(st2.nextToken());
			int x3 = Integer.parseInt(st2.nextToken());

			if (x1 < M || x2 < M || x3 < M) {
				continue;
			}
			if (x1 + x2 + x3 < S) {
				continue;
			} 
			else {
				count++;
				students.add(x1);
				students.add(x2);
				students.add(x3);
			}

		}
		sb.append(count+"\n");
		for (int i = 0; i < students.size(); i++) {
			sb.append(students.get(i)).append(" ");
		}

		System.out.println(sb);
		
	}

}
