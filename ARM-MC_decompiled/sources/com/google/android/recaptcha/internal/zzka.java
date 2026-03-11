package com.google.android.recaptcha.internal;

import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzka extends zzjr {
    private final MessageDigest zza;
    private final int zzb;
    private boolean zzc;

    /* synthetic */ zzka(MessageDigest messageDigest, int i, zzkb zzkb) {
        this.zza = messageDigest;
        this.zzb = i;
    }

    private final void zzc() {
        zzjf.zze(!this.zzc, "Cannot re-use a Hasher after calling hash() on it");
    }

    /* access modifiers changed from: protected */
    public final void zza(byte[] bArr, int i, int i2) {
        zzc();
        this.zza.update(bArr, 0, i2);
    }

    public final zzjv zzb() {
        zzc();
        this.zzc = true;
        int i = this.zzb;
        if (i == this.zza.getDigestLength()) {
            byte[] digest = this.zza.digest();
            int i2 = zzjv.zzb;
            return new zzju(digest);
        }
        byte[] copyOf = Arrays.copyOf(this.zza.digest(), i);
        int i3 = zzjv.zzb;
        return new zzju(copyOf);
    }
}
