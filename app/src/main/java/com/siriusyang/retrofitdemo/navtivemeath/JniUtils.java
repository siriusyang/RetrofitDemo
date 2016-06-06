package com.siriusyang.retrofitdemo.navtivemeath;

/**
 * Created by jack on 2016/6/6.
 *
 * http://www.open-open.com/lib/view/open1451917048573.html
 */
public class JniUtils {
    public static native String getStringFormC();
    static {
        System.loadLibrary("NdkJniDemo");//之前在build.gradle里面设置的so名字，必须一致
    }
}
