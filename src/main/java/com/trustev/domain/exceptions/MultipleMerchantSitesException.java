package com.trustev.domain.exceptions;

public class MultipleMerchantSitesException extends TrustevApiException {
    public MultipleMerchantSitesException() {
        super(400, "More than one Merchant Site has been setup for this ApiClient, but no username was provided for the action. Try adding a merchant site username as a method parameter.");
    }
}
