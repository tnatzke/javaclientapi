package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.util.EnumUtils;

public enum MarketType implements BaseEnum<MarketType> {

    Default(0),
    UnsecuredPersonalLoans(1),
    CreditCards(2),
    MultiFamilyRentalScreening(3),
    AutoLending(4),
    ShortTermAlternativeLending(5),
    TelecomAndCommunications(6),
    Insurance(7),
    Mortgage(8);

    private int id;

    MarketType(int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static MarketType convertFromString(String id) {
        return EnumUtils.convertFromString(id, MarketType.class);
    }
}
