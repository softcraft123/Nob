package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
class zzkg extends zzkh {
    final zzkd zza;
    @CheckForNull
    final Character zzb;

    zzkg(zzkd zzkd, @CheckForNull Character ch) {
        zzkd zzkd2 = zzkd;
        this.zza = zzkd;
        if (ch != null) {
            ch.charValue();
            if (zzkd.zzd('=')) {
                throw new IllegalArgumentException(zzji.zza("Padding character %s was already in alphabet", ch));
            }
        }
        this.zzb = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzkg) {
            zzkg zzkg = (zzkg) obj;
            if (!this.zza.equals(zzkg.zza) || !Objects.equals(this.zzb, zzkg.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzb;
        return Objects.hashCode(ch) ^ this.zza.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zza);
        if (8 % this.zza.zzb != 0) {
            if (this.zzb == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzb);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int zza(byte[] bArr, CharSequence charSequence) throws zzkf {
        zzkd zzkd;
        CharSequence zze = zze(charSequence);
        if (this.zza.zzc(zze.length())) {
            int i = 0;
            int i2 = 0;
            while (i < zze.length()) {
                long j = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    zzkd = this.zza;
                    if (i3 >= zzkd.zzc) {
                        break;
                    }
                    j <<= zzkd.zzb;
                    if (i + i3 < zze.length()) {
                        j |= (long) this.zza.zzb(zze.charAt(i4 + i));
                        i4++;
                    }
                    i3++;
                }
                int i5 = zzkd.zzd;
                int i6 = i4 * zzkd.zzb;
                int i7 = (i5 - 1) * 8;
                while (i7 >= (i5 * 8) - i6) {
                    bArr[i2] = (byte) ((int) ((j >>> i7) & 255));
                    i7 -= 8;
                    i2++;
                }
                i += this.zza.zzc;
            }
            return i2;
        }
        throw new zzkf("Invalid input length " + zze.length());
    }

    /* access modifiers changed from: package-private */
    public void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzjf.zzd(0, i2, bArr.length);
        while (i3 < i2) {
            zzf(appendable, bArr, i3, Math.min(this.zza.zzd, i2 - i3));
            i3 += this.zza.zzd;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        return (int) (((((long) this.zza.zzb) * ((long) i)) + 7) / 8);
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        zzkd zzkd = this.zza;
        return zzkd.zzc * zzkj.zza(i, zzkd.zzd, RoundingMode.CEILING);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzjf.zzd(i, i + i2, bArr.length);
        int i3 = 0;
        zzjf.zza(i2 <= this.zza.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & 255))) << 8;
        }
        int i5 = (i2 + 1) * 8;
        zzkd zzkd = this.zza;
        while (i3 < i2 * 8) {
            long j2 = j >>> ((i5 - zzkd.zzb) - i3);
            zzkd zzkd2 = this.zza;
            appendable.append(zzkd2.zza(((int) j2) & zzkd2.zza));
            i3 += this.zza.zzb;
        }
        if (this.zzb != null) {
            while (i3 < this.zza.zzd * 8) {
                this.zzb.charValue();
                appendable.append('=');
                i3 += this.zza.zzb;
            }
        }
    }

    zzkg(String str, String str2, @CheckForNull Character ch) {
        this(new zzkd(str, str2.toCharArray()), ch);
    }

    /* access modifiers changed from: package-private */
    public final CharSequence zze(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzb;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0 || charSequence.charAt(length) != '=') {
            }
            length--;
            break;
        } while (charSequence.charAt(length) != '=');
        return charSequence.subSequence(0, length + 1);
    }
}
