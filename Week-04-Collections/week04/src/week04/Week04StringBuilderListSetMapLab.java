//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  StringBuilders, Lists, Sets, & Maps
// Java Week 04 Lab  
//
package week04;

import java.util.ArrayList;
import java.util.List;

public class Week04StringBuilderListSetMapLab {

    public static void main(String[] args) {

        // 1. Why would we use a StringBuilder instead of a String?
        // 		a. Instantiate a new StringBuilder
        //		b. Append the characters 0 through 9 to it separated by dashes
        // 				Note:  make sure no dash appears at the end of the StringBuilder
        // StringBuilder isd great for concatenating strings without creating new String objects which
        // is great for memory and efficiency
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb1.append(i);
            if (i < 9) {
                sb1.append("-");
            }
        }
        System.out.println(sb1);


        // 2. List of String:
        //		a. Create a list of Strings
        //		b. Add 5 Strings to it, each with a different length
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("Cat");
        list.add("Dogs");
        list.add("Firetruck");
        list.add("Goldfish");
        System.out.println(list);


        // 3. Write and test a method that takes a list of strings
        //			and returns the shortest string
        String shortestString = findShortestString(list);
        System.out.println("The shortest string is: " + shortestString);


        // 4. Write and test a method that takes a list of strings
        //			and returns the list with the first and last element switched
        System.out.println("Original list: " + list);

        List<String> modList1 = switchFirstAndLast(list);
        System.out.println("Modified list: " + modList1);



        // 5. Write and test a method that takes a list of strings
        //			and returns a string with all the list elements concatenated to each other,
        // 			separated by a comma


        // 6. Write and test a method that takes a list of strings and a string
        //			and returns a new list with all strings from the original list
        // 			containing the second string parameter (i.e. like a search method)


        // 7. Write and test a method that takes a list of integers
        //			and returns a List<List<Integer>> with the following conditions specified
        //			for the return value:
        //		a. The first List in the returned value contains any number from the input list
        //			that is divisible by 2
        //		b. The second List contains values from the input list that are divisible by 3
        //		c. The third containing values divisible by 5, and
        //		d. The fourth all numbers from the input List not divisible by 2, 3, or 5


        // 8. Write and test a method that takes a list of strings
        //			and returns a list of integers that contains the length of each string


        // 9. Create a set of strings and add 5 values


        // 10. Write and test a method that takes a set of strings and a character
        //			and returns a set of strings consisting of all the strings in the
        // 			input set that start with the character parameter.


        // 11. Write and test a method that takes a set of strings
        //			and returns a list of the same strings


        // 12. Write and test a method that takes a set of integers
        //			and returns a new set of integers containing only even numbers
        //			from the original set


        // 13. Create a map of string and string and add 3 items to it where the key of each
        // 			is a word and the value is the definition of the word


        // 14. Write and test a method that takes a Map<String, String> and a string
        // 			and returns the value for a key in the map that matches the
        // 			string parameter (i.e. like a language dictionary lookup)


        // 15. Write and test a method that takes a List<String>
        //			and returns a Map<Character, Integer> containing a count of
        //			all the strings that start with a given character


    }


    // Method 15:


    // Method 14:


    // Method 12:


    // Method 11:


    // Method 10:


    // Method 8:


    // Method 7:


    // Method 6:


    // Method 5:


    // Method 4:
    public static List<String> switchFirstAndLast(List<String> list) {
        if (list == null || list.size() < 2) {
            return list;
        }
        List<String> modList = new ArrayList<>(list);

        String firstElement = modList.getFirst();
        String lastElement = modList.getLast();
        modList.set(0, lastElement);
        modList.set(modList.size() - 1, firstElement);
        return modList;
    }



    // Method 3:
    public static String findShortestString(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return null;
        }
        String shortest = strings.get(0);
        for (String str : strings) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        return shortest;


    }
}