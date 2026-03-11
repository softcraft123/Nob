package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.splitinstall.internal.zzv;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzas extends zzv {
    final /* synthetic */ int zza;
    final /* synthetic */ TaskCompletionSource zzb;
    final /* synthetic */ zzbc zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzas(zzbc zzbc, TaskCompletionSource taskCompletionSource, int i, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzc = zzbc;
        this.zza = i;
        this.zzb = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.play.core.splitinstall.internal.zzbo, android.os.IInterface] */
    /* access modifiers changed from: protected */
    public final void zzc() {
        try {
            this.zzc.zza.zze().zzc(this.zzc.zzd, this.zza, zzbc.zzo(), new zzat(this.zzc, this.zzb));
        } catch (RemoteException e) {
            zzbc.zzb.zzc(e, "cancelInstall(%d)", Integer.valueOf(this.zza));
            this.zzb.trySetException(new RuntimeException(e));
        }
    }
}
