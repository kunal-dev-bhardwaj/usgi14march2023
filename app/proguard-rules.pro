# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\Netcomm\AppData\Local\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
-keep class org.xmlpull.v1.** { *;}
-dontwarn org.xmlpull.v1.**
-dontwarn java.awt.**
-keepattributes Exceptions,InnerClasses,Signature,Deprecated, SourceFile,LineNumberTable,*Annotation*,EnclosingMethod

-keep class android.support.v7.widget.** { *; }
-keep class com.universalsompo.meta.metaapp.motor.models.**{ *;}
-keep class com.universalsompo.meta.metaapp.motor.mparser.**{ *;}
-keep class com.universalsompo.meta.metaapp.motor.databases.**{ *;}
-keep class com.universalsompo.meta.metaapp.motor.dialogs.**{ *;}
-keep class com.universalsompo.meta.metaapp.motor.constants.**{ *;}
-keep class com.universalsompo.meta.metaapp.motor.sharedpreferences.**{ *;}
-keep class com.universalsompo.meta.metaapp.utilities.**{ *;}

#### ----picasso---
-dontwarn com.squareup.picasso.**

#### ---circleImageview---
-dontwarn  de.hdodenhof.circleimageview.**

#### ---imagecompressor--
-dontwarn id.zelory.compressor.**

#### ---Apache Commons---

-dontwarn org.apache.commons.logging.**

#### ---showcase view---

-dontwarn smartdevelop.ir.eram.showcaseviewlib.**

#### ---volley---

-dontwarn com.mcxiaoke.volley.**

-dontwarn com.mcxiaoke.volley.error.**


-dontwarn com.nineoldandroids.**


-dontwarn com.daimajia.slider.**

-keep class butterknife.*
-keepclasseswithmembernames class * { @butterknife.* <methods>; }
-keepclasseswithmembernames class * { @butterknife.* <fields>; }

-dontwarn com.makeramen.**

-dontwarn com.theartofdev.edmodo.**

-dontwarn org.mockito.**


-dontwarn com.github.justzak.**

-dontwarn com.jpardogo.googleprogressbar.**

-dontwarn com.github.traex.rippleeffect.**

-dontwarn org.mockito.**

-dontwarn com.felipecsl.quickreturn.**

-dontwarn com.fatsecret4j.**

-dontwarn devs.mulham.horizontalcalendar.**

-dontwarn com.squareup.okhttp3.**

-dontwarn net.danlew.**

-dontwarn com.github.PhilJay.**

-dontwarn com.minimize.library.**

-dontwarn com.github.zurche.**

-dontwarn com.getbase.**

-dontwarn com.github.john990.**

-dontwarn me.itangqi.waveloadingview.**

-keep class mcalendarview.*
-keepclasseswithmembernames class * { @mcalendarview.* <methods>; }
-keepclasseswithmembernames class * { @mcalendarview.* <fields>; }


-dontwarn com.github.jakob-grabner.**

-dontwarn com.github.barteksc.**

-dontwarn com.github.bumptech.glide.**

-dontwarn me.pushy.**

-dontwarn com.github.zcweng.**


-dontwarn com.itextpdf.**

-dontwarn kotlin.Unit

-dontwarn com.facebook.**

-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson
-keep class com.universalsompo.meta.metaapp.motor.models.** { *; }
-keep class com.universalsompo.meta.metaapp.health.fragment.MyPolicyUSGI.Model.** { *; }
-keep class com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.** { *; }

##---------------End: proguard configuration for Gson  ----------