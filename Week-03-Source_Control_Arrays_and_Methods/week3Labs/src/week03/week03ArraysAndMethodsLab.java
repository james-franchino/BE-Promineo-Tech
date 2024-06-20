
//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject: Arrays & Methods
// Java Week 03 Lab
//
package week03;

public class week03ArraysAndMethodsLab {

    public static void main(String[] args) {
            
        //
        // Arrays:
        //
        
        // 1. Create an array with the following values 1, 5, 2, 8, 13, 6
        int[] num = {1, 5, 2, 8, 13, 6};

        
        // 2. Print out the first element in the array
        System.out.println("2:");
        System.out.println(num[0]);
        System.out.println("3:");
    
        
        // 3. Print out the last element in the array without using the number 5
        System.out.println(num[num.length -1]);
        System.out.println("6:");
        
        // 4. Print out the element in the array at position 6, what happens?
        //System.out.println(num[6]); 
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 6 out of                 bounds for length 6
        //at week3Labs/week03.week03ArraysAndMethodsLab.main(week03ArraysAndMethodsLab.java:29) 

        
        // 5. Print out the element in the array at position -1, what happens?
        //System.out.println(num[-1]);
        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds         for length 6
        //at week3Labs/week03.week03ArraysAndMethodsLab.main(week03ArraysAndMethodsLab.java:29)

            
        // 6. Write a traditional for loop that prints out each element in the array
        for(int i=0; i<num.length; i++) {
            System.out.println(num[i]);
        }
        System.out.println("7:");
    
            
        // 7. Write an enhanced for loop that prints out each element in the array
        for(int number : num) {
            System.out.println(number);
        }
        System.out.println("8:");
        

        
        // 8. Create a new variable called sum, write a loop that adds 
        //            each element in the array to the sum
        // Creating the variable
        int sum =0;
        // For loop to iterate through the array and add to sum.
        for(int i =0; i<num.length; i++) {
            sum += num[i];
        }
        //Print the sum
        System.out.println(sum);
        System.out.println("9:");

            
        // 9. Create a new variable called average and assign the average value of the array to it
        double average = sum / num.length;
        
        System.out.println(average);
        System.out.println("11:");

        
        // 10. Write an enhanced for loop that prints out each number in the array 
        //            only if the number is odd

        
        // 11. Create an array that contains the values "Sam", "Sally", "Thomas", and "Robert"
        String names[] = {"Sam", "Sally", "Thomas", "Robert"};
        
        
        // 12. Calculate the sum of all the letters in the new array
        int letterSum = 0;
        
        for (int i=0; i< names.length; i++ ) {
            letterSum += names[i].length();
        }
        System.out.println(letterSum);
        System.out.println("13:");

        

        //
        // Methods:
        //
        
        // 13. Write and test a method that takes a String name and prints out a greeting. 
        //            This method returns nothing.
        
            printGreeting("Sam");
            printGreeting("Sally"); 

        // 14. Write and test a method that takes a String name and  
        //            returns a greeting.  Do not print in the method.
            String greeting = printGreeting2("James");
            System.out.println(greeting);
            System.out.println("15:");

        
        // Compare method 13 and method 14:  
        //        a. Analyze the difference between these two methods.
        //        b. What do you find? 
        //        c. How are they different?
            //Method 13 is void, it returns nothing. You can use it to print to the console.
        
        
        // 15. Write and test a method that takes a String and an int and 
        //returns true if the number of letters in the string is greater than the int
            System.out.println(isStringGreater("Hello", 3)); 
            System.out.println(isStringGreater("World", 5)); 
            System.out.println(isStringGreater("Java", 2)); 
            System.out.println(isStringGreater("Programming", 10)); 
            System.out.println(isStringGreater("Cat", 4)); 
            
        
        // 16. Write and test a method that takes an array of string and a string and 
        //            returns true if the string passed in exists in the array
            String[] sampleArray = {"apple", "banana", "cherry", "date"};
            String targetString1 = "banana";
            String targetString2 = "grape";
            
            System.out.println("Array contains 'banana': " + containsString(sampleArray, targetString1)); 
            System.out.println("Array contains 'grape': " + containsString(sampleArray, targetString2));
        
        
        // 17. Write and test a method that takes an array of int and 
        //            returns the smallest number in the array
            int[] sampleArray1 = {34, 7, 23, -4, 18, 0};
            
            System.out.println("Smallest number in the array: " + findSmallestNumber(sampleArray1));
    
        
        // 18. Write and test a method that takes an array of double and 
        //            returns the average
        

        // 19. Write and test a method that takes an array of Strings and 
        //            returns an array of int where each element
        //            matches the length of the string at that position

                
        // 20. Write and test a method that takes an array of strings and 
        //            returns true if the sum of letters for all strings with an even amount of 
        //            letters is greater than the sum of those with an odd amount of letters.

    
        // 21. Write and test a method that takes a string and 
        //            returns true if the string is a palindrome

    }  
    
    // Method 13:
    public static void printGreeting(String name) {
        System.out.println("Hello, " + name + "! Welcome!");
    }

    // Method 14:
    public static String printGreeting2(String name) {
    		return "Hi " + name + "!";
    }

    
    // Method 15:
    public static boolean isStringGreater(String str, int number) {
        return str.length() > number;
    }

    
    // Method 16:
    public static boolean containsString(String[] array, String target) {
        for (String element : array) {
            if (element.equals(target)) {
                return true;
            }
        }
        return false;
        }

    
    // Method 17:
        public static int findSmallestNumber(int[] array) {
            if (array == null || array.length == 0) {
                throw new IllegalArgumentException("Array must not be null or empty");
            }
            
            int smallest = array[0];
            for (int number : array) {
                if (number < smallest) {
                    smallest = number;
                }
            }
            return smallest;
        }

    
    // Method 18:

    
    // Method 19:

    
    // Method 20:
    
    
    // Method 21:
} 
