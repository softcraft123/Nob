package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import com.google.android.gms.internal.p002firebaseauthapi.zzvv;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzbc implements zzby {
    private final OutputStream zza;

    public static zzby zza(OutputStream outputStream) {
        return new zzbc(outputStream);
    }

    private zzbc(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public final void zza(zzvv zzvv) throws IOException {
        try {
            zzalf.zzb zzn = zzvv.zzn();
            zzalf.zzb zzb = zzn;
            ((zzvv) ((zzalf) ((zzvv.zza) zzn).zza().zze())).zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    public final void zza(zzxh zzxh) throws IOException {
        try {
            zzxh.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
