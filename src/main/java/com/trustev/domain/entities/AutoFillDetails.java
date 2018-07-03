package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutoFillDetails
{
    @JsonProperty("Details")
    private PersonalDetails details;

    @JsonProperty("Status")
    private ADRStatus status;

    @JsonProperty("StatusDescription")
    private String statusDescription;

    public PersonalDetails getDetails() {
        return details;
    }

    public void setDetails(PersonalDetails details) {
        this.details = details;
    }

    public ADRStatus getStatus() {
        return status;
    }

    public void setStatus(ADRStatus status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
