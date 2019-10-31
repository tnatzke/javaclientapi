package com.trustev.domain.entities;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawDataTransaction extends Base<RawDataTransaction> {

    private Collection<RawDataEmail> emails;

    @JsonProperty("Emails")
    public Collection<RawDataEmail> getEmails() {
        return emails;
    }

    public void setEmails(Collection<RawDataEmail> emails) {
        this.emails = emails;
    }
}