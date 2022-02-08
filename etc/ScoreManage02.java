
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScoreManage02 {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("Test4.txt"));
		Scanner sc = new Scanner(System.in);

		int team = sc.nextInt();
		for (int i = 0; i < team; i++) {
			int member = sc.nextInt();
			int[] scoreData = new int[member];
			int teamTotal = 0;
			for (int j = 0; j < member; j++) {
				scoreData[j] = sc.nextInt();
				teamTotal += scoreData[j];
			}
			double teamAvg = (double) (teamTotal / member);
			int count = 0;
			for (int j = 0; j < member; j++) {
				if (scoreData[j] > teamAvg) {
					count++;
				}
			}
			System.out.printf("#%d %.3f%%", i + 1, ((double) count / member) * 100);
			System.out.println();
		}

	}
}
