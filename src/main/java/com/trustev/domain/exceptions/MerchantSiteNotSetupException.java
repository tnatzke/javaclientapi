package com.trustev.domain.exceptions;

public class MerchantSiteNotSetupException extends TrustevApiException {
    public MerchantSiteNotSetupException(String message) {
        super(400, message);
    }

    public MerchantSiteNotSetupException() {
        this("No MerchantSites have been setup, or all have been removed. Ensure that ApiClient.setUp was called for at least one set of credentials and that the MerchantSite was not removed with ApiClient.removeMerchantSite or ApiClient.removeAllMerchantSites");
    }
}
