package pro;

import java.util.*;

public class PRO2_뉴스클러스터링 {

	public static void main(String[] args) {
		String str1 = "aa1+aa2";
		String str2 = "AA12";

		// set과 map을 한 세트로 묶어서 들고다닐 Map
		Map<String, Object> obj1 = new HashMap<String, Object>();
		Map<String, Object> obj2 = new HashMap<String, Object>();

		// 다중집합이긴 하지만 어쨌든 집합의 형태를 띄고는 있으므로 HashSet을 사용
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();

		// 중복되는 원소가 발생할 경우 map에 해당 원소와 중복된 횟수를 담음
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();

		obj1.put("set", set1);
		obj1.put("map", map1);
		obj2.put("set", set2);
		obj2.put("map", map2);

		// str1과 str2에 대해 다중집합을 만들어옴 (set과 map 완성)
		obj1 = makeSet(str1.toCharArray(), obj1);
		obj2 = makeSet(str2.toCharArray(), obj2);

		// result는, 합집합의 원소 개수와 교집합의 원소 개수를 jakad 메서드로 처리한 결과.
		int result = jakad(addAll(obj1, obj2), retainAll(obj1, obj2));

		System.out.println(result);

	}

	// 다중집합을 만드는 메서드
	@SuppressWarnings("unchecked")
	private static Map<String, Object> makeSet(char[] str, Map<String, Object> obj) {

		Set<String> set = (Set<String>) obj.get("set");
		Map<String, Integer> map = (Map<String, Integer>) obj.get("map");

		for (int i = 0; i < str.length - 1; i++) {
			// 연속되는 두 글자가 모두 알파벳인 경우에만
			if (isLetter(str[i]) && isLetter(str[i + 1])) {
				String s = toStr(str[i], str[i + 1]);
				// set에 추가해보고, 이미 중복된 상태라면
				if (!set.add(s)) {
					// map에 해당 원소가 몇 개인지 표시하도록
					if (map.containsKey(s)) {
						map.put(s, map.get(s) + 1);
					} else {
						map.put(s, 2);
					}

				}
			}
		}
		// 결과적으로 set에는 해당 str에서 따온 모든 원소가 '중복없이' 들어있고,
		// map에는 해당 str에서 따온 원소 중 중복이 존재하는 원소만 '몇 번 등장했는지'와 함께 들어있음

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

	// 합집합 후 원소가 몇 개인지 세는 메서드
	@SuppressWarnings("unchecked")
	private static int addAll(Map<String, Object> obj1, Map<String, Object> obj2) {

		int result = 0;

		Set<String> set1 = (Set<String>) obj1.get("set");
		Set<String> set2 = (Set<String>) obj2.get("set");

		Map<String, Integer> map1 = (Map<String, Integer>) obj1.get("map");
		Map<String, Integer> map2 = (Map<String, Integer>) obj2.get("map");

		// 이 set에 set1과 set2의 합집합이 담긴다.
		Set<String> set = new HashSet<>();
		set.addAll(set1);
		set.addAll(set2);

		result += set.size();
		// 하지만 중복되는 원소에 대한 고려도 해줘야 하므로 map을 확인
		// 합집합 set에 들어있는 원소들을 순회해서, map1이나 map2에 존재하는 원소라면 (중복이 있었다면) 그 value만큼 반영해주기.
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

	// 교집합 후 원소가 몇 개인지 세는 메서드
	@SuppressWarnings("unchecked")
	private static int retainAll(Map<String, Object> obj1, Map<String, Object> obj2) {

		int result = 0;

		Set<String> set1 = (Set<String>) obj1.get("set");
		Set<String> set2 = (Set<String>) obj2.get("set");

		Map<String, Integer> map1 = (Map<String, Integer>) obj1.get("map");
		Map<String, Integer> map2 = (Map<String, Integer>) obj2.get("map");

		// 교집합이 되는 set
		Set<String> set = new HashSet<>();
		set.addAll(set1);
		set.retainAll(set2);

		result += set.size();
		// 마찬가지로 중복 고려
		for (String s : set) {
			if (map1.containsKey(s) && map2.containsKey(s)) {
				result += Math.min(map1.get(s), map2.get(s)) - 1;
			}
		}

		return result;
	}

	// 자카드. a는 합집합, r은 교집합 원소 수
	private static int jakad(int a, int r) {

		// 원소가 아예 없으면 완전 일치하므로 그대로 65536 return
		if (a == 0 && r == 0) {
			return 65536;
		}

		// 형변환에 주의해야..
		double temp = 65536 * ((double) r / (double) a);
		return (int) temp;

	}
}
