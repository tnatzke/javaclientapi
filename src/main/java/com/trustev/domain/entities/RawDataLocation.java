package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawDataLocation extends Base<RawDataLocation> {
    private RawDataCoordinates coordinates;
    private Map<String, String> addresses;

    @JsonProperty("Coordinates")
    public RawDataCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(RawDataCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty("Addresses")
    public Map<String, String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, String> addresses) {
        this.addresses = addresses;
    }

    @Override
    protected void buildSignificationProperties(List<Function<RawDataLocation, Comparable>> props) {
        props.add(RawDataLocation::getCoordinates);
        super.buildSignificationProperties(props);
    }
}