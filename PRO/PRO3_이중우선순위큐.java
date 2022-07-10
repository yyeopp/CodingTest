package pro;

import java.util.*;

public class PRO3_이중우선순위큐 {

	public static void main(String[] args) {

		String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };

		TreeMap<Integer, Integer> tree = new TreeMap<>();

		for (int i = 0; i < operations.length; i++) {

			StringTokenizer st = new StringTokenizer(operations[i]);

			if (st.nextToken().equals("I")) {
				int num = Integer.parseInt(st.nextToken());
				tree.put(num, num);
			} else {
				if (st.nextToken().equals("-1")) {
					tree.pollFirstEntry();
				} else {
					tree.pollLastEntry();
				}
			}
		}

		if (tree.isEmpty()) {
			System.out.println(Arrays.toString(new int[] { 0, 0 }));
		} else {
			System.out.println(Arrays.toString(new int[] { tree.lastKey(), tree.firstKey() }));
		}
	}

}
