package com.project.language.analyzer.model;

import java.util.Objects;

public class AnalyzeRequest {

    private String name;
    private String text;
    private Boolean useStopWords;
    private Boolean useRootWords;


    public AnalyzeRequest(String name, String text, Boolean useStopWords, Boolean useRootWords) {
        this.name = name;
        this.text = text;
        this.useStopWords = useStopWords;
        this.useRootWords = useRootWords;
    }

    public String getName() {
        return name;
    }

    public AnalyzeRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getText() {
        return text;
    }

    public AnalyzeRequest setText(String text) {
        this.text = text;
        return this;
    }

    public Boolean getUseStopWords() {
        if(Objects.isNull(useStopWords)){
            return false;
        }
        return useStopWords;
    }

    public AnalyzeRequest setUseStopWords(Boolean useStopWords) {
        this.useStopWords = useStopWords;
        return this;
    }

    public Boolean getUseRootWords() {
        if(Objects.isNull(useRootWords)){
            return false;
        }
        return useRootWords;
    }

    public AnalyzeRequest setUseRootWords(Boolean useRootWords) {
        this.useRootWords = useRootWords;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalyzeRequest that = (AnalyzeRequest) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getText(), that.getText()) &&
                Objects.equals(getUseStopWords(), that.getUseStopWords()) &&
                Objects.equals(getUseRootWords(), that.getUseRootWords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getText(), getUseStopWords(), getUseRootWords());
    }


}
