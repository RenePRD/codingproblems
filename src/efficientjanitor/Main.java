package efficientjanitor;

import java.util.Arrays;

public class Main {

	/*
	 * Bob works the closing shift at Efficiency 4 Life Secondary School. Every
	 * evening, he needs to take out all the trash and toss them into a big
	 * container at the school’s front gate. Since Bob likes to go home earlier
	 * rather than later, he works as efficiently as possible. He can take up to 3
	 * pounds in trash on each trip, taking multiple bags if needed. Given that
	 * trash bags can range from 0 to 3 pounds, what is the least number of trips
	 * that Bob will have to make for any given set of trash bags? Note that empty
	 * bags must also be brought to the container
	 */
	public static void main(String[] args) {
		System.out.println(takeOutTrash(new double[] { 0.1, 3, 2.3, 2, 1.1, 1.75 })); // 4
		System.out.println(takeOutTrash(new double[] { 3, 3, 0.2, 1 })); // 3
		System.out.println(takeOutTrash(new double[] { 0, 1, 2, 3, 2, 1, 0 })); // 3
		System.out.println(takeOutTrash(new double[] {})); // 0
		System.out.println(takeOutTrash(new double[] { 0 })); // 1
		System.out.println(takeOutTrash(new double[] { 0, 0, 0, 0, 0, 0 })); // 1
	}

	private static int takeOutTrash(double[] bags) {
		// sort
		Arrays.sort(bags);

		// greedily take bags from heaviest to lightest
		double maxWeight = 3;
		int tripCounter = 0;
		int numBags = bags.length;
		while (numBags > 0) {
//			System.out.println("trips: " + tripCounter + ", bags: " + numBags);
//			System.out.println(Arrays.toString(bags));
			for (int i = bags.length - 1; i >= 0; i--) {
				if (maxWeight >= bags[i] && bags[i] != -1) {
					// if im able to hold this bag, then pick up the bag
					maxWeight -= bags[i];
					// remove the bag, whatever that means
					numBags--;
					bags[i] = -1;
				}
			}
			// run to the front and reset
			tripCounter++;
			maxWeight = 3;
		}
		return tripCounter;
	}

}
