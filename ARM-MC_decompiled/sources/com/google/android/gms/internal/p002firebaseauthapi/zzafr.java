package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final /* synthetic */ class zzafr implements Runnable {
    private /* synthetic */ zzafo zza;
    private /* synthetic */ zzafq zzb;
    private /* synthetic */ TaskCompletionSource zzc;

    public /* synthetic */ zzafr(zzafo zzafo, zzafq zzafq, TaskCompletionSource taskCompletionSource) {
        this.zza = zzafo;
        this.zzb = zzafq;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        this.zzb.zza(this.zzc, this.zza.zza);
    }
}
