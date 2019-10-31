package com.trustev.domain.entities.otp;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.trustev.domain.entities.TimestampBase;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OTPResult extends TimestampBase<OTPResult> {

    private OTPStatus status;
    private String authURL;
    private String passcode;
    private PhoneDeliveryType deliveryType;
    private OTPLanguageEnum language;

    public OTPResult(String id) {
        this.setId(id);
        this.setTimestamp(new Date());
    }

    public OTPResult() {
    }

    @JsonProperty("Status")
    public OTPStatus getStatus() {
        return status;
    }

    public void setStatus(OTPStatus status) {
        this.status = status;
    }


    @JsonProperty("AuthURL")
    public String getAuthURL() {
        return authURL;
    }

    public void setAuthURL(String authURL) {
        this.authURL = authURL;
    }

    @JsonProperty("Passcode")
    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }


    @JsonProperty("DeliveryType")
    public PhoneDeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(PhoneDeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    @JsonProperty("Language")
    public OTPLanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(OTPLanguageEnum language) {
        this.language = language;
    }

    @Override
    protected void buildSignificationProperties(List<Function<OTPResult, Comparable>> props) {
        props.add(OTPResult::getStatus);
        props.add(OTPResult::getAuthURL);
        props.add(OTPResult::getPasscode);
        props.add(OTPResult::getDeliveryType);
        props.add(OTPResult::getLanguage);
        super.buildSignificationProperties(props);
    }
}
