package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.internal.zzbx;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzk implements zzr {
    public final /* synthetic */ SplitInstallRequest zza;

    public /* synthetic */ zzk(SplitInstallRequest splitInstallRequest) {
        this.zza = splitInstallRequest;
    }

    public final SplitInstallSessionState zza(SplitInstallSessionState splitInstallSessionState) {
        return (SplitInstallSessionState) zzbx.zzc(new zzn(splitInstallSessionState, this.zza));
    }
}
