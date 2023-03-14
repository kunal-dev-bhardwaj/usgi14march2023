#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_universalsompo_meta_metaapp_motor_activities_GoogleMapPlacesActivity_getNativeKey1(JNIEnv *env, jobject instance) {

    return (*env)->  NewStringUTF(env, "AIzaSyAMiYAw5JRMFjD3H6erGvs-fXPo_WlZR4w");
}

JNIEXPORT jstring JNICALL
Java_com_universalsompo_meta_metaapp_health_activities_GoogleMapDoctorPlacesActivity_getNativeKey2(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, "AIzaSyAMiYAw5JRMFjD3H6erGvs-fXPo_WlZR4w");
}

JNIEXPORT jstring JNICALL
Java_com_universalsompo_meta_metaapp_motor_activities_YoutubeVideo_getNativeKey3(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, "AIzaSyCjW2heJ2O6Er44EjTZNEHfzo4mbNmk3c4");
}