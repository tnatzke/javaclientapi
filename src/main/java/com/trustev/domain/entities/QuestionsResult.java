package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class QuestionsResult {

    @JsonProperty("Id")
    private int id;

    @JsonProperty("QuestionText")
    private String questionText;

    @JsonProperty("Choices")
    private List<ChoicesResult> choices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<ChoicesResult> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoicesResult> choices) {
        this.choices = choices;
    }
}
