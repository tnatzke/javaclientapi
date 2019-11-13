package com.trustev.domain.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trustev.domain.entities.kba.KBAStatus;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class KBAStatusTest {

    @Test
    public void testSerializingEnum() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        for (KBAStatus status : KBAStatus.class.getEnumConstants()) {
            String json = mapper.writeValueAsString(status);
            Assert.assertEquals(String.valueOf(status.getId()), json);
            KBAStatus enumFromJson = mapper.readValue(json, KBAStatus.class);
            Assert.assertEquals(status, enumFromJson);
        }
    }
}
