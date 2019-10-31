package com.trustev.domain.entities;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session extends IdBase<Session> {

    private Collection<Detail> details;
    private Collection<Device> devices;
    private Collection<Location> locations;
    private UUID sessionId;
    private SessionType sessionType;

    @JsonProperty("Details")
    public Collection<Detail> getDetails() {
        return this.details;
    }

    public void setDetails(final Collection<Detail> value) {
        this.details = value;
    }

    @JsonProperty("Devices")
    public Collection<Device> getDevices() {
        return this.devices;
    }

    public void setDevices(final Collection<Device> value) {
        this.devices = value;
    }

    @JsonProperty("Locations")
    public Collection<Location> getLocations() {
        return this.locations;
    }

    public void setLocations(final Collection<Location> value) {
        this.locations = value;
    }

    @JsonProperty("SessionId")
    public UUID getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(final UUID value) {
        this.sessionId = value;
    }

    @JsonProperty("SessionType")
    public SessionType getSessionType() {
        return this.sessionType;
    }

    public void setSessionType(final SessionType value) {
        this.sessionType = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Session, Comparable>> props) {
        props.add(Session::getSessionId);
        props.add(Session::getSessionType);
        super.buildSignificationProperties(props);
    }
}
