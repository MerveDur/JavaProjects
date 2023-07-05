package com.homework7;

import java.util.ArrayList;
import java.util.Map;

/**
 * InsertionSort class
 */
public class InsertionSort {
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
     * Constructs a InsertionSort object
     * @param originalMap The original map to be sorted
     */
    public InsertionSort(MyMap originalMap)
    {
        super();
        this.originalMap = originalMap;
        this.aux = new ArrayList<String>(this.originalMap.map.keySet());
        this.sortedMap = new MyMap();
    }

    /**
     * Sorts the original map using insertion sort algorithm
     */
    public void sort()
    {
        int n = aux.size();
        int i = 1;

        try
        {
            while (i < n)
            {
                String key = aux.get(i);
                int count = originalMap.map.get(key).count;
                int j = i - 1;

                while (j >= 0 && originalMap.map.get(aux.get(j)).count > count)
                {
                    aux.set(j + 1, aux.get(j));
                    j--;
                }

                aux.set(j + 1, key);
                i++;
            }
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
