package com.oreilly.countingwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyAnalyzerImp {
    String regex = "([A-Za-z]+)|([^A-Za-z]+)";

    protected String calculateHighestFrequency(String text) {
        String[] words = text.toLowerCase().split(regex);
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {

            map.put(word, map.getOrDefault(word, 0) + 1);
            System.out.println(word + " " +  map.get(word));
        }

        int highestFrequency = 0;
        String highestWord = "";
        for (Map.Entry<String, Integer> word : map.entrySet()) {
            Integer count = map.get(word.getKey());
            if (count > highestFrequency) {
                highestFrequency = count;
                highestWord = String.valueOf(word);
            }
        }


        return highestWord;

        // return Integer.parseInt(map.toString());
    }
    protected int calculateFrequencyForWord(String text,String word) {

        String[] words = text.toLowerCase().split(regex);
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        return map.getOrDefault(word, 0);
    }

    protected List<WordFrequencyImp> calculateMostFrequentNWords(String text, int n) {

        String[] words = text.toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<WordFrequencyImp> wordFrequencyList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            wordFrequencyList.add(new WordFrequencyImp(entry.getKey(), entry.getValue()));
        }
        return wordFrequencyList.subList(0, Math.min(n, wordFrequencyList.size()));
    }
}
