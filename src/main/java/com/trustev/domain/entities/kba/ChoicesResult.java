package com.trustev.domain.entities.kba;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trustev.domain.entities.Base;
import java.util.List;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChoicesResult extends Base<ChoicesResult> {

    private Integer id;
    private Boolean answer;
    private String choiceText;

    @JsonProperty("Id")
    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer value) {
        this.id = value;
    }

    @JsonProperty("Answer")
    public Boolean getAnswer() {
        return this.answer;
    }

    public void setAnswer(final Boolean value) {
        this.answer = value;
    }

    @JsonProperty("ChoiceText")
    public String getChoiceText() {
        return this.choiceText;
    }

    public void setChoiceText(final String value) {
        this.choiceText = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ChoicesResult, Comparable>> props) {
        props.add(ChoicesResult::getId);
        props.add(ChoicesResult::getAnswer);
        props.add(ChoicesResult::getChoiceText);
        super.buildSignificationProperties(props);
    }
}
