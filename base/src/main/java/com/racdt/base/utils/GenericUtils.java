package com.racdt.base.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class GenericUtils {

    private GenericUtils(){
    }

    public static Class<?> getGenericType(Object obj) {
        Class<?> genericType = null;
        Type gnrcType = obj.getClass().getGenericSuperclass();
        if (gnrcType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) gnrcType;
            Type types[] = parameterizedType.getActualTypeArguments();

            if (types != null && types.length > 0) {
                Type type = types[0];//有多个泛型 就拿第一个
                if (type instanceof Class) {
                    genericType = (Class<?>) type;
                }
            }
        }
        return genericType;
    }


}
