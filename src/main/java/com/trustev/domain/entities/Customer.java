package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trustev.util.DateTimeDeserializer;
import com.trustev.util.DateUtils;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Function;


/**
 * The Customer object includes the information on a Customer such as Address, Names, Email, and Phone Number information.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer extends IdBase<Customer> {

    private String firstName;
    private String lastName;
    private Collection<Email> email;
    private String phoneNumber;
    private Date dateOfBirth;
    private Collection<Address> addresses;
    private String accountNumber;
    private String socialSecurityNumber;

    /**
     * @return The First Name of the Customer.
     */
    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName The First Name of the Customer.
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The Last Name of the Customer.
     */
    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName The Last Name of the Customer.
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return A collection of Emails. Please see Emails object for further parameter information.
     */
    @JsonProperty("Emails")
    public Collection<Email> getEmail() {
        return email;
    }

    /**
     * @param email A collection of Emails. Please see Emails object for further parameter information.
     */

    public void setEmail(Collection<Email> email) {
        this.email = email;
    }

    /**
     * @return The Phone Number for the Customer.
     */
    @JsonProperty("PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber The Phone Number for the Customer.
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return The Date of Birth of the Customer.
     */
    @JsonProperty("DateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DEFAULT_DATE_FORMAT, timezone = DateUtils.DEFAULT_TIME_ZONE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth The Date of Birth of the Customer.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
     * @return The Account number of the Customer.
     */
    @JsonProperty("AccountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber The Account number of the Customer.
     */

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return The Account number of the Customer.
     */
    @JsonProperty("SocialSecurityNumber")
    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    /**
     * @param socialSecurityNumber The Social Security Number of the customer
     */

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Customer, Comparable>> props) {
        props.add(Customer::getFirstName);
        props.add(Customer::getLastName);
        props.add(Customer::getPhoneNumber);
        props.add(Customer::getDateOfBirth);
        props.add(Customer::getAccountNumber);
        props.add(Customer::getSocialSecurityNumber);
        super.buildSignificationProperties(props);
    }
}
