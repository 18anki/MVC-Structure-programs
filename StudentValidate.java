package com.ankita.erp.Validator;

public class StudentValidate {

    public static boolean isNullOrEmpty(String s) {
        return s==null || s.trim().equals("")?true:false;
    }
}
