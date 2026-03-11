package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.splitinstall.internal.zzv;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzaq extends zzv {
    final /* synthetic */ int zza;
    final /* synthetic */ TaskCompletionSource zzb;
    final /* synthetic */ zzbc zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaq(zzbc zzbc, TaskCompletionSource taskCompletionSource, int i, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzc = zzbc;
        this.zza = i;
        this.zzb = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.play.core.splitinstall.internal.zzbo, android.os.IInterface] */
    /* access modifiers changed from: protected */
    public final void zzc() {
        try {
            ? zze = this.zzc.zza.zze();
            zzbc zzbc = this.zzc;
            zze.zzh(zzbc.zzd, this.zza, new zzay(zzbc, this.zzb));
        } catch (RemoteException e) {
            zzbc.zzb.zzc(e, "getSessionState(%d)", Integer.valueOf(this.zza));
            this.zzb.trySetException(new RuntimeException(e));
        }
    }
}
