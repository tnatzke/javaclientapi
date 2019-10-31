package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location extends TimestampBase<Location> {

    private Double latitude;
    private Double longitude;
    private LocationProvider provider;

    @JsonProperty("Latitude")
    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(final Double value) {
        this.latitude = value;
    }

    @JsonProperty("Longitude")
    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(final Double value) {
        this.longitude = value;
    }

    @JsonProperty("Provider")
    public LocationProvider getProvider() {
        return this.provider;
    }

    public void setProvider(final LocationProvider value) {
        this.provider = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Location, Comparable>> props) {
        props.add(Location::getLatitude);
        props.add(Location::getLongitude);
        props.add(Location::getProvider);
        super.buildSignificationProperties(props);
    }
}
