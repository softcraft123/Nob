package com.google.android.play.core.splitinstall.internal;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzbz implements zzcb, zzby {
    private static final Object zza = new Object();
    private volatile zzcb zzb;
    private volatile Object zzc = zza;

    private zzbz(zzcb zzcb) {
        this.zzb = zzcb;
    }

    public static zzby zzb(zzcb zzcb) {
        return zzcb instanceof zzby ? (zzby) zzcb : new zzbz(zzcb);
    }

    public static zzcb zzc(zzcb zzcb) {
        zzcb.getClass();
        return zzcb instanceof zzbz ? zzcb : new zzbz(zzcb);
    }

    public final Object zza() {
        Object obj;
        Object obj2 = this.zzc;
        Object obj3 = zza;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            obj = this.zzc;
            if (obj == obj3) {
                obj = this.zzb.zza();
                Object obj4 = this.zzc;
                if (obj4 != obj3) {
                    if (obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                }
                this.zzc = obj;
                this.zzb = null;
            }
        }
        return obj;
    }
}
