package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trustev.util.DateTimeDeserializer;
import com.trustev.util.DateUtils;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class TokenResponse extends Base<TokenResponse> {

    private String apiToken;
    private Date expireAt;
    private String credentialType;

    @JsonProperty("APIToken")
    public String getApiToken() {
        return this.apiToken;
    }

    public void setApiToken(final String apiToken) {
        this.apiToken = apiToken;
    }

    @JsonProperty("ExpireAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DEFAULT_DATE_FORMAT, timezone = DateUtils.DEFAULT_TIME_ZONE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(final Date value) {
        this.expireAt = value;
    }

    @JsonProperty("CredentialType")
    public String getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType;
    }

    @Override
    protected void buildSignificationProperties(List<Function<TokenResponse, Comparable>> props) {
        props.add(TokenResponse::getApiToken);
        props.add(TokenResponse::getExpireAt);
        props.add(TokenResponse::getCredentialType);
        super.buildSignificationProperties(props);
    }
}
