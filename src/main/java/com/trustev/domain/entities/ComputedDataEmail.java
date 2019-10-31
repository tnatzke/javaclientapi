package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedDataEmail extends Base<ComputedDataEmail> {

    private boolean isDisposable;
    private boolean isDomainNotAllowed;
    private boolean isUserNameNotAllowed;
    private boolean containsDomainIssue;
    private boolean containsMailboxIssue;
    private boolean containsSyntaxIssue;

    @JsonProperty("IsDisposable")
    public boolean isDisposable() {
        return isDisposable;
    }

    public void setDisposable(boolean isDisposable) {
        this.isDisposable = isDisposable;
    }

    @JsonProperty("IsDomainNotAllowed")
    public boolean isDomainNotAllowed() {
        return isDomainNotAllowed;
    }

    public void setDomainNotAllowed(boolean isDomainNotAllowed) {
        this.isDomainNotAllowed = isDomainNotAllowed;
    }

    @JsonProperty("IsUserNameNotAllowed")
    public boolean isUserNameNotAllowed() {
        return isUserNameNotAllowed;
    }

    public void setUserNameNotAllowed(boolean isUserNameNotAllowed) {
        this.isUserNameNotAllowed = isUserNameNotAllowed;
    }

    @JsonProperty("ContainsDomainIssue")
    public boolean isContainsDomainIssue() {
        return containsDomainIssue;
    }

    public void setContainsDomainIssue(boolean containsDomainIssue) {
        this.containsDomainIssue = containsDomainIssue;
    }

    @JsonProperty("ContainsMailboxIssue")
    public boolean isContainsMailboxIssue() {
        return containsMailboxIssue;
    }

    public void setContainsMailboxIssue(boolean containsMailboxIssue) {
        this.containsMailboxIssue = containsMailboxIssue;
    }

    @JsonProperty("ContainsSyntaxIssue")
    public boolean isContainsSyntaxIssue() {
        return containsSyntaxIssue;
    }

    public void setContainsSyntaxIssue(boolean containsSyntaxIssue) {
        this.containsSyntaxIssue = containsSyntaxIssue;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedDataEmail, Comparable>> props) {
        props.add(ComputedDataEmail::isDisposable);
        props.add(ComputedDataEmail::isDomainNotAllowed);
        props.add(ComputedDataEmail::isUserNameNotAllowed);
        props.add(ComputedDataEmail::isContainsDomainIssue);
        props.add(ComputedDataEmail::isContainsMailboxIssue);
        props.add(ComputedDataEmail::isContainsSyntaxIssue);
        super.buildSignificationProperties(props);
    }
}