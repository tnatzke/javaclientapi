package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.function.Function;

/**
 * The CaseStatus is used to let Trustev know the current status of any Case. When the status of a Case changes, please update the status of the Case.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaseStatus extends TimestampBase<CaseStatus> {

    private CaseStatusType status;
    private String comment;

    /**
     * @return The Status Type of the Trustev Case
     */
    @JsonProperty("Status")
    public CaseStatusType getStatus() {
        return status;
    }

    /**
     * @param status The Status Type of the Trustev Case
     */
    public void setStatus(CaseStatusType status) {
        this.status = status;
    }

    /**
     * @return Comment on the Status
     */
    @JsonProperty("Comment")
    public String getComment() {
        return comment;
    }

    /**
     * @param comment Comment on the Status
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    protected void buildSignificationProperties(List<Function<CaseStatus, Comparable>> props) {
        props.add(CaseStatus::getStatus);
        props.add(CaseStatus::getComment);
        super.buildSignificationProperties(props);
    }
}
