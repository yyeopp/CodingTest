package pro;

import java.util.*;

public class PRO2_뉴스클러스터링 {

	public static void main(String[] args) {
		String str1 = "aa1+aa2";
		String str2 = "AA12";

		Map<String, Object> obj1 = new HashMap<String, Object>();
		Map<String, Object> obj2 = new HashMap<String, Object>();

		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();

		obj1.put("set", set1);
		obj1.put("map", map1);
		obj2.put("set", set2);
		obj2.put("map", map2);

		obj1 = makeSet(str1.toCharArray(), obj1);
		obj2 = makeSet(str2.toCharArray(), obj2);

		int result = jakad(addAll(obj1, obj2), retainAll(obj1, obj2));
		System.out.println(result);

	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> makeSet(char[] str, Map<String, Object> obj) {

		Set<String> set = (Set<String>) obj.get("set");
		Map<String, Integer> map = (Map<String, Integer>) obj.get("map");

		for (int i = 0; i < str.length - 1; i++) {
			if (isLetter(str[i]) && isLetter(str[i + 1])) {
				String s = toStr(str[i], str[i + 1]);
				if (!set.add(s)) {
					if (map.containsKey(s)) {
						map.put(s, map.get(s) + 1);
					} else {
						map.put(s, 2);
					}

				}
			}
		}

		return obj;
	}

	private static boolean isLetter(char c) {
		if (Character.isAlphabetic(c)) {
			return true;
		}
		return false;
	}

	private static String toStr(char c1, char c2) {
		return Character.toString(Character.toLowerCase(c1)) + Character.toString(Character.toLowerCase(c2));
	}

	@SuppressWarnings("unchecked")
	private static int addAll(Map<String, Object> obj1, Map<String, Object> obj2) {

		int result = 0;

		Set<String> set1 = (Set<String>) obj1.get("set");
		Set<String> set2 = (Set<String>) obj2.get("set");

		Map<String, Integer> map1 = (Map<String, Integer>) obj1.get("map");
		Map<String, Integer> map2 = (Map<String, Integer>) obj2.get("map");

		Set<String> set = new HashSet<>();
		set.addAll(set1);
		set.addAll(set2);

		result += set.size();
		for (String s : set) {
			if (map1.containsKey(s) && map2.containsKey(s)) {
				result += Math.max(map1.get(s), map2.get(s)) - 1;
			} else {
				if (map1.containsKey(s)) {
					result += map1.get(s) - 1;
				}
				if (map2.containsKey(s)) {
					result += map2.get(s) - 1;
				}
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	private static int retainAll(Map<String, Object> obj1, Map<String, Object> obj2) {

		int result = 0;

		Set<String> set1 = (Set<String>) obj1.get("set");
		Set<String> set2 = (Set<String>) obj2.get("set");

		Map<String, Integer> map1 = (Map<String, Integer>) obj1.get("map");
		Map<String, Integer> map2 = (Map<String, Integer>) obj2.get("map");

		Set<String> set = new HashSet<>();
		set.addAll(set1);
		set.retainAll(set2);

		result += set.size();
		for (String s : set) {
			if (map1.containsKey(s) && map2.containsKey(s)) {
				result += Math.min(map1.get(s), map2.get(s)) - 1;
			}
		}

		return result;
	}

	private static int jakad(int a, int r) {

		if (a == 0 && r == 0) {
			return 65536;
		}

		double temp = 65536 * ((double) r / (double) a);
		return (int) temp;

	}
}
