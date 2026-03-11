package com.google.android.gms.internal.fido;

import com.google.common.base.Ascii;
import java.io.IOException;
import javax.annotation.CheckForNull;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzgd extends zzge {
    private zzgd(zzgb zzgb, @CheckForNull Character ch) {
        super(zzgb, ch);
        zzbm.zzc(zzgb.zzf.length == 64);
    }

    /* access modifiers changed from: package-private */
    public final zzgf zza(zzgb zzgb, @CheckForNull Character ch) {
        return new zzgd(zzgb, ch);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzbm.zze(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            zzgb zzgb = this.zzb;
            byte b = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << Ascii.DLE) | (bArr[i3 + 2] & 255);
            appendable.append(zzgb.zza(b >>> Ascii.DC2));
            appendable.append(this.zzb.zza((b >>> Ascii.FF) & 63));
            appendable.append(this.zzb.zza((b >>> 6) & 63));
            appendable.append(this.zzb.zza(b & Utf8.REPLACEMENT_BYTE));
            i3 += 3;
        }
        if (i3 < i2) {
            zze(appendable, bArr, i3, i2 - i3);
        }
    }

    zzgd(String str, String str2, @CheckForNull Character ch) {
        this(new zzgb(str, str2.toCharArray()), ch);
    }
}
