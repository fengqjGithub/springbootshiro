package com.zr.utils.common;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bootdo
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

    /**
     * 实体类对象转换成Map
     * @param obj
     * @return
     */
    public static Map<String, String> convertObjToMap(Object obj) {
        Map<String, String> reMap = new HashMap<String, String>();
        if (obj == null)
            return null;
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                try {
                    Field f = obj.getClass().getDeclaredField(
                            fields[i].getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(fields[i].getName(), o.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return reMap;
    }
}
