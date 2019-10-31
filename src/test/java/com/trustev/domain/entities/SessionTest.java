package com.trustev.domain.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringReader;
import org.junit.Assert;
import org.junit.Test;

public class SessionTest extends BaseTest<Session> {

    public SessionTest() {
        super(Session.class);
    }

    @Override
    Session generateObject() {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n"
            + "  \"Details\": [\n"
            + "    {\n"
            + "      \"Browser\": \"sample string 1\",\n"
            + "      \"ClientIp\": \"sample string 2\",\n"
            + "      \"Host\": \"sample string 3\",\n"
            + "      \"Id\": \"b0a482bc-f977-446b-ad1e-00452dac48ee\",\n"
            + "      \"OS\": \"sample string 5\",\n"
            + "      \"Referer\": \"sample string 6\",\n"
            + "      \"Timestamp\": \"2019-08-12T20:33:11.1425213Z\",\n"
            + "      \"UserAgent\": \"sample string 8\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"Browser\": \"sample string 1\",\n"
            + "      \"ClientIp\": \"sample string 2\",\n"
            + "      \"Host\": \"sample string 3\",\n"
            + "      \"Id\": \"b0a482bc-f977-446b-ad1e-00452dac48ee\",\n"
            + "      \"OS\": \"sample string 5\",\n"
            + "      \"Referer\": \"sample string 6\",\n"
            + "      \"Timestamp\": \"2019-08-12T20:33:11.1425213Z\",\n"
            + "      \"UserAgent\": \"sample string 8\"\n"
            + "    }\n"
            + "  ],\n"
            + "  \"Devices\": [\n"
            + "    {\n"
            + "      \"Attributes\": {\n"
            + "        \"sample string 1\": \"sample string 2\",\n"
            + "        \"sample string 3\": \"sample string 4\"\n"
            + "      },\n"
            + "      \"DeviceIdentifier\": \"sample string 1\",\n"
            + "      \"Id\": \"4cd328ab-8f39-40f0-a5e1-40e7fde91946\",\n"
            + "      \"Timestamp\": \"2019-08-12T20:33:11.1425213Z\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"Attributes\": {\n"
            + "        \"sample string 1\": \"sample string 2\",\n"
            + "        \"sample string 3\": \"sample string 4\"\n"
            + "      },\n"
            + "      \"DeviceIdentifier\": \"sample string 1\",\n"
            + "      \"Id\": \"4cd328ab-8f39-40f0-a5e1-40e7fde91946\",\n"
            + "      \"Timestamp\": \"2019-08-12T20:33:11.1425213Z\"\n"
            + "    }\n"
            + "  ],\n"
            + "  \"Locations\": [\n"
            + "    {\n"
            + "      \"Id\": \"5180830f-67ff-467c-aa94-771906f1ff9e\",\n"
            + "      \"Latitude\": 2.1,\n"
            + "      \"Longitude\": 3.1,\n"
            + "      \"Provider\": {},\n"
            + "      \"Timestamp\": \"2019-08-12T20:33:11.1425213Z\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"Id\": \"5180830f-67ff-467c-aa94-771906f1ff9e\",\n"
            + "      \"Latitude\": 2.1,\n"
            + "      \"Longitude\": 3.1,\n"
            + "      \"Provider\": {},\n"
            + "      \"Timestamp\": \"2019-08-12T20:33:11.1425213Z\"\n"
            + "    }\n"
            + "  ],\n"
            + "  \"SessionId\": \"be50c10e-b68d-4f4f-9d44-6df33c1f11c5\",\n"
            + "  \"SessionType\": 0\n"
            + "}";


        Session session = null;

        try {
            session = mapper.readValue(new StringReader(json), Session.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return session;
    }

}
