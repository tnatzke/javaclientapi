package com.trustev.domain.entities;

public enum BaseUrl {
    EU("https://app-eu.trustev.com/api/v2.0"),
    US("https://app.trustev.com/api/v2.0");

    private String url;

    BaseUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
