import java.util.*;

public class SKT3 {

	public static void main(String[] args) {

		String[] plans = { "100 1 3", "500 4", "2000 5" };
		String[] clients = { "300 3 5", "1500 1", "100 1 3", "50 1 2" };

		int[] answer = new int[clients.length];

		for (int i = 0; i < clients.length; i++) {
			StringTokenizer st = new StringTokenizer(clients[i]);
			int data = Integer.parseInt(st.nextToken());
			Set<Integer> service = new HashSet<>();
			while (st.hasMoreTokens()) {
				service.add(Integer.parseInt(st.nextToken()));
			}

			for (int j = 0; j < plans.length; j++) {
				st = new StringTokenizer(plans[j]);
				int planD = Integer.parseInt(st.nextToken());

				while (st.hasMoreTokens()) {
					service.remove(Integer.parseInt(st.nextToken()));
				}

				if (planD < data) {
					continue;
				}

				if (service.isEmpty()) {
					answer[i] = j + 1;
					break;
				}

			}
		}
		System.out.println(Arrays.toString(answer));
	}

}
