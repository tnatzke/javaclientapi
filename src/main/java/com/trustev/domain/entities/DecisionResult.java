package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.util.EnumUtils;

public enum DecisionResult implements BaseEnum<DecisionResult> {
    Unknown(0),
    Pass(1),
    Flag(2),
    Fail(3);

    private final int id;

    DecisionResult(final int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static DecisionResult convertFromString(String id) {
        return EnumUtils.convertFromString(id, DecisionResult.class);
    }
}
