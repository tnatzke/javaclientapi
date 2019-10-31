package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse extends Base<ErrorResponse> {

    private String message;

    @JsonProperty("Message")
    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String value) {
        this.message = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ErrorResponse, Comparable>> props) {
        props.add(ErrorResponse::getMessage);
        super.buildSignificationProperties(props);
    }
}
