package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawDataBINInformation extends Base<RawDataBINInformation> {

    private String bin;
    private String brand;
    private String countryISO3166_Code2;
    private String cardType;
    private String bank;

    @JsonProperty("BIN")
    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    @JsonProperty("Brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("CountryISO3166_Code2")
    public String getCountryISO3166_Code2() {
        return countryISO3166_Code2;
    }

    public void setCountryISO3166_Code2(String countryISO3166_Code2) {
        this.countryISO3166_Code2 = countryISO3166_Code2;
    }

    @JsonProperty("CardType")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @JsonProperty("Bank")
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    protected void buildSignificationProperties(List<Function<RawDataBINInformation, Comparable>> props) {
        props.add(RawDataBINInformation::getBin);
        props.add(RawDataBINInformation::getBrand);
        props.add(RawDataBINInformation::getCountryISO3166_Code2);
        props.add(RawDataBINInformation::getCardType);
        props.add(RawDataBINInformation::getBank);
        super.buildSignificationProperties(props);
    }
}