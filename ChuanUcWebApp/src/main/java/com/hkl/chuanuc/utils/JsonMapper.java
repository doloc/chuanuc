package com.hkl.chuanuc.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

public class JsonMapper {
	
	private final ObjectMapper objMapper = new ObjectMapper();
	public static JsonMapper Instant = new JsonMapper();
	
	public JsonMapper() {
        Map<SerializationConfig.Feature, Boolean> config = new HashMap<SerializationConfig.Feature, Boolean>();
        config.put(SerializationConfig.Feature.AUTO_DETECT_GETTERS, false);
        config.put(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS, false);
        config.put(SerializationConfig.Feature.INDENT_OUTPUT, true);
        for (SerializationConfig.Feature feature : config.keySet()) {
            objMapper.configure(feature, config.get(feature));
        }
        objMapper.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);
    }

    public <T, V> Map<T, V> getMap(String json) {
        try {
            return objMapper.readValue(json, new TypeReference<Map<T, V>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> List<T> getList(String json) {
        try {
            return objMapper.readValue(json, new TypeReference<List<T>>() {
            });
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }

    public <T> T getObject(Class<T> type, String json) {
        try {
            return objMapper.readValue(json, type);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    public String toJson(Object obj) {
        try {
            return objMapper.writeValueAsString(obj);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> getList(String json, Class<T> clazz) throws Exception {
        try {
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            return objMapper.readValue(json, typeFactory.constructCollectionType(ArrayList.class, clazz));
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return Collections.emptyList();
    }
	
}
