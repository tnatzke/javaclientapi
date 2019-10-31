package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedData extends Base<ComputedData> {
    private CaseType caseType;
    private ComputedDataVelocity velocity;
    private ComputedDataList blackList;
    private ComputedDataList greyList;
    private ComputedDataList whiteList;
    private ComputedDataCustomer customer;
    private ComputedDataTransaction transaction;
    private ComputedDataLocation location;
    private ComputedDataPhone phone;
    private ComputedDataAccount account;

    @JsonProperty("CaseType")
    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    @JsonProperty("Velocity")
    public ComputedDataVelocity getVelocity() {
        return velocity;
    }

    public void setVelocity(ComputedDataVelocity velocity) {
        this.velocity = velocity;
    }

    @JsonProperty("BlackList")
    public ComputedDataList getBlackList() {
        return blackList;
    }

    public void setBlackList(ComputedDataList blackList) {
        this.blackList = blackList;
    }

    @JsonProperty("GreyList")
    public ComputedDataList getGreyList() {
        return greyList;
    }

    public void setGreyList(ComputedDataList greyList) {
        this.greyList = greyList;
    }

    @JsonProperty("WhiteList")
    public ComputedDataList getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(ComputedDataList whiteList) {
        this.whiteList = whiteList;
    }

    @JsonProperty("Customer")
    public ComputedDataCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ComputedDataCustomer customer) {
        this.customer = customer;
    }

    @JsonProperty("Transaction")
    public ComputedDataTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(ComputedDataTransaction transaction) {
        this.transaction = transaction;
    }

    @JsonProperty("Location")
    public ComputedDataLocation getLocation() {
        return location;
    }

    public void setLocation(ComputedDataLocation location) {
        this.location = location;
    }

    @JsonProperty("Phone")
    public ComputedDataPhone getPhone() {
        return phone;
    }

    public void setPhone(ComputedDataPhone phone) {
        this.phone = phone;
    }

    @JsonProperty("Account")
    public ComputedDataAccount getAccount() {
        return account;
    }

    public void setAccount(ComputedDataAccount account) {
        this.account = account;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedData, Comparable>> props) {
        props.add(ComputedData::getCaseType);
        props.add(ComputedData::getVelocity);
        props.add(ComputedData::getBlackList);
        props.add(ComputedData::getGreyList);
        props.add(ComputedData::getWhiteList);
        props.add(ComputedData::getCustomer);
        props.add(ComputedData::getTransaction);
        props.add(ComputedData::getLocation);
        props.add(ComputedData::getPhone);
        props.add(ComputedData::getAccount);
        super.buildSignificationProperties(props);
    }
}
