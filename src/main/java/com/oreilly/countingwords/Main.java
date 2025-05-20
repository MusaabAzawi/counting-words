package com.oreilly.countingwords;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        WordFrequencyAnalyzerImp wordFrequencyAnalyzerImp = new WordFrequencyAnalyzerImp();
        String text = "The sun shines over the lake";
        String word = "the";
        int frequency = 4;
        try {
//            String currentWord = String.valueOf(wordFrequencyAnalyzerImp.calculateFrequencyForWord(text,word));
//            System.out.println(currentWord);
//            String highestFrequency = wordFrequencyAnalyzerImp.calculateHighestFrequency(text);
//            System.out.println(highestFrequency);
            List<WordFrequencyImp> mostFrequentWords = wordFrequencyAnalyzerImp.calculateMostFrequentNWords(text, frequency);
            for (WordFrequencyImp wordFreq : mostFrequentWords) {
                System.out.println(wordFreq.getWord() + ": " + wordFreq.getFrequency());
            }
        }catch (NumberFormatException e) {
            e.getCause();
        }
    }
}
