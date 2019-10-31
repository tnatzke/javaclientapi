package com.trustev.domain.entities;

import java.util.Date;

public class TokenResponseTest extends BaseTest<TokenResponse> {

    public TokenResponseTest() {
        super(TokenResponse.class);
    }

    @Override
    TokenResponse generateObject() {
        TokenResponse object = new TokenResponse();
        object.setApiToken("first");
        object.setCredentialType("second");
        object.setExpireAt(new Date());
        return object;
    }
}
