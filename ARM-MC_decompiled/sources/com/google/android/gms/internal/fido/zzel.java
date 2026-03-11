package com.google.android.gms.internal.fido;

import android.os.Build;
import android.util.Log;
import dalvik.system.VMStack;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzel extends zzeg {
    /* access modifiers changed from: private */
    public static final boolean zza = zza.zza();
    /* access modifiers changed from: private */
    public static final boolean zzb;
    private static final zzef zzc = new zzef() {
        public zzdj zza(Class<?> cls, int i) {
            return zzdj.zza;
        }

        public String zzb(Class cls) {
            StackTraceElement zza;
            if (zzel.zza) {
                try {
                    if (cls.equals(zzel.zzp())) {
                        return VMStack.getStackClass2().getName();
                    }
                } catch (Throwable unused) {
                }
            }
            if (!zzel.zzb || (zza = zzfj.zza(cls, 1)) == null) {
                return null;
            }
            return zza.getClassName();
        }
    };

    /* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
    final class zza {
        zza() {
        }

        static boolean zza() {
            return zzel.zzt();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        zzb = z;
        Class<Log> cls = Log.class;
    }

    static Class<?> zzp() {
        return VMStack.getStackClass2();
    }

    static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzt() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", new Class[0]);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public zzdp zze(String str) {
        return zzeo.zzb(str);
    }

    /* access modifiers changed from: protected */
    public zzef zzh() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public zzev zzj() {
        return zzep.zzb();
    }

    /* access modifiers changed from: protected */
    public String zzm() {
        return "platform: Android";
    }
}
