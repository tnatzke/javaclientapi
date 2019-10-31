package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedDataCustomer extends Base<ComputedDataCustomer> {

    private CaseType caseType;
    private boolean isReturningToPlatform;
    private boolean hasGoodHistory;
    private boolean hasBadHistory;
    private boolean hasSuspiciousHistory;
    private boolean isNameAddressCombinationValid;
    private ComputedDataEmail email;

    @JsonProperty("CaseType")
    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    @JsonProperty("IsReturningToPlatform")
    public boolean isReturningToPlatform() {
        return isReturningToPlatform;
    }

    public void setReturningToPlatform(boolean isReturningToPlatform) {
        this.isReturningToPlatform = isReturningToPlatform;
    }

    @JsonProperty("HasGoodHistory")
    public boolean isHasGoodHistory() {
        return hasGoodHistory;
    }

    public void setHasGoodHistory(boolean hasGoodHistory) {
        this.hasGoodHistory = hasGoodHistory;
    }

    @JsonProperty("HasBadHistory")
    public boolean isHasBadHistory() {
        return hasBadHistory;
    }

    public void setHasBadHistory(boolean hasBadHistory) {
        this.hasBadHistory = hasBadHistory;
    }

    @JsonProperty("HasSuspiciousHistory")
    public boolean isHasSuspiciousHistory() {
        return hasSuspiciousHistory;
    }

    public void setHasSuspiciousHistory(boolean hasSuspiciousHistory) {
        this.hasSuspiciousHistory = hasSuspiciousHistory;
    }

    @JsonProperty("IsNameAddressCombinationValid")
    public boolean isNameAddressCombinationValid() {
        return isNameAddressCombinationValid;
    }

    public void setNameAddressCombinationValid(boolean isNameAddressCombinationValid) {
        this.isNameAddressCombinationValid = isNameAddressCombinationValid;
    }

    @JsonProperty("Email")
    public ComputedDataEmail getEmail() {
        return email;
    }

    public void setEmail(ComputedDataEmail email) {
        this.email = email;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedDataCustomer, Comparable>> props) {
        props.add(ComputedDataCustomer::getCaseType);
        props.add(ComputedDataCustomer::isReturningToPlatform);
        props.add(ComputedDataCustomer::isHasGoodHistory);
        props.add(ComputedDataCustomer::isHasBadHistory);
        props.add(ComputedDataCustomer::isHasSuspiciousHistory);
        props.add(ComputedDataCustomer::isNameAddressCombinationValid);
        props.add(ComputedDataCustomer::getEmail);
        super.buildSignificationProperties(props);
    }
}