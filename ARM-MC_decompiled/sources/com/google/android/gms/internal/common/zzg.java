package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class zzg extends Handler {
    private final Looper zza = Looper.getMainLooper();

    public zzg() {
    }

    public zzg(Looper looper) {
        super(looper);
    }

    public zzg(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
