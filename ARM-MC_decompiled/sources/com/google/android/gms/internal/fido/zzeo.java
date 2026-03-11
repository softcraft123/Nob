package com.google.android.gms.internal.fido;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzeo extends zzei {
    static final boolean zza = (Build.FINGERPRINT == null || "robolectric".equals(Build.FINGERPRINT));
    static final boolean zzb = ("goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE));
    static final boolean zzc;
    private static final AtomicReference zzd = new AtomicReference();
    private static final AtomicLong zze = new AtomicLong();
    private static final ConcurrentLinkedQueue zzf = new ConcurrentLinkedQueue();
    private volatile zzdp zzg;

    static {
        boolean z = false;
        if ("eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE)) {
            z = true;
        }
        zzc = z;
    }

    private zzeo(String str) {
        super(str);
        if (zza || zzb) {
            this.zzg = new zzej().zza(zza());
        } else if (zzc) {
            this.zzg = zzeu.zzc().zzb(false).zza(zza());
        } else {
            this.zzg = null;
        }
    }

    public static zzdp zzb(String str) {
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzek) atomicReference.get()).zza(str);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char charAt = str.charAt(length);
                if (charAt != '$') {
                    if (charAt == '.') {
                        break;
                    }
                } else {
                    str = str.replace(Typography.dollar, '.');
                    break;
                }
            } else {
                break;
            }
        }
        zzeo zzeo = new zzeo(str);
        zzem.zza.offer(zzeo);
        if (zzd.get() != null) {
            while (true) {
                zzeo zzeo2 = (zzeo) zzem.zza.poll();
                if (zzeo2 == null) {
                    break;
                }
                zzeo2.zzg = ((zzek) zzd.get()).zza(zzeo2.zza());
            }
            if (((zzen) zzf.poll()) != null) {
                zze.getAndDecrement();
                throw null;
            }
        }
        return zzeo;
    }
}
