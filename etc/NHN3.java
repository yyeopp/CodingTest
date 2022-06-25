import java.util.*;

public class NHN3 {

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		int m = 9;
		String[] people = { "A 1 2", "B 2 3 4", "C 4 5", "D 5 6 7", "E 6 7 8", "F 8 9" };
		String[] pairs = { "A B", "C F" };

		int[][] map = new int[people.length][people.length];

		Set[] list = new Set[people.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = new HashSet<Integer>();
		}
		for (int i = 0; i < people.length; i++) {
			StringTokenizer st = new StringTokenizer(people[i]);
			st.nextToken();
			while (st.hasMoreTokens()) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				if (i == j) {
					continue;
				}
				Set<Integer> temp = new HashSet<>();
				temp.addAll(list[i]);
				temp.retainAll(list[j]);

				if (temp.size() > 0) {
					map[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 10000;
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			map[i][i] = 0;
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				for (int z = 0; z < map.length; z++) {
					if (map[j][i] != 10000 && map[i][z] != 10000) {
						map[j][z] = Math.min(map[j][z], map[j][i] + map[i][z]);
					}
				}
			}
		}

		int[] answer = new int[pairs.length];
		for (int i = 0; i < pairs.length; i++) {
			char[] temp = pairs[i].toCharArray();
			int a = temp[0] - 65;
			int b = temp[2] - 65;

			answer[i] = map[a][b] - 1;
			if (answer[i] > 9000) {
				answer[i] = -1;
			}
		}
		System.out.println(Arrays.toString(answer));

	}

}
