package org.wujianeng.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author wu_jianeng@foxmail.com
 * @date 2022/1/8 21:39
 */
public class AnnotationUtil {
    public static Annotation getAnnotation(Object obj, Class annotationClass) {
        Class clazz = obj.getClass();
        return clazz.getAnnotation(annotationClass);
    }

    public static Annotation getAnnotation(Class clazz, Class annotationClass) {
        return clazz.getAnnotation(annotationClass);
    }

    public static Annotation getAnnotation(Field field, Class annotationClass) {
        return field.getAnnotation(annotationClass);
    }
}
