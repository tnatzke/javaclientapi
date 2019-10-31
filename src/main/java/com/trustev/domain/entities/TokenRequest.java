package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trustev.util.DateTimeDeserializer;
import com.trustev.util.DateUtils;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class TokenRequest extends Base<TokenRequest> {
    private static String userName;
    private static String passwordHash;
    private static String userNameHash;
    private static Date timestamp;

    @JsonProperty("userName")
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(final String value) {
        this.userName = value;
    }

    @JsonProperty("passwordHash")
    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(final String value) {
        this.passwordHash = value;
    }

    @JsonProperty("userNameHash")
    public String getUserNameHash() {
        return this.userNameHash;
    }

    public void setUserNameHash(final String value) {
        this.userNameHash = value;
    }

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DEFAULT_DATE_FORMAT, timezone = DateUtils.DEFAULT_TIME_ZONE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final Date value) {
        this.timestamp = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<TokenRequest, Comparable>> props) {
        props.add(TokenRequest::getUserName);
        props.add(TokenRequest::getPasswordHash);
        props.add(TokenRequest::getUserNameHash);
        props.add(TokenRequest::getTimestamp);
        super.buildSignificationProperties(props);
    }
}
