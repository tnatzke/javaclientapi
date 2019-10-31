package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.util.EnumUtils;

public enum CaseStatusType implements BaseEnum<CaseStatusType> {
    Completed(0),
    RejectedFraud(1),
    RejectedAuthFailure(2),
    RejectedSuspicious(3),
    Cancelled(4),
    ChargebackFraud(5),
    ChargebackOther(6),
    Refunded(7),
    Placed(8),
    OnHoldReview(9),
    ReportedFraud(12);

    private int id;

    CaseStatusType(int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return id;
    }

    @JsonCreator
    public static CaseStatusType convertFromString(String id) {
        return EnumUtils.convertFromString(id, CaseStatusType.class);
    }
}
