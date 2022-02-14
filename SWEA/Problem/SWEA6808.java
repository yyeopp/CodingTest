package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA6808 {

	static int[] me;
	static int[] you;

	static int[][] me2 = new int[362880][9];

	static int[] temp = new int[9];

	static boolean[] isSelected;
	static int idx = 0;

	public static void game(int count, int[] person, int[][] person2) {

		if (count == 9) {
			for (int i = 0; i < 9; i++) {
				person2[idx][i] = temp[i];
			}
			idx++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i] == true) {
				continue;
			}
			temp[count] = person[i];
			isSelected[i] = true;

			game(count + 1, person, person2);

			isSelected[i] = false;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());

			me = new int[9];
			you = new int[9];

			for (int i = 0; i < 9; i++) {
				me[i] = Integer.parseInt(st.nextToken());

			}
			int youCnt = 0;
			you: for (int i = 1; i <= 18; i++) {
				for (int j = 0; j < me.length; j++) {
					if (me[j] == i) {
						continue you;
					}
				}
				you[youCnt] = i;
				youCnt++;
			}

			isSelected = new boolean[9];

			game(0, me, me2);
			idx = 0;

			int winCnt = 0;
			int losCnt = 0;

			for (int i = 0; i < me2.length; i++) {

				int sumMe = 0;
				int sumYou = 0;

				for (int j = 0; j < 9; j++) {
					if (me2[i][j] > you[j]) {
						sumMe += (me2[i][j] + you[j]);
						continue;
					}
					if (me2[i][j] < you[j]) {
						sumYou += (me2[i][j] + you[j]);
						continue;
					}
				}

				if (sumMe > sumYou) {
					winCnt++;
					continue;
				} else if (sumMe < sumYou) {
					losCnt++;
					continue;
				} else if (sumMe == sumYou) {
					continue;
				}
			}

			sb.append(winCnt).append(" ").append(losCnt).append("\n");

		}
		System.out.println(sb);

	}

}
