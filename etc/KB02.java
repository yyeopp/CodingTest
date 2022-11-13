
public class KB02 {

	public static void main(String[] args) {

		int money = 1000000000;
		int minratio = 50;
		int maxratio = 99;
		int ranksize = 100000;
		int threshold = 0;
		int months = 6;

		for (int i = 0; i < months; i++) {
			int aMoney = getAMoney(money);
			if (aMoney < threshold) {
				continue;
			}

			int taxRate = getTaxRate(aMoney, minratio, maxratio, ranksize, threshold);
			int tax = aMoney / 100 * taxRate;

			money -= tax;
		}

		System.out.println(money);

	}

	private static int getAMoney(int money) {
		return money / 100 * 100;
	}

	private static int getTaxRate(int aMoney, int minratio, int maxratio, int ranksize, int threshold) {

		int moneyOverflow = aMoney - threshold;
		int weight = moneyOverflow / ranksize;
		int limit = maxratio - minratio;

		if (weight > limit) {
			return maxratio;
		}

		return minratio + weight;

	}

}
