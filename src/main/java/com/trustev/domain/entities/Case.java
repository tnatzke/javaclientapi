package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

import com.trustev.domain.exceptions.TrustevApiException;
import java.util.function.Function;

/**
 * The Case Object is the what Trustev bases its Decision on. It is a container for all the information that can be provided.
 * The more information that you provide us with, the more accurate our Decision, so please populate as much as possible.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Case extends TimestampBase<Case> {

    private UUID sessionId;
    private String caseNumber;
    private Transaction transaction;
    private Customer customer;
    private Collection<CaseStatus> statuses;
    private Collection<Payment> payments;
    private CaseType caseType;
    private MarketType marketType;
    private String locationConsentId;
    private Fulfilment fulfilment;

    /**
     * @param sessionId  SessionId is required when adding a Trustev Case. SessionId is available through Trustev.js as a publicly accessible variable - TrustevV2.SessionId
     * @param caseNumber The CaseNumber of the case being created
     * @throws TrustevApiException If the sessionId passed in is null
     */
    @JsonCreator
    public Case(@JsonProperty("SessionId") UUID sessionId, @JsonProperty("CaseNumber") String caseNumber) throws TrustevApiException {
        this.setTimestamp(new Date());

        if (sessionId == null) {
            throw new TrustevApiException(400, "Session ID cannot be null");
        }
        this.sessionId = sessionId;
        this.caseNumber = caseNumber;
    }

    /**
     * @return SessionId is required when adding a Trustev Case. SessionId is available through Trustev.js as a publicly accessible variable - TrustevV2.SessionId
     */
    @JsonProperty("SessionId")
    public UUID getSessionId() {
        return sessionId;
    }

    private void setSessionId(final UUID value) {
        this.sessionId = value;
    }

    /**
     * @return The CaseNumber is chosen by the Merchant to uniquely identify the Trustev Case. It can be an alphanumeric string of your liking, but it must be unique.
     * We would always recommend that Merchants set the Case Number as the internal Order Number so it is easy to reference in later reporting.
     * Please see our Testing Guide to find out how to use the CaseNumber to get expected Trustev Decisions during Integration.
     */
    @JsonProperty("CaseNumber")
    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    /**
     * @return Transaction Object - includes details such as Transaction Amount, Currency, Items and Transaction delivery/billing address.
     */
    @JsonProperty("Transaction")
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * @param transaction Transaction Object - includes details such as Transaction Amount, Currency, Items and Transaction delivery/billing address.
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * @return Customer Object - includes details like First/Last name of Customer, address details, phone numbers, email addresses.
     * Social details may also be included here where available.
     * Please see Customer object for further parameter information.
     */
    @JsonProperty("Customer")
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer Customer Object - includes details like First/Last name of Customer, address details, phone numbers, email addresses.
     *                 Social details may also be included here where available.
     *                 Please see Customer object for further parameter information.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return A Status includes the Order Status and a Comment section. Trustev require that a Status is attached to a Trustev Case so that we can learn from the decision that you make on a Trustev Case.
     */
    @JsonProperty("Statuses")
    public Collection<CaseStatus> getStatuses() {
        return statuses;
    }

    /**
     * @param statuses A Status includes the Order Status and a Comment section. Trustev require that a Status is attached to a Trustev Case so that we can learn from the decision that you make on a Trustev Case.
     */
    public void setStatuses(Collection<CaseStatus> statuses) {
        this.statuses = statuses;
    }

    /**
     * @return Payments includes forwarding the Payment Type (Credit/Debit Card, PayPal), and the BIN/IIN Number of the relevant card should it be available.
     */
    @JsonProperty("Payments")
    public Collection<Payment> getPayments() {
        return payments;
    }

    /**
     * @param payments Payments includes forwarding the Payment Type (Credit/Debit Card, PayPal), and the BIN/IIN Number of the relevant card should it be available.
     */
    public void setPayments(Collection<Payment> payments) {
        this.payments = payments;
    }

    /**
     * @return The CaseType of this Case
     */
    @JsonProperty("CaseType")
    public CaseType getCaseType() {
        return this.caseType;
    }

    /**
     * @param caseType to set
     */
    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    /**
     * @return The MarketType of this Case
     */
    @JsonProperty("MarketType")
    public MarketType getMarketType() {
        return marketType;
    }

    /**
     * @param marketType to set
     */
    public void setMarketType(MarketType marketType) {
        this.marketType = marketType;
    }

    /**
     * @return the Location ConsentId used for the location services
     */
    @JsonProperty("LocationConsentId")
    public String getLocationConsentId() {
        return locationConsentId;
    }

    /**
     * @param locationConsentId to set in the case
     */
    public void setLocationConsentId(String locationConsentId) {
        this.locationConsentId = locationConsentId;
    }

    /**
     * @return the Fulfilment object
     */
    @JsonProperty("Fulfilment")
    public Fulfilment getFulfilment() {
        return fulfilment;
    }

    /**
     * @param fulfilment to set in the case
     */
    public void setFulfilment(Fulfilment fulfilment) {
        this.fulfilment = fulfilment;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Case, Comparable>> props) {
        props.add(Case::getSessionId);
        props.add(Case::getCaseNumber);
        props.add(Case::getTransaction);
        props.add(Case::getCustomer);
        props.add(Case::getCaseType);
        props.add(Case::getMarketType);
        props.add(Case::getLocationConsentId);
        props.add(Case::getFulfilment);
        super.buildSignificationProperties(props);
    }
}
