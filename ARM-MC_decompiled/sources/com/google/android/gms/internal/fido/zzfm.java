package com.google.android.gms.internal.fido;

import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzfm implements Closeable {
    private static final ThreadLocal zza = new zzfl();
    private int zzb = 0;

    public static int zza() {
        return ((zzfm) zza.get()).zzb;
    }

    public final void close() {
        int i = this.zzb;
        if (i > 0) {
            this.zzb = i - 1;
            return;
        }
        throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
    }
}
