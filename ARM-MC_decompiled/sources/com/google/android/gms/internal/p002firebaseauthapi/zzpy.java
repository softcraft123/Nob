package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzpy {
    /* access modifiers changed from: private */
    public final Map<zzpx, zzps<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<Class<?>, zzpz<?, ?>> zzb;

    public final <KeyT extends zzbi, PrimitiveT> zzpy zza(zzps<KeyT, PrimitiveT> zzps) throws GeneralSecurityException {
        if (zzps != null) {
            zzpx zzpx = new zzpx(zzps.zza(), zzps.zzb());
            if (this.zza.containsKey(zzpx)) {
                zzps zzps2 = this.zza.get(zzpx);
                if (zzps2.equals(zzps) && zzps.equals(zzps2)) {
                    return this;
                }
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + String.valueOf(zzpx));
            }
            this.zza.put(zzpx, zzps);
            return this;
        }
        throw new NullPointerException("primitive constructor must be non-null");
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> zzpy zza(zzpz<InputPrimitiveT, WrapperPrimitiveT> zzpz) throws GeneralSecurityException {
        if (zzpz != null) {
            Class<WrapperPrimitiveT> zzb2 = zzpz.zzb();
            if (this.zzb.containsKey(zzb2)) {
                zzpz zzpz2 = this.zzb.get(zzb2);
                if (zzpz2.equals(zzpz) && zzpz.equals(zzpz2)) {
                    return this;
                }
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + String.valueOf(zzb2));
            }
            this.zzb.put(zzb2, zzpz);
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    public final zzpw zza() {
        return new zzpw(this);
    }

    private zzpy() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    private zzpy(zzpw zzpw) {
        this.zza = new HashMap(zzpw.zza);
        this.zzb = new HashMap(zzpw.zzb);
    }
}
