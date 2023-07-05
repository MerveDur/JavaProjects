package com.homework7;

import java.util.ArrayList;
import java.util.Map;
/**
 * QuickSort class
 */
public class QuickSort {
    /**
     *The original map to be sorted
     */
    MyMap originalMap;
    /**
     *The sorted map
     */
    MyMap sortedMap;
    /**
     * Auxiliary list used in the merge sort algorithm
     */
    ArrayList<String> aux;

    /**
     * Constructs a QuickSort object
     * @param originalMap The original map to be sorted
     */
    public QuickSort(MyMap originalMap)
    {
        super();
        this.originalMap = originalMap;
        this.aux = new ArrayList<String>(this.originalMap.map.keySet());
        this.sortedMap = new MyMap();
    }

    /**
     * Partition function for QuickSort
     * @param low The lower bound of the subarray to partition
     * @param high The upper bound of the subarray to partition
     * @return The partition index
     */
    private int partition(int low, int high)
    {
        String pivot = aux.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++)
        {
            if (originalMap.map.get(aux.get(j)).count <= originalMap.map.get(pivot).count)
            {
                i++;

                String temp = aux.get(i);
                aux.set(i, aux.get(j));
                aux.set(j, temp);
            }
        }

        String temp = aux.get(i + 1);
        aux.set(i + 1, aux.get(high));
        aux.set(high, temp);

        return i + 1;
    }

    /**
     * Helper function for recursive QuickSort
     * @param low The lower bound of the subarray to sort
     * @param high The upper bound of the subarray to sort
     */
    private void quickSortHelper(int low, int high)
    {
        if (low < high)
        {
            int pi = partition(low, high);

            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    /**
     * The main sort function for QuickSort
     */
    public void sort()
    {
        try
        {
            quickSortHelper(0, aux.size() - 1);
            generateNewMap();
        }
        catch(Exception e)
        {
            System.out.println("Sorting Error: " + e.getMessage());
        }
    }

    /**
     * Generates the new map after sorting
     */
    private void generateNewMap()
    {
        for (int i = 0; i < aux.size(); i++)
        {
            this.sortedMap.assign(aux.get(i), this.originalMap.map.get(aux.get(i)).words);
        }
    }

    /**
     * Prints the sorted array
     */
    public void printSortedArray()
    {
        try
        {
            for (Map.Entry<String, Info> e : sortedMap.map.entrySet())
                System.out.println("Letter: " + e.getKey() + " - Count: "
                        + e.getValue().count + " - Words: " + e.getValue().words);
        }
        catch (Exception e)
        {
            System.out.println("Printing Error: " + e.getMessage());
        }
    }

    /**
     * Prints the original  array
     */
    public void printOriginalArray()
    {
        try
        {
            for (Map.Entry<String,Info> e : originalMap.map.entrySet())
                System.out.println("Letter: " + e.getKey() + " - Count: "
                        + e.getValue().count + " - Words: " + e.getValue().words);
        }
        catch (Exception e)
        {
            System.out.println("Printing Error: " + e.getMessage());
        }
    }
}
