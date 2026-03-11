package com.google.android.recaptcha.internal;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzbv implements Executor {
    public static final zzbv zza = new zzbv();

    private zzbv() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
