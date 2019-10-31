package com.trustev.util;

import com.trustev.domain.entities.BaseEnum;

public class EnumUtils {
    public static <T extends BaseEnum> T convertFromString(String id, Class<T> enumClass) {
        if (id != null) {
            try {
                int fromId = Integer.parseInt(id);
                for (BaseEnum val : enumClass.getEnumConstants()) {
                    if (val.getId() == fromId) {
                        return (T) val;
                    }
                }
            } catch (NumberFormatException ex) {

            }
        }
        return null;
    }
}
