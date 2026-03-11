package com.google.android.gms.fido.u2f;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fido.u2f.api.common.RegisterRequestParams;
import com.google.android.gms.internal.fido.zzw;
import com.google.android.gms.internal.fido.zzy;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final /* synthetic */ class zza implements RemoteCall {
    public final /* synthetic */ U2fApiClient zza;
    public final /* synthetic */ RegisterRequestParams zzb;

    public /* synthetic */ zza(U2fApiClient u2fApiClient, RegisterRequestParams registerRequestParams) {
        this.zza = u2fApiClient;
        this.zzb = registerRequestParams;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzw) ((zzy) obj).getService()).zzc(new zzc(this.zza, (TaskCompletionSource) obj2), this.zzb);
    }
}
