package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.util.EnumUtils;

public enum SessionType implements BaseEnum<SessionType> {

    JavaScript(0),
    Mobile(1),
    Broker(2);

    private int id;

    SessionType(int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return id;
    }

    @JsonCreator
    public static SessionType convertFromString(String id) {
        return EnumUtils.convertFromString(id, SessionType.class);
    }
}
