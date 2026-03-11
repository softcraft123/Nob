package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzzp;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzzj<T_WRAPPER extends zzzp<JcePrimitiveT>, JcePrimitiveT> {
    public static final zzzj<zzzs, Cipher> zza = new zzzj<>(new zzzs());
    public static final zzzj<zzzw, Mac> zzb = new zzzj<>(new zzzw());
    public static final zzzj<zzzr, KeyAgreement> zzc = new zzzj<>(new zzzr());
    public static final zzzj<zzzt, KeyPairGenerator> zzd = new zzzj<>(new zzzt());
    public static final zzzj<zzzu, KeyFactory> zze = new zzzj<>(new zzzu());
    private final zzzn<JcePrimitiveT> zzf;

    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        return this.zzf.zza(str);
    }

    public static List<Provider> zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    static {
        new zzzj(new zzzy());
        new zzzj(new zzzv());
    }

    private zzzj(T_WRAPPER t_wrapper) {
        if (zziv.zzb()) {
            this.zzf = new zzzo(t_wrapper);
        } else if (zzaaf.zza()) {
            this.zzf = new zzzm(t_wrapper);
        } else {
            this.zzf = new zzzl(t_wrapper);
        }
    }
}
