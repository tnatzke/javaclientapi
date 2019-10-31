package com.trustev.web;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.trustev.domain.entities.kba.KBAResult;
import com.trustev.domain.entities.otp.OTPResult;
import com.trustev.domain.exceptions.MerchantSiteNotSetupException;
import com.trustev.domain.exceptions.MultipleMerchantSitesException;
import com.trustev.util.DateUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import com.trustev.domain.entities.*;
import com.trustev.domain.exceptions.TrustevApiException;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;

/*
 * The ApiClient has all the methods required to communicate with the Trustev Platform.
 */
public class ApiClient {

    private static Map<String, MerchantSite> merchantSites;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ApiClient.class);

    static {
        merchantSites = new ConcurrentHashMap<>();
    }

    /**
     * Initialize the Trustev class by passing in your UserName, Secret and Password.
     * If you do not have this information, please contact our Integration Team - integrate@trustev.com
     *
     * @param userName Your Trustev Username
     * @param password Your Trustev Password
     * @param secret   Your Trustev Secret
     * @param baseUrl  The base url for the api calls (either US or EU)
     */
    public static void setUp(String userName, String password, String secret, BaseUrl baseUrl) {
        setUp(userName, password, secret, null, baseUrl);
    }

    /**
     * Initialize the Trustev class by passing in your UserName, Secret and Password.
     * If you do not have this information, please contact our Integration Team - integrate@trustev.com
     *
     * @param userName Your Trustev Username
     * @param password Your Trustev Password
     * @param secret   Your Trustev Secret
     * @param baseUrl  The base url for the api calls (either US or EU)
     */
    public static void setUp(String userName, String password, String secret, String publicKey, BaseUrl baseUrl) {
        if (baseUrl == null) {
            throw new IllegalArgumentException("baseUrl cannot be null.");
        }
        setUp(userName, password, secret, publicKey, baseUrl.getUrl());
    }

    /**
     * Initialize the Trustev class by passing in your UserName, Secret and Password.
     * If you do not have this information, please contact our Integration Team - integrate@trustev.com
     *
     * @param userName Your Trustev Username
     * @param password Your Trustev Password
     * @param secret   Your Trustev Secret
     * @param baseUrl  A url string specifying base url for the api calls
     */
    public static void setUp(String userName, String password, String secret, String publicKey, String baseUrl) {
        if (!hasMerchantSite(userName)) {
            merchantSites.put(userName, new MerchantSite(userName, password, secret, publicKey, baseUrl));
        }
    }

    /**
     * Initialize the Trustev class by passing in your UserName, Secret and Password.
     * If you do not have this information, please contact our Integration Team - integrate@trustev.com
     *
     * @param userName Your Trustev Username
     * @param password Your Trustev Password
     * @param secret   Your Trustev Secret
     * @param baseUrl  A url string specifying base url for the api calls
     */
    public static void setUp(String userName, String password, String secret, String baseUrl) {
        setUp(userName, password, secret, null, baseUrl);
    }

    /**
     * Check if the Merchant Site associated with the username is already in the Map of merchantSites
     *
     * @param userName the username for the given merchant site
     * @return true if the merchant site is already registered, false if the merchant site is not registered (or if the map of merchantSites is empty)
     */
    private static boolean hasMerchantSite(String userName) {
        if (merchantSites.isEmpty()) {
            return false;
        } else {
            return merchantSites.containsKey(userName);
        }
    }

    /**
     * Checks if there are multiple Merchant Sites registered with the Api Client
     *
     * @return true if there are more than 1 Merchant Sites, false if there is only 1 or if the Map of registered sites is empty
     */
    private static boolean hasMultipleMerchantSites() {
        return merchantSites != null && merchantSites.size() > 1;
    }

    /**
     * Clears the all registered Merchant Site credentials
     */
    public static void removeAllMerchantSites() {
        merchantSites.clear();
    }

    /**
     * Removes a merchant site from the ApiClient's regiserted merchant sites
     *
     * @param username the username for the merchant site that will be removed
     * @return true if the merchant site was successfully removed, false if the merchant site is not registered in the ApiClient's registered merchant sites or the removal failed
     */
    public static boolean removeMerchantSite(String username) {
        if (merchantSites != null && merchantSites.containsKey(username)) {
            merchantSites.remove(username);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Post your Case to the TrustevClient Api
     *
     * @param kase Your Case which you want to POST
     * @return The Case, along with the Case Id that the TrustevClient API have assigned it.
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Case postCase(Case kase) throws TrustevApiException {
        String url = "/Case";
        return performHttpCall(url, HttpMethod.POST, Case.class, kase, true);
    }

    /**
     * Post your Case to the TrustevClient Api
     *
     * @param kase     Your Case which you want to POST
     * @param username The merchant site username that the request is being made by
     * @return The Case, along with the Case Id that the TrustevClient API have assigned it.
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Case postCase(Case kase, String username) throws TrustevApiException {
        String url = "/Case";
        return performHttpCall(url, HttpMethod.POST, Case.class, kase, true, username);
    }

    /**
     * Update your Case with the case Id, provided with the new Case object
     *
     * @param kase   Your Case which you want to PUT and update the existing Case with.
     * @param caseId The Case Id of the Case you want to update. The TrustevClient API will have assigned this Id and returned it in the response Case from the PostCase Method
     * @return The case that was just updated
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Case updateCase(Case kase, String caseId) throws TrustevApiException {
        String url = "/Case/" + caseId;
        return performHttpCall(url, HttpMethod.PUT, Case.class, kase, true);
    }

    /**
     * Update your Case with the case Id, provided with the new Case object
     *
     * @param kase     Your Case which you want to PUT and update the existing Case with.
     * @param caseId   The Case Id of the Case you want to update. The TrustevClient API will have assigned this Id and returned it in the response Case from the PostCase Method
     * @param username The merchant site username that the request is being made by
     * @return The case that was just updated
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Case updateCase(Case kase, String caseId, String username) throws TrustevApiException {
        String url = "/Case/" + caseId;
        return performHttpCall(url, HttpMethod.PUT, Case.class, kase, true, username);
    }

    /**
     * Get the Case with the Id caseId
     *
     * @param caseId The Case Id of the Case you want to get. The TrustevClient API will have assigned this Id and returned it in the response Case from the PostCase Method
     * @return The Case with Id equal to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Case getCase(String caseId) throws TrustevApiException {
        String url = "/Case/" + caseId;
        return performHttpCall(url, HttpMethod.GET, Case.class, null, true);
    }

    /**
     * Get the Case with the Id caseId
     *
     * @param caseId The Case Id of the Case you want to get. The TrustevClient API will have assigned this Id and returned it in the response Case from the PostCase Method
     * @return The Case with Id equal to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Case getCase(String caseId, String username) throws TrustevApiException {
        String url = "/Case/" + caseId;
        return performHttpCall(url, HttpMethod.GET, Case.class, null, true, username);
    }

    /**
     * Get a Decision on a Case with Id caseId.
     *
     * @param caseId The Id of a Case which you have already posted to the TrustevClient API.
     * @return The Decision with Id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Decision getDecision(String caseId) throws TrustevApiException {
        String url = "/Decision/" + caseId;
        return performHttpCall(url, HttpMethod.GET, Decision.class, null, true);
    }

    /**
     * Get a Decision on a Case with Id caseId.
     *
     * @param caseId   The Id of a Case which you have already posted to the TrustevClient API.
     * @param username The merchant site username that the request is being made by
     * @return The Decision with Id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Decision getDecision(String caseId, String username) throws TrustevApiException {
        String url = "/Decision/" + caseId;
        return performHttpCall(url, HttpMethod.GET, Decision.class, null, true, username);
    }

    /**
     * Gets a Detailed Decision on a Case with Id caseId.
     *
     * @param caseId The Id of a Case which you have already posted to the TrustevClient API.
     * @return The Detailed Decision with Id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static DetailedDecision getDetailedDecision(String caseId) throws TrustevApiException {
        String url = "/DetailedDecision/" + caseId;
        return performHttpCall(url, HttpMethod.GET, DetailedDecision.class, null, true);
    }

    public static Session postSession() throws TrustevApiException {
        String url = "/Session";
        return performHttpCall(url, HttpMethod.POST, Session.class, new Session(), false, null, true);
    }

    public static Session postSession(Session session) throws TrustevApiException {
        String url = "/Session";
        return performHttpCall(url, HttpMethod.POST, Session.class, session, false, null, true);
    }

    /**
     * Use this endpoint and HTTP method to Request OR Regenerate a OTP to a previously created Trustev Case.
     *
     * @param caseId  The Id of a Case which you have already posted to the TrustevClient API.
     * @param request Status request object
     * @return digital auth object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static OTPResult postOtp(String caseId, OTPResult request) throws TrustevApiException {
        String url = "/case/" + caseId + "/authentication/otp";
        return performHttpCall(url, HttpMethod.POST, OTPResult.class, request, true);
    }

    /**
     * Use this endpoint and HTTP method to Request OR Verification a OTP to a previously created Trustev Case.
     *
     * @param caseId  The Id of a Case which you have already posted to the TrustevClient API.
     * @param request Status request object
     * @return digital auth object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static OTPResult putOtp(String caseId, OTPResult request) throws TrustevApiException {
        String url = "/case/" + caseId + "/authentication/otp";
        return performHttpCall(url, HttpMethod.PUT, OTPResult.class, request, true);
    }


    /**
     * Gets a Detailed Decision on a Case with Id caseId.
     *
     * @param caseId   The Id of a Case which you have already posted to the TrustevClient API.
     * @param username The merchant site username that the request is being made by
     * @return The Detailed Decision with Id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static DetailedDecision getDetailedDecision(String caseId, String username) throws TrustevApiException {
        String url = "/DetailedDecision/" + caseId;
        return performHttpCall(url, HttpMethod.GET, DetailedDecision.class, null, true, username);
    }

    /**
     * Post your Customer to an existing Case
     *
     * @param caseId   The Case Id of a Case which you have already posted
     * @param customer Your Customer which you want to post
     * @return The Customer that was posted on this method
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Customer postCustomer(String caseId, Customer customer) throws TrustevApiException {
        String url = "/Case/{id}/Customer".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Customer.class, customer, true);
    }

    /**
     * Post your Customer to an existing Case
     *
     * @param caseId   The Case Id of a Case which you have already posted
     * @param customer Your Customer which you want to post
     * @param username The merchant site username that the request is being made by
     * @return The Customer that was posted on this method
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Customer postCustomer(String caseId, Customer customer, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Customer.class, customer, true, username);
    }

    /**
     * Update the Customer on a Case which already contains a Customer
     *
     * @param caseId   The Case Id of a Case which you have already posted
     * @param customer Your Customer which you want to Put and update the existing Customer with
     * @return The updated Customer object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Customer updateCustomer(String caseId, Customer customer) throws TrustevApiException {
        String url = "/Case/{id}/Customer".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.PUT, Customer.class, customer, true);
    }

    /**
     * Update the Customer on a Case which already contains a Customer
     *
     * @param caseId   The Case Id of a Case which you have already posted
     * @param customer Your Customer which you want to Put and update the existing Customer with
     * @param username The merchant site username that the request is being made by
     * @return The updated Customer object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Customer updateCustomer(String caseId, Customer customer, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.PUT, Customer.class, customer, true, username);
    }

    /**
     * Get the Customer attached to the Case
     *
     * @param caseId The case Id of the the Case with the Customer you want to get
     * @return The Customer with id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Customer getCustomer(String caseId) throws TrustevApiException {
        String url = "/Case/{id}/Customer".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.GET, Customer.class, null, true);
    }

    /**
     * Get the Customer attached to the Case
     *
     * @param caseId   The case Id of the the Case with the Customer you want to get
     * @param username The merchant site username that the request is being made by
     * @return The Customer with id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Customer getCustomer(String caseId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.GET, Customer.class, null, true, username);
    }

    /**
     * Post your Transaction to an existing Case
     *
     * @param caseId      The Case Id of a Case which you have already posted
     * @param transaction Your Transaction which you want to post
     * @return The transaction that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Transaction postTransaction(String caseId, Transaction transaction) throws TrustevApiException {
        String url = "/Case/{id}/Transaction".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Transaction.class, transaction, true);
    }

    /**
     * Post your Transaction to an existing Case
     *
     * @param caseId      The Case Id of a Case which you have already posted
     * @param transaction Your Transaction which you want to post
     * @param username    The merchant site username that the request is being made by
     * @return The transaction that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Transaction postTransaction(String caseId, Transaction transaction, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Transaction.class, transaction, true, username);
    }

    /**
     * Update the Transaction on a Case which already contains a Transaction
     *
     * @param caseId      The Case Id of a Case which you have already posted
     * @param transaction Your Transaction which you want to Put and update the existing Transaction with
     * @return The updated Transaction object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Transaction updateTransaction(String caseId, Transaction transaction) throws TrustevApiException {
        String url = "/Case/{id}/Transaction".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.PUT, Transaction.class, transaction, true);
    }

    /**
     * Update the Transaction on a Case which already contains a Transaction
     *
     * @param caseId      The Case Id of a Case which you have already posted
     * @param transaction Your Transaction which you want to Put and update the existing Transaction with
     * @param username    The merchant site username that the request is being made by
     * @return The updated Transaction object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Transaction updateTransaction(String caseId, Transaction transaction, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.PUT, Transaction.class, transaction, true, username);
    }

    /**
     * Get the Transaction attached to the Case
     *
     * @param caseId The Case Id of the the Case with the Transaction you want to get
     * @return the Transaction with id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Transaction getTransaction(String caseId) throws TrustevApiException {
        String url = "/Case/{id}/Transaction".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.GET, Transaction.class, null, true);
    }

    /**
     * Get the Transaction attached to the Case
     *
     * @param caseId   The Case Id of the the Case with the Transaction you want to get
     * @param username The merchant site username that the request is being made by
     * @return the Transaction with id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Transaction getTransaction(String caseId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.GET, Transaction.class, null, true, username);
    }

    /**
     * Post your CaseStatus to an existing Case
     *
     * @param caseId     The Case Id of a Case which you have already posted
     * @param caseStatus Your CaseStatus which you want to post
     * @return the CaseStatus object that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static CaseStatus postCaseStatus(String caseId, CaseStatus caseStatus) throws TrustevApiException {
        String url = "/Case/{id}/Status".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, CaseStatus.class, caseStatus, true);
    }

    /**
     * Post your CaseStatus to an existing Case
     *
     * @param caseId     The Case Id of a Case which you have already posted
     * @param caseStatus Your CaseStatus which you want to post
     * @param username   The merchant site username that the request is being made by
     * @return the CaseStatus object that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static CaseStatus postCaseStatus(String caseId, CaseStatus caseStatus, String username) throws TrustevApiException {
        String url = "/Case/{id}/Status".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, CaseStatus.class, caseStatus, true, username);
    }

    /**
     * Get a specific status from a Case
     *
     * @param caseId       The Case Id of a Case which you have already posted
     * @param caseStatusId The Id of the CaseStatus you want to get
     * @return the CaseStatus object with id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static CaseStatus getCaseStatus(String caseId, String caseStatusId) throws TrustevApiException {
        String url = "/Case/{id}/Status/{id2}".replace("{id}", caseId).replace("{id2}", caseStatusId);
        return performHttpCall(url, HttpMethod.GET, CaseStatus.class, null, true);
    }

    /**
     * Get a specific status from a Case
     *
     * @param caseId       The Case Id of a Case which you have already posted
     * @param caseStatusId The Id of the CaseStatus you want to get
     * @param username     The merchant site username that the request is being made by
     * @return the CaseStatus object with id equals to caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static CaseStatus getCaseStatus(String caseId, String caseStatusId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Status/{id2}".replace("{id}", caseId).replace("{id2}", caseStatusId);
        return performHttpCall(url, HttpMethod.GET, CaseStatus.class, null, true, username);
    }

    /**
     * Get all the Statuses from a Case
     *
     * @param caseId The Case Id of a Case which you have already posted
     * @return A Collection of CaseStatus objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<CaseStatus> getCaseStatuses(String caseId) throws TrustevApiException {
        String url = "/Case/{id}/Status".replace("{id}", caseId);
        GenericType<Collection<CaseStatus>> type = new GenericType<Collection<CaseStatus>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true);
    }

    /**
     * Get all the Statuses from a Case
     *
     * @param caseId   The Case Id of a Case which you have already posted
     * @param username The merchant site username that the request is being made by
     * @return A Collection of CaseStatus objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<CaseStatus> getCaseStatuses(String caseId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Status".replace("{id}", caseId);
        GenericType<Collection<CaseStatus>> type = new GenericType<Collection<CaseStatus>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true, username);
    }

    /**
     * Post your CustomerAddress to an existing Customer on an existing Case
     *
     * @param caseId          The Case Id of a Case with the Customer  which you have already posted
     * @param customerAddress Your CustomerAddress which you want to post
     * @return The Address object that was just posted in this call
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address postCustomerAddress(String caseId, Address customerAddress) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Address".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Address.class, customerAddress, true);
    }

    /**
     * Post your CustomerAddress to an existing Customer on an existing Case
     *
     * @param caseId          The Case Id of a Case with the Customer  which you have already posted
     * @param customerAddress Your CustomerAddress which you want to post
     * @param username        The merchant site username that the request is being made by
     * @return The Address object that was just posted in this call
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address postCustomerAddress(String caseId, Address customerAddress, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Address".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Address.class, customerAddress, true, username);
    }

    /**
     * Update a specific CustomerAddress on a Case which already contains a CustomerAddress
     *
     * @param caseId            The Case Id of a Case which you have already posted
     * @param customerAddress   The CustomerAddress you want to update the existing CustomerAddress to
     * @param customerAddressId The id of the CustomerAddress you want to update
     * @return The updated Address object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address updateCustomerAddress(String caseId, Address customerAddress, String customerAddressId) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Address/{id2}".replace("{id}", caseId).replace("{id2}", customerAddressId);
        return performHttpCall(url, HttpMethod.PUT, Address.class, customerAddress, true);
    }

    /**
     * Update a specific CustomerAddress on a Case which already contains a CustomerAddress
     *
     * @param caseId            The Case Id of a Case which you have already posted
     * @param customerAddress   The CustomerAddress you want to update the existing CustomerAddress to
     * @param customerAddressId The id of the CustomerAddress you want to update
     * @param username          The merchant site username that the request is being made by
     * @return The updated Address object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address updateCustomerAddress(String caseId, Address customerAddress, String customerAddressId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Address/{id2}".replace("{id}", caseId).replace("{id2}", customerAddressId);
        return performHttpCall(url, HttpMethod.PUT, Address.class, customerAddress, true, username);
    }

    /**
     * Get a specific CustomerAddress from a Case
     *
     * @param caseId            The Case Id of a Case with the Customer which you have already posted
     * @param customerAddressId The Id of the CustomerAddress you want to get
     * @return The Address object that matches caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address getCustomerAddress(String caseId, String customerAddressId) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Address/{id2}".replace("{id}", caseId).replace("{id2}", customerAddressId);
        return performHttpCall(url, HttpMethod.GET, Address.class, null, true);
    }

    /**
     * Get a specific CustomerAddress from a Case
     *
     * @param caseId            The Case Id of a Case with the Customer which you have already posted
     * @param customerAddressId The Id of the CustomerAddress you want to get
     * @param username          The merchant site username that the request is being made by
     * @return The Address object that matches caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address getCustomerAddress(String caseId, String customerAddressId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Address/{id2}".replace("{id}", caseId).replace("{id2}", customerAddressId);
        return performHttpCall(url, HttpMethod.GET, Address.class, null, true, username);
    }

    /**
     * Get all the Addresses from a Customer on a Case
     *
     * @param caseId The Case Id of a Case with the Customer which you have already posted
     * @return A Collection of Address objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<Address> getCustomerAddresses(String caseId) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Address".replace("{id}", caseId);
        GenericType<Collection<Address>> type = new GenericType<Collection<Address>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true);
    }

    /**
     * Get all the Addresses from a Customer on a Case
     *
     * @param caseId   The Case Id of a Case with the Customer which you have already posted
     * @param username The merchant site username that the request is being made by
     * @return A Collection of Address objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<Address> getCustomerAddresses(String caseId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Address".replace("{id}", caseId);
        GenericType<Collection<Address>> type = new GenericType<Collection<Address>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true, username);
    }

    /**
     * Post your Email to an existing Customer on an existing Case
     *
     * @param caseId The Case Id of a Case with the Customer  which you have already posted
     * @param email  Your Email which you want to post
     * @return the Email object that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Email postEmail(String caseId, Email email) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Email".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Email.class, email, true);
    }

    /**
     * Post your Email to an existing Customer on an existing Case
     *
     * @param caseId   The Case Id of a Case with the Customer  which you have already posted
     * @param email    Your Email which you want to post
     * @param username The merchant site username that the request is being made by
     * @return the Email object that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Email postEmail(String caseId, Email email, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Email".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Email.class, email, true, username);
    }

    /**
     * Update a specific Email on a Case which already contains a Email
     *
     * @param caseId  The Case Id of a Case which you have already posted
     * @param email   The Email you want to update the existing Email to
     * @param emailId The id of the Email you want to update
     * @return the updated Email object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Email updateEmail(String caseId, Email email, String emailId) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Email/{id2}".replace("{id}", caseId).replace("{id2}", emailId);
        return performHttpCall(url, HttpMethod.PUT, Email.class, email, true);
    }

    /**
     * Update a specific Email on a Case which already contains a Email
     *
     * @param caseId   The Case Id of a Case which you have already posted
     * @param email    The Email you want to update the existing Email to
     * @param emailId  The id of the Email you want to update
     * @param username The merchant site username that the request is being made by
     * @return the updated Email object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Email updateEmail(String caseId, Email email, String emailId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Email/{id2}".replace("{id}", caseId).replace("{id2}", emailId);
        return performHttpCall(url, HttpMethod.PUT, Email.class, email, true, username);
    }

    /**
     * Get a specific Email from a Case
     *
     * @param caseId  The Case Id of a Case with the Customer which you have already posted
     * @param emailId The Id of the Email you want to get
     * @return the Email object which id matches caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Email getEmail(String caseId, String emailId) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Email/{id2}".replace("{id}", caseId).replace("{id2}", emailId);
        return performHttpCall(url, HttpMethod.GET, Email.class, null, true);
    }

    /**
     * Get a specific Email from a Case
     *
     * @param caseId   The Case Id of a Case with the Customer which you have already posted
     * @param emailId  The Id of the Email you want to get
     * @param username The merchant site username that the request is being made by
     * @return the Email object which id matches caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Email getEmail(String caseId, String emailId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Email/{id2}".replace("{id}", caseId).replace("{id2}", emailId);
        return performHttpCall(url, HttpMethod.GET, Email.class, null, true, username);
    }

    /**
     * Get all the Emails from a Case
     *
     * @param caseId The Case Id of a Case with the Customer  which you have already posted
     * @return A Collection of Email objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<Email> getEmails(String caseId) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Email".replace("{id}", caseId);
        GenericType<Collection<Email>> type = new GenericType<Collection<Email>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true);
    }

    /**
     * Get all the Emails from a Case
     *
     * @param caseId   The Case Id of a Case with the Customer  which you have already posted
     * @param username The merchant site username that the request is being made by
     * @return A Collection of Email objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<Email> getEmails(String caseId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Customer/Email".replace("{id}", caseId);
        GenericType<Collection<Email>> type = new GenericType<Collection<Email>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true, username);
    }

    /**
     * Post your Payment to an existing Case
     *
     * @param caseId  The Case Id of a Case which you have already posted
     * @param payment Your Payment which you want to post
     * @return the Payment object that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Payment postPayment(String caseId, Payment payment) throws TrustevApiException {
        String url = "/Case/{id}/Payment".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Payment.class, payment, true);
    }

    /**
     * Post your Payment to an existing Case
     *
     * @param caseId   The Case Id of a Case which you have already posted
     * @param payment  Your Payment which you want to post
     * @param username The merchant site username that the request is being made by
     * @return the Payment object that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Payment postPayment(String caseId, Payment payment, String username) throws TrustevApiException {
        String url = "/Case/{id}/Payment".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Payment.class, payment, true, username);
    }

    /**
     * Update a specific Payment on a Case which already contains a Payment
     *
     * @param caseId    The Case Id of a Case which you have already posted
     * @param payment   The Payment you want to update the existing Payment to
     * @param paymentId The id of the Payment you want to update
     * @return the updated Payment object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Payment updatePayment(String caseId, Payment payment, String paymentId) throws TrustevApiException {
        String url = "/Case/{id}/Payment/{id2}".replace("{id}", caseId).replace("{id2}", paymentId);
        return performHttpCall(url, HttpMethod.PUT, Payment.class, payment, true);
    }

    /**
     * Update a specific Payment on a Case which already contains a Payment
     *
     * @param caseId    The Case Id of a Case which you have already posted
     * @param payment   The Payment you want to update the existing Payment to
     * @param paymentId The id of the Payment you want to update
     * @param username  The merchant site username that the request is being made by
     * @return the updated Payment object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Payment updatePayment(String caseId, Payment payment, String paymentId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Payment/{id2}".replace("{id}", caseId).replace("{id2}", paymentId);
        return performHttpCall(url, HttpMethod.PUT, Payment.class, payment, true, username);
    }

    /**
     * Get a specific Payment from a Case
     *
     * @param caseId    The Case Id of a Case which you have already posted
     * @param paymentId The Id of the Payment you want to get
     * @return The Payment object that matches paymentId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Payment getPayment(String caseId, String paymentId) throws TrustevApiException {
        String url = "/Case/{id}/Payment/{id2}".replace("{id}", caseId).replace("{id2}", paymentId);
        return performHttpCall(url, HttpMethod.GET, Payment.class, null, true);
    }

    /**
     * Get a specific Payment from a Case
     *
     * @param caseId    The Case Id of a Case which you have already posted
     * @param paymentId The Id of the Payment you want to get
     * @param username  The merchant site username that the request is being made by
     * @return The Payment object that matches paymentId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Payment getPayment(String caseId, String paymentId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Payment/{id2}".replace("{id}", caseId).replace("{id2}", paymentId);
        return performHttpCall(url, HttpMethod.GET, Payment.class, null, true, username);
    }

    /**
     * Get all the Payments from a Case
     *
     * @param caseId The Case Id of a Case which you have already posted
     * @return A collection of Payment objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<Payment> getPayments(String caseId) throws TrustevApiException {
        String url = "/Case/{id}/Payment".replace("{id}", caseId);
        GenericType<Collection<Payment>> type = new GenericType<Collection<Payment>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true);
    }

    /**
     * Get all the Payments from a Case
     *
     * @param caseId   The Case Id of a Case which you have already posted
     * @param username The merchant site username that the request is being made by
     * @return A collection of Payment objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<Payment> getPayments(String caseId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Payment".replace("{id}", caseId);
        GenericType<Collection<Payment>> type = new GenericType<Collection<Payment>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true, username);
    }

    /**
     * Post your TransactionAddress to an existing Transaction on an existing Case
     *
     * @param caseId             The Case Id of a Case with the Transaction which you have already posted
     * @param transactionAddress Your TransactionAddress which you want to post
     * @return the Address object that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address postTransactionAddress(String caseId, Address transactionAddress) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Address".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Address.class, transactionAddress, true);
    }

    /**
     * Post your TransactionAddress to an existing Transaction on an existing Case
     *
     * @param caseId             The Case Id of a Case with the Transaction which you have already posted
     * @param transactionAddress Your TransactionAddress which you want to post
     * @param username           The merchant site username that the request is being made by
     * @return the Address object that was just posted
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address postTransactionAddress(String caseId, Address transactionAddress, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Address".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, Address.class, transactionAddress, true, username);
    }

    /**
     * Update a specific TransactionAddress on a Case which already contains a TransactionAddress
     *
     * @param caseId               The Case Id of a Case which you have already posted
     * @param transactionAddress   The TransactionAddress you want to update the existing TransactionAddress to
     * @param transactionAddressId The id of the TransactionAddress you want to update
     * @return the updated Address object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address updateTransactionAddress(String caseId, Address transactionAddress, String transactionAddressId) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Address/{id2}".replace("{id}", caseId).replace("{id2}", transactionAddressId);

        return performHttpCall(url, HttpMethod.PUT, Address.class, transactionAddress, true);
    }

    /**
     * Update a specific TransactionAddress on a Case which already contains a TransactionAddress
     *
     * @param caseId               The Case Id of a Case which you have already posted
     * @param transactionAddress   The TransactionAddress you want to update the existing TransactionAddress to
     * @param transactionAddressId The id of the TransactionAddress you want to update
     * @param username             The merchant site username that the request is being made by
     * @return the updated Address object
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address updateTransactionAddress(String caseId, Address transactionAddress, String transactionAddressId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Address/{id2}".replace("{id}", caseId).replace("{id2}", transactionAddressId);

        return performHttpCall(url, HttpMethod.PUT, Address.class, transactionAddress, true, username);
    }

    /**
     * Get a specific TransactionAddress from a Case
     *
     * @param caseId               The Case Id of a Case with the Customer which you have already posted
     * @param transactionAddressId The Id of the TransactionAddress you want to get
     * @return The address object that matches transactionAddressId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address getTransactionAddress(String caseId, String transactionAddressId) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Address/{id2}".replace("{id}", caseId).replace("{id2}", transactionAddressId);

        return performHttpCall(url, HttpMethod.GET, Address.class, null, true);
    }

    /**
     * Get a specific TransactionAddress from a Case
     *
     * @param caseId               The Case Id of a Case with the Customer which you have already posted
     * @param transactionAddressId The Id of the TransactionAddress you want to get
     * @param username             The merchant site username that the request is being made by
     * @return The address object that matches transactionAddressId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Address getTransactionAddress(String caseId, String transactionAddressId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Address/{id2}".replace("{id}", caseId).replace("{id2}", transactionAddressId);
        return performHttpCall(url, HttpMethod.GET, Address.class, null, true, username);
    }

    /**
     * Get all the Addresses from a Transaction on a Case
     *
     * @param caseId The Case Id of a Case with the Transaction which you have already posted
     * @return A Collection of Address
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<Address> getTransactionAddresses(String caseId) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Address".replace("{id}", caseId);
        GenericType<Collection<Address>> type = new GenericType<Collection<Address>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true);
    }

    /**
     * Get all the Addresses from a Transaction on a Case
     *
     * @param caseId   The Case Id of a Case with the Transaction which you have already posted
     * @param username The merchant site username that the request is being made by
     * @return A Collection of Address
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<Address> getTransactionAddresses(String caseId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Address".replace("{id}", caseId);
        GenericType<Collection<Address>> type = new GenericType<Collection<Address>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true, username);
    }

    /**
     * Post your TransactionItem to an existing Transaction on an existing Case
     *
     * @param caseId          The Case Id of a Case with the Transaction which you have already posted
     * @param transactionItem Your TransactionItem which you want to post
     * @return The posted TransactionItem
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static TransactionItem postTransactionItem(String caseId, TransactionItem transactionItem) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Item".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, TransactionItem.class, transactionItem, true);
    }

    /**
     * Post your TransactionItem to an existing Transaction on an existing Case
     *
     * @param caseId          The Case Id of a Case with the Transaction which you have already posted
     * @param transactionItem Your TransactionItem which you want to post
     * @param username        The merchant site username that the request is being made by
     * @return The posted TransactionItem
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static TransactionItem postTransactionItem(String caseId, TransactionItem transactionItem, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Item".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, TransactionItem.class, transactionItem, true, username);
    }

    /**
     * Update a specific TransactionItem on a Case which already contains a TransactionItem
     *
     * @param caseId            The Case Id of a Case which you have already posted
     * @param transactionItem   The TransactionAddress you want to update the existing TransactionItem to
     * @param transactionItemId The id of the TransactionItem you want to update
     * @return The updated TransactionItem
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static TransactionItem updateTransactionItem(String caseId, TransactionItem transactionItem, String transactionItemId) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Item/{id2}".replace("{id}", caseId).replace("{id2}", transactionItemId);
        return performHttpCall(url, HttpMethod.PUT, TransactionItem.class, transactionItem, true);
    }

    /**
     * Update a specific TransactionItem on a Case which already contains a TransactionItem
     *
     * @param caseId            The Case Id of a Case which you have already posted
     * @param transactionItem   The TransactionAddress you want to update the existing TransactionItem to
     * @param transactionItemId The id of the TransactionItem you want to update
     * @param username          The merchant site username that the request is being made by
     * @return The updated TransactionItem
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static TransactionItem updateTransactionItem(String caseId, TransactionItem transactionItem, String transactionItemId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Item/{id2}".replace("{id}", caseId).replace("{id2}", transactionItemId);
        return performHttpCall(url, HttpMethod.PUT, TransactionItem.class, transactionItem, true, username);
    }

    /**
     * Get a specific TransactionItem from a Case
     *
     * @param caseId            The Case Id of a Case with the Customer which you have already posted
     * @param transactionItemId The Id of the TransactionItem you want to get
     * @return the TransactionItem that matches transactionItemId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static TransactionItem getTransactionItem(String caseId, String transactionItemId) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Item/{id2}".replace("{id}", caseId).replace("{id2}", transactionItemId);
        return performHttpCall(url, HttpMethod.GET, TransactionItem.class, null, true);
    }

    /**
     * Get a specific TransactionItem from a Case
     *
     * @param caseId            The Case Id of a Case with the Customer which you have already posted
     * @param transactionItemId The Id of the TransactionItem you want to get
     * @param username          The merchant site username that the request is being made by
     * @return the TransactionItem that matches transactionItemId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static TransactionItem getTransactionItem(String caseId, String transactionItemId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Item/{id2}".replace("{id}", caseId).replace("{id2}", transactionItemId);
        return performHttpCall(url, HttpMethod.GET, TransactionItem.class, null, true, username);
    }

    /**
     * Get all the TransactionItems from a Transaction on a Case
     *
     * @param caseId The Case Id of a Case with the Transaction which you have already posted
     * @return A Collection of TransactionItem objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<TransactionItem> getTransactionItems(String caseId) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Item".replace("{id}", caseId);
        GenericType<Collection<TransactionItem>> type = new GenericType<Collection<TransactionItem>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true);
    }

    /**
     * Get all the TransactionItems from a Transaction on a Case
     *
     * @param caseId   The Case Id of a Case with the Transaction which you have already posted
     * @param username The merchant site username that the request is being made by
     * @return A Collection of TransactionItem objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static Collection<TransactionItem> getTransactionItems(String caseId, String username) throws TrustevApiException {
        String url = "/Case/{id}/Transaction/Item".replace("{id}", caseId);
        GenericType<Collection<TransactionItem>> type = new GenericType<Collection<TransactionItem>>() {
        };
        return performHttpCall(url, HttpMethod.GET, type, null, true, username);
    }

    /**
     * Get all the TransactionItems from a Transaction on a Case
     *
     * @param caseId The Case Id of a Case with the Transaction which you have already posted
     * @return A Collection of TransactionItem objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static KBAResult postKBA(String caseId, KBAResult request) throws TrustevApiException {
        String url = "Case/{id}/authentication/kba".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, KBAResult.class, request, true);
    }

    /**
     * Get all the TransactionItems from a Transaction on a Case
     *
     * @param caseId   The Case Id of a Case with the Transaction which you have already posted
     * @param username The merchant site username that the request is being made by
     * @return A Collection of TransactionItem objects that match caseId
     * @throws TrustevApiException A Custom Trustev Api Exception
     */
    public static KBAResult postKBA(String caseId, KBAResult request, String username) throws TrustevApiException {
        String url = "Case/{id}/authentication/kba".replace("{id}", caseId);
        return performHttpCall(url, HttpMethod.POST, KBAResult.class, request, true, username);
    }

    /**
     * This method performs the Http Request to the TrustevClient API
     *
     * @param uriPath                The HttpMethod Uri
     * @param httpMethod             The Http Method
     * @param responseType           The type of the response object
     * @param entity                 The relevant entity
     * @param isAuthenticationNeeded Does this API call require the X-Authorization header
     */
    private static <T> T performHttpCall(String uriPath, String httpMethod, Class<T> responseType, Object entity, Boolean isAuthenticationNeeded) throws TrustevApiException {
        return performHttpCall(uriPath, httpMethod, responseType, entity, isAuthenticationNeeded, null, false);
    }

    /**
     * This method performs the Http Request to the TrustevClient API
     *
     * @param uriPath                The HttpMethod Uri
     * @param httpMethod             The Http Method
     * @param responseType           The type of the response object
     * @param entity                 The relevant entity
     * @param isAuthenticationNeeded Does this API call require the X-Authorization header
     */
    private static <T> T performHttpCall(String uriPath, String httpMethod, GenericType<T> responseType, Object entity, Boolean isAuthenticationNeeded) throws TrustevApiException {
        return performHttpCallImpl(uriPath, httpMethod, responseType, entity, isAuthenticationNeeded, null, false);
    }

    /**
     * This method performs the Http Request to the TrustevClient API
     *
     * @param uriPath                The HttpMethod Uri
     * @param httpMethod             The Http Method
     * @param responseType           The type of the response object
     * @param entity                 The relevant entity
     * @param isAuthenticationNeeded Does this API call require the X-Authorization header
     * @param userName               The username of the credentials to include in the request.
     */
    private static <T> T performHttpCall(String uriPath, String httpMethod, Class<T> responseType, Object entity, Boolean isAuthenticationNeeded, String userName)
        throws TrustevApiException {
        return performHttpCall(uriPath, httpMethod, responseType, entity, isAuthenticationNeeded, userName, false);
    }

    /**
     * This method performs the Http Request to the TrustevClient API
     *
     * @param uriPath                The HttpMethod Uri
     * @param httpMethod             The Http Method
     * @param responseType           The type of the response object
     * @param entity                 The relevant entity
     * @param isAuthenticationNeeded Does this API call require the X-Authorization header
     * @param userName               The username of the credentials to include in the request.
     */
    private static <T> T performHttpCall(String uriPath, String httpMethod, GenericType<T> responseType, Object entity, Boolean isAuthenticationNeeded, String userName)
        throws TrustevApiException {
        return performHttpCallImpl(uriPath, httpMethod, responseType, entity, isAuthenticationNeeded, userName, false);
    }

    /**
     * This method performs the Http Request to the TrustevClient API
     *
     * @param uriPath                The HttpMethod Uri
     * @param httpMethod             The Http Method
     * @param responseType           The type of the response object
     * @param entity                 The relevant entity
     * @param isAuthenticationNeeded Does this API call require the X-Authorization header
     * @param userName               The username of the credentials to include in the request.
     * @param includePublicKey       Does this API call require the X-PublicKey header
     */
    private static <T> T performHttpCall(String uriPath, String httpMethod, Class<T> responseType, Object entity, Boolean isAuthenticationNeeded, String userName, boolean includePublicKey)
        throws TrustevApiException {
        GenericType<T> genericType = new GenericType<>(responseType);
        return performHttpCallImpl(uriPath, httpMethod, genericType, entity, isAuthenticationNeeded, userName, includePublicKey);
    }

    /**
     * This method performs the Http Request to the TrustevClient API
     *
     * @param uriPath                The HttpMethod Uri
     * @param httpMethod             The Http Method
     * @param responseType           The type of the response object
     * @param entity                 The relevant entity
     * @param isAuthenticationNeeded Does this API call require the X-Authorization header
     * @param userName               The username of the credentials to include in the request.
     * @param includePublicKey       Does this API call require the X-PublicKey header
     */
    private static <T> T performHttpCallImpl(String uriPath, String httpMethod, GenericType<T> responseType, Object entity, boolean isAuthenticationNeeded, String userName, boolean includePublicKey)
        throws TrustevApiException {
        T responseObject;
        Client client = ClientBuilder.newClient();
        client.register(JacksonJsonProvider.class);
        MerchantSite merchantSite = getMerchantSiteForRequest(userName);
        WebTarget resource = client.target(merchantSite.getBaseUrl()).path(uriPath);
        logger.info("Generating request URL: " + resource.getUri() + " Http Method: " + httpMethod + " UserName: " + merchantSite.getUserName());
        Invocation.Builder resourceBuilder = resource.request();

        if (isAuthenticationNeeded) {
            logger.debug("Including X-Authorization Header for user: " + merchantSite.getUserName());
            resourceBuilder = resourceBuilder.header("X-Authorization", String.format("%1$s %2$s", merchantSite.getUserName(), getApiToken(merchantSite)));
        }

        if (includePublicKey) {
            if (merchantSite.getPublicKey() == null) {
                throw new MerchantSiteNotSetupException("A MerchantSite was not setup with a public key for the given username. Be sure that ApiClient.setUp passing the public key was called for " + merchantSite.getUserName());
            }
            logger.debug("Including X-PublicKey Header for user: " + merchantSite.getUserName());
            resourceBuilder = resourceBuilder.header("X-PublicKey", merchantSite.getPublicKey());
        }

        resourceBuilder = resourceBuilder.accept(MediaType.APPLICATION_JSON);
        Response response;

        logger.info("Submitting request URL: " + resource.getUri() + " Http Method: " + httpMethod + " UserName: " + merchantSite.getUserName());
        response = resourceBuilder.method(httpMethod, Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

        logger.info("Response URL: " + resource.getUri() + " Http Method: " + httpMethod + " UserName: " + merchantSite.getUserName() + "Status: " + response.getStatus());
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            responseObject = response.readEntity(responseType);
        } else {
            ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
            throw new TrustevApiException(response.getStatus(), errorResponse.getMessage());
        }
        return responseObject;
    }

    private static MerchantSite getMerchantSiteForRequest(String userName) throws MultipleMerchantSitesException, MerchantSiteNotSetupException {
        MerchantSite merchantSite;
        if (!merchantSites.isEmpty()) {
            if (userName == null) {
                if (hasMultipleMerchantSites()) {
                    throw new MultipleMerchantSitesException();
                }
                merchantSite = merchantSites.entrySet().iterator().next().getValue();
                if (merchantSite.getUserName() == null || merchantSite.getUserName().equals("")) {
                    throw new MerchantSiteNotSetupException();
                }
            } else {
                if (hasMerchantSite(userName)) {
                    merchantSite = merchantSites.get(userName);
                } else {
                    throw new MerchantSiteNotSetupException("A MerchantSite for the given username was not setup correctly. Be sure that ApiClient.setUp was called for " + userName);
                }
            }
        } else {
            throw new MerchantSiteNotSetupException();
        }
        return merchantSite;
    }

    private static String getApiToken(MerchantSite merchantSite) throws TrustevApiException {
        if (merchantSite.getApiToken() == null || merchantSite.getExpiryDate() == null || merchantSite.getExpiryDate().before(new Date())) {
            setToken(merchantSite);
        }
        return merchantSite.getApiToken();
    }

    private static void setToken(MerchantSite merchantSite) throws TrustevApiException {
        String url = "/Token";
        TokenResponse response = performHttpCall(url, HttpMethod.POST, TokenResponse.class, createToken(merchantSite), false, merchantSite.getUserName());
        merchantSite.setApiToken(response.getApiToken());
        merchantSite.setExpiryDate(response.getExpireAt());
    }

    private static TokenRequest createToken(MerchantSite merchantSite) {
        TokenRequest request = new TokenRequest();
        request.setTimestamp(new Date());
        request.setUserName(merchantSite.getUserName());
        request.setPasswordHash(createHash(merchantSite.getPassword(), request.getTimestamp(), merchantSite.getSecret()));
        request.setUserNameHash(createHash(merchantSite.getUserName(), request.getTimestamp(), merchantSite.getSecret()));
        return request;
    }

    private static String createHash(String value, Date timestamp, String sharedsecret) {
        String hashValue = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String part1prehash = String.format("%1$s.%2$s", DateUtils.formatTimeStamp(timestamp), value);
            md.update(part1prehash.getBytes());
            String part1hash = bytesToHex(md.digest());
            String part2prehash = String.format("%1$s.%2$s", part1hash, sharedsecret);
            //String hashValue = new String(Hex.encode(md.digest(part2prehash.getBytes("UTF-8"))));
            md.update(part2prehash.getBytes());
            hashValue = bytesToHex(md.digest());
            return hashValue;
        } catch (NoSuchAlgorithmException e) {
            logger.error("Could not find SHA-256 algorithm.", e);
        }
        return hashValue;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) {
            result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }
}
