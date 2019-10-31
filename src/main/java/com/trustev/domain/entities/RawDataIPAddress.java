package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawDataIPAddress extends IdBase<RawDataIPAddress> {

    private String clientIp;
    private String continent;
    private String country;
    private String countryCode;
    private String state;
    private String city;
    private String connectionType;
    private String lineSpeed;
    private String routingType;
    private String sld;
    private String tld;
    private String hostingFacility;
    private String proxyType;
    private String anonymizerStatus;

    @JsonProperty("ClientIp")
    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(final String value) {
        this.clientIp = value;
    }

    @JsonProperty("Continent")
    public String getContinent() {
        return this.continent;
    }

    public void setContinent(final String value) {
        this.continent = value;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(final String value) {
        this.country = value;
    }

    @JsonProperty("CountryCode")
    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(final String value) {
        this.countryCode = value;
    }

    @JsonProperty("State")
    public String getState() {
        return this.state;
    }

    public void setState(final String value) {
        this.state = value;
    }

    @JsonProperty("City")
    public String getCity() {
        return this.city;
    }

    public void setCity(final String value) {
        this.city = value;
    }

    @JsonProperty("ConnectionType")
    public String getConnectionType() {
        return this.connectionType;
    }

    public void setConnectionType(final String value) {
        this.connectionType = value;
    }

    @JsonProperty("LineSpeed")
    public String getLineSpeed() {
        return this.lineSpeed;
    }

    public void setLineSpeed(final String value) {
        this.lineSpeed = value;
    }

    @JsonProperty("RoutingType")
    public String getRoutingType() {
        return this.routingType;
    }

    public void setRoutingType(final String value) {
        this.routingType = value;
    }

    @JsonProperty("SLD")
    public String getSLD() {
        return this.sld;
    }

    public void setSLD(final String value) {
        this.sld = value;
    }

    @JsonProperty("TLD")
    public String getTLD() {
        return this.tld;
    }

    public void setTLD(final String value) {
        this.tld = value;
    }

    @JsonProperty("HostingFacility")
    public String getHostingFacility() {
        return this.hostingFacility;
    }

    public void setHostingFacility(final String value) {
        this.hostingFacility = value;
    }

    @JsonProperty("ProxyType")
    public String getProxyType() {
        return this.proxyType;
    }

    public void setProxyType(final String value) {
        this.proxyType = value;
    }

    @JsonProperty("AnonymizerStatus")
    public String getAnonymizerStatus() {
        return this.anonymizerStatus;
    }

    public void setAnonymizerStatus(final String value) {
        this.anonymizerStatus = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<RawDataIPAddress, Comparable>> props) {
        props.add(RawDataIPAddress::getClientIp);
        props.add(RawDataIPAddress::getContinent);
        props.add(RawDataIPAddress::getCountry);
        props.add(RawDataIPAddress::getCountryCode);
        props.add(RawDataIPAddress::getState);
        props.add(RawDataIPAddress::getCity);
        props.add(RawDataIPAddress::getConnectionType);
        props.add(RawDataIPAddress::getLineSpeed);
        props.add(RawDataIPAddress::getRoutingType);
        props.add(RawDataIPAddress::getSLD);
        props.add(RawDataIPAddress::getTLD);
        props.add(RawDataIPAddress::getHostingFacility);
        props.add(RawDataIPAddress::getProxyType);
        props.add(RawDataIPAddress::getAnonymizerStatus);
        super.buildSignificationProperties(props);
    }
}
