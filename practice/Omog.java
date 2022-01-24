import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Omog {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);

		byte[][] dataSet = new byte[19][19];

		for (int i = 0; i < dataSet.length; i++) {
			for (int j = 0; j < dataSet[i].length; j++) {
				dataSet[i][j] = sc.nextByte();
			}
		}

		boolean Finish = false;
		for (int i = 0; i < dataSet.length; i++) {
			for (int j = 0; j < dataSet[i].length; j++) {

				if (dataSet[i][j] != 0) {
					byte count = 0;
					for (int k = 1; k <= 4; k++) {

						if (Finish == true) {
							break;
						}
						if (j > 14) {
							break;
						}
						if (dataSet[i][j] == dataSet[i][j + k]) {
							count++;
						}
						if (count == 4) {
							Finish = true;
							System.out.println(dataSet[i][j]);
							System.out.printf("%d %d", i + 1, j + 1);
						}
					}
					if (Finish == true) {
						break;
					}
					count = 0;
					for (int k = 1; k <= 4; k++) {
						if (Finish == true) {
							break;
						}
						if (i > 14 || j > 14) {
							break;
						}
						if (dataSet[i][j] == dataSet[i + k][j + k]) {
							count++;
						}
						if (count == 4) {
							Finish = true;
							System.out.println(dataSet[i][j]);
							System.out.printf("%d %d", i + 1, j + 1);
						}
					}
					if (Finish == true) {
						break;
					}
					count = 0;
					for (int k = 1; k <= 4; k++) {

						if (Finish == true) {
							break;
						}
						if (i > 14 || j < 4) {
							break;
						}
						if (dataSet[i][j] == dataSet[i + k][j - k]) {
							count++;
						}
						if (count == 4) {
							Finish = true;
							System.out.println(dataSet[i][j]);
							System.out.printf("%d %d", i + 1, j + 1);
						}
					}
					if (Finish == true) {
						break;
					}
				}

			}
			if (Finish == true) {
				break;
			}
		}

	}

}
