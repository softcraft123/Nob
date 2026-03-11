package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzo implements Callable {
    public final /* synthetic */ SplitInstallSessionState zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzo(SplitInstallSessionState splitInstallSessionState, int i) {
        this.zza = splitInstallSessionState;
        this.zzb = i;
    }

    public final Object call() {
        int status;
        SplitInstallSessionState splitInstallSessionState = this.zza;
        int i = this.zzb;
        int i2 = FakeSplitInstallManager.zza;
        if (splitInstallSessionState != null && i == splitInstallSessionState.sessionId() && ((status = splitInstallSessionState.status()) == 1 || status == 2 || status == 8 || status == 9 || status == 7)) {
            return SplitInstallSessionState.create(i, 7, splitInstallSessionState.errorCode(), splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
        }
        throw new SplitInstallException(-3);
    }
}
