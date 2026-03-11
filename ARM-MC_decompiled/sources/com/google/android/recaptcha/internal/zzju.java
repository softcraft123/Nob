package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import java.io.Serializable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzju extends zzjv implements Serializable {
    final byte[] zza;

    public final int zzb() {
        return this.zza.length * 8;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(zzjv zzjv) {
        if (this.zza.length != zzjv.zze().length) {
            return false;
        }
        boolean z = true;
        int i = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i >= bArr.length) {
                return z;
            }
            z &= bArr[i] == zzjv.zze()[i];
            i++;
        }
    }

    public final byte[] zzd() {
        return (byte[]) this.zza.clone();
    }

    /* access modifiers changed from: package-private */
    public final byte[] zze() {
        return this.zza;
    }

    zzju(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final int zza() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (length >= 4) {
            return ((bArr[3] & 255) << Ascii.CAN) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << Ascii.DLE);
        }
        throw new IllegalStateException(zzji.zza("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
    }
}
