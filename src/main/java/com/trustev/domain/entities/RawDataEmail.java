package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawDataEmail extends Base<RawDataEmail> {
    private String emailAddress;

    @JsonProperty("EmailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    protected void buildSignificationProperties(List<Function<RawDataEmail, Comparable>> props) {
        props.add(RawDataEmail::getEmailAddress);
        super.buildSignificationProperties(props);
    }
}