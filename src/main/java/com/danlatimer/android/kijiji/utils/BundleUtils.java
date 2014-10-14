package com.danlatimer.android.kijiji.utils;

import android.os.Bundle;
import android.util.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Helper class to convert bundles to maps
 */
public class BundleUtils {

    private static final String BEGIN_OBJECT = "BEGIN_OBJECT";
    private static final String NUMBER = "NUMBER";

    /**
     * Converts a map into a bundle
     *
     * @param map
     * @return
     */
    public static Bundle bundleFromMap(Map<String, Object> map) {
        Bundle bundle = new Bundle();

        for(Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if(value instanceof String) {
                bundle.putString(key, (String) value);
            }
            if(value instanceof Integer) {
                bundle.putInt(key, (Integer) value);
            }
            if(value instanceof Map) {
                Bundle innerBundle = bundleFromMap((Map) value);
                bundle.putBundle(key, innerBundle);
            }
        }

        return bundle;
    }

    /**
     * Parses Json and creates a bundle
     *
     * @param json
     * @return
     */
    public static Bundle bundleFromJson(String json) {
        JsonReader jsonReader = new JsonReader(new StringReader(json));

        try {
            Map<String, Object> map = readMapFromJson(jsonReader);
            return bundleFromMap(map);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Reads a map object from json and returns in map format
     *
     * @param jsonReader
     * @return
     * @throws IOException
     */
    private static Map<String, Object> readMapFromJson(JsonReader jsonReader) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();

        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String key = jsonReader.nextName();
            Object value = parseValue(jsonReader);

            map.put(key, value);
        }
        jsonReader.endObject();

        return map;
    }

    /**
     * Parses an int, string or object
     *
     * @param jsonReader
     * @return
     * @throws IOException
     */
    private static Object parseValue(JsonReader jsonReader) throws IOException {
        Object value;

        final String valuePeek = jsonReader.peek().toString();
        if(valuePeek.equals(BEGIN_OBJECT)) {
            value = readMapFromJson(jsonReader);
        }
        else if(valuePeek.equals(NUMBER)) {
            value = jsonReader.nextInt();
        }
        else {
            value = jsonReader.nextString();
        }
        return value;
    }
}
