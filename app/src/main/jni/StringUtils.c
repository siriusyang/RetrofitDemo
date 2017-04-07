//
// Created by sirius on 2016/6/6.
//
#include "com_siriusyang_retrofitdemo_navtivemeath_JniUtils.h"
 /*
  *Class:     com_siriusyang_retrofitdemo_navtivemeath_JniUtils
 * Method:    getStringFormC
 * Signature: ()Ljava/lang/String;
 */

/*
 * Class:     com_siriusyang_retrofitdemo_navtivemeath_JniUtils
 * Method:    getAddNumberFormC
 * Signature: (II)Ljava/lang/String;
 */
JNIEXPORT jint  JNICALL Java_com_siriusyang_retrofitdemo_navtivemeath_JniUtils_getAddNumberFormC
        (JNIEnv *env, jclass obj, jint i, jint b){
    return i+b;
}

JNIEXPORT jstring JNICALL
                 Java_com_siriusyang_retrofitdemo_navtivemeath_JniUtils_getStringFormC(JNIEnv *env,
                                                                                       jclass type)
{

    return (*env)->NewStringUTF(env, "这里是来自c的string");
}