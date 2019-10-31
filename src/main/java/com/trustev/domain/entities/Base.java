package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Base<T extends Base> implements Comparable<T> {

    final Logger logger = LoggerFactory.getLogger(Base.class);

    private static ConcurrentMap<Class, List<Function<Base, Comparable>>> significantPropertiesCache = new ConcurrentHashMap();

    public List<Function<Base, Comparable>> fetchCachedSignificationProperties() {
        List<Function<Base, Comparable>> result = significantPropertiesCache.get(this.getClass());
        if (result == null) {
            List<Function<T, Comparable>> significantProperties = new ArrayList<>();
            buildSignificationProperties(significantProperties);
            result = significantProperties.stream()
                .map(action -> (Function<Base, Comparable>) action)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
            significantPropertiesCache.putIfAbsent(this.getClass(), result);
        }
        return result;
    }

    protected void buildSignificationProperties(List<Function<T, Comparable>> props) {

    }

    @JsonIgnore
    protected final Class getTypeEquiv() {
        return this.getClass();
    }


    @Override
    public int hashCode() {
        int currHash = 1;
        List<Function<Base, Comparable>> actions = fetchCachedSignificationProperties();
        if (actions != null && actions.size() > 0) {
            for (Function<Base, Comparable> action : actions) {
                currHash = hashCodeForProperty(currHash, action.apply(this));
            }
        }
        return currHash;
    }

    private int hashCodeForProperty(int currHash, Object that) {
        if (currHash == 0) {
            currHash = 1;
        }
        return (currHash * 31 + (that == null ? 0 : that.hashCode()));
    }

    @Override
    public boolean equals(Object that) {
        boolean isEqual = false;
        if (that != null) {
            if (this == that) {
                isEqual = true;
            } else if (that instanceof Base) {
                Base castedThat = (Base) that;
                if (this.getTypeEquiv().equals(castedThat.getTypeEquiv())) {
                    isEqual = this.compareTo((T) castedThat) == 0;
                }
            }
        }
        return isEqual;
    }

    @Override
    public int compareTo(T that) {
        if (this == that) {
            return 0;
        }

        int comparison = compareNullStatus(this, that);
        if (comparison != 0) {
            return comparison;
        }

        List<Function<Base, Comparable>> actions = fetchCachedSignificationProperties();
        if (actions != null && actions.size() > 0) {
            for (Function<Base, Comparable> action : actions) {
                comparison = compareTo(action.apply(this), action.apply(that));
                if (comparison != 0) {
                    return comparison;
                }
            }
        }

        return comparison;
    }

    private static int compareNullStatus(Object lhs, Object rhs) {
        if (lhs == null && rhs != null) {
            return -1;
        }
        if (lhs != null && rhs == null) {
            return 1;
        }
        return 0;
    }

    private static int compareTo(Comparable lhs, Comparable rhs) {
        if (lhs == rhs) {
            return 0;
        }
        if (lhs == null && rhs != null) {
            return -1;
        }
        if (lhs != null && rhs == null) {
            return 1;
        }
        return lhs.compareTo(rhs);
    }

    @Override
    public String toString() {
        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.info("Failed to convert to json falling back to super.toString", e);
            result = super.toString();
        }
        return result;
    }
}
