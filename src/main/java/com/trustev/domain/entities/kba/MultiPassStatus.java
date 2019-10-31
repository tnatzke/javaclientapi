package com.trustev.domain.entities.kba;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.domain.entities.BaseEnum;
import com.trustev.util.EnumUtils;

public enum MultiPassStatus implements BaseEnum<MultiPassStatus> {
    NotEnabled(-1),
    NotUsed(0),
    Used(1),
    Using(2);

    private int id;

    MultiPassStatus(int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static MultiPassStatus convertFromString(String id) {
        return EnumUtils.convertFromString(id, MultiPassStatus.class);
    }
}
