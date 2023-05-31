package shortest_word_distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestWordDistance {
    //turn array into arraylist
    //use indexOf Arraylist
    //subtract each

    /*The solution you gave just changes the array to an arraylist and getting using the indexOfMethod
    * this does not work in the test case where you have duplicates of the word
    * and so if you have two pairs of the words, */
    public static void main(String[] args) {
        String[] words12 = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String word1 = "fox";
        String word2 = "dog";
        System.out.println(twoPointersShortestWordDistance(words12, word1, word2)); //5

        String[] words34 = {"a", "c", "d", "b", "a"};
        String word3 = "a";
        String word4 = "b";
        System.out.println(twoPointersShortestWordDistance(words34, word3, word4)); //1

        String[] words56 = {"a", "b", "c", "d", "e"};
        String word5 = "a";
        String word6 = "e";
        System.out.println(twoPointersShortestWordDistance(words56, word5, word6)); //4

        String[] words78 = {"a", "b", "c", "d", "b", "s", "k", "r", "e", "o", "a"};
        String word7 = "a";
        String word8 = "b";
        System.out.println(twoPointersShortestWordDistance(words78, word7, word8)); //1
    }

    public static int shortestWordDistance(String[] stringArray, String word1, String word2) {
        List<String> wordArrayList = new ArrayList<>(Arrays.asList(stringArray));
        int word1Index = wordArrayList.lastIndexOf(word1);
        int word2Index = wordArrayList.lastIndexOf(word2);

        return Math.abs(word2Index - word1Index);
    }

    public static int twoPointersShortestWordDistance(String[] stringArray, String word1, String word2) {
        int word1Index = -1, word2Index = -1;
        // you basically want a shortest distance update everytime to get the shortest distance possible
        int shortestDistance = stringArray.length;

        for(int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(word1))
                word1Index = i;
            else if (stringArray[i].equals(word2))
                word2Index = i;

            //once both indices are updated, we'll also update shortest distance!
            if ( word1Index != -1 && word2Index  != -1)
                shortestDistance = Math.min(shortestDistance, Math.abs(word2Index - word1Index));
        }

        return shortestDistance;

    }
}
