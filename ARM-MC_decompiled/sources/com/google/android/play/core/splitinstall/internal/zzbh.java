package com.google.android.play.core.splitinstall.internal;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzbh extends RuntimeException {
    public zzbh(String str) {
        super(str);
    }

    public zzbh(String str, Throwable th) {
        super("Failed to initialize FileStorage", th);
    }
}
