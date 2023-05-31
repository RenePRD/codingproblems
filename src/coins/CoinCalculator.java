package coins;

import java.util.HashMap;
import java.util.Map;

public class CoinCalculator {
	
	Map<Integer, Integer> m = new HashMap<>();
	
	public CoinCalculator() {
		m.put(1, 1);
		m.put(7, 1);
		m.put(22, 1);
	}
	
	public int findNumberOfCoins3(int value) {
		if (value < 1) {
			return Integer.MAX_VALUE;
		}
		if (!m.containsKey(value)) {
			m.put(value, Math.min(Math.min(findNumberOfCoins3(value - 1), findNumberOfCoins3(value - 7))
					, findNumberOfCoins3(value - 22)) + 1);
		}
		return m.get(value);
	}
	
	public int findNumberOfCoins2(int value) {
		if (value < 1) {
			return Integer.MAX_VALUE;
		}
		// base case
		if (value == 1 || value == 7 || value == 22) {
			return 1;
		}
		// recursive step
		return Math.min(Math.min(findNumberOfCoins2(value - 1), findNumberOfCoins2(value - 7))
				, findNumberOfCoins2(value - 22)) + 1;
	}

	/*
	 * $10 • $5 • $2 • $1 • $0.5 • $0.2 • $0.1
	 */
	public int findNumberOfCoins(double value) {
		// subtract as many $10 as possible
		int counter = 0;
		int newValue = (int) (value * 10);

		double[] coinValues = { 10, 5, 2, 1, 0.5, 0.2, 0.1 };
		for (double coinValue : coinValues) {
			int i = (int) (coinValue * 10);
			counter += newValue / i;
			newValue = newValue % i;
		}

		return counter;
	}

	

	public static void main(String[] args) {
		CoinCalculator c = new CoinCalculator();
		for (int i = 1; i <= 200; i++) {
			System.out.println(i + ": " + c.findNumberOfCoins3(i));
		}
//		System.out.println(c.findNumberOfCoins2(28)); // 4
//		System.out.println(c.findNumberOfCoins2(2)); // 2
//		System.out.println(c.findNumberOfCoins2(13)); // 7
//		System.out.println(c.findNumberOfCoins2(30)); // 3
//		System.out.println(c.findNumberOfCoins2(134)); // 8
//		System.out.println(c.findNumberOfCoins2(138)); // 9
//		System.out.println(c.findNumberOfCoins2(50)); // 5
//		System.out.println(c.findNumberOfCoins2(35)); // 5
//		System.out.println(c.findNumberOfCoins2(78)); // 9
//		System.out.println(c.findNumberOfCoins2(72)); // 6
//		System.out.println(c.findNumberOfCoins2(57)); // 6
//		System.out.println(c.findNumberOfCoins2(51)); // 3
//		System.out.println(c.findNumberOfCoins2(29)); // 2
//		System.out.println(c.findNumberOfCoins2(64)); // 7
//		System.out.println(c.findNumberOfCoins2(58)); // 4

//		System.out.println(c.findNumberOfCoins2(1)); // 1
//		System.out.println(c.findNumberOfCoins2(2)); // 2
//		System.out.println(c.findNumberOfCoins2(3)); // 3
//		System.out.println(c.findNumberOfCoins2(6)); // 6
//		System.out.println(c.findNumberOfCoins2(7)); // 1
//		System.out.println(c.findNumberOfCoins2(8)); // 2
//		System.out.println(c.findNumberOfCoins2(9)); // 3
//		System.out.println(c.findNumberOfCoins2(22)); // 1
//		System.out.println(c.findNumberOfCoins2(23)); // 2
//		System.out.println(c.findNumberOfCoins2(24)); // 3
		// 1x22 + 2x1 --> 3
		// 3x7 + 3x1 --> 6
		// 24x1 --> 24

//		System.out.println(c.findNumberOfCoins2(25)); // 4
//		System.out.println(c.findNumberOfCoins2(27)); // 6
//		// 1x22 + 5x1 --> 6
//		// 27x1 --> 27
//		// 3x7 + 6x1 --> 9
//
//		System.out.println(c.findNumberOfCoins2(28)); // 4
		// 4x7 -> 4 = f(21) + 1
		// 1x22 + 6x1 -> 7 = f(6) + 1
		// 28x1 -> 28 = f(27) + 1

	}

}
