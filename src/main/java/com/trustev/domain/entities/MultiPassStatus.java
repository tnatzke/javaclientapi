package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonValue;

public enum MultiPassStatus
{
    NotEnabled  (-1),
    NotUsed  (0),
    Used  (1),
    Using  (2);

    private final int status;

    MultiPassStatus(final int status) {
        this.status = status;
    }

    @JsonValue
    public int toInt()
    {
        return this.status;
    }
}
