package com.google.android.gms.fido.u2f;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fido.u2f.api.common.SignRequestParams;
import com.google.android.gms.internal.fido.zzw;
import com.google.android.gms.internal.fido.zzy;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final /* synthetic */ class zzb implements RemoteCall {
    public final /* synthetic */ U2fApiClient zza;
    public final /* synthetic */ SignRequestParams zzb;

    public /* synthetic */ zzb(U2fApiClient u2fApiClient, SignRequestParams signRequestParams) {
        this.zza = u2fApiClient;
        this.zzb = signRequestParams;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzw) ((zzy) obj).getService()).zzd(new zzd(this.zza, (TaskCompletionSource) obj2), this.zzb);
    }
}
