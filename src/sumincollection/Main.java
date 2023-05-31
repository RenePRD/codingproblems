package sumincollection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		System.out.println(bruteForce(new int[] { 1, 2, 5, 9 }, 8)); // false
		System.out.println(bruteForce(new int[] { 1, 2, 4, 4 }, 8)); // true
		System.out.println(slidingWindow(new int[] { 1, 2, 5, 9 }, 8)); // false
		System.out.println(slidingWindow(new int[] { 1, 2, 4, 4 }, 8)); // true
		System.out.println(hashMethod(new int[] { 1, 2, 5, 9 }, 8)); // false
		System.out.println(hashMethod(new int[] { 1, 2, 4, 4 }, 8)); // true
	}

	public static boolean bruteForce(int[] nums, int target) {
//		-nested loops
//		-test every pair of numbers
//		-if sum is found, return true
//		-after loop return false
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean slidingWindow(int[] nums, int target) {
//		-sort array
		Arrays.sort(nums);
//		-pointers on left and right of array
		int left = 0;
		int right = nums.length - 1;
//		-if sum is greater/less than shift the corresponding pointer towards the middle
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				return true;
			}
			if (sum > target) {
				right--;
			} else {
				left++;
			}
		}
//		-otherwise return false
		return false;
	}

	public static boolean hashMethod(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				return true;
			}
			set.add(target-num);
		}
		return false;
//		-iterate through elements
//		-each element has a "corresponding value"
//		-check within the map if such a value exists
//		-if not, add this element to the map
//		-if so, return true
//		-return false after loop
	}

}
