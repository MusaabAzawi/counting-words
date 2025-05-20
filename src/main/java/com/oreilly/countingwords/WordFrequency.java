package com.oreilly.countingwords;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/hello-world")
public class WordFrequency {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
    String text = "The sun shines over the lake";

//    @GET
//    @Path("/echo")
//    public Response calculateHighestFrequency(@QueryParam("text") String msg) {
//        WordFrequency wordFrequency = new WordFrequency();
//        // String result = wordFrequency.calculateHighestFrequency(msg).toString();
//        return Response.ok("your message was: " + msg).build();
//    }
//

    @GET
    @Path("/highest-frequency")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateHighestFrequencyGet(@QueryParam("text") String text) {
        System.out.println("Received GET with text: " + text);
        return calculateHighestFrequencyInternal(text);
    }
    @GET
    @Path("/frequency")
    @Produces(MediaType.TEXT_PLAIN)
    public int calculateFrequencyForWordGet(@QueryParam("text") String text,@QueryParam("word") String word) {
        return calculateFrequencyForWord(text, word);
    }

    @GET
    @Path("/FrequencyNWords")
    @Produces(MediaType.TEXT_PLAIN)
    public List<WordFrequencyImp> calculateFrequencyNWords(@QueryParam("text") String text,@QueryParam("n") int n) {
        System.out.println("Received GET with text: " + text);
        return calculateMostFrequentNWords(text, n);
    }


    private String calculateHighestFrequencyInternal(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "No input text provided.";
        }

        String[] words = text.toLowerCase().split("[^a-zA-Z]+");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!word.trim().isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        int highestFrequency = 0;
        String highestWord = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > highestFrequency) {
                highestFrequency = entry.getValue();
                highestWord = entry.getKey();
            }
        }

        return highestWord.isEmpty() ? "No valid words found." : highestWord;
    }

    private int calculateFrequencyForWord(String text,String word) {

        Map<String, Integer> map = new HashMap<>();
        String[] words = text.toLowerCase().split("([A-Za-z]+)|([^A-Za-z]+)");
        for (String w : words) {
            if(!w.trim().isEmpty()) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }

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


