package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedDataTransaction extends Base<ComputedDataTransaction> {
    private ComputedDataEmail email;

    @JsonProperty("Email")
    public ComputedDataEmail getEmail() {
        return email;
    }

    public void setEmail(ComputedDataEmail email) {
        this.email = email;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedDataTransaction, Comparable>> props) {
        props.add(ComputedDataTransaction::getEmail);
        super.buildSignificationProperties(props);
    }
}