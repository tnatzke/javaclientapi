package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

/**
 * Represents an Address for either a Customer or Transaction
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends TimestampBase<Address> {

    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private String postalCode;
    private AddressType type;
    private String countryCode;
    private boolean isDefault;

    /**
     * @return The First Name for the Standard/Billing/Delivery Address.
     */
    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName The First Name for the Standard/Billing/Delivery Address.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The Last Name for the Standard/Billing/Delivery Address.
     */
    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName The Last Name for the Standard/Billing/Delivery Address.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Address Line 1 for the Standard/Billing/Delivery Address.
     */
    @JsonProperty("Address1")
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 Address Line 1 for the Standard/Billing/Delivery Address.
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return Address Line 2 for the Standard/Billing/Delivery Address.
     */
    @JsonProperty("Address2")
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 Address Line 2 for the Standard/Billing/Delivery Address.
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return Address Line 3 for the Standard/Billing/Delivery Address.
     */
    @JsonProperty("Address3")
    public String getAddress3() {
        return address3;
    }

    /**
     * @param address3 Address Line 3 for the Standard/Billing/Delivery Address.
     */
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    /**
     * @return City for the Standard/Billing/Delivery Address.
     */
    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    /**
     * @param city City for the Standard/Billing/Delivery Address.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return State for the Standard/Billing/Delivery Address.
     */
    @JsonProperty("State")
    public String getState() {
        return state;
    }

    /**
     * @param state State for the Standard/Billing/Delivery Address.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return The Postal Code for the Standard/Billing/Delivery Address.
     */
    @JsonProperty("PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode The Postal Code for the Standard/Billing/Delivery Address.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return The Address Type - Standard (0), Billing (1), or Delivery (2)
     */
    @JsonProperty("Type")
    public AddressType getType() {
        return type;
    }

    /**
     * @param type The Address Type - Standard (0), Billing (1), or Delivery (2)
     */
    public void setType(AddressType type) {
        this.type = type;
    }

    /**
     * @return These are the 2 letter country codes published by ISO. Details can be found at http://www.nationsonline.org/oneworld/countrycodes.htm
     */
    @JsonProperty("CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode These are the 2 letter country codes published by ISO. Details can be found at http://www.nationsonline.org/oneworld/countrycodes.htm
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return Is this the default address?
     */
    @JsonProperty("IsDefault")
    public boolean getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault Is this the default address?
     */
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Address, Comparable>> props) {
        props.add(Address::getFirstName);
        props.add(Address::getLastName);
        props.add(Address::getAddress1);
        props.add(Address::getAddress2);
        props.add(Address::getAddress3);
        props.add(Address::getCity);
        props.add(Address::getState);
        props.add(Address::getPostalCode);
        props.add(Address::getType);
        props.add(Address::getCountryCode);
        props.add(Address::getIsDefault);
        super.buildSignificationProperties(props);
    }
}
