package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.fido.zzk;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final /* synthetic */ class zzn implements RemoteCall {
    public final /* synthetic */ Fido2PrivilegedApiClient zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzn(Fido2PrivilegedApiClient fido2PrivilegedApiClient, String str) {
        this.zza = fido2PrivilegedApiClient;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        ((com.google.android.gms.internal.fido.zzn) ((zzk) obj).getService()).zzc(new zzv(this.zza, (TaskCompletionSource) obj2), this.zzb);
    }
}
