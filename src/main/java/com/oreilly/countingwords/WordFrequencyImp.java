package com.oreilly.countingwords;

public class WordFrequencyImp {
    private final String word;
    private final int frequency;

    public WordFrequencyImp(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    String getWord() {
        return word;
    };
    int getFrequency() {
        return frequency;
    };
}
