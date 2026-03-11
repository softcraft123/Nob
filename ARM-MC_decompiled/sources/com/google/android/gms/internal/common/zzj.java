package com.google.android.gms.internal.common;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class zzj {
    public static Object zza(Class cls, String str, zzi... zziArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return zzc(cls, "isIsolated", (Object) null, false, zziArr);
    }

    public static Object zzb(String str, String str2, ClassLoader classLoader, zzi... zziArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        return zzc(classLoader.loadClass("com.google.android.gms.common.security.ProviderInstallerImpl"), "reportRequestStats2", (Object) null, false, zziArr);
    }

    private static Object zzc(Class cls, String str, Object obj, boolean z, zzi... zziArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int length = zziArr.length;
        Class[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i = 0; i < zziArr.length; i++) {
            zzi zzi = zziArr[i];
            zzi.getClass();
            clsArr[i] = zzi.zzc();
            objArr[i] = zziArr[i].zzd();
        }
        return cls.getDeclaredMethod(str, clsArr).invoke((Object) null, objArr);
    }
}
