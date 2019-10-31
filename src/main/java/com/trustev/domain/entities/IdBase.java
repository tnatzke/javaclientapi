package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

public abstract class IdBase<T extends IdBase> extends Base<T> {

    private String id;

    /**
     * @return This is the Object Id. The Id is returned once a Trustev Case has
     * been created. It is required when getting a Trustev Decision on a
     * Trustev Case, when updating a Case Status, and anytime you wish
     * to update Trustev Case information.
     */
    @JsonProperty("Id")
    public String getId() {
        return this.id;
    }

    public void setId(final String value) {
        this.id = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<T, Comparable>> props) {
        props.add(T::getId);
        super.buildSignificationProperties(props);
    }
}
