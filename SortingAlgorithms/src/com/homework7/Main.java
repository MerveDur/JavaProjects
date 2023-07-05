package com.homework7;

public class Main {

    public static void main(String[] args) {
        // String str = "'Hush, hush!' whispered the rushing wind.";
        //String str = "Buzzing bees buzz.";
        //String str = "aaaa bbbb cccc";//bestCase
        //String str = "Buzzing bees buzz.";//averageCase
        String str = "zzzzzzzzzzzz yyyyxxxx www vvv uu tt s r q p o n m l k j i h g f e d c b a";//worstCase

        MyMap newMapObj = new MyMap();
        newMapObj.buildMap(str);
        System.out.println("Original String:\t" + str);
        System.out.println("Preprocessed String:\t" + newMapObj.str);
        MergeSort ms = new MergeSort(newMapObj);

        System.out.println("\n\n1-MergeSort-->The original (unsorted) map:");
        ms.printOriginalArray();

        System.out.println("\n\n1-MergeSort-->The sorted map:");
        long startTime = System.nanoTime();
        ms.sort();
        long endTime = System.nanoTime();
        long runningTime = endTime - startTime;
        System.out.println("\n\n1-MergeSort running time: "+runningTime);
        ms.printSortedArray();


        SelectionSort ss = new SelectionSort(newMapObj);

        System.out.println("\n\n2-SelectionSort-->The original (unsorted) map:");
        ss.printOriginalArray();

        System.out.println("\n\n2-SelectionSort-->The sorted map:");
        startTime = System.nanoTime();
        ss.sort();
        endTime = System.nanoTime();
        runningTime = endTime - startTime;
        System.out.println("\n\n2-SelectionSort running time: "+runningTime);
        ss.printSortedArray();

        InsertionSort is = new InsertionSort(newMapObj);

        System.out.println("\n\n3-InsertionSort-->The original (unsorted) map:");
        is.printOriginalArray();

        System.out.println("\n\n3-InsertionSort-->The sorted map:");
        startTime = System.nanoTime();
        is.sort();
        endTime = System.nanoTime();
        runningTime = endTime - startTime;
        System.out.println("\n\n3-InsertionSort running time: "+runningTime);
        is.printSortedArray();

        BubbleSort bs = new BubbleSort(newMapObj);

        System.out.println("\n\n4-BubbleSort-->The original (unsorted) map:");
        bs.printOriginalArray();

        System.out.println("\n\n4-BubbleSort-->The sorted map:");
        startTime = System.nanoTime();
        bs.sort();
        endTime = System.nanoTime();
        runningTime = endTime - startTime;
        System.out.println("\n\n4-BubbleSort running time: "+runningTime);
        bs.printSortedArray();

        QuickSort qs = new QuickSort(newMapObj);

        System.out.println("\n\n5-QuickSort-->The original (unsorted) map:");
        qs.printOriginalArray();

        System.out.println("\n\n5-QuickSort-->The sorted map:");
        startTime = System.nanoTime();
        qs.sort();
        endTime = System.nanoTime();
        runningTime = endTime - startTime;
        System.out.println("\n\n5-QuickSort running time: "+runningTime);
        qs.printSortedArray();
    }
}