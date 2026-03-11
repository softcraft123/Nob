package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zznq {
    private static final Logger zza = Logger.getLogger(zznq.class.getName());
    private static final zznq zzb = new zznq();
    private ConcurrentMap<String, zzbh<?>> zzc = new ConcurrentHashMap();
    private ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();

    public final <P> zzbh<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zzbh<?> zzc2 = zzc(str);
        if (zzc2.zza().equals(cls)) {
            return zzc2;
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzc2.getClass());
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", which only supports: " + String.valueOf(zzc2.zza()));
    }

    private final synchronized zzbh<?> zzc(String str) throws GeneralSecurityException {
        if (this.zzc.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type " + str + ", see https://developers.google.com/tink/faq/registration_errors");
        }
        return (zzbh) this.zzc.get(str);
    }

    public final zzbh<?> zza(String str) throws GeneralSecurityException {
        return zzc(str);
    }

    public static zznq zza() {
        return zzb;
    }

    private final synchronized void zza(zzbh<?> zzbh, boolean z, boolean z2) throws GeneralSecurityException {
        String zzb2 = zzbh.zzb();
        if (z2 && this.zzd.containsKey(zzb2)) {
            if (!((Boolean) this.zzd.get(zzb2)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type " + zzb2);
            }
        }
        zzbh zzbh2 = (zzbh) this.zzc.get(zzb2);
        if (zzbh2 != null) {
            if (!zzbh2.getClass().equals(zzbh.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type " + zzb2);
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{zzb2, zzbh2.getClass().getName(), zzbh.getClass().getName()}));
            }
        }
        this.zzc.putIfAbsent(zzb2, zzbh);
        this.zzd.put(zzb2, Boolean.valueOf(z2));
    }

    public final synchronized <P> void zza(zzbh<P> zzbh, boolean z) throws GeneralSecurityException {
        zza(zzbh, zziv.zza.ALGORITHM_NOT_FIPS, z);
    }

    public final synchronized <P> void zza(zzbh<P> zzbh, zziv.zza zza2, boolean z) throws GeneralSecurityException {
        if (zza2.zza()) {
            zza((zzbh<?>) zzbh, false, z);
        } else {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
    }

    public final boolean zzb(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }
}
