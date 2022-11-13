import java.util.Arrays;
import java.util.StringTokenizer;

public class KB01 {

	static String logs = "2019/05/01 00:59:19" + "\n" + "2019/06/01 01:35:20";

	public static void main(String[] args) {

		int[] answer = new int[24];

		String[] logArr = logs.split("\n");

		for (int i = 0; i < logArr.length; i++) {
			answer[getHour(logArr[i])]++;
		}

		System.out.println(Arrays.toString(answer));
	}

	private static int getHour(String log) {

		StringTokenizer st = new StringTokenizer(log);
		st.nextToken();

		String timeString = st.nextToken();
		String[] timeArr = timeString.split(":");

		int hour = Integer.parseInt(timeArr[0]);

		return (hour + 9) % 24;
	}

}
