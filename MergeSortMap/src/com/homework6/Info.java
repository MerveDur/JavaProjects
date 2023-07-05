package com.homework6;

import java.util.List;
import java.util.ArrayList;

/**
 * Info class
 */
public class Info {

    /**
     *The count value representing the number of letter
     */
    private int count;
    /**
     *The list of words
     */
    private ArrayList<String> words;

    /**
     * Constructs an Info object
     */
    public Info() {
        count = 0;
        words = new ArrayList<String>();
    }

    /**
     * Gets the count value
     * @return the count value
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count value
     * @param count the count value to be set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Gets the list of words
     * @return the list of words
     */
    public List<String> getWords() {
        return words;
    }

    /**
     * Sets the list of words
     * @param words the list of words to be set
     */
    public void setWords(ArrayList<String> words)
    {
        if (words == null)
        {
            throw new IllegalArgumentException("Input words list cannot be null.");
        }
        this.words = words;
    }

    /**
     * Formatted string representation of the words
     * @return the formatted string representation of the words
     */
    public String printGetWords()
    {
        if (words == null)
        {
            throw new IllegalStateException("Words list is null.");
        }
        String newStr = new String();
        for(int i = 0; i < words.size(); i++)
        {
            newStr+=words.get(i);
            if(i!= words.size() - 1)
            {
                newStr+=", ";
            }
        }

        return newStr;
    }
}
