package com.google.android.gms.internal.fido;

import com.google.common.base.Ascii;
import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzfs extends zzft implements Serializable {
    final byte[] zza;

    zzfs(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final int zzb() {
        return this.zza.length * 8;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(zzft zzft) {
        if (this.zza.length != zzft.zze().length) {
            return false;
        }
        boolean z = true;
        int i = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i >= bArr.length) {
                return z;
            }
            z &= bArr[i] == zzft.zze()[i];
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

    public final int zza() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (length >= 4) {
            return ((bArr[3] & 255) << Ascii.CAN) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << Ascii.DLE);
        }
        throw new IllegalStateException(zzbo.zza("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
    }
}
