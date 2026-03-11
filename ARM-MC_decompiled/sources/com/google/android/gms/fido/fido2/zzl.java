package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fido.fido2.api.common.BrowserPublicKeyCredentialCreationOptions;
import com.google.android.gms.internal.fido.zzk;
import com.google.android.gms.internal.fido.zzn;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final /* synthetic */ class zzl implements RemoteCall {
    public final /* synthetic */ Fido2PrivilegedApiClient zza;
    public final /* synthetic */ BrowserPublicKeyCredentialCreationOptions zzb;

    public /* synthetic */ zzl(Fido2PrivilegedApiClient fido2PrivilegedApiClient, BrowserPublicKeyCredentialCreationOptions browserPublicKeyCredentialCreationOptions) {
        this.zza = fido2PrivilegedApiClient;
        this.zzb = browserPublicKeyCredentialCreationOptions;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzn) ((zzk) obj).getService()).zzd(new zzq(this.zza, (TaskCompletionSource) obj2), this.zzb);
    }
}
