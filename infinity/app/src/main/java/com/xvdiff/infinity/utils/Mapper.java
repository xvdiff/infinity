/*
 * ∞ (infinity) - 8chan browser for Android - https://github.com/xvdiff/infinity
 * Copyright (c) 2014 xvdiff
 *
 * This program is distributed as free software: You are free to redistribute
 * and/or modify it under the terms of the Apache License v2.0
 *
 * You should have received a copy of the Apache License Version 2.0, January 2004
 * along with this program.  If not, see <http://www.apache.org/licenses/LICENSE-2.0/>.
 *
 */
package com.xvdiff.infinity.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.xvdiff.infinity.utils.Logger;

import java.io.IOException;
import java.util.List;

public final class Mapper {

    private static final String TAG = "Mapper";

    private static ObjectMapper MAPPER;

    public static ObjectMapper getInstance() {
        if(MAPPER == null) {
            MAPPER = new ObjectMapper();
            MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        return MAPPER;
    }

    public static <T> String toJson(T object) {
        try {
            Logger.debug(TAG, "Serializing object of type %s", object.getClass().getName());
            return getInstance().writeValueAsString(object);
        } catch (JsonProcessingException jsonProcEx) {
            Logger.error(TAG, "Unable to process object", jsonProcEx);
        } catch (Exception ex) {
            Logger.error(TAG, "Failed to process object", ex);
        }

        return null;
    }

    public static <T> T mapObject(String data, Class<T> type)
        throws JsonParseException, JsonMappingException, IOException
    {
        return getInstance().readValue(data, type);
    }

    public static <T> T tryMapObject(String data, Class<T> type) {
        try {
           return mapObject(data, type);
        } catch (Exception ex) {
            Logger.error(TAG, "Failed to parse data", ex);
        }
        return null;
    }

    public static <T> List<T> mapCollection(String data, Class<T> type)
        throws JsonParseException, JsonMappingException, IOException
    {
        TypeFactory typeFactory = getInstance().getTypeFactory();
        return getInstance().readValue(data, typeFactory.constructCollectionType(List.class, type));
    }

    public static <T> List<T> tryMapCollection(String data, Class<T> type) {
        try {
            return mapCollection(data, type);
        } catch (Exception ex) {
            Logger.error(TAG, "Failed to parse collection", ex);
        }
        return null;
    }

}
