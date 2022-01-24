
public class Execute {

	public void execute(String msg) {

		String[] msgData = msg.split("");
		int[] data = new int[msgData.length];
		for (int i = 0; i < data.length; i++) {
			data[i] = Integer.parseInt(msgData[i]);
		}

		int[] count = new int[10];
		for (int i = 0; i < data.length; i++) {
			count[data[i]]++;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			System.out.println(i + " : " + count[i]);
		}

	}

	public static void main(String[] args) {
		Test3 c = new Test3();
		c.execute("53290539955364534323455987827332679340558347453272569584");

		System.out.println("=======");
		c.execute("13334444555557777777");
	}
}
