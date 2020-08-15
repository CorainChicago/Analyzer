package com.project.language.analyzer.model;

import java.util.LinkedHashMap;
import java.util.List;

public class AnalyzeResponse {

    private String id;
    private String name;
    private String original;
    private Boolean useStopWords;
    private Boolean useRootWords;
    private LinkedHashMap<String, Integer> result;
    private List<String> top25WordsUsed;

    public AnalyzeResponse(String name, Boolean useStopWords, Boolean useRootWords) {
        this.name = name;
        this.useStopWords = useStopWords;
        this.useRootWords = useRootWords;
    }

    public AnalyzeResponse(String name) {
        this.name = name;
    }

    public AnalyzeResponse(String name, String original) {
        this.name = name;
        this.original = original;
    }

    public AnalyzeResponse() {
    }

    public String getId() {
        return id;
    }

    public AnalyzeResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnalyzeResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getOriginal() {
        return original;
    }

    public AnalyzeResponse setOriginal(String original) {
        this.original = original;
        return this;
    }

    public Boolean getUseStopWords() {
        return useStopWords;
    }

    public AnalyzeResponse setUseStopWords(Boolean useStopWords) {
        this.useStopWords = useStopWords;
        return this;
    }

    public Boolean getUseRootWords() {
        return useRootWords;
    }

    public AnalyzeResponse setUseRootWords(Boolean stem) {
        this.useRootWords = stem;
        return this;
    }

    public LinkedHashMap<String, Integer> getResult() {
        return result;
    }

    public AnalyzeResponse setResult(LinkedHashMap result) {
        this.result = result;
        return this;
    }

    public List<String> getTop25WordsUsed() {
        return top25WordsUsed;
    }

    public AnalyzeResponse setTop25WordsUsed(List<String> top25WordsUsed) {
        this.top25WordsUsed = top25WordsUsed;
        return this;
    }
}
