package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzzb implements zzbd {
    private final ECPrivateKey zza;
    private final zzzd zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzzh zze;
    private final zzlr zzf;
    private final byte[] zzg;

    public static zzbd zza(zzke zzke) throws GeneralSecurityException {
        ECPrivateKey zza2 = zzzf.zza(zzze.zza.zza(((zzkb) ((zzlg) zzke.zza())).zzd()), zzne.zza(zzke.zzf().zza(zzbf.zza())));
        byte[] bArr = new byte[0];
        if (((zzkb) ((zzlg) zzke.zza())).zzh() != null) {
            bArr = ((zzkb) ((zzlg) zzke.zza())).zzh().zzb();
        }
        return new zzzb(zza2, bArr, zzze.zza(((zzkb) ((zzlg) zzke.zza())).zze()), zzze.zzb.zza(((zzkb) ((zzlg) zzke.zza())).zzf()), zzln.zza((zzkb) ((zzlg) zzke.zza())), zzke.zzh().zzb());
    }

    private zzzb(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzzh zzzh, zzlr zzlr, byte[] bArr2) {
        this.zza = eCPrivateKey;
        this.zzb = new zzzd(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzzh;
        this.zzf = zzlr;
        this.zzg = bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(byte[] r11, byte[] r12) throws java.security.GeneralSecurityException {
        /*
            r10 = this;
            byte[] r0 = r10.zzg
            boolean r0 = com.google.android.gms.internal.p002firebaseauthapi.zzqn.zza(r0, r11)
            if (r0 == 0) goto L_0x005d
            byte[] r0 = r10.zzg
            int r0 = r0.length
            java.security.interfaces.ECPrivateKey r1 = r10.zza
            java.security.spec.ECParameterSpec r1 = r1.getParams()
            java.security.spec.EllipticCurve r1 = r1.getCurve()
            com.google.android.gms.internal.firebase-auth-api.zzzh r2 = r10.zze
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzzf.zza((java.security.spec.EllipticCurve) r1)
            int r2 = r2.ordinal()
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x0029
            int r1 = r1 * r3
            goto L_0x0033
        L_0x0029:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "unknown EC point format"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            int r1 = r1 * r3
        L_0x0032:
            int r1 = r1 + r4
        L_0x0033:
            int r2 = r11.length
            int r1 = r1 + r0
            if (r2 < r1) goto L_0x0055
            byte[] r4 = java.util.Arrays.copyOfRange(r11, r0, r1)
            com.google.android.gms.internal.firebase-auth-api.zzzd r3 = r10.zzb
            java.lang.String r5 = r10.zzc
            byte[] r6 = r10.zzd
            com.google.android.gms.internal.firebase-auth-api.zzlr r0 = r10.zzf
            int r8 = r0.zza()
            com.google.android.gms.internal.firebase-auth-api.zzzh r9 = r10.zze
            r7 = r12
            byte[] r12 = r3.zza(r4, r5, r6, r7, r8, r9)
            com.google.android.gms.internal.firebase-auth-api.zzlr r0 = r10.zzf
            byte[] r11 = r0.zza(r12, r11, r1)
            return r11
        L_0x0055:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "ciphertext too short"
            r11.<init>(r12)
            throw r11
        L_0x005d:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "Invalid ciphertext (output prefix mismatch)"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzzb.zza(byte[], byte[]):byte[]");
    }
}
