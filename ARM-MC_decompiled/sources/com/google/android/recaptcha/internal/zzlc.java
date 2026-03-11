package com.google.android.recaptcha.internal;

import java.io.IOException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
class zzlc extends zzlb {
    protected final byte[] zza;

    zzlc(byte[] bArr) {
        super((zzld) null);
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzle) || zzd() != ((zzle) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzlc)) {
            return obj.equals(this);
        }
        zzlc zzlc = (zzlc) obj;
        int zzj = zzj();
        int zzj2 = zzlc.zzj();
        if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzlc.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd > zzlc.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzlc.zzd());
        } else if (!(zzlc instanceof zzlc)) {
            return zzlc.zzg(0, zzd).equals(zzg(0, zzd));
        } else {
            zzlc zzlc2 = zzlc;
            byte[] bArr = this.zza;
            byte[] bArr2 = zzlc.zza;
            zzlc.zzc();
            int i = 0;
            int i2 = 0;
            while (i < zzd) {
                if (bArr[i] != bArr2[i2]) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        }
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: protected */
    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: protected */
    public final int zzf(int i, int i2, int i3) {
        return zznl.zzb(i, this.zza, 0, i3);
    }

    public final zzle zzg(int i, int i2) {
        int zzi = zzi(0, i2, zzd());
        if (zzi == 0) {
            return zzle.zzb;
        }
        return new zzkz(this.zza, 0, zzi);
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzkw zzkw) throws IOException {
        ((zzlk) zzkw).zzc(this.zza, 0, zzd());
    }
}
