package com.trustev.domain.entities;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.function.Function;

/**
 * The Detailed decision Raw data object
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawData extends Base<RawData> {

    private CaseType caseType;
    private String deviceTag;
    private String trustevCustomerId;
    private String browser;
    private String os;
    private String navigatorOsCpu;
    private String navigatorLanguage;
    private String navigatorPlugins;
    private String screenWidth;
    private String screenHeight;
    private String screenColorDepth;
    private Collection<RawDataIPAddress> ipAddresses;
    private RawDataBINInformation binInformation;
    private RawDataCustomer customer;
    private RawDataTransaction transaction;
    private RawDataLocation location;

    @JsonProperty("CaseType")
    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }


    @JsonProperty("DeviceTag")
    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    @JsonProperty("TrustevCustomerId")
    public String getTrustevCustomerId() {
        return trustevCustomerId;
    }

    public void setTrustevCustomerId(String trustevCustomerId) {
        this.trustevCustomerId = trustevCustomerId;
    }

    @JsonProperty("Browser")
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @JsonProperty("OS")
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @JsonProperty("NavigatorOscpu")
    public String getNavigatorOscpu() {
        return navigatorOsCpu;
    }

    public void setNavigatorOscpu(String navigatorOsCpu) {
        this.navigatorOsCpu = navigatorOsCpu;
    }

    @JsonProperty("NavigatorLanguage")
    public String getNavigatorLanguage() {
        return navigatorLanguage;
    }

    public void setNavigatorLanguage(String navigatorLanguage) {
        this.navigatorLanguage = navigatorLanguage;
    }

    @JsonProperty("NavigatorPlugins")
    public String getNavigatorPlugins() {
        return navigatorPlugins;
    }

    public void setNavigatorPlugins(String navigatorPlugins) {
        this.navigatorPlugins = navigatorPlugins;
    }


    @JsonProperty("ScreenWidth")
    public String getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(String screenWidth) {
        this.screenWidth = screenWidth;
    }

    @JsonProperty("ScreenHeight")
    public String getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(String screenHeight) {
        this.screenHeight = screenHeight;
    }

    @JsonProperty("ScreenColorDepth")
    public String getScreenColorDepth() {
        return screenColorDepth;
    }

    public void setScreenColorDepth(String screenColorDepth) {
        this.screenColorDepth = screenColorDepth;
    }

    @JsonProperty("IPAddresses")
    public Collection<RawDataIPAddress> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(Collection<RawDataIPAddress> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    @JsonProperty("BINInformation")
    public RawDataBINInformation getBinInformation() {
        return binInformation;
    }

    public void setBinInformation(RawDataBINInformation binInformation) {
        this.binInformation = binInformation;
    }

    @JsonProperty("Customer")
    public RawDataCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(RawDataCustomer customer) {
        this.customer = customer;
    }

    @JsonProperty("Transaction")
    public RawDataTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(RawDataTransaction transaction) {
        this.transaction = transaction;
    }

    @JsonProperty("Location")
    public RawDataLocation getLocation() {
        return location;
    }

    public void setLocation(RawDataLocation location) {
        this.location = location;
    }

    @Override
    protected void buildSignificationProperties(List<Function<RawData, Comparable>> props) {
        props.add(RawData::getCaseType);
        props.add(RawData::getDeviceTag);
        props.add(RawData::getTrustevCustomerId);
        props.add(RawData::getBrowser);
        props.add(RawData::getOs);
        props.add(RawData::getNavigatorLanguage);
        props.add(RawData::getNavigatorPlugins);
        props.add(RawData::getScreenWidth);
        props.add(RawData::getScreenHeight);
        props.add(RawData::getScreenColorDepth);
        props.add(RawData::getBinInformation);
        props.add(RawData::getCustomer);
        props.add(RawData::getTransaction);
        props.add(RawData::getLocation);
        super.buildSignificationProperties(props);
    }
}
