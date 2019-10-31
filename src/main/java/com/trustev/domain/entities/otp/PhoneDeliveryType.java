package com.trustev.domain.entities.otp;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.domain.entities.BaseEnum;
import com.trustev.util.EnumUtils;

public enum PhoneDeliveryType implements BaseEnum<PhoneDeliveryType> {
    Sms(0),
    Voice(1);

    private final int id;

    PhoneDeliveryType(final int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static PhoneDeliveryType convertFromString(String id) {
        return EnumUtils.convertFromString(id, PhoneDeliveryType.class);
    }
}
