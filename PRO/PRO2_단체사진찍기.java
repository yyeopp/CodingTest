package pro;

public class PRO2_단체사진찍기 {

	static final int K = 8;

	public int solution(int n, String[] data) {
		char[] kakao = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };

		int answer = 0;
		do {
			if (confirm(kakao, data)) {
				answer++;
			}

		} while (np(kakao));

		return answer;
	}

	private static boolean confirm(char[] arr, String[] data) {

		boolean pass = true;
		for (int i = 0; i < data.length; i++) {

			char[] condition = data[i].toCharArray();
			char x = condition[0];
			char y = condition[2];

			int tx = 0;
			int ty = 0;

			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == x) {
					tx = j;
				} else if (arr[j] == y) {
					ty = j;
				}
			}

			if (condition[3] == '=') {
				if (Math.abs(tx - ty) - 1 != condition[4] - 48) {
					pass = false;
					break;
				}
			} else {
				if (condition[3] == '>') {
					if (Math.abs(tx - ty) - 1 <= condition[4] - 48) {
						pass = false;
						break;
					}
				} else {
					if (Math.abs(tx - ty) - 1 >= condition[4] - 48) {
						pass = false;
						break;
					}
				}
			}

		}

		return pass;

	}

	private static boolean np(char[] kakao) {

		int i = K - 1;

		while (i > 0 && kakao[i - 1] >= kakao[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = K - 1;
		while (kakao[i - 1] >= kakao[j]) {
			j--;
		}

		swap(kakao, i - 1, j);

		int k = K - 1;
		while (i < k) {
			swap(kakao, i, k);
			i++;
			k--;
		}

		return true;
	}

	public static void swap(char[] kakao, int i, int j) {
		char temp = kakao[i];
		kakao[i] = kakao[j];
		kakao[j] = temp;
	}
}
