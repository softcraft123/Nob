package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaz implements zzbv {
    private final InputStream zza;

    public static zzbv zza(byte[] bArr) {
        return new zzaz(new ByteArrayInputStream(bArr));
    }

    public final zzvv zza() throws IOException {
        try {
            return zzvv.zza(this.zza, zzaku.zza());
        } finally {
            this.zza.close();
        }
    }

    public final zzxh zzb() throws IOException {
        try {
            return zzxh.zza(this.zza, zzaku.zza());
        } finally {
            this.zza.close();
        }
    }

    private zzaz(InputStream inputStream) {
        this.zza = inputStream;
    }
}
