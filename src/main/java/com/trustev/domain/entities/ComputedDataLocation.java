package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedDataLocation extends Base<ComputedDataLocation> {

    private CaseType caseType;
    private boolean isIPCountryDomestic;
    private ComputedDataBIN bin;

    @JsonProperty("CaseType")
    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    @JsonProperty("IsIPCountryDomestic")
    public boolean isIPCountryDomestic() {
        return isIPCountryDomestic;
    }

    public void setIPCountryDomestic(boolean isIPCountryDomestic) {
        this.isIPCountryDomestic = isIPCountryDomestic;
    }

    @JsonProperty("BIN")
    public ComputedDataBIN getBin() {
        return bin;
    }

    public void setBin(ComputedDataBIN bin) {
        this.bin = bin;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedDataLocation, Comparable>> props) {
        props.add(ComputedDataLocation::getCaseType);
        props.add(ComputedDataLocation::isIPCountryDomestic);
        props.add(ComputedDataLocation::getBin);
        super.buildSignificationProperties(props);
    }
}