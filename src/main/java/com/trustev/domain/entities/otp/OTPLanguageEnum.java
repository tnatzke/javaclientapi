package com.trustev.domain.entities.otp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.domain.entities.BaseEnum;
import com.trustev.util.EnumUtils;

public enum OTPLanguageEnum implements BaseEnum<OTPLanguageEnum> {
    /// <summary>
    /// English
    /// </summary>
    EN(0),

    /// <summary>
    /// Spanish
    /// </summary>
    ES(1);
    private final int id;

    OTPLanguageEnum(final int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static OTPLanguageEnum convertFromString(String id) {
        return EnumUtils.convertFromString(id, OTPLanguageEnum.class);
    }
}
