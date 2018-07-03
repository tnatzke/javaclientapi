package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {
    private List<Detail> details;
    private List<Device> devices;
    private String sessionId;
    private SessionType sessionType;

    @JsonProperty("Details")
    public List<Detail> getDetails() {
        return details;
    }

    @JsonProperty("Details")
    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @JsonProperty("Devices")
    public List<Device> getDevices() {
        return devices;
    }

    @JsonProperty("Devices")
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @JsonProperty("SessionId")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("SessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("SessionType")
    public SessionType getSessionType() {
        return sessionType;
    }

    @JsonProperty("SessionType")
    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }
}
