package coins;

public class Main {

	/*
	 * $10 • $5 • $2 • $1 • $0.5 • $0.2 • $0.1
	 */
	public static void main(String[] args) {
		CoinCalculator c = new CoinCalculator();
		System.out.println(c.findNumberOfCoins(5.20)); // 2
		System.out.println(c.findNumberOfCoins(1.20)); // 2
		System.out.println(c.findNumberOfCoins(11.30)); // 4
		System.out.println(c.findNumberOfCoins(0.50)); // 1
	}

}
