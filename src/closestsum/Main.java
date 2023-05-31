package closestsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		closest(new int[] { -1, 3, 8, 2, 9, 5 }, new int[] { 4, 1, 2, 10, 5, 20 }, 24);
	}

	public static void closest(int[] arr1, int[] arr2, int target) {
//		-sort arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);
//		-create an arraylist to hold pairs for a given distance
		List<int[]> pairs = new ArrayList<>();
//		-track the closest difference to target so far
		int smallestDistance = Integer.MAX_VALUE;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				int sum = arr1[i] + arr2[j];
				int distance = Math.abs(target - sum);
				// if this pair's difference to target is less than the current closest then
				// clear the arraylist and add the pair to an arraylist
				if (distance < smallestDistance) {
					smallestDistance = distance;
					pairs.clear();
					pairs.add(new int[] { arr1[i], arr2[j] });
				} else if (distance == smallestDistance) {
					pairs.add(new int[] { arr1[i], arr2[j] });
				}
			}
		}
		for (int[] pair : pairs) {
			System.out.println(Arrays.toString(pair));
		}
	}

}
