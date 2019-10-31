package com.trustev.domain.entities;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawDataCustomer extends Base<RawDataCustomer> {
    private String firstName;
    private String lastName;
    private Collection<RawDataEmail> emails;
    private String socialSecurityNumber;
    private String phoneNumber;

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("Emails")
    public Collection<RawDataEmail> getEmails() {
        return emails;
    }

    public void setEmails(Collection<RawDataEmail> emails) {
        this.emails = emails;
    }

    @JsonProperty("SocialSecurityNumber")
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @JsonProperty("PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected void buildSignificationProperties(List<Function<RawDataCustomer, Comparable>> props) {
        props.add(RawDataCustomer::getFirstName);
        props.add(RawDataCustomer::getLastName);
        props.add(RawDataCustomer::getSocialSecurityNumber);
        props.add(RawDataCustomer::getPhoneNumber);
        super.buildSignificationProperties(props);
    }
}