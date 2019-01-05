package com.example.yt.libiarymessage.Until;

import android.util.Log;
import android.widget.EditText;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyUntil {


    static public <T> T isEntry(Class<T> mycss, EditText... kong) throws Exception {
        Class<?> aClass = Class.forName(mycss.getName());
        Object o = aClass.newInstance();
        Field[] fields = aClass.getDeclaredFields();
        List<T> strings = new ArrayList<>();
        EditText[] a = kong;
        for (int i = 0; i < a.length; i++) {
            String mytetx = a[i].getText() + "";
            Field ts = fields[i];
            String name = ts.getName();
            String s = ts.getGenericType().toString();
            if (mytetx.equals("")) {
                return null;
            }
            if("class java.lang.String".equals(s)){
               Method method = aClass.getMethod("set" + getMethodName(name), String.class);
               method.setAccessible(false);
               method.invoke(o, mytetx);
                Log.i("MyMethod", method.getName());
           }else {
                Method method = aClass.getMethod("set" + getMethodName(name), Integer.class);
                method.setAccessible(false);
                method.invoke(o, Integer.valueOf(mytetx));
                Log.i("MyMethod", method.getName());
            }

        }
        return (T) o;
    }

    public static String getMethodName(String file) {
        String substring = file.substring(1, file.length());
        char c = file.charAt(0);
        char c1 = Character.toUpperCase(c);
        Log.i("Myresult", c1 + substring);
        return c1 + substring;

    }
}
