package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.util.EnumUtils;

public enum FulfilmentGeoLocation implements BaseEnum<FulfilmentGeoLocation> {
    /// <summary>
    /// Undefined
    /// </summary>
    Undefined(0),
    /// <summary>
    /// National Location
    /// </summary>
    National(1),
    /// <summary>
    /// International Location
    /// </summary>
    International(2);

    private final int id;

    private FulfilmentGeoLocation(final int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static FulfilmentGeoLocation convertFromString(String id) {
        return EnumUtils.convertFromString(id, FulfilmentGeoLocation.class);
    }
}
