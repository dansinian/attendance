package com.wsh.servlet;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsChOrEnOrNum {
    @Test
    public static String  IsChOrNum(String content){
        String keyType = "";
        String regex = "^[\\u4e00-\\u9fa5_a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(content);
        boolean b = match.matches();
        if (b == true) {
            keyType = "chinese";
        } else {
            regex = "^[0-9]*$";
            pattern = Pattern.compile(regex);
            match = pattern.matcher(content);
            b = match.matches();
            if (b==true) {
                keyType = "number";
            } else {
                keyType = "english";
            }
        }
        return keyType;
    }
}
