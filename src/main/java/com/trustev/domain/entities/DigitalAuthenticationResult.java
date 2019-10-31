package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.trustev.domain.entities.kba.KBAResult;
import com.trustev.domain.entities.otp.OTPResult;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DigitalAuthenticationResult extends TimestampBase<DigitalAuthenticationResult> {

    public DigitalAuthenticationResult() {
        setTimestamp(new Date());
    }

    private OTPResult otp;
    private KBAResult kba;

    @JsonProperty("OTP")
    public OTPResult getOtp() {
        return otp;
    }

    public void setOtp(OTPResult otp) {
        this.otp = otp;
    }

    public KBAResult getKba() {
        return this.kba;
    }

    @JsonProperty("KBA")
    public void setKba(final KBAResult value) {
        this.kba = value;
    }

    @Override
    protected void buildSignificationProperties(List<Function<DigitalAuthenticationResult, Comparable>> props) {
        props.add(DigitalAuthenticationResult::getOtp);
        props.add(DigitalAuthenticationResult::getKba);
        super.buildSignificationProperties(props);
    }
}
