package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.splitinstall.internal.zzn;
import com.google.android.play.core.splitinstall.internal.zzv;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzal extends zzv {
    final /* synthetic */ Collection zza;
    final /* synthetic */ Collection zzb;
    final /* synthetic */ zzn zzc;
    final /* synthetic */ TaskCompletionSource zzd;
    final /* synthetic */ zzbc zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzal(zzbc zzbc, TaskCompletionSource taskCompletionSource, Collection collection, Collection collection2, zzn zzn, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zze = zzbc;
        this.zza = collection;
        this.zzb = collection2;
        this.zzc = zzn;
        this.zzd = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [com.google.android.play.core.splitinstall.internal.zzbo, android.os.IInterface] */
    /* access modifiers changed from: protected */
    public final void zzc() {
        ArrayList zzn = zzbc.zzn(this.zza);
        zzn.addAll(zzbc.zzm(this.zzb));
        try {
            this.zzc.zzb(2);
            this.zze.zza.zze().zzj(this.zze.zzd, zzn, zzbc.zzb(this.zzc), new zzba(this.zze, this.zzd));
        } catch (RemoteException e) {
            zzbc.zzb.zzc(e, "startInstall(%s,%s)", this.zza, this.zzb);
            this.zzd.trySetException(new RuntimeException(e));
        }
    }
}
