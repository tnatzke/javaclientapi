package com.trustev.domain.entities.kba;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trustev.domain.entities.BaseEnum;
import com.trustev.util.EnumUtils;

public enum KBAStatus implements BaseEnum<KBAStatus> {
    NotConfigured(-1),
    Offered(0),
    MultiPassOffered(1),
    Ineligible(2),
    NoData(3),
    Passed(4),
    Failed(5),
    Abandoned(6);

    private int id;

    KBAStatus(int id) {
        this.id = id;
    }

    @JsonValue
    public int getId() {
        return this.id;
    }

    @JsonCreator
    public static KBAStatus convertFromString(String id) {
        return EnumUtils.convertFromString(id, KBAStatus.class);
    }
}
