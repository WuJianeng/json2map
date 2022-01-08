package org.wujianeng.parser;

import org.junit.Test;
import org.wujianeng.JsonTest;
import org.wujianeng.config.User;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author wu_jianeng@foxmail.com
 * @date 2022/1/8 21:47
 */
public class JsonParserImplTest {

    private static Class getConfigClass() {
        return User.class;
    }

    @Test
    public void testGetTableName() {
        Class clazz = getConfigClass();
        String tableName = JsonParserImpl.getTableName(clazz);
        System.out.println("table name: " + tableName);
    }

    @Test
    public void testGetFieldAnnotation() {
        Class clazz = getConfigClass();
        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = JsonParserImpl.getFieldName(field);
            String jsonPath = JsonParserImpl.getJsonPath(field);
            if (fieldName != null) {
                System.out.print("field: " + fieldName + "\t");
            }
            System.out.println("json-path: " + jsonPath);
        }
    }

    @Test
    public void testParse() {
        String userJson = JsonTest.loadJson("search_user.json");
        Map<String, Object> res = new JsonParserImpl().parse(userJson, User.class);
        for (Map.Entry entry : res.entrySet()) {
            System.out.println(entry);
        }
    }
}
