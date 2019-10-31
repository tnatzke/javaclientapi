package com.trustev.domain.entities;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.function.Function;

/**
 * Transaction Object - includes details such as Transaction Amount, Currency, Items and Transaction delivery/billing address.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction extends TimestampBase<Transaction> {

    private double totalTransactionValue;
    private String currency;
    private Collection<Address> addresses;
    private Collection<TransactionItem> items;
    public Collection<Email> emails;

    /**
     * @return Total Value of the Transaction.
     */
    @JsonProperty("TotalTransactionValue")
    public double getTotalTransactionValue() {
        return totalTransactionValue;
    }

    /**
     * @param totalTransactionValue Total Value of the Transaction.
     */
    public void setTotalTransactionValue(double totalTransactionValue) {
        this.totalTransactionValue = totalTransactionValue;
    }

    /**
     * @return Currency Type Code. Standard Currency Type codes can be found at http://www.xe.com/currency
     */
    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency Currency Type Code. Standard Currency Type codes can be found at http://www.xe.com/currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return Addresses Object  Contains standard/delivery/billing information. Please see Address Object for further parameter information.
     */
    @JsonProperty("Addresses")
    public Collection<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses Addresses Object  Contains standard/delivery/billing information. Please see Address Object for further parameter information.
     */
    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return Items Object  contains details on Item Name, Quantity and Item Value. Please see Items Object for further parameter information.
     */
    @JsonProperty("Items")
    public Collection<TransactionItem> getItems() {
        return items;
    }

    /**
     * @param items Items Object  contains details on Item Name, Quantity and Item Value. Please see Items Object for further parameter information.
     */
    public void setItems(Collection<TransactionItem> items) {
        this.items = items;
    }

    /**
     * @return Email Object
     */
    @JsonProperty("Emails")
    public Collection<Email> getEmails() {
        return this.emails;
    }

    /**
     * @param emails Email Object
     */
    public void setEmails(Collection<Email> emails) {
        this.emails = emails;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Transaction, Comparable>> props) {
        props.add(Transaction::getTotalTransactionValue);
        props.add(Transaction::getCurrency);
        props.add(Transaction::getTotalTransactionValue);
        props.add(Transaction::getTotalTransactionValue);
        props.add(Transaction::getTotalTransactionValue);
        super.buildSignificationProperties(props);
    }
}
