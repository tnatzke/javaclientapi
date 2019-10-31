package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedDecision extends Decision<DetailedDecision> {

    private String caseNumber;
    private String caseId;
    private RawData rawData;
    private ComputedData computedData;
    private DigitalAuthenticationResult authentication;

    @JsonProperty("CaseNumber")
    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(final String value) {
        this.caseNumber = value;
    }

    @JsonProperty("CaseId")
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(final String value) {
        this.caseId = value;
    }

    @JsonProperty("RawData")
    public RawData getRawData() {
        return rawData;
    }

    public void setRawData(final RawData value) {
        this.rawData = value;
    }

    @JsonProperty("ComputedData")
    public ComputedData getComputedData() {
        return computedData;
    }

    public void setComputedData(final ComputedData value) {
        this.computedData = value;
    }

    @JsonProperty("Authentication")
    public DigitalAuthenticationResult getAuthentication() {
        return authentication;
    }

    public void setAuthentication(final DigitalAuthenticationResult value) {
        authentication = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<DetailedDecision, Comparable>> props) {
        props.add(DetailedDecision::getCaseNumber);
        props.add(DetailedDecision::getCaseId);
        props.add(DetailedDecision::getRawData);
        props.add(DetailedDecision::getComputedData);
        props.add(DetailedDecision::getAuthentication);
        super.buildSignificationProperties(props);
    }
}