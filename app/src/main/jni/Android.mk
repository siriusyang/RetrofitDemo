LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := NdkJniDemo
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	E:\StudioProjects\RetrofitDemo2\app\src\main\jni\StringUtils.c \

LOCAL_C_INCLUDES += E:\StudioProjects\RetrofitDemo2\app\src\main\jni
LOCAL_C_INCLUDES += E:\StudioProjects\RetrofitDemo2\app\src\Default\jni
LOCAL_C_INCLUDES += E:\StudioProjects\RetrofitDemo2\app\src\debug\jni
LOCAL_C_INCLUDES += E:\StudioProjects\RetrofitDemo2\app\src\DefaultDebug\jni

include $(BUILD_SHARED_LIBRARY)
