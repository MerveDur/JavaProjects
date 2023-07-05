package com.homework7;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * MergeSort class
 */
public class MergeSort {
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
     * Constructs a MergeSort object
     * @param originalMap The original map to be sorted
     */
    public MergeSort(MyMap originalMap) {
        super();
        this.originalMap = originalMap;
        this.aux = new ArrayList<String>(this.originalMap.map.keySet());
        this.sortedMap = new MyMap();
    }

    /**
     * Merges two subarrays of the auxiliary list
     * @param l Starting index of the first subarray
     * @param m Ending index of the first subarray
     * @param r Ending index of the second subarray
     */
    public void merge(int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        String Left[] = new String[n1];
        int R[] = new int[n2];
        String Right[] = new String[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = originalMap.map.get(((List<String>) this.aux).get(l + i)).count;
            Left[i] = this.aux.get(l + i);
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = originalMap.map.get(((List<String>) this.aux).get(m + 1 + j)).count;
            Right[j] = this.aux.get(m + 1 + j);
        }


        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                aux.set(k, Left[i]);
                i++;
            }

            else {
                aux.set(k, Right[j]);
                j++;
            }

            k++;
        }

        while (i < n1) {
            aux.set(k, Left[i]);
            i++;
            k++;
        }

        while (j < n2) {
            aux.set(k, Right[j]);
            j++;
            k++;
        }
    }

    /**
     * Generates the new map after sorting
     */
    private void generateNewMap() {
        for (int i = 0; i < aux.size(); i++)
            this.sortedMap.assign(aux.get(i), this.originalMap.map.get(aux.get(i)).words);
    }


    /**
     * Recursive helper method to perform merge sort
     * @param l Starting index of the subarray
     * @param r Ending index of the subarray
     */
    private void sortHelper (int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sortHelper(l, m);
            sortHelper(m + 1, r);
            merge(l, m, r);
        }

    }

    /**
     * Sorts the original map using merge sort algorithm
     */
    public void sort()
    {
        try
        {
            sortHelper (0, this.originalMap.mapSize - 1);
            generateNewMap();
        }
        catch(Exception e)
        {
            System.out.println("Sorting Error: " + e.getMessage());
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