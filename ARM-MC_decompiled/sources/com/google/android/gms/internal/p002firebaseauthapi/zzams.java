package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzams  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzams<T> implements zzanb<T> {
    private final zzamm zza;
    private final zzanu<?, ?> zzb;
    private final boolean zzc;
    private final zzakw<?> zzd;

    public final int zza(T t) {
        zzanu<?, ?> zzanu = this.zzb;
        int zzb2 = zzanu.zzb(zzanu.zzd(t));
        return this.zzc ? zzb2 + this.zzd.zza((Object) t).zza() : zzb2;
    }

    public final int zzb(T t) {
        int hashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    static <T> zzams<T> zza(zzanu<?, ?> zzanu, zzakw<?> zzakw, zzamm zzamm) {
        return new zzams<>(zzanu, zzakw, zzamm);
    }

    public final T zza() {
        zzamm zzamm = this.zza;
        if (zzamm instanceof zzalf) {
            return ((zzalf) zzamm).zzo();
        }
        return zzamm.zzq().zzf();
    }

    private zzams(zzanu<?, ?> zzanu, zzakw<?> zzakw, zzamm zzamm) {
        this.zzb = zzanu;
        this.zzc = zzakw.zza(zzamm);
        this.zzd = zzakw;
        this.zza = zzamm;
    }

    public final void zzd(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    public final void zza(T t, T t2) {
        zzand.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzand.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzanc zzanc, zzaku zzaku) throws IOException {
        boolean z;
        zzanu<?, ?> zzanu = this.zzb;
        zzakw<?> zzakw = this.zzd;
        Object zzc2 = zzanu.zzc(t);
        zzakx<?> zzb2 = zzakw.zzb(t);
        do {
            try {
                if (zzanc.zzc() == Integer.MAX_VALUE) {
                    zzanu.zzb((Object) t, zzc2);
                    return;
                }
                int zzd2 = zzanc.zzd();
                int i = 0;
                if (zzd2 == 11) {
                    Object obj = null;
                    zzajv zzajv = null;
                    while (zzanc.zzc() != Integer.MAX_VALUE) {
                        int zzd3 = zzanc.zzd();
                        if (zzd3 != 16) {
                            if (zzd3 != 26) {
                                if (zzd3 == 12 || !zzanc.zzt()) {
                                    break;
                                }
                            } else if (obj != null) {
                                zzakw.zza(zzanc, obj, zzaku, zzb2);
                            } else {
                                zzajv = zzanc.zzp();
                            }
                        } else {
                            i = zzanc.zzj();
                            obj = zzakw.zza(zzaku, this.zza, i);
                        }
                    }
                    if (zzanc.zzd() != 12) {
                        throw zzall.zzb();
                    } else if (zzajv != null) {
                        if (obj != null) {
                            zzakw.zza(zzajv, obj, zzaku, zzb2);
                        } else {
                            zzanu.zza(zzc2, i, zzajv);
                        }
                    }
                } else if ((zzd2 & 7) == 2) {
                    Object zza2 = zzakw.zza(zzaku, this.zza, zzd2 >>> 3);
                    if (zza2 != null) {
                        zzakw.zza(zzanc, zza2, zzaku, zzb2);
                    } else {
                        z = zzanu.zza(zzc2, zzanc, 0);
                        continue;
                    }
                } else {
                    z = zzanc.zzt();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzanu.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.google.android.gms.internal.firebase-auth-api.zzalf$zzf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.firebase-auth-api.zzalf$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.p002firebaseauthapi.zzaju r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.firebase-auth-api.zzalf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf) r0
            com.google.android.gms.internal.firebase-auth-api.zzanx r1 = r0.zzb
            com.google.android.gms.internal.firebase-auth-api.zzanx r2 = com.google.android.gms.internal.p002firebaseauthapi.zzanx.zzc()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.firebase-auth-api.zzanx r1 = com.google.android.gms.internal.p002firebaseauthapi.zzanx.zzd()
            r0.zzb = r1
        L_0x0011:
            r6 = r1
            com.google.android.gms.internal.firebase-auth-api.zzalf$zzd r10 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0019:
            if (r12 >= r13) goto L_0x00af
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r1 = 2
            if (r2 == r12) goto L_0x0054
            r12 = r2 & 7
            if (r12 != r1) goto L_0x004c
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r12 = r9.zzd
            com.google.android.gms.internal.firebase-auth-api.zzaku r0 = r14.zzd
            com.google.android.gms.internal.firebase-auth-api.zzamm r1 = r9.zza
            int r3 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r1, r3)
            r0 = r12
            com.google.android.gms.internal.firebase-auth-api.zzalf$zzf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanx) r6, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r7)
            goto L_0x0019
        L_0x0043:
            com.google.android.gms.internal.p002firebaseauthapi.zzamx.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            r3 = r11
            r5 = r13
            r7 = r14
            int r12 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r7)
            goto L_0x0019
        L_0x0054:
            r3 = r11
            r5 = r13
            r7 = r14
            r11 = 0
            r12 = r10
        L_0x0059:
            if (r4 >= r5) goto L_0x00a0
            int r13 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r3, r4, r7)
            int r14 = r7.zza
            int r2 = r14 >>> 3
            r4 = r14 & 7
            if (r2 == r1) goto L_0x0081
            r8 = 3
            if (r2 == r8) goto L_0x006b
            goto L_0x0097
        L_0x006b:
            if (r0 != 0) goto L_0x0078
            if (r4 != r1) goto L_0x0097
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(r3, r13, r7)
            java.lang.Object r12 = r7.zzc
            com.google.android.gms.internal.firebase-auth-api.zzajv r12 = (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r12
            goto L_0x0059
        L_0x0078:
            com.google.android.gms.internal.p002firebaseauthapi.zzamx.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x0081:
            if (r4 != 0) goto L_0x0097
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r3, r13, r7)
            int r11 = r7.zza
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r13 = r9.zzd
            com.google.android.gms.internal.firebase-auth-api.zzaku r14 = r7.zzd
            com.google.android.gms.internal.firebase-auth-api.zzamm r0 = r9.zza
            java.lang.Object r13 = r13.zza(r14, r0, r11)
            r0 = r13
            com.google.android.gms.internal.firebase-auth-api.zzalf$zzf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzf) r0
            goto L_0x0059
        L_0x0097:
            r2 = 12
            if (r14 == r2) goto L_0x00a1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((int) r14, (byte[]) r3, (int) r13, (int) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r7)
            goto L_0x0059
        L_0x00a0:
            r13 = r4
        L_0x00a1:
            if (r12 == 0) goto L_0x00a9
            int r11 = r11 << 3
            r11 = r11 | r1
            r6.zza((int) r11, (java.lang.Object) r12)
        L_0x00a9:
            r12 = r13
            r11 = r3
            r13 = r5
            r14 = r7
            goto L_0x0019
        L_0x00af:
            r5 = r13
            if (r12 != r5) goto L_0x00b3
            return
        L_0x00b3:
            com.google.android.gms.internal.firebase-auth-api.zzall r10 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzams.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzaju):void");
    }

    public final void zza(T t, zzaol zzaol) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzakz zzakz = (zzakz) next.getKey();
            if (zzakz.zzc() != zzaoj.MESSAGE || zzakz.zze() || zzakz.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzalp) {
                zzaol.zza(zzakz.zza(), (Object) ((zzalp) next).zza().zzb());
            } else {
                zzaol.zza(zzakz.zza(), next.getValue());
            }
        }
        zzanu<?, ?> zzanu = this.zzb;
        zzanu.zza(zzanu.zzd(t), zzaol);
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final boolean zze(T t) {
        return this.zzd.zza((Object) t).zzg();
    }
}
