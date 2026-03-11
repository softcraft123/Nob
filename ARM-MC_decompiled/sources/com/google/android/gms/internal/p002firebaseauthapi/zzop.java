package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzop  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzop {
    private static final zzor<zzoi> zza = new zzos();
    private static final zzop zzb = zzb();
    private final Map<Class<? extends zzcb>, zzor<? extends zzcb>> zzc = new HashMap();

    public final zzbi zza(zzcb zzcb, @Nullable Integer num) throws GeneralSecurityException {
        return zzb(zzcb, num);
    }

    private final synchronized <ParametersT extends zzcb> zzbi zzb(ParametersT parameterst, @Nullable Integer num) throws GeneralSecurityException {
        zzor zzor;
        zzor = this.zzc.get(parameterst.getClass());
        if (zzor != null) {
        } else {
            throw new GeneralSecurityException("Cannot create a new key for parameters " + String.valueOf(parameterst) + ": no key creator for this class was registered.");
        }
        return zzor.zza(parameterst, num);
    }

    public static /* synthetic */ zzof zza(zzoi zzoi, Integer num) {
        zzxb zza2 = zzoi.zzb().zza();
        zzbh<?> zza3 = zznq.zza().zza(zza2.zzf());
        if (zznq.zza().zzb(zza2.zzf())) {
            zzwx zza4 = zza3.zza(zza2.zze());
            return new zzof(zzqb.zza(zza4.zzf(), zza4.zze(), zza4.zzb(), zza2.zzd(), num), zzbf.zza());
        }
        throw new GeneralSecurityException("Creating new keys is not allowed.");
    }

    public static zzop zza() {
        return zzb;
    }

    private static zzop zzb() {
        zzop zzop = new zzop();
        try {
            zzop.zza(zza, zzoi.class);
            return zzop;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final synchronized <ParametersT extends zzcb> void zza(zzor<ParametersT> zzor, Class<ParametersT> cls) throws GeneralSecurityException {
        zzor zzor2 = this.zzc.get(cls);
        if (zzor2 != null) {
            if (!zzor2.equals(zzor)) {
                throw new GeneralSecurityException("Different key creator for parameters class " + String.valueOf(cls) + " already inserted");
            }
        }
        this.zzc.put(cls, zzor);
    }
}
