package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzfm {
    private final Lazy zza = LazyKt.lazy(zzfl.zza);

    public zzfm() {
        int i = zzav.zza;
    }

    public final HttpURLConnection zza(String str) throws zzbd, MalformedURLException, IOException {
        if (((zzfk) this.zza.getValue()).zzb(str)) {
            URLConnection openConnection = new URL(str).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            return (HttpURLConnection) openConnection;
        }
        throw new zzbd(zzbb.zzc, zzba.zzQ, (String) null);
    }
}
