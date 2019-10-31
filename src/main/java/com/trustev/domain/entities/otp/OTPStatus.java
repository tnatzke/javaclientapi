package com.trustev.domain.entities.otp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.domain.entities.BaseEnum;
import com.trustev.util.EnumUtils;

public enum OTPStatus implements BaseEnum<OTPStatus> {
    /// <summary>
    /// Case is Eligible and OTP Offered
    /// </summary>
    Offered(0),

    /// <summary>
    /// OTP Offered And Passed
    /// </summary>
    Pass(1),

    /// <summary>
    /// OTP Offered And Failed
    /// </summary>
    Fail(2),

    /// <summary>
    /// Case is Ineligible and OTP was not Offered
    /// </summary>
    Ineligible(3),

    /// <summary>
    /// OTP Offered and code sent
    /// </summary>
    InProgress(4),

    /// <summary>
    /// Hit max retries
    /// </summary>
    MaxRetryHit(5),

    /// <summary>
    /// Final state of Abandoned
    /// </summary>
    Abandoned(6),

    /// <summary>
    /// OTP is not Configured
    /// </summary>
    NotConfigured(7);

    private final int id;

    OTPStatus(final int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static OTPStatus convertFromString(String id) {
        return EnumUtils.convertFromString(id, OTPStatus.class);
    }
}
