import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KE3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		pQueue.add(Integer.parseInt(st.nextToken()));
		pQueue.add(Integer.parseInt(st.nextToken()));
		pQueue.add(Integer.parseInt(st.nextToken()));

		int a = pQueue.poll();
		int b = pQueue.poll();
		int c = pQueue.poll();

		int min = 0;
		int max = 0;

		if (b == a + 1 && c == b + 1) {
			min = 0;
		} else if (b - 2 == a || c - 2 == b) {
			min = 1;
		} else {
			min = 2;
		}

		if (b == a + 1 && c == b + 1) {
			max = 0;
		} else if (b == a + 1 || c == b + 1) {
			if (b == a + 1) {
				max = c - b - 1;
			} else {
				max = b - a - 1;
			}
		} else {
			max = Math.max(b - a, c - b) - 1;
		}
		System.out.println(min);
		System.out.println(max);
	}

}