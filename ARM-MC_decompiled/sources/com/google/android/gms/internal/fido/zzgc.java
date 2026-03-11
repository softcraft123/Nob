package com.google.android.gms.internal.fido;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzgc extends zzge {
    final char[] zza;

    private zzgc(zzgb zzgb) {
        super(zzgb, (Character) null);
        this.zza = new char[512];
        zzbm.zzc(zzgb.zzf.length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzgb.zza(i >>> 4);
            this.zza[i | 256] = zzgb.zza(i & 15);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzgf zza(zzgb zzgb, @CheckForNull Character ch) {
        return new zzgc(zzgb);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzbm.zze(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = bArr[i3] & 255;
            appendable.append(this.zza[b]);
            appendable.append(this.zza[b | 256]);
        }
    }

    zzgc(String str, String str2) {
        this(new zzgb("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
