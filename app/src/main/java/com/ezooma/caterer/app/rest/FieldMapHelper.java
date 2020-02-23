package com.ezooma.caterer.app.rest;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by Gurvinder Rajpal on 28-02-2018.
 */

class FieldMapHelper {
    private HashMap<String, Object> mFieldsMap;

    public FieldMapHelper(Object classObject) {
        mFieldsMap = new HashMap<>();
        getSuperClass(classObject);
    }

    private void getSuperClass(Object classObject) {
        Class<?> aClass = classObject.getClass();
        HashMap<String, Object> fieldsMap = getParams(aClass, classObject);
        mFieldsMap.putAll(fieldsMap);
        Class<?> clazz = aClass.getSuperclass();
        while (clazz != null) {
            fieldsMap = getParams(clazz, classObject);
            mFieldsMap.putAll(fieldsMap);
            clazz = clazz.getSuperclass();
        }


    }

    private HashMap<String, Object> getParams(Class<?> clazz, Object classObject) {
        Field[] fields = clazz.getDeclaredFields();
        HashMap<String, Object> fieldsMap = new HashMap<>();

        for (Field a : fields) {
            a.setAccessible(true);
            Class<?> aa = a.getType();
            SerializedName annotation = a.getAnnotation(SerializedName.class);
            if (annotation != null) {
                Object o = null;
                try {
                    o = a.get(classObject);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (o != null)
                    fieldsMap.put(annotation.value(), o);
            }
        }
        return fieldsMap;
    }

    HashMap<String, Object> getFieldMap() {
        return mFieldsMap;
    }
}
