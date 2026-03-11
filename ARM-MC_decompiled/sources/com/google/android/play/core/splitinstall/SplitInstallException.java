package com.google.android.play.core.splitinstall;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.splitinstall.model.zza;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public class SplitInstallException extends ApiException {
    public SplitInstallException(int i) {
        super(new Status(i, String.format("Split Install Error(%d): %s", new Object[]{Integer.valueOf(i), zza.zzb(i)})));
        if (i == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
