package com.google.android.recaptcha.internal;

import java.io.IOException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public class zznn extends IOException {
    private boolean zza;

    public zznn(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zza;
    }

    public zznn(String str) {
        super(str);
    }
}
