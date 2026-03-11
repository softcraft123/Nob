package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
abstract class zzhu {
    int[] zza;
    private final int zzb;

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public final ByteBuffer zza(byte[] bArr, int i) {
        int[] zza2 = zza(zzhp.zza(bArr), i);
        int[] iArr = (int[]) zza2.clone();
        zzhp.zza(iArr);
        for (int i2 = 0; i2 < zza2.length; i2++) {
            zza2[i2] = zza2[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zza2, 0, 16);
        return order;
    }

    /* access modifiers changed from: package-private */
    public abstract int[] zza(int[] iArr, int i);

    public zzhu(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zza = zzhp.zza(bArr);
            this.zzb = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= bArr2.length) {
            zza(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    private final void zza(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length == zza()) {
            int remaining = byteBuffer2.remaining();
            int i = remaining / 64;
            int i2 = i + 1;
            for (int i3 = 0; i3 < i2; i3++) {
                ByteBuffer zza2 = zza(bArr, this.zzb + i3);
                if (i3 == i) {
                    zzyz.zza(byteBuffer, byteBuffer2, zza2, remaining % 64);
                } else {
                    zzyz.zza(byteBuffer, byteBuffer2, zza2, 64);
                }
            }
            return;
        }
        throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza());
    }

    public byte[] zza(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        zza(bArr, allocate, byteBuffer);
        return allocate.array();
    }
}
