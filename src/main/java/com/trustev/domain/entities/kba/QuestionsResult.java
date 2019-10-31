package com.trustev.domain.entities.kba;

import com.trustev.domain.entities.Base;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionsResult extends Base<QuestionsResult> {

    private Integer id;
    private String questionText;
    private List<ChoicesResult> choices;

    @JsonProperty("Id")
    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer value) {
        this.id = value;
    }

    @JsonProperty("QuestionText")
    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(final String value) {
        this.questionText = value;
    }

    @JsonProperty("Choices")
    public List<ChoicesResult> getChoices() {
        return this.choices;
    }

    public void setChoices(final List<ChoicesResult> value) {
        this.choices = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<QuestionsResult, Comparable>> props) {
        props.add(QuestionsResult::getId);
        props.add(QuestionsResult::getQuestionText);
        super.buildSignificationProperties(props);
    }
}
