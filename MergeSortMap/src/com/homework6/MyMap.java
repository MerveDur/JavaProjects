package com.homework6;

import java.util.LinkedHashMap;

/**
 * MyMap class
 */
public class MyMap {
    /**
     * The LinkedHashMap representing the map
     */
    private LinkedHashMap<String, Info> map;
    /**
     * The size of the map
     */
    private int mapSize;
    /**
     * Used for the key of the map structure
     */
    private String str;

    /**
     * Constructs a MyMap object
     * @param map the LinkedHashMap representing the map
     * @param mapSize the size of the map
     * @param str the string used as the key for the map structure
     */
    public MyMap(LinkedHashMap<String, Info> map, int mapSize, String str)
    {
        this.map = map;
        this.mapSize = mapSize;
        this.str = str;
    }

    /**
     * Constructs a MyMap object
     * @param str the string used as the key for the map structure
     */
    public MyMap(String str)
    {
        this.str=str;
        map = new LinkedHashMap<String,Info>();
        mapSize = 0;
        createMap();
    }

    /**
     * Getter the map.
     * @return the LinkedHashMap representing the map
     */
    public LinkedHashMap<String, Info> getMap() {
        return map;
    }

    /**
     * Sets the map.
     * @param map the LinkedHashMap representing the map to be set
     */
    public void setMap(LinkedHashMap<String, Info> map) {
        this.map = map;
    }

    /**
     * Getter the size of the map
     * @return the size of the map
     */
    public int getMapSize() {
        return mapSize;
    }

    /**
     * Sets the size of the map
     * @param mapSize the size of the map to be set
     */
    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    /**
     * Getter the string used as the key for the map structure
     *
     * @return the string used as the key
     */
    public String getStr() {
        return str;
    }

    /**
     * Sets the string used as the key for the map structure
     * @param str the string used as the key to be set
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**
     * Creates the map by manipulating the input string and populating the LinkedHashMap.
     */
    private void createMap()
    {
        if (str == null || str.isEmpty())
        {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }
        String[] words = str.split(" ");//Split the string into words

        for (int i = 0; i < words.length; i++)
        {
            for (int j = 0; j < words[i].length(); j++)
            {
                String letter = String.valueOf(words[i].charAt(j));
                //If the key already exists, update the associated Info object
                if (map.containsKey(letter))
                {
                    Info info = map.get(letter);
                    info.setCount(info.getCount()+1);
                    info.getWords().add(words[i]);
                }
                else//If the key doesn't exist, create a new Info object and add it to the map
                {
                    Info info = new Info();
                    info.setCount(info.getCount()+1);
                    info.getWords().add(words[i]);
                    map.put(letter, info);
                    mapSize++;
                }
            }
        }
    }

    /**
     * Prints the map by iterating over the keys and values.
     */
    public void printMap()
    {
        if(map == null)
        {
            throw new IllegalStateException("Map is null.");
        }
        for (String key : map.keySet())
        {
            Info info = map.get(key);
            System.out.println("Letter: " + key + " - Count: " + info.getCount() + " - Words: [" + info.printGetWords() + "]") ;
        }
    }
}
