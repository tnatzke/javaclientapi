package com.trustev.domain.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public abstract class BaseTest<T extends Base> {

    protected Class<T> classType;

    public BaseTest(Class<T> classType) {
        this.classType = classType;
    }

    abstract T generateObject();

    @Test
    public void testNullSafeEquals() {
        final T first = generateObject();
        final T nullObject = null;
        assertFalse("Calling equals on a " + classType.getName() + " and passing in a null object fails", first.equals(nullObject));
    }

    @Test
    public void testEqualsSameInstance() {
        final T first = generateObject();
        assertEquals("Calling equals on itself failed for " + classType.getName(), first, first);
    }

    @Test
    public void testEqualsSameObject() {
        final T first = generateObject();
        final T second = generateObject();
        final StringBuilder assertMessage = new StringBuilder();
        Assert.assertEquals("Two identical " + classType.getName() + " are NOT equal!", first, second);
    }

    @Test
    public void testNotEqualToAString() {
        final Object first = generateObject();
        final String aString = first.toString();
        assertFalse("Calling equals on a " + classType.getName() + " and passing in a Stirng should not return true", first.equals(aString));
    }


    @Test
    public void testJsonSerializable() throws JsonProcessingException {
        T object = generateObject();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(object);
        Assert.assertNotNull(json);
    }

    @Test
    public void testJsonDeserializable() throws IOException {
        T object = generateObject();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(object);
        Assert.assertNotNull(json);
        Object secondObject = mapper.readValue(json, classType);
        Assert.assertEquals("The original object did not equal the recreated object.", object, secondObject);
    }
}
