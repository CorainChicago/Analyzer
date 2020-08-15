package com.project.language.analyzer.entity;

import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Analysis {

    @Id
    private String id;
    private String name;
    private List<String> original;

    private HashMap<String, Integer> textWithCount;

    private HashMap<String, Integer> textCountRules;
    private HashMap<String, Integer> textCountStopWords;
    private HashMap<String, Integer> textCountStopWordsRules;

    private List<Map.Entry<String, Integer>> orderedList;

}
