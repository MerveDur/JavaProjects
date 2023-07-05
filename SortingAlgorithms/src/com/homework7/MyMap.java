package com.homework7;

import java.util.LinkedHashMap;
import java.util.ArrayList;

public class MyMap {
    LinkedHashMap <String, Info> map;
    int mapSize;
    String str;
    String [] words;

    public MyMap() {
        this.map = new LinkedHashMap<String, Info>();
        this.mapSize = 0;
        this.str = null;
        this.words = null;
    }

    public LinkedHashMap<String, Info> getMap() {
        return map;
    }

    public void setMap(LinkedHashMap<String, Info> map) {
        this.map = map;
    }

    public void append(String x, String word) {
        if (this.map.containsKey(x)) {
            Info myinfo = this.map.get(x);
            myinfo.push(word);
        }
        else
            addNewCharacter(x, word);
    }


    private void addNewCharacter (String x, String word) {
        ArrayList<String> words = new ArrayList<String>();
        words.add(word);
        Info myInfo = new Info (1, words);
        this.map.put(x, myInfo);
        this.mapSize ++;
    }

    public void assign(String x, ArrayList<String> words) {
        addNewCharacter(x, (String) words.get(0));
        for (int i = 1; i < words.size(); i++) {
            append(x, (String) words.get(i));
        }
    }

    public void buildMap (String str) {
        this.str = str.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
        this.words = this.str.split(" ");
        for (int i = 0; i < this.words.length; i++) {
            for (int j = 0; j < this.words[i].length(); j++) {
                append(this.words[i].substring(j, j + 1), this.words[i]);
            }
        }
    }
}
