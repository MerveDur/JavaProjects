package com.homework6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MergeSort class
 */
public class MergeSort {
    /**
     *The original map to be sorted
     */
    private MyMap originalMap;
    /**
     *The sorted map
     */
    private MyMap sortedMap;
    /**
     * Auxiliary list used in the merge sort algorithm
     */
    private ArrayList<String> aux;

    /**
     * Constructs a MergeSort object
     * @param map the MyMap object to be sorted
     */
    public MergeSort(MyMap map) {
        this.originalMap = map;
        this.sortedMap = null;
        this.aux = new ArrayList<String>();
    }

    /**
     * Gets the original map
     * @return the original MyMap object
     */
    public MyMap getOriginalMap() {
        return originalMap;
    }

    /**
     * Sets the original map
     * @param originalMap the MyMap object to be set as the original map
     */
    public void setOriginalMap(MyMap originalMap) {
        this.originalMap = originalMap;
    }

    /**
     * Gets the sorted map
     * @return the sorted MyMap object
     */
    public MyMap getSortedMap() {
        return sortedMap;
    }

    /**
     * Sets the sorted map
     * @param sortedMap the MyMap object to be set as the sorted map
     */
    public void setSortedMap(MyMap sortedMap) {
        this.sortedMap = sortedMap;
    }

    /**
     * Gets the auxiliary list
     * @return the auxiliary list
     */
    public ArrayList<String> getAux() {
        return aux;
    }

    /**
     * Sets the auxiliary list
     * @param aux the auxiliary list to be set
     */
    public void setAux(ArrayList<String> aux) {
        this.aux = aux;
    }

    /**
     * Sorts the map using the merge sort algorithm
     * @return the sorted MyMap object
     */
    public MyMap sortMap()
    {
        if (sortedMap == null)//It checks if the sortedMap is null
        {
            if(originalMap == null)
            {
                throw new IllegalStateException("Original map is null.");
            }
            //If it is null,it gets the map from the originalMap and sorts it using mergeSort,then stores it in sortedMap
            LinkedHashMap<String, Info> map = originalMap.getMap();
            sortedMap = new MyMap(mergeSort(map), map.size(), originalMap.getStr());
        }
        return sortedMap;
    }

    /**
     * Recursively performs the merge sort algorithm on the map
     * @param map the map to be sorted
     * @return the sorted map
     */
    private LinkedHashMap<String, Info> mergeSort(LinkedHashMap<String, Info> map)
    {
        if(map.size() <= 1)//If the size of the map is 1 or less, it returns the map as it is
        {
            return map;
        }
        //Otherwise, it splits the map into two halves, sorts them recursively, and then merges them
        LinkedHashMap<String, Info> leftMap = new LinkedHashMap<String, Info>();
        LinkedHashMap<String, Info> rightMap = new LinkedHashMap<String, Info>();

        int middle = map.size() / 2;
        int index = 0;

        for(Map.Entry<String, Info> entry : map.entrySet())
        {
            if(index < middle)
            {
                leftMap.put(entry.getKey(), entry.getValue());
            }
            else
            {
                rightMap.put(entry.getKey(), entry.getValue());
            }
            index++;
        }

        leftMap = mergeSort(leftMap);
        rightMap = mergeSort(rightMap);

        return merge(leftMap, rightMap);
    }

    /**
     * Merges two maps together in sorted order
     * @param leftMap  the left map to be merged
     * @param rightMap the right map to be merged
     * @return the merged map in sorted order
     */
    private LinkedHashMap<String, Info> merge(LinkedHashMap<String, Info> leftMap, LinkedHashMap<String, Info> rightMap)
    {
        if(leftMap == null || rightMap == null)
        {
            throw new IllegalArgumentException("Left map or right map cannot be null.");
        }
        LinkedHashMap<String, Info> mergedMap = new LinkedHashMap<String, Info>();

        while(!leftMap.isEmpty() && !rightMap.isEmpty())//It continues this process until both maps are empty
        {
            Map.Entry<String, Info> leftEntry = leftMap.entrySet().iterator().next();
            Map.Entry<String, Info> rightEntry = rightMap.entrySet().iterator().next();

            //It iteratively compares the smallest (first) elements of the two maps,
            //adds the smaller one to the merged map and removes it from its original map
            if(leftEntry.getValue().getCount() <= rightEntry.getValue().getCount())
            {
                mergedMap.put(leftEntry.getKey(), leftEntry.getValue());
                leftMap.remove(leftEntry.getKey());
            }
            else
            {
                mergedMap.put(rightEntry.getKey(), rightEntry.getValue());
                rightMap.remove(rightEntry.getKey());
            }
        }

        while(!leftMap.isEmpty())
        {
            Map.Entry<String, Info> leftEntry = leftMap.entrySet().iterator().next();
            mergedMap.put(leftEntry.getKey(), leftEntry.getValue());
            leftMap.remove(leftEntry.getKey());
        }

        while(!rightMap.isEmpty())
        {
            Map.Entry<String, Info> rightEntry = rightMap.entrySet().iterator().next();
            mergedMap.put(rightEntry.getKey(), rightEntry.getValue());
            rightMap.remove(rightEntry.getKey());
        }

        return mergedMap;
    }
}