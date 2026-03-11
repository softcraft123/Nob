package com.google.android.play.core.splitcompat;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzc implements ThreadFactory {
    zzc() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
