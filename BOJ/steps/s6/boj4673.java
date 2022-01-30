package steps.s6;

import java.io.*;

public class boj4673 {

	public static boolean isSelfNo(int n) {
		boolean isSelfNo = false;
		for (int i = n - 1; i >= n - 37; i--) {

			if (i == 0 || i == (n - 37)) {
				isSelfNo = true;
				break;
			}
			if (i > 0 && i < 10) {
				if (i * 2 == n) {
					isSelfNo = false;
					break;
				}
			}
			if (i >= 10 && i < 100) {
				if (i + i / 10 + i % 10 == n) {
					isSelfNo = false;
					break;
				}
			}

			if (i >= 100 && i < 1000) {
				int hun = i / 100;
				int ten = (i - hun * 100) / 10;
				int one = i - hun * 100 - ten * 10;
				if (i + hun + ten + one == n) {
					isSelfNo = false;
					break;
				}
			}

			if (i >= 1000 && i < 10000) {
				int tho = i / 1000;
				int hun = (i - tho * 1000) / 100;
				int ten = (i - tho * 1000 - hun * 100) / 10;
				int one = i - tho * 1000 - hun * 100 - ten * 10;

				if (i + tho + hun + ten + one == n) {
					isSelfNo = false;
					break;
				}
			}
		}

		return isSelfNo;

	}

	public static void main(String[] args) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			for (int i = 1; i <= 10000; i++) {
				if (boj4673.isSelfNo(i) == true) {

					bw.write(i + "\n");
				}
			}
			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
