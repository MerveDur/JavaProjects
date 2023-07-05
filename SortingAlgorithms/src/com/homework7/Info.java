package com.homework7;

import java.util.ArrayList;

public class Info {
    int count;
    ArrayList<String> words = new ArrayList<String>();

    public Info(int count, ArrayList<String> words) {
        this.count = count;
        this.words = words;
    }

    public void push(String word)
    {
        if (words == null)
        {
            throw new IllegalStateException("Words list is null.");
        }
        this.count++;
        this.words.add(word);
    }

    // pop wasn't a part of the homework
    public void pop(String word) {
        if (this.words.contains(word)) {
            this.words.remove(word);
            this.count++;
        }
        else
            System.out.println("'" + word + "' is not found.");
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

}

