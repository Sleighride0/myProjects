package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    private WordCount wordCount;

    @Before
    public void setup(){
        wordCount = new WordCount();
    }
    @Test
    public void returns_wordCount_correctly_when_appearing_twice() {
        String words[] = new String[]{"ba", "ba", "black"};
        Map<String, Integer> result = wordCount.getCount(words);
        Map<String, Integer> expected = new HashMap<>();
        expected.put ("ba", 2);
        expected.put ("black", 1);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void returns_wordCount_correctly_when_appearing_in_nonconsequitive_order() {
        String words[] = new String[]{"ba", "black", "ba"};
        Map<String, Integer> result = wordCount.getCount(words);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void returns_wordCount_map_empty_when_array_empty() {
        String words[] = new String[]{};
        Map<String, Integer> result = wordCount.getCount(words);
        Map<String, Integer> expected = new HashMap<>();

        Assert.assertEquals(expected, result);
    }







}
