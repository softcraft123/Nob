package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzx extends zzy {
    private final Callable zze;

    /* synthetic */ zzx(Callable callable, byte[] bArr) {
        super(false, 1, 5, (String) null, (Throwable) null, -1, (byte[]) null);
        this.zze = callable;
    }

    /* access modifiers changed from: package-private */
    public final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
