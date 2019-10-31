package com.trustev.domain.entities;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device extends TimestampBase<Device> {

    private Map<String, String> attributes;
    private String deviceIdentifier;

    @JsonProperty("Attributes")
    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(final Map<String, String> value) {
        this.attributes = value;
    }

    @JsonProperty("DeviceIdentifier")
    public String getDeviceIdentifier() {
        return this.deviceIdentifier;
    }

    public void setDeviceIdentifier(final String value) {
        this.deviceIdentifier = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Device, Comparable>> props) {
        props.add(Device::getDeviceIdentifier);
        super.buildSignificationProperties(props);
    }
}
