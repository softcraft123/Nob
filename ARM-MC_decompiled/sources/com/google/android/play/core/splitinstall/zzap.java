package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.splitinstall.internal.zzv;
import java.util.List;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzap extends zzv {
    final /* synthetic */ List zza;
    final /* synthetic */ TaskCompletionSource zzb;
    final /* synthetic */ zzbc zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzap(zzbc zzbc, TaskCompletionSource taskCompletionSource, List list, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzc = zzbc;
        this.zza = list;
        this.zzb = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.play.core.splitinstall.internal.zzbo, android.os.IInterface] */
    /* access modifiers changed from: protected */
    public final void zzc() {
        try {
            this.zzc.zza.zze().zzf(this.zzc.zzd, zzbc.zzm(this.zza), zzbc.zzo(), new zzaw(this.zzc, this.zzb));
        } catch (RemoteException e) {
            zzbc.zzb.zzc(e, "deferredLanguageUninstall(%s)", this.zza);
            this.zzb.trySetException(new RuntimeException(e));
        }
    }
}
