package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzql  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzql extends RuntimeException {
    public static <T> T zza(zzqo<T> zzqo) {
        try {
            return zzqo.zza();
        } catch (Exception e) {
            throw new zzql((Throwable) e);
        }
    }

    public zzql(String str) {
        super(str);
    }

    public zzql(Throwable th) {
        super(th);
    }

    public zzql(String str, Throwable th) {
        super(str, th);
    }
}
