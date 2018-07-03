package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Detail {
    private String browser;
    private String clientIp;
    private String host;
    private String id;
    private String os;
    private String referer;
    private Date timestamp;
    private String userAgent;

    @JsonProperty("Browser")
    public String getBrowser() {
        return browser;
    }

    @JsonProperty("Browser")
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @JsonProperty("ClientIp")
    public String getClientIp() {
        return clientIp;
    }

    @JsonProperty("ClientIp")
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    @JsonProperty("Host")
    public String getHost() {
        return host;
    }

    @JsonProperty("Host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("OS")
    public String getOs() {
        return os;
    }

    @JsonProperty("OS")
    public void setOs(String os) {
        this.os = os;
    }

    @JsonProperty("Referer")
    public String getReferer() {
        return referer;
    }

    @JsonProperty("Referer")
    public void setReferer(String referer) {
        this.referer = referer;
    }

    @JsonProperty("Timestamp")
    public Date getTimestamp() {
        return timestamp;
    }

    @JsonProperty("Timestamp")
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("UserAgent")
    public String getUserAgent() {
        return userAgent;
    }

    @JsonProperty("UserAgent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
