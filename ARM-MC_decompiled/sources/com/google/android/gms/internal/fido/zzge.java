package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
class zzge extends zzgf {
    @CheckForNull
    private volatile zzgf zza;
    final zzgb zzb;
    @CheckForNull
    final Character zzc;

    zzge(zzgb zzgb, @CheckForNull Character ch) {
        this.zzb = zzgb;
        if (ch != null) {
            ch.charValue();
            if (zzgb.zzc('=')) {
                throw new IllegalArgumentException(zzbo.zza("Padding character %s was already in alphabet", ch));
            }
        }
        this.zzc = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzge) {
            zzge zzge = (zzge) obj;
            if (!this.zzb.equals(zzge.zzb) || !Objects.equals(this.zzc, zzge.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return Objects.hashCode(ch) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public zzgf zza(zzgb zzgb, @CheckForNull Character ch) {
        return new zzge(zzgb, ch);
    }

    /* access modifiers changed from: package-private */
    public void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzbm.zze(0, i2, bArr.length);
        while (i3 < i2) {
            zze(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        zzgb zzgb = this.zzb;
        return zzgb.zzc * zzgh.zza(i, zzgb.zzd, RoundingMode.CEILING);
    }

    public final zzgf zzd() {
        zzgf zzgf = this.zza;
        if (zzgf == null) {
            zzgb zzgb = this.zzb;
            zzgb zzb2 = zzgb.zzb();
            if (zzb2 == zzgb) {
                zzgf = this;
            } else {
                zzgf = zza(zzb2, this.zzc);
            }
            this.zza = zzgf;
        }
        return zzgf;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzbm.zze(i, i + i2, bArr.length);
        int i3 = 0;
        zzbm.zzc(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & 255))) << 8;
        }
        int i5 = (i2 + 1) * 8;
        zzgb zzgb = this.zzb;
        while (i3 < i2 * 8) {
            long j2 = j >>> ((i5 - zzgb.zzb) - i3);
            zzgb zzgb2 = this.zzb;
            appendable.append(zzgb2.zza(((int) j2) & zzgb2.zza));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i3 += this.zzb.zzb;
            }
        }
    }

    zzge(String str, String str2, @CheckForNull Character ch) {
        this(new zzgb(str, str2.toCharArray()), ch);
    }
}
