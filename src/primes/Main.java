package primes;

import java.util.HashSet;
import java.util.Set;

public class Main {

	Set<Integer> primes;

	public Main() {
		primes = new HashSet<>();
	}

	public boolean isPrime(int n) {
		if (primes.contains(n)) {
			return true;
		}
		
		// check the mod of n by all our primes
		for (int prime : primes) {
			// if 0 then return false
			if (n % prime == 0) {
				return false;
			}
		}

		// if loop finishes, add to primes and return true
		primes.add(n);
		return true;
	}

	public static void main(String[] args) {
		Main m = new Main();
		int n = 100;
		for (int i = 2; i <= n; i++) {
			if (m.isPrime(i)) {
				System.out.println(i);
			}
		}
	}

}
