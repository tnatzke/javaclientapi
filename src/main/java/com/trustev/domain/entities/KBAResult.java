package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;
import java.util.List;

public class KBAResult {
    @JsonProperty("Timestamp")
    private Date timestamp;

    @JsonProperty("Status")
    private KBAStatus status;

    @JsonProperty("AnswerUrl")
    private String answerUrl;

    @JsonProperty("Questions")
    private List<QuestionsResult> questions;

    @JsonProperty("MultiPassQuestions")
    private List<QuestionsResult> multiPassQuestions;

    @JsonProperty("MultiPassStatus")
    private MultiPassStatus multiPassStatus;

    public MultiPassStatus getMultiPassStatus() {
        return multiPassStatus;
    }

    public void setMultiPassStatus(MultiPassStatus multiPassStatus) {
        this.multiPassStatus = multiPassStatus;
    }

    public List<QuestionsResult> getMultiPassQuestions() {
        return multiPassQuestions;
    }

    public void setMultiPassQuestions(List<QuestionsResult> multiPassQuestions) {
        this.multiPassQuestions = multiPassQuestions;
    }

    public List<QuestionsResult> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsResult> questions) {
        this.questions = questions;
    }

    public String getAnswerUrl() {
        return answerUrl;
    }

    public void setAnswerUrl(String answerUrl) {
        this.answerUrl = answerUrl;
    }

    public KBAStatus getStatus() {
        return status;
    }

    public void setStatus(KBAStatus status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
