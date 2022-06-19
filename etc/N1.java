
public class N1 {

	public static void main(String[] args) {

		int N = 16;
		int largest = 0;
		int shift = 0;
		int temp = N;

		for (int i = 1; i < 30; ++i) {
			int index = (temp & 1);
			System.out.println("index  "+index );
			temp = ((temp >> 1) | (index << 30));
			System.out.println("temp  "+temp);

			if (temp > largest) {
				largest = temp;
				shift = i;
			}
		}
		System.out.println(largest);
		System.out.println(shift);
	}

}
