package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
class zzakg extends zzakd {
    protected final byte[] zzb;

    public byte zza(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: protected */
    public int zze() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        return zzalh.zza(i, this.zzb, zze(), i3);
    }

    public int zzb() {
        return this.zzb.length;
    }

    public final zzajv zza(int i, int i2) {
        int zza = zza(0, i2, zzb());
        if (zza == 0) {
            return zzajv.zza;
        }
        return new zzajz(this.zzb, zze(), zza);
    }

    public final zzakh zzc() {
        return zzakh.zza(this.zzb, zze(), zzb(), true);
    }

    zzakg(byte[] bArr) {
        super();
        bArr.getClass();
        this.zzb = bArr;
    }

    /* access modifiers changed from: protected */
    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzajw zzajw) throws IOException {
        zzajw.zza(this.zzb, zze(), zzb());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzajv) || zzb() != ((zzajv) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (!(obj instanceof zzakg)) {
            return obj.equals(this);
        }
        zzakg zzakg = (zzakg) obj;
        int zza = zza();
        int zza2 = zzakg.zza();
        if (zza == 0 || zza2 == 0 || zza == zza2) {
            return zza(zzakg, 0, zzb());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzajv zzajv, int i, int i2) {
        if (i2 > zzajv.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        } else if (i2 > zzajv.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzajv.zzb());
        } else if (!(zzajv instanceof zzakg)) {
            return zzajv.zza(0, i2).equals(zza(0, i2));
        } else {
            zzakg zzakg = (zzakg) zzajv;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzakg.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzakg.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }
}
