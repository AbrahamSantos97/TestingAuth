package com.example.restexample.restexample.Utils;

import java.util.Objects;

import org.apache.logging.log4j.util.Strings;

public class ParsersFile {
    
    private ParsersFile(){}

    public static String parseObjectToString(Object object){
        return Objects.isNull(object)?Strings.EMPTY:object.toString();
    }

    public static Integer parseObjectToInteger(Object object){
        return Objects.isNull(object)?null:Integer.valueOf(object.toString());
    }

}
