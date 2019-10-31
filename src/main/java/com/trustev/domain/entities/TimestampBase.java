package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trustev.util.DateTimeDeserializer;
import com.trustev.util.DateUtils;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

public abstract class TimestampBase<T extends TimestampBase> extends IdBase<T> {

    private Date timestamp;

    @JsonProperty("Timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DEFAULT_DATE_FORMAT, timezone = DateUtils.DEFAULT_TIME_ZONE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final Date value) {
        this.timestamp = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<T, Comparable>> props) {
        props.add(T::getTimestamp);
        super.buildSignificationProperties(props);
    }
}
