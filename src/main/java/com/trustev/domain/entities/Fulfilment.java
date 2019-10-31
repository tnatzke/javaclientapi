package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

public class Fulfilment extends Base<Fulfilment> {

    private TimeToFulfilment timeToFulfilment;
    private FulfilmentMethod fulfilmentMethod;
    private FulfilmentGeoLocation fulfilmentGeoLocation;

    /**
     * @return The TimeToFulfilment of this Case
     */
    @JsonProperty("TimeToFulfilment")
    public TimeToFulfilment getTimeToFulfilment() {
        return this.timeToFulfilment;
    }

    /**
     * @param timeToFulfilment to set
     */
    public void setTimeToFulfilment(TimeToFulfilment timeToFulfilment) {
        this.timeToFulfilment = timeToFulfilment;
    }

    /**
     * @return The FulfilmentMethod of this Case
     */
    @JsonProperty("Method")
    public FulfilmentMethod getFulfilmentMethod() {
        return this.fulfilmentMethod;
    }

    /**
     * @param fulfilmentMethod to set
     */
    public void setFulfilmentMethod(FulfilmentMethod fulfilmentMethod) {
        this.fulfilmentMethod = fulfilmentMethod;
    }

    /**
     * @return The FulfilmentGeoLocation of this Case
     */
    @JsonProperty("GeoLocation")
    public FulfilmentGeoLocation getFulfilmentGeoLocation() {
        return this.fulfilmentGeoLocation;
    }

    /**
     * @param fulfilmentGeoLocation to set
     */
    public void setFulfilmentGeoLocation(FulfilmentGeoLocation fulfilmentGeoLocation) {
        this.fulfilmentGeoLocation = fulfilmentGeoLocation;
    }

    @Override
    protected void buildSignificationProperties(List<Function<Fulfilment, Comparable>> props) {
        props.add(Fulfilment::getTimeToFulfilment);
        props.add(Fulfilment::getFulfilmentMethod);
        props.add(Fulfilment::getFulfilmentGeoLocation);
        super.buildSignificationProperties(props);
    }
}
