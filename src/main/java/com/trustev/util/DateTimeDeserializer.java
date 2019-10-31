package com.trustev.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.Date;

/*Ignores formatting specified by the @JsonFormat annotation. Some times dates are in the following formats.
0001-01-01T00:00:00Z,
2019-08-19T14:51:13.35Z,
2019-08-19T14:51:14.1625031Z
 */
public class DateTimeDeserializer extends StdDeserializer<Date> {

    DateTimeDeserializer(){
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return this._parseDate(p, ctxt);
    }
}
