package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjf;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzjs {
    private static final zzaaj zza;
    private static final zzph<zzjf, zzqe> zzb = zzph.zza(new zzjr(), zzjf.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzja, zzqb> zzd = zznx.zza(new zzjt(), zzja.class, zzqb.class);
    private static final zznt<zzqb> zze;
    private static final Map<zzjf.zza, zzxz> zzf;
    private static final Map<zzxz, zzjf.zza> zzg;

    /* access modifiers changed from: private */
    public static zzja zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzup zza2 = zzup.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzja.zzc().zza(zzjf.zzc().zza(zza2.zzd().zzb()).zza(zza(zzqb.zzb())).zza()).zza(zzaal.zza(zza2.zzd().zzd(), zzch.zza(zzch))).zza(zzqb.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing AesSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
    }

    private static zzjf.zza zza(zzxz zzxz) throws GeneralSecurityException {
        Map<zzxz, zzjf.zza> map = zzg;
        if (map.containsKey(zzxz)) {
            return map.get(zzxz);
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzjf zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzus zza2 = zzus.zza(zzqe.zza().zze(), zzaku.zza());
                if (zza2.zzb() == 0) {
                    return zzjf.zzc().zza(zza2.zza()).zza(zza(zzqe.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzxz zza(zzjf.zza zza2) throws GeneralSecurityException {
        Map<zzjf.zza, zzxz> map = zzf;
        if (map.containsKey(zza2)) {
            return map.get(zza2);
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zza2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zza = zzb2;
        zzc = zzpd.zza(new zzju(), zzb2, zzqe.class);
        zze = zznt.zza(new zzjw(), zzb2, zzqb.class);
        HashMap hashMap = new HashMap();
        hashMap.put(zzjf.zza.zzc, zzxz.RAW);
        hashMap.put(zzjf.zza.zza, zzxz.TINK);
        hashMap.put(zzjf.zza.zzb, zzxz.CRUNCHY);
        zzf = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zzxz.class);
        enumMap.put(zzxz.RAW, zzjf.zza.zzc);
        enumMap.put(zzxz.TINK, zzjf.zza.zza);
        enumMap.put(zzxz.CRUNCHY, zzjf.zza.zzb);
        enumMap.put(zzxz.LEGACY, zzjf.zza.zzb);
        zzg = Collections.unmodifiableMap(enumMap);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
