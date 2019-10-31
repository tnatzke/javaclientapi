package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.function.Function;

/**
 * Payments includes forwarding the Payment Type (Credit/Debit Card, PayPal…), and the BIN/IIN Number of the relevant card should it be available.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment extends IdBase<Payment> {

    private PaymentType paymentType;
    private String binNumber;

    /**
     * @return The type of Payment method used
     */
    @JsonProperty("PaymentType")
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType The type of Payment method used
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }


    /**
     * @return The BIN Number - the first 6 digits of a Debit/Credit Card Number.
     */
    @JsonProperty("BINNumber")
    public String getBinNumber() {
        return this.binNumber;
    }

    /**
     * @param bINNumber The BIN Number - the first 6 digits of a Debit/Credit Card Number.
     */

    public void setBinNumber(String bINNumber) {
        this.binNumber = bINNumber;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Payment, Comparable>> props) {
        props.add(Payment::getPaymentType);
        props.add(Payment::getBinNumber);
        super.buildSignificationProperties(props);
    }
}
