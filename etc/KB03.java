
public class KB03 {

	static int num;
	static boolean[] checked;
	static int result;

	public static void main(String[] args) {

		int[] rooms = { 3, 1, 2, 4 };
		result = 0;
		checked = new boolean[rooms.length];
		num = 0;

		for (int i = 0; i < checked.length; i++) {

			if (num == rooms.length) {
				break;
			}
			if (!checked[i]) {
				num++;
				checked[i] = true;
				findLoop(i, rooms);
			}
		}

		if (result == 1) {
			System.out.println(1);
		} else {
			System.out.println(result - 1);
		}

	}

	private static void findLoop(int idx, int[] rooms) {
		while (true) {
			if (!checked[rooms[idx] - 1]) {
				num++;
				checked[rooms[idx] - 1] = true;
				idx = rooms[idx] - 1;
			} else {
				result++;
				break;
			}
		}
	}
}
