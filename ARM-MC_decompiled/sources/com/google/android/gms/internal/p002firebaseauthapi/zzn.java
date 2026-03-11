package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.regex.Matcher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzn extends zzm {
    private final Matcher zza;

    public final int zza() {
        return this.zza.end();
    }

    public final int zzb() {
        return this.zza.start();
    }

    zzn(Matcher matcher) {
        this.zza = (Matcher) zzu.zza(matcher);
    }

    public final boolean zza(int i) {
        return this.zza.find(i);
    }

    public final boolean zzc() {
        return this.zza.matches();
    }
}
