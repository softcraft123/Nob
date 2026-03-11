package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabt implements zzafv<zzair> {
    private final /* synthetic */ zzaio zza;
    private final /* synthetic */ zzael zzb;

    zzabt(zzaar zzaar, zzaio zzaio, zzael zzael) {
        this.zza = zzaio;
        this.zzb = zzael;
        Objects.requireNonNull(zzaar);
    }

    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzair zzair = (zzair) obj;
        zzaio zzaio = this.zza;
        if (zzaio instanceof zzais) {
            this.zzb.zzb(zzair.zza());
        } else if (zzaio instanceof zzaiu) {
            this.zzb.zza(zzair);
        } else {
            throw new IllegalArgumentException("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was " + this.zza.getClass().getName() + ".");
        }
    }
}
