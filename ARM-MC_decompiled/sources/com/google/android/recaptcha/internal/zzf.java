package com.google.android.recaptcha.internal;

import kotlinx.coroutines.TimeoutCancellationException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzf {
    public static final zzbd zza(Exception exc, zzbd zzbd) {
        if (exc instanceof TimeoutCancellationException) {
            return new zzbd(zzbb.zzb, zzba.zzb, exc.getMessage());
        }
        return exc instanceof zzbd ? (zzbd) exc : zzbd;
    }
}
