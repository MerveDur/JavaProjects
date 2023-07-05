package com.homework6;

/**
 * The main class
 */
public class Main {
    /**
     * The main method of the program
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        /**
         * Input string
         */
        String str="'Hush, hush!' whispered the rushing wind.";


        str=preprocessing(str);//String is preprocessed
        MyMap myMap = new MyMap(str);//mymap object is created

        System.out.println("\nThe original (unsorted) map:");
        myMap.printMap();//The initial state of the mymap object is printed
        MergeSort mergeSort = new MergeSort(myMap);
        myMap = mergeSort.sortMap();//Merge sort operation is applied to mymap object
        System.out.println("\nThe sorted map:");
        myMap.printMap();//The sorted version of the mymap object is printed

    }
    /**
     *  Removes non-letter and space characters from input string and converts uppercase letters to lowercase
     * @param input the input string to be preprocessed
     * @return the preprocessed string
     */
    public static String preprocessing(String input)
    {
        System.out.println("Original String:    "+input);
        input = input.toLowerCase();//Convert uppercase letters to lowercase
        input=input.replaceAll("[^a-z\\s]", "");//Removing non-letter and white space characters
        System.out.println("Preprocessed String:    "+input);
        return input;
    }
}

