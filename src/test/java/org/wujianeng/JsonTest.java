package org.wujianeng;

import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author wu_jianeng@foxmail.com
 * @date 2022/1/8 21:17
 */
public class JsonTest {

    public static String loadJson(String fileName) {
        InputStream inputStream = JsonTest.class.getClassLoader().getResourceAsStream(fileName);
        Scanner scanner = new Scanner(inputStream);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        return sb.toString();
    }

    @Test
    public void validateJson() {
        String json = loadJson("demo.json");
        Object res = JsonPath.read(json, "$.data[1].type");
        System.out.println(res);
        Assert.assertNotNull(res);
    }
}
