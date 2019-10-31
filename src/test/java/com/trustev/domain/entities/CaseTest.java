package com.trustev.domain.entities;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CaseTest extends BaseTest<Case> {

    public CaseTest() {
        super(Case.class);
    }

    @Override
    Case generateObject() {
        try {

            String json = "{\n"
                + "    \"Id\": \"c589af78-d25b-411a-a629-f510a9a356db|f97bca48-b750-4548-a65c-2b9682214f0c\",\n"
                + "    \"CaseNumber\": \"2\",\n"
                + "    \"CaseType\": 0,\n"
                + "    \"MarketType\": 0,\n"
                + "    \"Customer\": {\n"
                + "        \"AccountNumber\": null,\n"
                + "        \"Addresses\": [{\n"
                + "                \"Address1\": \"100 N ACORN AVE APARTMENT 1\",\n"
                + "                \"Address2\": null,\n"
                + "                \"Address3\": null,\n"
                + "                \"City\": \"ATLANTA\",\n"
                + "                \"CountryCode\": null,\n"
                + "                \"FirstName\": null,\n"
                + "                \"Id\": \"bf6b54b1-6d66-48f9-a9a0-4b23b183be64\",\n"
                + "                \"IsDefault\": false,\n"
                + "                \"LastName\": null,\n"
                + "                \"PostalCode\": \"30326\",\n"
                + "                \"State\": \"GA\",\n"
                + "                \"Timestamp\": \"0001-01-01T00:00:00Z\",\n"
                + "                \"Type\": 0\n"
                + "            }\n"
                + "        ],\n"
                + "        \"DateOfBirth\": \"2000-08-18T05:00:00Z\",\n"
                + "        \"Emails\": [],\n"
                + "        \"FirstName\": \"AARON\",\n"
                + "        \"Id\": \"7c4d493e-44cb-4719-ae61-40767bd52605\",\n"
                + "        \"LastName\": \"TESTA\",\n"
                + "        \"PhoneNumber\": null,\n"
                + "        \"SocialAccounts\": [],\n"
                + "        \"SocialSecurityNumber\": \"666-01-0001\"\n"
                + "    },\n"
                + "    \"LocationConsentId\": null,\n"
                + "    \"IdentityConsentId\": null,\n"
                + "    \"Payments\": [],\n"
                + "    \"SessionId\": \"c589af78-d25b-411a-a629-f510a9a356db\",\n"
                + "    \"Statuses\": [{\n"
                + "            \"Comment\": \"Status added by Trustev to set current status to placed\",\n"
                + "            \"Id\": \"e609ed26-3a54-43f4-b0a4-3ec4f460b798\",\n"
                + "            \"Status\": 8,\n"
                + "            \"Timestamp\": \"2019-08-19T14:51:14.1625031Z\"\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timestamp\": \"2019-08-19T14:51:13.35Z\",\n"
                + "    \"Transaction\": null\n"
                + "}\n";


            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Case.class);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to create object.");
        }
    }
}
