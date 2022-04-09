import java.util.*;

public class OHouseSol {
	static StringBuilder sb;
	static List<String> list;

	public static void main(String[] args) {
		String path = "EEESEEEEEENNNN";
		list = new ArrayList<String>();
		char[] order = path.toCharArray();

		char start = order[0];
		int idx = 0; 
		int distance = 100;
		int startTime = 0;
		int time = 0;
		loop: while (true) {

			while (true) {
				idx++;

				if (idx == order.length) {
					break loop;
				}

				if (start == order[idx]) {
					distance += 100;
					time++;
					continue;
				} else {
					time++;
					announce(distance, startTime, time, start, order[idx]);
					break;
				}

			}

			start = order[idx];
			startTime = time;
			distance = 100;

		}

		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		System.out.println(Arrays.toString(answer));

	}

	private static void announce(int distance, int startTime, int time, char prev, char next) {
		sb = new StringBuilder();
		String direction = direction(prev, next);

		if (distance <= 500) {
			sb.append("Time ").append(startTime).append(": Go straight ").append(distance).append("m and turn ")
					.append(direction);
		} else {
			startTime += (distance - 500) / 100;
			sb.append("Time ").append(startTime).append(": Go straight 500m and turn ").append(direction);
		}
		list.add(sb.toString());

	}

	private static String direction(char prev, char next) {
		if (prev == 'E') {
			if (next == 'S') {
				return "right";
			} else {
				return "left";
			}

		} else if (prev == 'N') {
			if (next == 'E') {
				return "right";
			} else {
				return "left";
			}
		} else if (prev == 'S') {
			if (next == 'W') {
				return "right";
			} else {
				return "left";
			}
		} else {
			if (next == 'N') {
				return "right";
			} else {
				return "left";
			}
		}
	}

}
