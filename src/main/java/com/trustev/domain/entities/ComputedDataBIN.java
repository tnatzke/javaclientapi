package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedDataBIN extends Base<ComputedDataBIN> {

    private boolean doesMatchCustomerBillingAddressCountry;
    private boolean doesMatchCustomerDeliveryAddressCountry;
    private boolean doesMatchTransactionBillingAddressCountry;
    private boolean doesMatchTransactionDeliveryAddressCountry;
    private boolean doesMatchIPCountry;
    private boolean isCountryDomestic;

    @JsonProperty("DoesMatchCustomerBillingAddressCountry")
    public boolean isDoesMatchCustomerBillingAddressCountry() {
        return doesMatchCustomerBillingAddressCountry;
    }

    public void setDoesMatchCustomerBillingAddressCountry(boolean doesMatchCustomerBillingAddressCountry) {
        this.doesMatchCustomerBillingAddressCountry = doesMatchCustomerBillingAddressCountry;
    }

    @JsonProperty("DoesMatchCustomerDeliveryAddressCountry")
    public boolean isDoesMatchCustomerDeliveryAddressCountry() {
        return doesMatchCustomerDeliveryAddressCountry;
    }

    public void setDoesMatchCustomerDeliveryAddressCountry(boolean doesMatchCustomerDeliveryAddressCountry) {
        this.doesMatchCustomerDeliveryAddressCountry = doesMatchCustomerDeliveryAddressCountry;
    }

    @JsonProperty("DoesMatchTransactionBillingAddressCountry")
    public boolean isDoesMatchTransactionBillingAddressCountry() {
        return doesMatchTransactionBillingAddressCountry;
    }

    public void setDoesMatchTransactionBillingAddressCountry(boolean doesMatchTransactionBillingAddressCountry) {
        this.doesMatchTransactionBillingAddressCountry = doesMatchTransactionBillingAddressCountry;
    }

    @JsonProperty("DoesMatchTransactionDeliveryAddressCountry")
    public boolean isDoesMatchTransactionDeliveryAddressCountry() {
        return doesMatchTransactionDeliveryAddressCountry;
    }

    public void setDoesMatchTransactionDeliveryAddressCountry(boolean doesMatchTransactionDeliveryAddressCountry) {
        this.doesMatchTransactionDeliveryAddressCountry = doesMatchTransactionDeliveryAddressCountry;
    }

    @JsonProperty("DoesMatchIPCountry")
    public boolean isDoesMatchIPCountry() {
        return doesMatchIPCountry;
    }

    public void setDoesMatchIPCountry(boolean doesMatchIPCountry) {
        this.doesMatchIPCountry = doesMatchIPCountry;
    }

    @JsonProperty("IsCountryDomestic")
    public boolean isCountryDomestic() {
        return isCountryDomestic;
    }

    public void setCountryDomestic(boolean isCountryDomestic) {
        this.isCountryDomestic = isCountryDomestic;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedDataBIN, Comparable>> props) {
        props.add(ComputedDataBIN::isDoesMatchCustomerBillingAddressCountry);
        props.add(ComputedDataBIN::isDoesMatchCustomerDeliveryAddressCountry);
        props.add(ComputedDataBIN::isDoesMatchTransactionBillingAddressCountry);
        props.add(ComputedDataBIN::isDoesMatchTransactionDeliveryAddressCountry);
        props.add(ComputedDataBIN::isDoesMatchIPCountry);
        props.add(ComputedDataBIN::isCountryDomestic);
        super.buildSignificationProperties(props);
    }
}