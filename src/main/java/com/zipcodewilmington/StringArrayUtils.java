package com.zipcodewilmington;

import java.util.*;


/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
       boolean solution = true;
        for (String word : array){
            if (word.equals(value)){
                solution = true;
                break;
            } else {
                solution = false;
            }
        }
       return solution;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
     String[] reversedArr = new String[array.length];
     for (int i = 0; i < array.length; i++){
            reversedArr[i] = array[array.length - 1 - i];
        }
     return reversedArr;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

        //first we return a reversed array
        String[] reversedArr = new String[array.length];
        for (int i = 0; i < array.length; i++){
            reversedArr[i] = array[array.length - 1 - i];
        }

        //then we compare the two
        return (Arrays.equals(array,reversedArr)); //comparing arrays must require this format<< not ==, or .equals()

    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

        //initialize a hashset. just like arraylist but no duplicates are allowed
        Set<Character> letters = new HashSet<>();

        //this will iterate through each string in the full array
        for (String str : array) {
            // make every string lowercase to avoid case issues
            String lowerCaseStr = str.toLowerCase();

            // this will iterate through each letter in an individual string
            for (char ch : lowerCaseStr.toCharArray()) {
                // if a letter is an alphabetical letter (just checking that each Char is a letteR)
                if (Character.isLetter(ch)) {
                    //add it to the hashset
                    letters.add(ch);
                }
            }
        }

        //if the hashset equals 26, that means the array contained every letter of alphabet
        //otherwise it would have been less than 26
        return letters.size() == 26;
    }


    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter = 0;
        //check if value is in string

            for (String word : array){
                if (word.equals(value)){
                    counter++;
                }
            }

            return counter;

        //add 1 to counter
        //make the above to a method
        //do a for each loop on the array and call this method on each word
        //return counter total
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        //make it into an arrayList to easily manipulate
        ArrayList<String> newArrList = new ArrayList<>();

        //add every element except valueToRemoves
        for (String word : array){
            if (!word.equals(valueToRemove)) {
                newArrList.add(word);
            }
        }
        //convert back to an Array
        String[] solution = newArrList.toArray(new String[0]);
        //return updated Array
        return solution;

    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        //convert it to arraylist for easier use
        ArrayList<String> newArrList = new ArrayList<>();

        //add elements to arrayList just to copy it perfectly
        for (String str : array){
            newArrList.add(str);
        }

        ArrayList<String> secondList = new ArrayList<>();
        secondList.add(newArrList.get(0));

        for (int i = 1; i < newArrList.size(); i++){
            if (!newArrList.get(i-1).equals(newArrList.get(i))){
                secondList.add(newArrList.get(i));
            }
        }
        //convert secondList to an array
        String[] solution = secondList.toArray(new String[0]);

        return solution;

    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        List<String> resultList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(array[i - 1])) {
                sb.append(array[i]);
            } else {
                resultList.add(sb.toString());
                sb.setLength(0); // Clear the string builder
                sb.append(array[i]);
            }
        }
        resultList.add(sb.toString()); // add last sequence
        System.out.println(resultList);
        return resultList.toArray(new String[0]);
        }



//    public static void main (String[] args){
//        String[] testArr = {"a", "a", "a", "x", "y", "z", "z", "z", "k"};
//        packConsecutiveDuplicates(testArr);
//    }


}
