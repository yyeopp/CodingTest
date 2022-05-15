
public class G01 {

	public String solution(int n, String text, int second) {

		char[] arr = text.toCharArray();
		int s = second % (arr.length + n);
		String answer = "";

		if (s - n < 0) {
			for (int i = 0; i < Math.abs(s - n); i++) {
				answer += "_";
			}
			for (int i = 0; i < n - Math.abs(s - n); i++) {
				if (arr[i] == ' ') {
					answer += "_";
				} else {
					answer += arr[i];
				}
			}
		} else if (s > arr.length) {
			for (int i = s - n; i < arr.length; i++) {
				if (arr[i] == ' ') {
					answer += "_";
				} else {
					answer += arr[i];
				}
			}
			for (int i = 0; i < s - arr.length; i++) {
				answer += "_";
			}

		} else {
			for (int i = s - n; i < s; i++) {
				if (arr[i] == ' ') {
					answer += "_";
				} else {
					answer += arr[i];
				}
			}
		}

		return answer;
	}
}