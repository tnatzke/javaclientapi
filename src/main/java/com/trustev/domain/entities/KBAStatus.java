package com.trustev.domain.entities;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.deser.StdDeserializer;

import java.io.IOException;

@JsonDeserialize(using = KBAStatus.KBAStatusDeserializer.class)
public enum KBAStatus
{
    NotConfigured (-1),
    Offered (0),
    MultiPassOffered (1),
    Ineligible (2),
    NoData (3),
    Passed (4),
    Failed (5),
    Abbandoned (6);

    private final int status;

    KBAStatus(final int status) {
        this.status = status;
    }

    @JsonValue
    public int toInt()
    {
        return this.status;
    }

    public static class KBAStatusDeserializer extends StdDeserializer<KBAStatus> {
        public KBAStatusDeserializer() {
            super(KBAStatus.class);
        }

        @Override
        public KBAStatus deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
            final JsonNode jsonNode = jp.readValueAsTree();

            KBAStatus type;
            int valueNum = jsonNode.asInt();

            switch(valueNum)
            {
                case -1:
                    type = KBAStatus.NotConfigured;
                    break;
                case 0:
                    type = KBAStatus.Offered;
                    break;
                case 1:
                    type = KBAStatus.MultiPassOffered;
                    break;
                case 2:
                    type = KBAStatus.Ineligible;
                    break;
                case 3:
                    type = KBAStatus.NoData;
                    break;
                case 4:
                    type = KBAStatus.Passed;
                    break;
                case 5:
                    type = KBAStatus.Failed;
                    break;
                case 6:
                    type = KBAStatus.Abbandoned;
                    break;
                default:
                    return null;
            }

            return type;
        }
    }
}
