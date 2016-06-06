//
// Created by sirius on 2016/6/6.
//

#include "com_siriusyang_retrofitdemo_navtivemeath_JniUtils.h"
 /*
  *Class:     com_siriusyang_retrofitdemo_navtivemeath_JniUtils
 * Method:    getStringFormC
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_siriusyang_retrofitdemo_navtivemeath_JniUtils_getStringFormC
        (JNIEnv *env, jobject obj){
    return (*env)->NewStringUTF(env, "这里是来自c的string");
}
