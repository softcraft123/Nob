package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaas  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaas {
    private String zza;
    private List<zzahy> zzb;
    private zze zzc;

    public final zze zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final List<MultiFactorInfo> zzc() {
        return zzbk.zza(this.zzb);
    }

    public zzaas(String str, List<zzahy> list, zze zze) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zze;
    }
}
