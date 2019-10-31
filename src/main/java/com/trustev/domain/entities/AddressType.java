package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.util.EnumUtils;

public enum AddressType implements BaseEnum<AddressType> {
    Standard(0),
    Billing(1),
    Delivery(2);

    private int id;

    AddressType(int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static AddressType convertFromString(String id) {
        return EnumUtils.convertFromString(id, AddressType.class);
    }
}
