package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaad  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaad extends ThreadLocal<Mac> {
    private final /* synthetic */ zzaae zza;

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac zza2 = zzzj.zzb.zza(this.zza.zzc);
            zza2.init(this.zza.zzd);
            return zza2;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    zzaad(zzaae zzaae) {
        Objects.requireNonNull(zzaae);
        this.zza = zzaae;
    }
}
