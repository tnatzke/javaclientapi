package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.trustev.util.DateTimeDeserializer;
import com.trustev.util.DateUtils;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantSite extends IdBase<MerchantSite> {

    private String userName;
    private String password;
    private String secret;
    private String publicKey;
    private String baseUrl;
    private String apiToken;
    private Date expiryDate;

    public MerchantSite() {
    }

    public MerchantSite(String userName, String password, String secret, String baseUrl) {
        this(userName, password, secret, null, baseUrl);
    }

    public MerchantSite(String userName, String password, String secret, String publicKey, String baseUrl) {
        this.userName = userName;
        this.password = password;
        this.secret = secret;
        this.publicKey = publicKey;
        this.baseUrl = baseUrl;
    }

    /**
     * @return The Merchante Site's Username
     */
    @JsonProperty("Username")
    public String getUserName() {
        return userName;
    }

    /**
     * @param value
     */
    public void setUserName(final String value) {
        this.userName = value;
    }

    @JsonProperty("Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(final String value) {
        this.password = value;
    }

    @JsonProperty("Secret")
    public String getSecret() {
        return secret;
    }

    public void setSecret(final String value) {
        this.secret = value;
    }

    @JsonProperty("PublicKey")
    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(final String value) {
        this.publicKey = value;
    }

    @JsonProperty("BaseUrl")
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(final String value) {
        this.baseUrl = value;
    }

    @JsonProperty("ApiToken")
    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(final String value) {
        this.apiToken = value;
    }

    @JsonProperty("ExpiryDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DEFAULT_DATE_FORMAT, timezone = DateUtils.DEFAULT_TIME_ZONE)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(final Date value) {
        this.expiryDate = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<MerchantSite, Comparable>> props) {
        props.add(MerchantSite::getUserName);
        props.add(MerchantSite::getPassword);
        props.add(MerchantSite::getSecret);
        props.add(MerchantSite::getPublicKey);
        props.add(MerchantSite::getBaseUrl);
        props.add(MerchantSite::getApiToken);
        props.add(MerchantSite::getExpiryDate);
        super.buildSignificationProperties(props);
    }
}
