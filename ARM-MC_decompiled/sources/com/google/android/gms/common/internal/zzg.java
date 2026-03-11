package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class zzg extends zza {
    final /* synthetic */ BaseGmsClient zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzg(BaseGmsClient baseGmsClient, int i, Bundle bundle) {
        super(baseGmsClient, i, bundle);
        Objects.requireNonNull(baseGmsClient);
        this.zze = baseGmsClient;
    }

    /* access modifiers changed from: protected */
    public final boolean zza() {
        this.zze.zzc.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void zzb(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.zze;
        if (!baseGmsClient.enableLocalFallback() || !baseGmsClient.zzg()) {
            baseGmsClient.zzc.onReportServiceBinding(connectionResult);
            baseGmsClient.onConnectionFailed(connectionResult);
            return;
        }
        baseGmsClient.zzf(16);
    }
}
