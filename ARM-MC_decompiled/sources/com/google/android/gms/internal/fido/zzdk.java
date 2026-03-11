package com.google.android.gms.internal.fido;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class zzdk {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    protected zzdk(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }

    public static zzdk zza(String str, Class cls) {
        return new zzdk(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        String name = getClass().getName();
        String name2 = cls.getName();
        return name + DomExceptionUtils.SEPARATOR + this.zza + "[" + name2 + "]";
    }

    public final boolean zzb() {
        return this.zzc;
    }

    private zzdk(String str, Class cls, boolean z, boolean z2) {
        zzfk.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        System.identityHashCode(this);
        for (int i = 0; i < 5; i++) {
        }
    }
}
