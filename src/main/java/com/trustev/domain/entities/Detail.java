package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Detail extends TimestampBase<Detail> {

    private String browser;
    private String clientIp;
    private String host;
    private String oS;
    private String referer;
    private String userAgent;

    @JsonProperty("Browser")
    public String getBrowser() {
        return this.browser;
    }

    public void setBrowser(final String value) {
        this.browser = value;
    }

    @JsonProperty("ClientIp")
    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(final String value) {
        this.clientIp = value;
    }

    @JsonProperty("Host")
    public String getHost() {
        return this.host;
    }

    public void setHost(final String value) {
        this.host = value;
    }

    @JsonProperty("OS")
    public String getOS() {
        return this.oS;
    }

    public void setOS(final String value) {
        this.oS = value;
    }

    @JsonProperty("Referer")
    public String getReferer() {
        return this.referer;
    }

    public void setReferer(final String value) {
        this.referer = value;
    }

    @JsonProperty("UserAgent")
    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(final String value) {
        this.userAgent = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Detail, Comparable>> props) {
        props.add(Detail::getBrowser);
        props.add(Detail::getClientIp);
        props.add(Detail::getHost);
        props.add(Detail::getOS);
        props.add(Detail::getReferer);
        props.add(Detail::getUserAgent);
        super.buildSignificationProperties(props);
    }
}
