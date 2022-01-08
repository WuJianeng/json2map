package org.wujianeng.parser;

import java.util.Map;

/**
 * @author wu_jianeng@foxmail.com
 * @date 2022/1/8 21:13
 */
public interface JsonParser {
    /**
     * transfer json to map with specific class config
     */
    Map<String, Object> parse(String json, Class configClass);
}
