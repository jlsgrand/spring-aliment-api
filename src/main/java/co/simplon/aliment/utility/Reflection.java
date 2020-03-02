package co.simplon.aliment.utility;

import co.simplon.aliment.model.Aliment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflection {
    public static String fieldNameOrDefault(Class c, String fieldName, String defaultFieldName){
        for(Field f : c.getDeclaredFields()){
            if(f.getName().equals(fieldName)){
                return fieldName;
            }
        }
        return defaultFieldName;
    }
}
