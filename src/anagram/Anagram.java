package anagram;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    // loop through first string, saving each letter as key and its count as the value in a map
    //loop through second string, removing each letter
    //if map values are all 0, then anagram
    //else not anagram


    /*IMPROVEMENTS
    * instead of doing two for each loop, use a for loop for one string, using the string length
    * But you have to check first if the two strings have the same length
    * also you can get or default */
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> letterCountMap = new HashMap<>();

        for (int i=0; i < s1.length(); i++) {
            if (letterCountMap.containsKey(s1.charAt(i)))
                letterCountMap.put(s1.charAt(i), letterCountMap.get(s1.charAt(i)) + 1);
            else letterCountMap.put(s1.charAt(i), 1);

            letterCountMap.put(s2.charAt(i), letterCountMap.getOrDefault(s2.charAt(i), 0) - 1);
        }

        for(char c : letterCountMap.keySet()) {
            if (letterCountMap.get(c) != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("rat", "car")); //false
        System.out.println(isAnagram("hello", "world")); //false
        System.out.println(isAnagram("rene", "ener")); //true
        System.out.println(isAnagram("meteor", "remote")); // true
        System.out.println(isAnagram("epgndsdkngs", "gjlsbdgjbsd")); // false
        System.out.println(isAnagram("dessert", "stressed")); // false
    }
}
