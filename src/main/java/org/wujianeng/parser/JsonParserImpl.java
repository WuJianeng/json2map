package org.wujianeng.parser;

import com.jayway.jsonpath.JsonPath;
import org.wujianeng.annotation.FieldName;
import org.wujianeng.annotation.Path;
import org.wujianeng.annotation.Table;
import org.wujianeng.util.AnnotationUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wu_jianeng@foxmail.com
 * @date 2022/1/8 21:37
 */
public class JsonParserImpl implements JsonParser {
    public Map<String, Object> parse(String json, Class configClass) {
        Map<String, Object> res = new HashMap<>();
        for (Field field : configClass.getDeclaredFields()) {
            String fieldName = getFieldName(field);
            String jsonPath = getJsonPath(field);
            res.put(fieldName, JsonPath.read(json, jsonPath));
        }
        return res;
    }

    public static String getTableName(Class configClass) {
        Annotation annotation = AnnotationUtil.getAnnotation(configClass, Table.class);
        if (annotation == null) {
            return null;
        } else {
            return ((Table) annotation).name();
        }
    }

    public static String getJsonPath(Field field) {
        Annotation annotation = AnnotationUtil.getAnnotation(field, Path.class);
        if (annotation == null) {
            return null;
        }
        return ((Path) annotation).value();
    }

    public static String getFieldName(Field field) {
        Annotation annotation = AnnotationUtil.getAnnotation(field, FieldName.class);
        if (annotation == null) {
            return null;
        }
        return ((FieldName) annotation).value();
    }
}
