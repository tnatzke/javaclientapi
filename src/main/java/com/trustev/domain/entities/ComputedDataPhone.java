package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedDataPhone extends Base<ComputedDataPhone> {
    private boolean isPhoneRisky;

    @JsonProperty("IsPhoneRisky")
    public boolean isPhoneRisky() {
        return isPhoneRisky;
    }

    public void setPhoneRisky(boolean isPhoneRisky) {
        this.isPhoneRisky = isPhoneRisky;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedDataPhone, Comparable>> props) {
        props.add(ComputedDataPhone::isPhoneRisky);
        super.buildSignificationProperties(props);
    }
}