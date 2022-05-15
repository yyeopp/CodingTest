public class G03 {
	public int[] solution(String[] replies, int n, int k) {

		int length = replies.length;

		int[] answer = new int[length];

		for (int tc = 0; tc < answer.length; tc++) {
			char[] arr = replies[tc].toCharArray();
			int l = n;
			int maxLength = arr.length;
			boolean ok = true;

			loop: while (l < maxLength) {
				for (int i = 0; i < arr.length - l; i++) {
					char[] pattern = new char[l];
					for (int j = 0; j < pattern.length; j++) {
						pattern[j] = arr[i + j];
					}

					int result = 1;

					int j = i + l;

					loop2: while (j <= arr.length - l) {
						boolean identical = true;
						for (int j2 = 0; j2 < pattern.length; j2++) {
							if (pattern[j2] != arr[j + j2]) {
								identical = false;
								break loop2;
							}
						}
						if (identical) {
							result++;
							j += l;
						}
						if (result >= k) {
							ok = false;
							break loop;
						}
					}

				}
				l++;
			}
			if (ok) {
				answer[tc] = 1;
			}

		}
		return answer;
	}
}