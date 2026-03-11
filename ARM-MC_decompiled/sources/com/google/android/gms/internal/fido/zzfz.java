package com.google.android.gms.internal.fido;

import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzfz extends zzfp {
    private final MessageDigest zza;
    private final int zzb;
    private boolean zzc;

    /* synthetic */ zzfz(MessageDigest messageDigest, int i, zzfy zzfy) {
        this.zza = messageDigest;
        this.zzb = i;
    }

    private final void zzd() {
        zzbm.zzf(!this.zzc, "Cannot re-use a Hasher after calling hash() on it");
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2) {
        zzd();
        this.zza.update(bArr, 0, i2);
    }

    public final zzft zzc() {
        zzd();
        this.zzc = true;
        int i = this.zzb;
        if (i == this.zza.getDigestLength()) {
            byte[] digest = this.zza.digest();
            int i2 = zzft.zzb;
            return new zzfs(digest);
        }
        byte[] copyOf = Arrays.copyOf(this.zza.digest(), i);
        int i3 = zzft.zzb;
        return new zzfs(copyOf);
    }
}
