
public class StarPrint {

	public static void main(String[] args) {

		String[][] A = new String[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i >= j) {
					A[i][j] = "*";
				} else {
					A[i][j] = " ";
				}
			}

		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j]);
			}
			System.out.println();
		}

	}
}
