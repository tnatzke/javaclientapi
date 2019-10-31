package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.util.EnumUtils;

public enum TimeToFulfilment implements BaseEnum<TimeToFulfilment> {
    /// <summary>
    /// Undefined
    /// </summary>
    Undefined(0),
    /// <summary>
    /// Immediate
    /// </summary>
    Immediate(1),
    /// <summary>
    /// Same Day
    /// </summary>
    SameDay(2),
    /// <summary>
    ///  Next Day
    /// </summary>
    NextDay(3),
    /// <summary>
    /// Up To 3 Days,
    /// </summary>
    UpTo3Days(4),
    /// <summary>
    /// Up To 5 Days
    /// </summary>
    UpTo5Days(5);

    private final int id;

    TimeToFulfilment(final int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static TimeToFulfilment convertFromString(String id) {
        return EnumUtils.convertFromString(id, TimeToFulfilment.class);
    }
}
