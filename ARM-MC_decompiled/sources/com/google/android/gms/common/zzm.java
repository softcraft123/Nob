package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
abstract class zzm extends zzj {
    private static final WeakReference zzb = new WeakReference((Object) null);
    private WeakReference zza = zzb;

    zzm(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] zzb();

    /* access modifiers changed from: package-private */
    public final byte[] zzc() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zza.get();
            if (bArr == null) {
                bArr = zzb();
                this.zza = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
