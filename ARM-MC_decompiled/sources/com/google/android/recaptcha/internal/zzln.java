package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public abstract class zzln extends zzkw {
    private static final Logger zzb = Logger.getLogger(zzln.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzps.zzx();
    zzlo zza;

    private zzln() {
        throw null;
    }

    /* synthetic */ zzln(zzlm zzlm) {
    }

    public static int zzA(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzB(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    @Deprecated
    static int zzw(int i, zzoi zzoi, zzow zzow) {
        int zzA = zzA(i << 3);
        return zzA + zzA + ((zzko) zzoi).zza(zzow);
    }

    public static int zzx(zzoi zzoi) {
        int zzo = zzoi.zzo();
        return zzA(zzo) + zzo;
    }

    static int zzy(zzoi zzoi, zzow zzow) {
        int zza2 = ((zzko) zzoi).zza(zzow);
        return zzA(zza2) + zza2;
    }

    public static int zzz(String str) {
        int i;
        try {
            i = zzpv.zzc(str);
        } catch (zzpu unused) {
            i = str.getBytes(zznl.zza).length;
        }
        return zzA(i) + i;
    }

    public final void zzC() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzD(String str, zzpu zzpu) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzpu);
        byte[] bytes = str.getBytes(zznl.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzll(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b) throws IOException;

    public abstract void zzd(int i, boolean z) throws IOException;

    public abstract void zze(int i, zzle zzle) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(long j) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(byte[] bArr, int i, int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzm(int i, zzoi zzoi, zzow zzow) throws IOException;

    public abstract void zzn(int i, zzoi zzoi) throws IOException;

    public abstract void zzo(int i, zzle zzle) throws IOException;

    public abstract void zzp(int i, String str) throws IOException;

    public abstract void zzr(int i, int i2) throws IOException;

    public abstract void zzs(int i, int i2) throws IOException;

    public abstract void zzt(int i) throws IOException;

    public abstract void zzu(int i, long j) throws IOException;

    public abstract void zzv(long j) throws IOException;
}
