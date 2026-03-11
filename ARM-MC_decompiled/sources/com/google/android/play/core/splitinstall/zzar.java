package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.splitinstall.internal.zzv;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzar extends zzv {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzbc zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzar(zzbc zzbc, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzb = zzbc;
        this.zza = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.play.core.splitinstall.internal.zzbo, android.os.IInterface] */
    /* access modifiers changed from: protected */
    public final void zzc() {
        try {
            ? zze = this.zzb.zza.zze();
            zzbc zzbc = this.zzb;
            zze.zzi(zzbc.zzd, new zzaz(zzbc, this.zza));
        } catch (RemoteException e) {
            zzbc.zzb.zzc(e, "getSessionStates", new Object[0]);
            this.zza.trySetException(new RuntimeException(e));
        }
    }
}
