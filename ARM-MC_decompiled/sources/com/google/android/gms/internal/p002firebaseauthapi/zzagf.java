package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final /* synthetic */ class zzagf implements Runnable {
    private /* synthetic */ zzagc zza;
    private /* synthetic */ String zzb;

    public /* synthetic */ zzagf(zzagc zzagc, String str) {
        this.zza = zzagc;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zze(this.zzb);
    }
}
