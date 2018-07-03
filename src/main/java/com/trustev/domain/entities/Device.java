package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.util.Dictionary;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {
    private Dictionary<String, String> attributes;
    private String deviceIdentifier;
    private String id;
    private Date timestamp;

    @JsonProperty("Attributes")
    public Dictionary<String, String> getAttributes() {
        return attributes;
    }

    @JsonProperty("Attributes")
    public void setAttributes(Dictionary<String, String> attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("DeviceIdentifier")
    public String getDeviceIdentifier() {
        return deviceIdentifier;
    }

    @JsonProperty("DeviceIdentifier")
    public void setDeviceIdentifier(String deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Timestamp")
    public Date getTimestamp() {
        return timestamp;
    }

    @JsonProperty("Timestamp")
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
