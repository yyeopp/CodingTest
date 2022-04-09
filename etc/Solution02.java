import java.util.*;
import java.util.Map.Entry;

public class OHouseSol2 {

	static Map<String, Integer> map;

	static class Pattern {
		String pattern;
		int size;
		int repeat;

		public Pattern(String pattern, int size, int repeat) {
			this.pattern = pattern;
			this.size = size;
			this.repeat = repeat;
		}

	}

	public static void main(String[] args) {
		map = new HashMap<>();
		String call = "abxdeydeabz";
		char[] order = call.toCharArray();
		int maxLength = call.length();
		int length = 1;
		int idx = 0;

		while (length <= maxLength) {

			if (idx + length > maxLength) {
				idx = 0;
				length++;
				continue;
			}

			char[] temp = new char[length];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = Character.toLowerCase(order[idx + i]);
			}
			String pattern = String.valueOf(temp);

			boolean repeated = false;

			if (map.containsKey(pattern)) {
				map.put(pattern, map.get(pattern) + 1);
				repeated = true;
			}

			if (!repeated) {
				map.put(pattern, 1);
			}
			idx++;

		}

		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj2, Entry<String, Integer> obj1) {
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});

		int size = list_entries.get(0).getValue();

		for (Entry<String, Integer> entry : list_entries) {
			if (entry.getValue() < size)
				break;

			call = call.replaceAll("(?i)" + entry.getKey(), "");

		}
		System.out.println(call);

	}

}
