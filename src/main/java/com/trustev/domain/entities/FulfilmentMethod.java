package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.util.EnumUtils;

public enum FulfilmentMethod implements BaseEnum<FulfilmentMethod> {
    /// <summary>
    /// Undefined
    /// </summary>
    Undefined(0),
    /// <summary>
    /// Virtual
    /// </summary>
    Virtual(1),
    /// <summary>
    /// In Person
    /// </summary>
    InPerson(2),
    /// <summary>
    /// Post
    /// </summary>
    Post(3),
    /// <summary>
    /// Courier
    /// </summary>
    Courier(4);

    private final int id;

    FulfilmentMethod(final int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static FulfilmentMethod convertFromString(String id) {
        return EnumUtils.convertFromString(id, FulfilmentMethod.class);
    }
}
