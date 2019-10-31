package com.trustev.domain.entities.kba;

import com.trustev.domain.entities.TimestampBase;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KBAResult extends TimestampBase<KBAResult> {

    private String answerUrl;
    private List<QuestionsResult> multiPassQuestions;
    private MultiPassStatus multiPassStatus;
    private List<QuestionsResult> questions;
    private KBAStatus status;

    @JsonProperty("AnswerUrl")
    public String getAnswerUrl() {
        return this.answerUrl;
    }

    public void setAnswerUrl(final String value) {
        this.answerUrl = value;
    }

    @JsonProperty("MultiPassQuestions")
    public List<QuestionsResult> getMultiPassQuestions() {
        return this.multiPassQuestions;
    }

    public void setMultiPassQuestions(final List<QuestionsResult> value) {
        this.multiPassQuestions = value;
    }

    @JsonProperty("MultiPassStatus")
    public MultiPassStatus getMultiPassStatus() {
        return this.multiPassStatus;
    }

    public void setMultiPassStatus(final MultiPassStatus value) {
        this.multiPassStatus = value;
    }

    @JsonProperty("Questions")
    public List<QuestionsResult> getQuestions() {
        return this.questions;
    }

    public void setQuestions(final List<QuestionsResult> value) {
        this.questions = value;
    }

    @JsonProperty("Status")
    public KBAStatus getStatus() {
        return this.status;
    }

    public void setStatus(final KBAStatus value) {
        this.status = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<KBAResult, Comparable>> props) {
        props.add(KBAResult::getAnswerUrl);
        props.add(KBAResult::getMultiPassStatus);
        props.add(KBAResult::getStatus);
        super.buildSignificationProperties(props);
    }
}
