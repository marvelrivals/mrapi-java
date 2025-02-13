package org.mrapi;

import com.google.gson.JsonElement;

import java.lang.reflect.Field;

import static org.mrapi.MarvalRivalsAPI.gson;

public class RivalObject {
    public String toString() {
        try {
            StringBuilder string = new StringBuilder(this.getClass().getSimpleName() + "[");
            int i = 1;
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(this);
                string.append(field.getName()).append("=")
                        .append(value != null ? value.toString() : "null")
                        .append(i < this.getClass().getDeclaredFields().length ? ", " : "");
                i++;
            }
            return string + "]";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonElement toJson() {
        return gson.toJsonTree(this);
    }

    public String toJsonString() {
        return gson.toJson(this);
    }

    public static <T extends RivalObject> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T extends RivalObject> T fromJson(JsonElement json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
