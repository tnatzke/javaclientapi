package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.util.EnumUtils;

public enum CaseType implements BaseEnum<CaseType> {
    Default(0),
    AccountCreation(2),
    Application(3);

    private int id;

    CaseType(int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static CaseType convertFromString(String id) {
        return EnumUtils.convertFromString(id, CaseType.class);
    }
}
