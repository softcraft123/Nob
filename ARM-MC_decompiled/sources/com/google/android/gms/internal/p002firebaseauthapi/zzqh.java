package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqh {
    /* access modifiers changed from: private */
    public final Map<zzqj, zznx<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<zzqk, zznt<?>> zzb;
    /* access modifiers changed from: private */
    public final Map<zzqj, zzph<?, ?>> zzc;
    /* access modifiers changed from: private */
    public final Map<zzqk, zzpd<?>> zzd;

    public final <SerializationT extends zzqf> zzqh zza(zznt<SerializationT> zznt) throws GeneralSecurityException {
        zzqk zzqk = new zzqk(zznt.zzb(), zznt.zza());
        if (this.zzb.containsKey(zzqk)) {
            zznt zznt2 = this.zzb.get(zzqk);
            if (zznt2.equals(zznt) && zznt.equals(zznt2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + String.valueOf(zzqk));
        }
        this.zzb.put(zzqk, zznt);
        return this;
    }

    public final <KeyT extends zzbi, SerializationT extends zzqf> zzqh zza(zznx<KeyT, SerializationT> zznx) throws GeneralSecurityException {
        zzqj zzqj = new zzqj(zznx.zza(), zznx.zzb());
        if (this.zza.containsKey(zzqj)) {
            zznx zznx2 = this.zza.get(zzqj);
            if (zznx2.equals(zznx) && zznx.equals(zznx2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + String.valueOf(zzqj));
        }
        this.zza.put(zzqj, zznx);
        return this;
    }

    public final <SerializationT extends zzqf> zzqh zza(zzpd<SerializationT> zzpd) throws GeneralSecurityException {
        zzqk zzqk = new zzqk(zzpd.zzb(), zzpd.zza());
        if (this.zzd.containsKey(zzqk)) {
            zzpd zzpd2 = this.zzd.get(zzqk);
            if (zzpd2.equals(zzpd) && zzpd.equals(zzpd2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + String.valueOf(zzqk));
        }
        this.zzd.put(zzqk, zzpd);
        return this;
    }

    public final <ParametersT extends zzcb, SerializationT extends zzqf> zzqh zza(zzph<ParametersT, SerializationT> zzph) throws GeneralSecurityException {
        zzqj zzqj = new zzqj(zzph.zza(), zzph.zzb());
        if (this.zzc.containsKey(zzqj)) {
            zzph zzph2 = this.zzc.get(zzqj);
            if (zzph2.equals(zzph) && zzph.equals(zzph2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + String.valueOf(zzqj));
        }
        this.zzc.put(zzqj, zzph);
        return this;
    }

    public final zzqi zza() {
        return new zzqi(this);
    }

    public zzqh() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public zzqh(zzqi zzqi) {
        this.zza = new HashMap(zzqi.zza);
        this.zzb = new HashMap(zzqi.zzb);
        this.zzc = new HashMap(zzqi.zzc);
        this.zzd = new HashMap(zzqi.zzd);
    }
}
