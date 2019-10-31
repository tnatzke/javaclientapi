package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedDataVelocity extends Base<ComputedDataVelocity> {

    private CaseType caseType;
    private int decisionsWithin1Hour;
    private int decisionsWithin24Hours;
    private int decisionsWithin7Days;
    private int decisionsWithin30Days;
    private boolean isShortTermVelocityHigh;
    private boolean isShortTermVelocityMedium;
    private boolean isLongTermVelocityHigh;
    private boolean isLongTermVelocityMedium;

    @JsonProperty("CaseType")
    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    @JsonProperty("DecisionsWithin1Hour")
    public int getDecisionsWithin1Hour() {
        return decisionsWithin1Hour;
    }

    public void setDecisionsWithin1Hour(int decisionsWithin1Hour) {
        this.decisionsWithin1Hour = decisionsWithin1Hour;
    }

    @JsonProperty("DecisionsWithin24Hours")
    public int getDecisionsWithin24Hours() {
        return decisionsWithin24Hours;
    }

    public void setDecisionsWithin24Hours(int decisionsWithin24Hours) {
        this.decisionsWithin24Hours = decisionsWithin24Hours;
    }

    @JsonProperty("DecisionsWithin7Days")
    public int getDecisionsWithin7Days() {
        return decisionsWithin7Days;
    }

    public void setDecisionsWithin7Days(int decisionsWithin7Days) {
        this.decisionsWithin7Days = decisionsWithin7Days;
    }

    @JsonProperty("DecisionsWithin30Days")
    public int getDecisionsWithin30Days() {
        return decisionsWithin30Days;
    }

    public void setDecisionsWithin30Days(int decisionsWithin30Days) {
        this.decisionsWithin30Days = decisionsWithin30Days;
    }

    @JsonProperty("IsShortTermVelocityHigh")
    public boolean isIsShortTermVelocityHigh() {
        return isShortTermVelocityHigh;
    }

    public void setIsShortTermVelocityHigh(boolean isShortTermVelocityHigh) {
        this.isShortTermVelocityHigh = isShortTermVelocityHigh;
    }

    @JsonProperty("IsShortTermVelocityMedium")
    public boolean isIsShortTermVelocityMedium() {
        return isShortTermVelocityMedium;
    }

    public void setIsShortTermVelocityMedium(boolean isShortTermVelocityMedium) {
        this.isShortTermVelocityMedium = isShortTermVelocityMedium;
    }

    @JsonProperty("IsLongTermVelocityHigh")
    public boolean isIsLongTermVelocityHigh() {
        return isLongTermVelocityHigh;
    }

    public void setIsLongTermVelocityHigh(boolean isLongTermVelocityHigh) {
        this.isLongTermVelocityHigh = isLongTermVelocityHigh;
    }

    public boolean isIsLongTermVelocityMedium() {
        return this.isLongTermVelocityMedium;
    }

    @JsonProperty("IsLongTermVelocityMedium")
    public void setIsLongTermVelocityMedium(boolean isLongTermVelocityMedium) {
        this.isLongTermVelocityMedium = isLongTermVelocityMedium;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedDataVelocity, Comparable>> props) {
        props.add(ComputedDataVelocity::getCaseType);
        props.add(ComputedDataVelocity::getDecisionsWithin1Hour);
        props.add(ComputedDataVelocity::getDecisionsWithin24Hours);
        props.add(ComputedDataVelocity::getDecisionsWithin7Days);
        props.add(ComputedDataVelocity::getDecisionsWithin30Days);
        props.add(ComputedDataVelocity::isIsShortTermVelocityHigh);
        props.add(ComputedDataVelocity::isIsShortTermVelocityMedium);
        props.add(ComputedDataVelocity::isIsLongTermVelocityHigh);
        props.add(ComputedDataVelocity::isIsLongTermVelocityMedium);
        super.buildSignificationProperties(props);
    }
}
