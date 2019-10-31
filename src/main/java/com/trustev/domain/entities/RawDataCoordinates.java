package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawDataCoordinates extends Base<RawDataCoordinates> {

    private String ip;
    private String deviceCellular;
    private String deviceBrowser;

    @JsonProperty("IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("DeviceCellular")
    public String getDeviceCellular() {
        return deviceCellular;
    }

    public void setDeviceCellular(String deviceCellular) {
        this.deviceCellular = deviceCellular;
    }

    @JsonProperty("DeviceBrowser;")
    public String getDeviceBrowser() {
        return deviceBrowser;
    }

    public void setDeviceBrowser(String deviceBrowser) {
        this.deviceBrowser = deviceBrowser;
    }

    @Override
    protected void buildSignificationProperties(List<Function<RawDataCoordinates, Comparable>> props) {
        props.add(RawDataCoordinates::getIp);
        props.add(RawDataCoordinates::getDeviceCellular);
        props.add(RawDataCoordinates::getDeviceBrowser);
        super.buildSignificationProperties(props);
    }
}