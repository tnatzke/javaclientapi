package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonValue;

public enum SessionType {
    JavaScript(0),
    Mobile(1),
    Broker(2);

    private final int status;

    SessionType(final int status) {
        this.status = status;
    }

    @JsonValue
    public int toInt()
    {
        return this.status;
    }
    }
