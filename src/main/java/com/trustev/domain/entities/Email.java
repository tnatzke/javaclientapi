package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

/**
 * The Email object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email extends IdBase<Email> {

    private String emailAddress;
    private boolean isDefault;

    /**
     * @return Email Address of the Customer
     */
    @JsonProperty("EmailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress Email Address of the Customer
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return Is this is the default Email for the Customer?
     */
    @JsonProperty("IsDefault")
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * @param isDefault Is this is the default Email for the Customer?
     */
    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Email, Comparable>> props) {
        props.add(Email::getEmailAddress);
        props.add(Email::isDefault);
        super.buildSignificationProperties(props);
    }
}
