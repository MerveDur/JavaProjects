package com.homework7;

import java.util.ArrayList;
import java.util.Map;

/**
 * BubbleSort class
 */
public class BubbleSort {
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
     * Constructs a BubbleSort object
     * @param originalMap The original map to be sorted
     */
    public BubbleSort(MyMap originalMap)
    {
        super();
        this.originalMap = originalMap;
        this.aux = new ArrayList<String>(this.originalMap.map.keySet());
        this.sortedMap = new MyMap();
    }

    /**
     * Sorts the original map using bubble sort algorithm.
     */
    public void sort()
    {
        for(int i = 0; i < aux.size()-1; i++)
        {
            for (int j = 0; j < aux.size()-i-1; j++)
            {
                if(originalMap.map.get(aux.get(j)).count > originalMap.map.get(aux.get(j+1)).count)
                {
                    String temp = aux.get(j);
                    aux.set(j, aux.get(j+1));
                    aux.set(j+1, temp);
                }
            }
        }
        generateNewMap();
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
