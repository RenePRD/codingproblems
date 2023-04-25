//package closestsum;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Main {
//
//	public static void main(String[] args) {
//		closest(new int[] { -1, 3, 8, 2, 9, 5 }, new int[] { 4, 1, 2, 10, 5, 20 }, 24);
//	}
//
//	public static void closest(int[] arr1, int[] arr2, int target) {
////		-sort arrays
//		Arrays.sort(arr1);
//		Arrays.sort(arr2);
////		-create an arraylist to hold pairs for a given distance
//		List<int[]> pairs = new ArrayList<>();
////		-track the closest difference to target so far
//		int smallestDistance = Integer.MAX_VALUE;
//		for (int i = 0; i < arr1.length; i++) {
//			for (int j = 0; j < arr2.length; j++) {
//				int sum = arr1[i] + arr2[j];
//				int distance = Math.abs(target - sum);
//				// if this pair's difference to target is less than the current closest then
//				// clear the arraylist and add the pair to an arraylist
//				if (distance < smallestDistance) {
//					smallestDistance = distance;
//					pairs.clear();
//					pairs.add(new int[] { arr1[i], arr2[j] });
//				} else if (distance == smallestDistance) {
//					pairs.add(new int[] { arr1[i], arr2[j] });
//				}
//			}
//		}
//		for (int[] pair : pairs) {
//			System.out.println(Arrays.toString(pair));
//		}
//	}
//
//	public static void closet(int[] arr1, int[] arr2, int target) {
//	//sort array
//	//start
//
//	// Sort both arrays in ascending order
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//
//	int lenArr = arr1.length;
//	List<int[]> closestPairs = new ArrayList<>();
//	int minDiff = Integer.MAX_VALUE;  // Initialize minimum difference as maximum integer value
//
//	int i = 0;  // Pointer for array 1
//	int j = lenArr - 1;  // Pointer for array 2
//
//        while (i < lenArr && j >= 0) {
//		// Calculate the sum of the current pair
//		int currSum = arr1[i] + arr2[j];
//
//		// Calculate the absolute difference between the current sum and target sum
//		int currDiff = Math.abs(currSum - targetSum);
//
//		// If the current difference is less than the current minimum difference,
//		// update the closestPairs list and the minimum difference
//		if (currDiff < minDiff) {
//			closestPairs = new ArrayList<>();
//			closestPairs.add(new int[]{arr1[i], arr2[j]});
//			minDiff = currDiff;
//		}
//		// If the current difference is equal to the current minimum difference,
//		// append the current pair to the closestPairs list
//		else if (currDiff == minDiff) {
//			closestPairs.add(new int[]{arr1[i], arr2[j]});
//		}
//
//		// Move the pointers based on the comparison of current sum and target sum
//		if (currSum < targetSum) {
//			i++;
//		} else {
//			j--;
//		}
//	}
//
//	// Sort the closestPairs list in ascending order based on the sum of the pairs
//        closestPairs.sort((a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
//
//        return closestPairs;
//}
