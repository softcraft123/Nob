package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.os.Build;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.play.core.splitinstall.internal.zzu;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public class SplitInstallHelper {
    private static final zzu zza = new zzu("SplitInstallHelper");

    private SplitInstallHelper() {
    }

    public static void loadLibrary(Context context, String str) throws UnsatisfiedLinkError {
        synchronized (zzn.class) {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e) {
                String str2 = context.getApplicationInfo().nativeLibraryDir + DomExceptionUtils.SEPARATOR + System.mapLibraryName(str);
                if (new File(str2).exists()) {
                    System.load(str2);
                } else {
                    throw e;
                }
            }
        }
    }

    public static void updateAppInfo(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            zzu zzu = zza;
            zzu.zzd("Calling dispatchPackageBroadcast", new Object[0]);
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method method = cls.getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke((Object) null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mAppThread");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                obj.getClass().getMethod("dispatchPackageBroadcast", new Class[]{Integer.TYPE, String[].class}).invoke(obj, new Object[]{3, new String[]{context.getPackageName()}});
                zzu.zzd("Called dispatchPackageBroadcast", new Object[0]);
            } catch (Exception e) {
                zza.zzc(e, "Update app info with dispatchPackageBroadcast failed!", new Object[0]);
            }
        }
    }
}
