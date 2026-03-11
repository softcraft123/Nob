package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxh;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzbm implements zzob {
    private final List<zzbs> zza;
    private final zzok zzb;
    @Nullable
    private final zzbm zzc;

    public final int zza() {
        return this.zza.size();
    }

    private static zzbi zza(zzxh.zzb zzb2) throws GeneralSecurityException {
        zzqb zzb3 = zzb(zzb2);
        zzoz zza2 = zzoz.zza();
        zzch zza3 = zzch.zza();
        if (!zza2.zzb(zzb3)) {
            return new zzof(zzb3, zza3);
        }
        return zza2.zza(zzb3, zza3);
    }

    /* access modifiers changed from: private */
    public static zzbm zzb(zzbm zzbm) {
        zzok zzok = zzbm.zzb;
        if (zzok.zza()) {
            return zzbm;
        }
        zzbl zzbl = new zzbl(zzbm, zzok);
        ArrayList arrayList = new ArrayList(zzbm.zza.size());
        for (zzbs next : zzbm.zza) {
            zzbs zzbs = next;
            zzbs zzbs2 = zzbs;
            zzbs zzbs3 = zzbs2;
            arrayList.add(new zzbs(next.zzb, zzbs.zzc, zzbs2.zze, zzbs3.zzf, zzbs3.zzg, zzbl));
        }
        return new zzbm((List<zzbs>) arrayList, zzok, zzbm);
    }

    static final zzbm zza(zzxh zzxh) throws GeneralSecurityException {
        zzd(zzxh);
        return new zzbm(zzxh, zzc(zzxh), zzok.zza);
    }

    public static final zzbm zza(zzbj zzbj) throws GeneralSecurityException {
        return new zzbn().zza(new zzbq(zzbj.zza()).zzb().zza()).zza();
    }

    /* JADX WARNING: type inference failed for: r0v17, types: [com.google.android.gms.internal.firebase-auth-api.zzalf] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzbm zzb() throws java.security.GeneralSecurityException {
        /*
            r21 = this;
            r1 = r21
            com.google.android.gms.internal.firebase-auth-api.zzxh r2 = r1.zzd()
            com.google.android.gms.internal.firebase-auth-api.zzxh$zza r3 = com.google.android.gms.internal.p002firebaseauthapi.zzxh.zzc()
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.List<com.google.android.gms.internal.firebase-auth-api.zzbs> r0 = r1.zza
            int r0 = r0.size()
            r4.<init>(r0)
            java.util.List<com.google.android.gms.internal.firebase-auth-api.zzbs> r0 = r1.zza
            java.util.Iterator r5 = r0.iterator()
            r6 = 0
            r7 = r6
        L_0x001d:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00eb
            java.lang.Object r0 = r5.next()
            r8 = r0
            com.google.android.gms.internal.firebase-auth-api.zzbs r8 = (com.google.android.gms.internal.p002firebaseauthapi.zzbs) r8
            com.google.android.gms.internal.firebase-auth-api.zzbi r0 = r8.zzb()
            boolean r0 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzce
            if (r0 == 0) goto L_0x0062
            com.google.android.gms.internal.firebase-auth-api.zzbi r0 = r8.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzce r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzce) r0
            com.google.android.gms.internal.firebase-auth-api.zzbi r10 = r0.zzc()
            com.google.android.gms.internal.firebase-auth-api.zzbs r9 = new com.google.android.gms.internal.firebase-auth-api.zzbs
            com.google.android.gms.internal.firebase-auth-api.zzxc r11 = r8.zzc
            int r12 = r8.zza()
            boolean r13 = r8.zze()
            com.google.android.gms.internal.firebase-auth-api.zzbu r15 = com.google.android.gms.internal.p002firebaseauthapi.zzbs.zza
            r16 = 0
            r14 = 0
            r9.<init>(r10, r11, r12, r13, r14, r15)
            com.google.android.gms.internal.firebase-auth-api.zzxc r0 = r8.zzc
            int r8 = r8.zza()
            com.google.android.gms.internal.firebase-auth-api.zzxh$zzb r0 = zzb(r10, r0, r8)
            goto L_0x00d8
        L_0x0062:
            com.google.android.gms.internal.firebase-auth-api.zzxh$zzb r0 = r2.zza(r7)
            com.google.android.gms.internal.firebase-auth-api.zzwx r9 = r0.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwx$zzb r10 = r9.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwx$zzb r11 = com.google.android.gms.internal.p002firebaseauthapi.zzwx.zzb.ASYMMETRIC_PRIVATE
            if (r10 != r11) goto L_0x00e3
            java.lang.String r10 = r9.zzf()
            com.google.android.gms.internal.firebase-auth-api.zzajv r9 = r9.zze()
            com.google.android.gms.internal.firebase-auth-api.zzwx r9 = com.google.android.gms.internal.p002firebaseauthapi.zzci.zza(r10, r9)
            com.google.android.gms.internal.firebase-auth-api.zzalf$zzb r0 = r0.zzn()
            r10 = r0
            com.google.android.gms.internal.firebase-auth-api.zzalf$zzb r10 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzb) r10
            com.google.android.gms.internal.firebase-auth-api.zzxh$zzb$zza r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzxh.zzb.zza) r0
            com.google.android.gms.internal.firebase-auth-api.zzxh$zzb$zza r0 = r0.zza((com.google.android.gms.internal.p002firebaseauthapi.zzwx) r9)
            com.google.android.gms.internal.firebase-auth-api.zzamm r0 = r0.zze()
            com.google.android.gms.internal.firebase-auth-api.zzalf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf) r0
            r9 = r0
            com.google.android.gms.internal.firebase-auth-api.zzxh$zzb r9 = (com.google.android.gms.internal.p002firebaseauthapi.zzxh.zzb) r9
            r10 = 1
            com.google.android.gms.internal.firebase-auth-api.zzbi r0 = zza((com.google.android.gms.internal.p002firebaseauthapi.zzxh.zzb) r9)     // Catch:{ GeneralSecurityException -> 0x009d }
            r18 = r6
        L_0x009b:
            r14 = r0
            goto L_0x00b6
        L_0x009d:
            r0 = move-exception
            com.google.android.gms.internal.firebase-auth-api.zziw r11 = com.google.android.gms.internal.p002firebaseauthapi.zziu.zza
            boolean r11 = r11.zza()
            if (r11 != 0) goto L_0x00e2
            com.google.android.gms.internal.firebase-auth-api.zzof r0 = new com.google.android.gms.internal.firebase-auth-api.zzof
            com.google.android.gms.internal.firebase-auth-api.zzqb r11 = zzb((com.google.android.gms.internal.p002firebaseauthapi.zzxh.zzb) r9)
            com.google.android.gms.internal.firebase-auth-api.zzch r12 = com.google.android.gms.internal.p002firebaseauthapi.zzch.zza()
            r0.<init>(r11, r12)
            r18 = r10
            goto L_0x009b
        L_0x00b6:
            int r0 = r9.zza()
            com.google.android.gms.internal.firebase-auth-api.zzbs r13 = new com.google.android.gms.internal.firebase-auth-api.zzbs
            com.google.android.gms.internal.firebase-auth-api.zzxc r15 = r8.zzc
            int r8 = r2.zzb()
            if (r0 != r8) goto L_0x00c9
            r17 = r10
            goto L_0x00cb
        L_0x00c9:
            r17 = r6
        L_0x00cb:
            com.google.android.gms.internal.firebase-auth-api.zzbu r19 = com.google.android.gms.internal.p002firebaseauthapi.zzbs.zza
            r20 = 0
            r16 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19)
            r0 = r9
            r9 = r13
        L_0x00d8:
            r3.zza((com.google.android.gms.internal.p002firebaseauthapi.zzxh.zzb) r0)
            r4.add(r9)
            int r7 = r7 + 1
            goto L_0x001d
        L_0x00e2:
            throw r0
        L_0x00e3:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r2 = "The keyset contains a non-private key"
            r0.<init>(r2)
            throw r0
        L_0x00eb:
            int r0 = r2.zzb()
            r3.zza((int) r0)
            com.google.android.gms.internal.firebase-auth-api.zzbm r0 = new com.google.android.gms.internal.firebase-auth-api.zzbm
            com.google.android.gms.internal.firebase-auth-api.zzamm r2 = r3.zze()
            com.google.android.gms.internal.firebase-auth-api.zzalf r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf) r2
            com.google.android.gms.internal.firebase-auth-api.zzxh r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzxh) r2
            com.google.android.gms.internal.firebase-auth-api.zzok r3 = r1.zzb
            r0.<init>((com.google.android.gms.internal.p002firebaseauthapi.zzxh) r2, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzbs>) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzok) r3)
            com.google.android.gms.internal.firebase-auth-api.zzbm r0 = zzb((com.google.android.gms.internal.p002firebaseauthapi.zzbm) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbm.zzb():com.google.android.gms.internal.firebase-auth-api.zzbm");
    }

    private final zzbm zze() {
        zzbm zzbm = this.zzc;
        return zzbm == null ? this : zzbm;
    }

    @Deprecated
    public static final zzbm zza(zzbv zzbv, zzba zzba, byte[] bArr) throws GeneralSecurityException, IOException {
        zzvv zza2 = zzbv.zza();
        if (zza2 != null && zza2.zzc().zzb() != 0) {
            return zza(zza(zza2, zzba, bArr));
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final /* synthetic */ zzoa zza(int i) {
        if (i < 0 || i >= zza()) {
            throw new IndexOutOfBoundsException("Invalid index " + i + " for keyset of size " + zza());
        }
        zzbs zzbs = this.zza.get(i);
        if (!zza(zzbs.zzc)) {
            throw new IllegalStateException("Keyset-Entry at position " + i + " has wrong status");
        } else if (!zzbs.zzg) {
            return this.zza.get(i);
        } else {
            throw new IllegalStateException("Keyset-Entry at position " + i + " didn't parse correctly");
        }
    }

    public final /* synthetic */ zzoa zzc() {
        for (zzbs next : this.zza) {
            if (next != null && next.zze()) {
                if (next.zzc() == zzbk.zza) {
                    return next;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no valid primary");
    }

    private static zzqb zzb(zzxh.zzb zzb2) throws GeneralSecurityException {
        return zzqb.zza(zzb2.zzb().zzf(), zzb2.zzb().zze(), zzb2.zzb().zzb(), zzb2.zzf(), zzb2.zzf() == zzxz.RAW ? null : Integer.valueOf(zzb2.zza()));
    }

    static /* synthetic */ zzxc zza(zzbk zzbk) {
        if (zzbk.zza.equals(zzbk)) {
            return zzxc.ENABLED;
        }
        if (zzbk.zzb.equals(zzbk)) {
            return zzxc.DISABLED;
        }
        if (zzbk.zzc.equals(zzbk)) {
            return zzxc.DESTROYED;
        }
        throw new IllegalStateException("Unknown key status");
    }

    /* access modifiers changed from: private */
    public static zzxh.zzb zzb(zzbi zzbi, zzxc zzxc, int i) throws GeneralSecurityException {
        zzqb zzqb = (zzqb) zzoz.zza().zza(zzbi, zzqb.class, zzch.zza());
        Integer zze = zzqb.zze();
        if (zze == null || zze.intValue() == i) {
            return (zzxh.zzb) ((zzalf) zzxh.zzb.zzd().zza(zzwx.zza().zza(zzqb.zzf()).zza(zzqb.zzd()).zza(zzqb.zza())).zza(zzxc).zza(i).zza(zzqb.zzb()).zze());
        }
        throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
    }

    private static zzxh zza(zzvv zzvv, zzba zzba, byte[] bArr) throws GeneralSecurityException {
        try {
            zzxh zza2 = zzxh.zza(zzba.zza(zzvv.zzc().zzd(), bArr), zzaku.zza());
            zzd(zza2);
            return zza2;
        } catch (zzall unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* access modifiers changed from: package-private */
    public final zzxh zzd() {
        try {
            zzxh.zza zzc2 = zzxh.zzc();
            for (zzbs next : this.zza) {
                zzc2.zza(zzb(next.zzb(), next.zzc, next.zza()));
                if (next.zze()) {
                    zzc2.zza(next.zza());
                }
            }
            return (zzxh) ((zzalf) zzc2.zze());
        } catch (GeneralSecurityException e) {
            throw new zzql((Throwable) e);
        }
    }

    public final <P> P zza(zzbb zzbb, Class<P> cls) throws GeneralSecurityException {
        if (zzbb instanceof zznp) {
            zznp zznp = (zznp) zzbb;
            zzxh zzd = zze().zzd();
            zzcm.zzb(zzd);
            for (int i = 0; i < zza(); i++) {
                if (this.zza.get(i).zzg || !zza(this.zza.get(i).zzc)) {
                    throw new GeneralSecurityException("Key parsing of key with index " + i + " and type_url " + zzd.zza(i).zzb().zzf() + " failed, unable to get primitive");
                }
            }
            return zznp.zza(zze(), this.zzb, cls);
        }
        throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
    }

    public final String toString() {
        return zzcm.zza(zzd()).toString();
    }

    private static List<zzbs> zzc(zzxh zzxh) throws GeneralSecurityException {
        boolean z;
        zzbi zzbi;
        ArrayList arrayList = new ArrayList(zzxh.zza());
        for (zzxh.zzb next : zzxh.zze()) {
            int zza2 = next.zza();
            try {
                zzbi = zza(next);
                z = false;
            } catch (GeneralSecurityException e) {
                if (!zziu.zza.zza()) {
                    zzbi = new zzof(zzb(next), zzch.zza());
                    z = true;
                } else {
                    throw e;
                }
            }
            if (!zziu.zza.zza() || zza(next.zzc())) {
                arrayList.add(new zzbs(zzbi, next.zzc(), zza2, zza2 == zzxh.zzb(), z, zzbs.zza));
            } else {
                throw new GeneralSecurityException("Parsing of a single key failed (wrong status) and Tink is configured via validateKeysetsOnParsing to reject such keysets.");
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private zzbm(zzxh zzxh, List<zzbs> list, zzok zzok) throws GeneralSecurityException {
        this.zza = list;
        this.zzb = zzok;
        if (zziu.zza.zza()) {
            HashSet hashSet = new HashSet();
            for (zzxh.zzb next : zzxh.zze()) {
                if (!hashSet.contains(Integer.valueOf(next.zza()))) {
                    hashSet.add(Integer.valueOf(next.zza()));
                } else {
                    throw new GeneralSecurityException("KeyID " + next.zza() + " is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
                }
            }
            if (!hashSet.contains(Integer.valueOf(zzxh.zzb()))) {
                throw new GeneralSecurityException("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
            }
        }
        this.zzc = null;
    }

    private zzbm(List<zzbs> list, zzok zzok, zzbm zzbm) {
        this.zza = list;
        this.zzb = zzok;
        this.zzc = zzbm;
    }

    /* access modifiers changed from: private */
    public static void zzd(zzxh zzxh) throws GeneralSecurityException {
        if (zzxh == null || zzxh.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0012  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.p002firebaseauthapi.zzby r6) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r5 = this;
            com.google.android.gms.internal.firebase-auth-api.zzxh r0 = r5.zzd()
            java.util.List r1 = r0.zze()
            java.util.Iterator r1 = r1.iterator()
        L_0x000c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0061
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.firebase-auth-api.zzxh$zzb r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzxh.zzb) r2
            com.google.android.gms.internal.firebase-auth-api.zzwx r3 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwx$zzb r3 = r3.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwx$zzb r4 = com.google.android.gms.internal.p002firebaseauthapi.zzwx.zzb.UNKNOWN_KEYMATERIAL
            if (r3 == r4) goto L_0x003d
            com.google.android.gms.internal.firebase-auth-api.zzwx r3 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwx$zzb r3 = r3.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwx$zzb r4 = com.google.android.gms.internal.p002firebaseauthapi.zzwx.zzb.SYMMETRIC
            if (r3 == r4) goto L_0x003d
            com.google.android.gms.internal.firebase-auth-api.zzwx r3 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwx$zzb r3 = r3.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwx$zzb r4 = com.google.android.gms.internal.p002firebaseauthapi.zzwx.zzb.ASYMMETRIC_PRIVATE
            if (r3 == r4) goto L_0x003d
            goto L_0x000c
        L_0x003d:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException
            com.google.android.gms.internal.firebase-auth-api.zzwx r0 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwx$zzb r0 = r0.zzb()
            java.lang.String r0 = r0.name()
            com.google.android.gms.internal.firebase-auth-api.zzwx r1 = r2.zzb()
            java.lang.String r1 = r1.zzf()
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1}
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r6.<init>(r0)
            throw r6
        L_0x0061:
            r6.zza((com.google.android.gms.internal.p002firebaseauthapi.zzxh) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbm.zza(com.google.android.gms.internal.firebase-auth-api.zzby):void");
    }

    @Deprecated
    public final void zza(zzby zzby, zzba zzba, byte[] bArr) throws GeneralSecurityException, IOException {
        zzxh zzd = zzd();
        zzby.zza((zzvv) ((zzalf) zzvv.zza().zza(zzajv.zza(zzba.zzb(zzd.zzk(), bArr))).zza(zzcm.zza(zzd)).zze()));
    }

    private static boolean zza(zzxc zzxc) {
        int i = zzbo.zza[zzxc.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
