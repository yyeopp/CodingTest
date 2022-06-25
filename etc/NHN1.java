import java.util.Arrays;

public class NHN1 {

	public static void main(String[] args) {
		int[] cards = { 2, 3, 6, 5, 4, 1 };
		String[] shuffles = { "Cut", "Riffle", "Cut" };
		int[] answer = Arrays.copyOf(cards, cards.length);

		for (int i = 0; i < shuffles.length; i++) {
			if (shuffles[i].equals("Cut")) {
				answer = cut(answer);
			} else {
				answer = riffle(answer);
			}
		}
		System.out.println(Arrays.toString(answer));

	}

	private static int[] cut(int[] cards) {
		int[] result = new int[cards.length];
		int idx = cards.length / 2;
		for (int i = 0; i < result.length; i++) {
			if (idx == cards.length) {
				idx = 0;
			}
			result[i] = cards[idx];
			idx++;
		}
		return result;
	}

	private static int[] riffle(int[] cards) {
		int[] result = new int[cards.length];
		int size = cards.length / 2;
		int idx = 0;
		for (int i = 0; i < result.length; i += 2) {
			result[i] = cards[idx + size];
			result[i + 1] = cards[idx];
			idx++;
		}
		return result;
	}

}
