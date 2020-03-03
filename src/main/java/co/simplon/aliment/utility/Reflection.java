package co.simplon.aliment.utility;

import co.simplon.aliment.model.Aliment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflection {
    public static boolean isFieldName(Class c, String fieldName){
        for(Field f : c.getDeclaredFields()){
            if(f.getName().equals(fieldName)){
                return true;
            }
        }
        return false;
    }
}
