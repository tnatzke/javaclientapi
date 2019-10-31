package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedDataList extends Base<ComputedDataList> {

    private CaseType caseType;
    private boolean wasBinHit;
    private boolean wasEmailDomainHit;
    private boolean wasFullEmailAddressHit;
    private boolean wasPostCodeHit;
    private boolean wasCustomerIdHit;
    private boolean wasAccountNumberHit;
    private boolean wasIPHit;

    @JsonProperty("CaseType")
    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    @JsonProperty("WasBinHit")
    public boolean isWasBinHit() {
        return wasBinHit;
    }

    public void setWasBinHit(boolean wasBinHit) {
        this.wasBinHit = wasBinHit;
    }

    @JsonProperty("WasEmailDomainHit")
    public boolean isWasEmailDomainHit() {
        return wasEmailDomainHit;
    }

    public void setWasEmailDomainHit(boolean wasEmailDomainHit) {
        this.wasEmailDomainHit = wasEmailDomainHit;
    }

    @JsonProperty("WasFullEmailAddressHit")
    public boolean isWasFullEmailAddressHit() {
        return wasFullEmailAddressHit;
    }

    public void setWasFullEmailAddressHit(boolean wasFullEmailAddressHit) {
        this.wasFullEmailAddressHit = wasFullEmailAddressHit;
    }

    @JsonProperty("WasPostCodeHit")
    public boolean isWasPostCodeHit() {
        return wasPostCodeHit;
    }

    public void setWasPostCodeHit(boolean wasPostCodeHit) {
        this.wasPostCodeHit = wasPostCodeHit;
    }

    @JsonProperty("WasCustomerIdHit")
    public boolean isWasCustomerIdHit() {
        return wasCustomerIdHit;
    }

    public void setWasCustomerIdHit(boolean wasCustomerIdHit) {
        this.wasCustomerIdHit = wasCustomerIdHit;
    }

    @JsonProperty("WasAccountNumberHit")
    public boolean isWasAccountNumberHit() {
        return wasAccountNumberHit;
    }

    public void setWasAccountNumberHit(boolean wasAccountNumberHit) {
        this.wasAccountNumberHit = wasAccountNumberHit;
    }

    @JsonProperty("WasIPHit")
    public boolean isWasIPHit() {
        return wasIPHit;
    }

    public void setWasIPHit(boolean wasIPHit) {
        this.wasIPHit = wasIPHit;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedDataList, Comparable>> props) {
        props.add(ComputedDataList::getCaseType);
        props.add(ComputedDataList::isWasEmailDomainHit);
        props.add(ComputedDataList::isWasFullEmailAddressHit);
        props.add(ComputedDataList::isWasPostCodeHit);
        props.add(ComputedDataList::isWasCustomerIdHit);
        props.add(ComputedDataList::isWasAccountNumberHit);
        props.add(ComputedDataList::isWasIPHit);
        super.buildSignificationProperties(props);
    }
}
