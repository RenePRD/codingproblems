package number_of_good_pairs;

import java.util.HashMap;
import java.util.Map;

public class numberOfGoodPairs {
    //we'll keep a running count of pairs we walk though the array of integer
    //as we talk through the index, every repeated number as they come up, can pair up with the previous numbers
    //that we've looped through
    //we add the previous count of the current number, as the number of new pairs we add to the running pair count

    /*your initial method implemented with for loop didn't work, instead you had to do a for each loop
    * it was returning a nullpointer exception
    * not because you can't use a for loop, but you put i directly somewhere instead of arrays[i]*/

    public static int numberOfGoodPairs(int[] nums) {
        //keep track of total pair count
        int pairCount = 0;

        //create hashmap to keep track of the count of each number
        Map<Integer, Integer> numberCountMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            numberCountMap.put(nums[i], numberCountMap.getOrDefault(nums[i], 0) + 1);
            pairCount += numberCountMap.get(nums[i]) - 1;
        }

        return pairCount;

    }

    public static int numGoodPairs(int[] nums) {
        int pairCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1); // increment the count of 'n' in the map
            // every new occurrence of a number can be paired with every previous occurrence
            // so if a number has already appeared 'p' times, we will have 'p-1' new pairs
            pairCount += map.get(n) - 1;
        }
        return pairCount;
    }

    public static void main(String[] args) {

//        int[] nums1 = { 1, 2, 3, 1, 1, 3 };
//        int result1 = numGoodPairs(nums1);
//        System.out.println("Result 1: " + result1 + " (Expected: 4)");
//
//        int[] nums2 = { 1, 1, 1, 1 };
//        int result2 = numGoodPairs(nums2);
//        System.out.println("Result 2: " + result2 + " (Expected: 6)");
//
//        int[] nums3 = { 1, 2, 3 };
//        int result3 = numGoodPairs(nums3);
//        System.out.println("Result 3: " + result3 + " (Expected: 0)");

        int[] nums1 = { 1, 2, 3, 1, 1, 3 };
        int result1 = numberOfGoodPairs(nums1);
        System.out.println("Result 1: " + result1 + " (Expected: 4)");

        int[] nums2 = { 1, 1, 1, 1 };
        int result2 = numberOfGoodPairs(nums2);
        System.out.println("Result 2: " + result2 + " (Expected: 6)");

        int[] nums3 = { 1, 2, 3 };
        int result3 = numberOfGoodPairs(nums3);
        System.out.println("Result 3: " + result3 + " (Expected: 0)");
    }


}
