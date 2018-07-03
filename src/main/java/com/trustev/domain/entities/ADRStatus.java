package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonValue;

public enum ADRStatus
{
    Started (0),
    Success(1),
    NoDetailsAvailable (2),
    InvalidCase (3),
    Ineligible (4),
    Error (5),
    Misconfigured (6),
    NoConsent (7);

    private final int status;

    ADRStatus(final int status) {
        this.status = status;
    }

    @JsonValue
    public int toInt()
    {
        return this.status;
    }
}
