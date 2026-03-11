package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzamq<T> implements zzanb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzanz.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzamm zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzamu zzn;
    private final zzalw zzo;
    private final zzanu<?, ?> zzp;
    private final zzakw<?> zzq;
    private final zzamf zzr;

    private static <T> double zza(T t, long j) {
        return ((Double) zzanz.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzanz.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zzaog zzaog, Class<?> cls, zzaju zzaju) throws IOException {
        switch (zzamp.zza[zzaog.ordinal()]) {
            case 1:
                int zzd2 = zzajr.zzd(bArr, i, zzaju);
                zzaju.zzc = Boolean.valueOf(zzaju.zzb != 0);
                return zzd2;
            case 2:
                return zzajr.zza(bArr, i, zzaju);
            case 3:
                zzaju.zzc = Double.valueOf(zzajr.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzaju.zzc = Integer.valueOf(zzajr.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzaju.zzc = Long.valueOf(zzajr.zzd(bArr, i));
                return i + 8;
            case 8:
                zzaju.zzc = Float.valueOf(zzajr.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zzc2 = zzajr.zzc(bArr, i, zzaju);
                zzaju.zzc = Integer.valueOf(zzaju.zza);
                return zzc2;
            case 12:
            case 13:
                int zzd3 = zzajr.zzd(bArr, i, zzaju);
                zzaju.zzc = Long.valueOf(zzaju.zzb);
                return zzd3;
            case 14:
                return zzajr.zza(zzamx.zza().zza(cls), bArr, i, i2, zzaju);
            case 15:
                int zzc3 = zzajr.zzc(bArr, i, zzaju);
                zzaju.zzc = Integer.valueOf(zzakh.zza(zzaju.zza));
                return zzc3;
            case 16:
                int zzd4 = zzajr.zzd(bArr, i, zzaju);
                zzaju.zzc = Long.valueOf(zzakh.zza(zzaju.zzb));
                return zzd4;
            case 17:
                return zzajr.zzb(bArr, i, zzaju);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02c5, code lost:
        r9 = r16 + ((r8 + r9) + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0390, code lost:
        r9 = r16 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x04a1, code lost:
        r9 = r16 + r0;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x04a6, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04b5, code lost:
        r9 = r16 + r0;
        r0 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04bc, code lost:
        r0 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04d0, code lost:
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x04d2, code lost:
        r2 = r2 + 3;
        r8 = 1048575;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            sun.misc.Unsafe r6 = zzb
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r7
            r4 = r2
            r9 = r4
            r3 = r8
        L_0x000e:
            int[] r5 = r0.zzc
            int r5 = r5.length
            if (r2 >= r5) goto L_0x04d9
            int r5 = r0.zzc((int) r2)
            r10 = 267386880(0xff00000, float:2.3665827E-29)
            r10 = r10 & r5
            int r10 = r10 >>> 20
            int[] r11 = r0.zzc
            r12 = r11[r2]
            int r13 = r2 + 2
            r11 = r11[r13]
            r13 = r11 & r8
            r14 = 17
            r15 = 1
            if (r10 > r14) goto L_0x003d
            if (r13 == r3) goto L_0x0038
            if (r13 != r8) goto L_0x0031
            r3 = r7
            goto L_0x0036
        L_0x0031:
            long r3 = (long) r13
            int r3 = r6.getInt(r1, r3)
        L_0x0036:
            r4 = r3
            r3 = r13
        L_0x0038:
            int r11 = r11 >>> 20
            int r11 = r15 << r11
            goto L_0x003e
        L_0x003d:
            r11 = r7
        L_0x003e:
            r5 = r5 & r8
            long r13 = (long) r5
            com.google.android.gms.internal.firebase-auth-api.zzalc r5 = com.google.android.gms.internal.p002firebaseauthapi.zzalc.DOUBLE_LIST_PACKED
            int r5 = r5.zza()
            if (r10 < r5) goto L_0x004e
            com.google.android.gms.internal.firebase-auth-api.zzalc r5 = com.google.android.gms.internal.p002firebaseauthapi.zzalc.SINT64_LIST_PACKED
            int r5 = r5.zza()
        L_0x004e:
            r5 = 0
            r16 = r9
            r8 = 0
            switch(r10) {
                case 0: goto L_0x04c1;
                case 1: goto L_0x04a9;
                case 2: goto L_0x0492;
                case 3: goto L_0x0482;
                case 4: goto L_0x0472;
                case 5: goto L_0x0466;
                case 6: goto L_0x045a;
                case 7: goto L_0x044d;
                case 8: goto L_0x0430;
                case 9: goto L_0x041b;
                case 10: goto L_0x0408;
                case 11: goto L_0x03f7;
                case 12: goto L_0x03e6;
                case 13: goto L_0x03d9;
                case 14: goto L_0x03cc;
                case 15: goto L_0x03bb;
                case 16: goto L_0x03aa;
                case 17: goto L_0x0394;
                case 18: goto L_0x0386;
                case 19: goto L_0x037b;
                case 20: goto L_0x0370;
                case 21: goto L_0x0365;
                case 22: goto L_0x035a;
                case 23: goto L_0x034f;
                case 24: goto L_0x0344;
                case 25: goto L_0x0339;
                case 26: goto L_0x032e;
                case 27: goto L_0x031f;
                case 28: goto L_0x0313;
                case 29: goto L_0x0307;
                case 30: goto L_0x02fb;
                case 31: goto L_0x02ef;
                case 32: goto L_0x02e3;
                case 33: goto L_0x02d7;
                case 34: goto L_0x02cb;
                case 35: goto L_0x02b1;
                case 36: goto L_0x029c;
                case 37: goto L_0x0287;
                case 38: goto L_0x0272;
                case 39: goto L_0x025d;
                case 40: goto L_0x0248;
                case 41: goto L_0x0232;
                case 42: goto L_0x021c;
                case 43: goto L_0x0206;
                case 44: goto L_0x01f0;
                case 45: goto L_0x01da;
                case 46: goto L_0x01c4;
                case 47: goto L_0x01ae;
                case 48: goto L_0x0198;
                case 49: goto L_0x0188;
                case 50: goto L_0x0178;
                case 51: goto L_0x016a;
                case 52: goto L_0x015e;
                case 53: goto L_0x014e;
                case 54: goto L_0x013e;
                case 55: goto L_0x012e;
                case 56: goto L_0x0122;
                case 57: goto L_0x0116;
                case 58: goto L_0x010a;
                case 59: goto L_0x00ec;
                case 60: goto L_0x00d8;
                case 61: goto L_0x00c6;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a6;
                case 64: goto L_0x009a;
                case 65: goto L_0x008e;
                case 66: goto L_0x007e;
                case 67: goto L_0x006e;
                case 68: goto L_0x0058;
                default: goto L_0x0056;
            }
        L_0x0056:
            goto L_0x04d0
        L_0x0058:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzamm r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzamm) r5
            com.google.android.gms.internal.firebase-auth-api.zzanb r8 = r0.zze((int) r2)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzamm) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x0390
        L_0x006e:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            long r8 = zzd(r1, r13)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzd((int) r12, (long) r8)
            goto L_0x0390
        L_0x007e:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            int r5 = zzc(r1, (long) r13)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zze((int) r12, (int) r5)
            goto L_0x0390
        L_0x008e:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzc((int) r12, (long) r8)
            goto L_0x0390
        L_0x009a:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzd((int) r12, (int) r7)
            goto L_0x0390
        L_0x00a6:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            int r5 = zzc(r1, (long) r13)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (int) r5)
            goto L_0x0390
        L_0x00b6:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            int r5 = zzc(r1, (long) r13)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzf((int) r12, (int) r5)
            goto L_0x0390
        L_0x00c6:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzajv r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5)
            goto L_0x0390
        L_0x00d8:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzanb r8 = r0.zze((int) r2)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb<?>) r8)
            goto L_0x0390
        L_0x00ec:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            java.lang.Object r5 = r6.getObject(r1, r13)
            boolean r8 = r5 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajv
            if (r8 == 0) goto L_0x0102
            com.google.android.gms.internal.firebase-auth-api.zzajv r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5)
            goto L_0x0390
        L_0x0102:
            java.lang.String r5 = (java.lang.String) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (java.lang.String) r5)
            goto L_0x0390
        L_0x010a:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (boolean) r15)
            goto L_0x0390
        L_0x0116:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzb((int) r12, (int) r7)
            goto L_0x0390
        L_0x0122:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (long) r8)
            goto L_0x0390
        L_0x012e:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            int r5 = zzc(r1, (long) r13)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzc((int) r12, (int) r5)
            goto L_0x0390
        L_0x013e:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            long r8 = zzd(r1, r13)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zze((int) r12, (long) r8)
            goto L_0x0390
        L_0x014e:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            long r8 = zzd(r1, r13)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzb((int) r12, (long) r8)
            goto L_0x0390
        L_0x015e:
            boolean r8 = r0.zzc(r1, (int) r12, (int) r2)
            if (r8 == 0) goto L_0x04d0
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (float) r5)
            goto L_0x0390
        L_0x016a:
            boolean r5 = r0.zzc(r1, (int) r12, (int) r2)
            if (r5 == 0) goto L_0x04d0
            r8 = 0
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (double) r8)
            goto L_0x0390
        L_0x0178:
            com.google.android.gms.internal.firebase-auth-api.zzamf r5 = r0.zzr
            java.lang.Object r8 = r6.getObject(r1, r13)
            java.lang.Object r9 = r0.zzf((int) r2)
            int r5 = r5.zza(r12, r8, r9)
            goto L_0x0390
        L_0x0188:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.firebase-auth-api.zzanb r8 = r0.zze((int) r2)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzamm>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb<?>) r8)
            goto L_0x0390
        L_0x0198:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzh(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x01ae:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzg(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x01c4:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x01da:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x01f0:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x0206:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzi(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x021c:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((java.util.List<?>) r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x0232:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x0248:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x025d:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zze(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x0272:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzj(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x0287:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzf(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x029c:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
            goto L_0x02c5
        L_0x02b1:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r5)
            if (r5 <= 0) goto L_0x04d0
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzh((int) r12)
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzi((int) r5)
        L_0x02c5:
            int r8 = r8 + r9
            int r8 = r8 + r5
            int r9 = r16 + r8
            goto L_0x04d2
        L_0x02cb:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzh(r12, r5, r7)
            goto L_0x0390
        L_0x02d7:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzg(r12, r5, r7)
            goto L_0x0390
        L_0x02e3:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r12, r5, r7)
            goto L_0x0390
        L_0x02ef:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r12, r5, r7)
            goto L_0x0390
        L_0x02fb:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r12, (java.util.List<java.lang.Integer>) r5, (boolean) r7)
            goto L_0x0390
        L_0x0307:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzi(r12, r5, r7)
            goto L_0x0390
        L_0x0313:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzajv>) r5)
            goto L_0x0390
        L_0x031f:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.firebase-auth-api.zzanb r8 = r0.zze((int) r2)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r12, (java.util.List<?>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb<?>) r8)
            goto L_0x0390
        L_0x032e:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb(r12, r5)
            goto L_0x0390
        L_0x0339:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (java.util.List<?>) r5, (boolean) r7)
            goto L_0x0390
        L_0x0344:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r12, r5, r7)
            goto L_0x0390
        L_0x034f:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r12, r5, r7)
            goto L_0x0390
        L_0x035a:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zze(r12, r5, r7)
            goto L_0x0390
        L_0x0365:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzj(r12, r5, r7)
            goto L_0x0390
        L_0x0370:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzf(r12, r5, r7)
            goto L_0x0390
        L_0x037b:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r12, r5, r7)
            goto L_0x0390
        L_0x0386:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r12, r5, r7)
        L_0x0390:
            int r9 = r16 + r5
            goto L_0x04d2
        L_0x0394:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04d0
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzamm r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzamm) r5
            com.google.android.gms.internal.firebase-auth-api.zzanb r8 = r0.zze((int) r2)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzamm) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x0390
        L_0x03aa:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04a6
            long r8 = r6.getLong(r1, r13)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzd((int) r12, (long) r8)
            goto L_0x04a1
        L_0x03bb:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04a6
            int r0 = r6.getInt(r1, r13)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zze((int) r12, (int) r0)
            goto L_0x04a1
        L_0x03cc:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04bc
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzc((int) r12, (long) r8)
            goto L_0x04b5
        L_0x03d9:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04bc
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzd((int) r12, (int) r7)
            goto L_0x04b5
        L_0x03e6:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04a6
            int r0 = r6.getInt(r1, r13)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (int) r0)
            goto L_0x04a1
        L_0x03f7:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04a6
            int r0 = r6.getInt(r1, r13)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzf((int) r12, (int) r0)
            goto L_0x04a1
        L_0x0408:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04a6
            java.lang.Object r0 = r6.getObject(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzajv r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r0)
            goto L_0x04a1
        L_0x041b:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04d0
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzanb r8 = r0.zze((int) r2)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb<?>) r8)
            goto L_0x0390
        L_0x0430:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04a6
            java.lang.Object r0 = r6.getObject(r1, r13)
            boolean r5 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajv
            if (r5 == 0) goto L_0x0446
            com.google.android.gms.internal.firebase-auth-api.zzajv r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r0)
            goto L_0x04a1
        L_0x0446:
            java.lang.String r0 = (java.lang.String) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (java.lang.String) r0)
            goto L_0x04a1
        L_0x044d:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04bc
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (boolean) r15)
            goto L_0x04b5
        L_0x045a:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04bc
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzb((int) r12, (int) r7)
            goto L_0x04b5
        L_0x0466:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04bc
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (long) r8)
            goto L_0x04b5
        L_0x0472:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04a6
            int r0 = r6.getInt(r1, r13)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzc((int) r12, (int) r0)
            goto L_0x04a1
        L_0x0482:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04a6
            long r8 = r6.getLong(r1, r13)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zze((int) r12, (long) r8)
            goto L_0x04a1
        L_0x0492:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04a6
            long r8 = r6.getLong(r1, r13)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zzb((int) r12, (long) r8)
        L_0x04a1:
            int r9 = r16 + r0
            r0 = r17
            goto L_0x04d2
        L_0x04a6:
            r0 = r17
            goto L_0x04d0
        L_0x04a9:
            r8 = r5
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04bc
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (float) r8)
        L_0x04b5:
            int r9 = r16 + r0
            r0 = r17
            r1 = r18
            goto L_0x04d2
        L_0x04bc:
            r0 = r17
            r1 = r18
            goto L_0x04d0
        L_0x04c1:
            r5 = r11
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x04d0
            r8 = 0
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakn.zza((int) r12, (double) r8)
            goto L_0x0390
        L_0x04d0:
            r9 = r16
        L_0x04d2:
            int r2 = r2 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000e
        L_0x04d9:
            r16 = r9
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r2 = r0.zzp
            java.lang.Object r3 = r2.zzd(r1)
            int r2 = r2.zza(r3)
            int r9 = r16 + r2
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x0539
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r2 = r0.zzq
            com.google.android.gms.internal.firebase-auth-api.zzakx r1 = r2.zza((java.lang.Object) r1)
            com.google.android.gms.internal.firebase-auth-api.zzang<T, java.lang.Object> r2 = r1.zza
            int r2 = r2.zzb()
            r3 = r7
        L_0x04f8:
            if (r7 >= r2) goto L_0x0512
            com.google.android.gms.internal.firebase-auth-api.zzang<T, java.lang.Object> r4 = r1.zza
            java.util.Map$Entry r4 = r4.zza((int) r7)
            java.lang.Object r5 = r4.getKey()
            com.google.android.gms.internal.firebase-auth-api.zzakz r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzakz) r5
            java.lang.Object r4 = r4.getValue()
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzakx.zza((com.google.android.gms.internal.p002firebaseauthapi.zzakz<?>) r5, (java.lang.Object) r4)
            int r3 = r3 + r4
            int r7 = r7 + 1
            goto L_0x04f8
        L_0x0512:
            com.google.android.gms.internal.firebase-auth-api.zzang<T, java.lang.Object> r1 = r1.zza
            java.lang.Iterable r1 = r1.zzc()
            java.util.Iterator r1 = r1.iterator()
        L_0x051c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0538
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            com.google.android.gms.internal.firebase-auth-api.zzakz r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzakz) r4
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzakx.zza((com.google.android.gms.internal.p002firebaseauthapi.zzakz<?>) r4, (java.lang.Object) r2)
            int r3 = r3 + r2
            goto L_0x051c
        L_0x0538:
            int r9 = r9 + r3
        L_0x0539:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamq.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzc((int) r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzb(r9, (long) r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zza(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r0 = r8.zzp
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r0 = r8.zzq
            com.google.android.gms.internal.firebase-auth-api.zzakx r9 = r0.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamq.zzb(java.lang.Object):int");
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzanz.zze(t, j)).intValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.google.android.gms.internal.firebase-auth-api.zzanx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v16, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v27, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v42, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v46, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v55, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v56, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v60, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v66, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v38, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v39, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v69, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v70, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v40, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v71, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v41, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v72, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v76, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v93, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v79, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v81, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v82, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v83, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v104, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v90, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v91, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v95, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v96, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v97, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v98, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v112, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v101, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v66, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v105, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v72, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v106, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v110, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v121, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v61, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v71, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v111, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v62, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v124, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v110, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v75, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v63, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v111, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v64, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v121, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v78, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v129, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v124, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v125, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v126, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v82, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v130, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v66, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v135, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v120, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v67, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v52, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v68, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v125, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v127, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v69, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v55, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v57, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v57, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v104, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v130, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v72, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v107, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v105, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v61, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v110, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v111, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v62, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v157, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v158, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v159, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v161, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v74, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v133, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v114, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v63, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v75, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v116, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v137, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v117, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v64, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v76, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v138, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v118, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v87, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v119, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v139, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v77, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v120, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v121, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v123, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v126, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v127, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v144, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v128, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v145, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v129, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v79, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v130, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v146, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v132, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v133, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v134, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v150, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v136, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v139, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v66, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v194, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v141, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v197, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v198, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v142, resolved type: byte} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x06ad  */
    /* JADX WARNING: Removed duplicated region for block: B:591:0x08a8 A[SYNTHETIC] */
    final int zza(T r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.p002firebaseauthapi.zzaju r38) throws java.io.IOException {
        /*
            r32 = this;
            r0 = r32
            r2 = r33
            r3 = r34
            r5 = r36
            r6 = r38
            zzf((java.lang.Object) r2)
            sun.misc.Unsafe r1 = zzb
            r4 = r35
            r7 = -1
            r8 = 0
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r14 = 0
            r15 = 0
        L_0x0018:
            if (r4 >= r5) goto L_0x0d4e
            int r15 = r4 + 1
            byte r4 = r3[r4]
            if (r4 >= 0) goto L_0x0026
            int r15 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((int) r4, (byte[]) r3, (int) r15, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
            int r4 = r6.zza
        L_0x0026:
            r29 = r15
            r15 = r4
            r4 = r29
            int r12 = r15 >>> 3
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r15 & 7
            r13 = 3
            if (r12 <= r7) goto L_0x0045
            int r8 = r8 / r13
            int r7 = r0.zze
            if (r12 < r7) goto L_0x0043
            int r7 = r0.zzf
            if (r12 > r7) goto L_0x0043
            int r7 = r0.zza((int) r12, (int) r8)
            goto L_0x0049
        L_0x0043:
            r7 = -1
            goto L_0x0049
        L_0x0045:
            int r7 = r0.zza((int) r12)
        L_0x0049:
            r8 = -1
            if (r7 != r8) goto L_0x005e
            r10 = r37
            r19 = r1
            r1 = r3
            r3 = r4
            r17 = r8
            r27 = r9
            r8 = r12
            r18 = r14
            r9 = 0
            r12 = r2
            r14 = r6
            goto L_0x0ce1
        L_0x005e:
            int[] r8 = r0.zzc
            int r18 = r7 + 1
            r13 = r8[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r13 & r18
            int r3 = r18 >>> 20
            r18 = r4
            r4 = r13 & r16
            long r4 = (long) r4
            r19 = r4
            java.lang.String r5 = ""
            r21 = 0
            r25 = 1
            r4 = 17
            if (r3 > r4) goto L_0x0390
            int r4 = r7 + 2
            r4 = r8[r4]
            int r8 = r4 >>> 20
            int r23 = r25 << r8
            r4 = r4 & r16
            if (r4 == r9) goto L_0x00a0
            r8 = r16
            if (r9 == r8) goto L_0x0092
            long r8 = (long) r9
            r1.putInt(r2, r8, r14)
            r8 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0092:
            if (r4 != r8) goto L_0x0096
            r14 = 0
            goto L_0x009c
        L_0x0096:
            long r8 = (long) r4
            int r8 = r1.getInt(r2, r8)
            r14 = r8
        L_0x009c:
            r27 = r14
            r14 = r4
            goto L_0x00a3
        L_0x00a0:
            r27 = r14
            r14 = r9
        L_0x00a3:
            switch(r3) {
                case 0: goto L_0x034e;
                case 1: goto L_0x032e;
                case 2: goto L_0x02f8;
                case 3: goto L_0x02f8;
                case 4: goto L_0x02d1;
                case 5: goto L_0x02a0;
                case 6: goto L_0x0271;
                case 7: goto L_0x024d;
                case 8: goto L_0x020b;
                case 9: goto L_0x01c0;
                case 10: goto L_0x0194;
                case 11: goto L_0x02d1;
                case 12: goto L_0x0142;
                case 13: goto L_0x0271;
                case 14: goto L_0x02a0;
                case 15: goto L_0x0118;
                case 16: goto L_0x00eb;
                case 17: goto L_0x00b9;
                default: goto L_0x00a6;
            }
        L_0x00a6:
            r35 = r2
            r2 = r1
            r1 = r35
            r8 = r7
            r35 = r14
            r9 = r18
            r17 = -1
        L_0x00b2:
            r7 = r34
            r18 = r15
            r15 = r6
            goto L_0x037e
        L_0x00b9:
            r3 = 3
            if (r11 != r3) goto L_0x00de
            java.lang.Object r3 = r0.zza(r2, (int) r7)
            int r4 = r12 << 3
            r8 = r4 | 4
            com.google.android.gms.internal.firebase-auth-api.zzanb r4 = r0.zze((int) r7)
            r5 = r34
            r9 = r6
            r13 = r7
            r6 = r18
            r17 = -1
            r7 = r36
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((java.lang.Object) r3, r4, (byte[]) r5, (int) r6, (int) r7, (int) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r9)
            r7 = r5
            r0.zza(r2, (int) r13, (java.lang.Object) r3)
            r3 = r27 | r23
            goto L_0x0139
        L_0x00de:
            r17 = -1
            r35 = r2
            r2 = r1
            r1 = r35
            r8 = r7
            r35 = r14
            r9 = r18
            goto L_0x00b2
        L_0x00eb:
            r9 = r6
            r13 = r7
            r4 = r18
            r17 = -1
            r7 = r34
            if (r11 != 0) goto L_0x0112
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r7, r4, r9)
            long r3 = r9.zzb
            long r5 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((long) r3)
            r3 = r19
            r1.putLong(r2, r3, r5)
            r29 = r2
            r2 = r1
            r1 = r29
            r3 = r27 | r23
            r4 = r2
            r2 = r1
            r1 = r4
            r5 = r36
            r4 = r8
            goto L_0x013b
        L_0x0112:
            r29 = r2
            r2 = r1
            r1 = r29
            goto L_0x013f
        L_0x0118:
            r4 = r2
            r2 = r1
            r1 = r4
            r9 = r6
            r13 = r7
            r4 = r18
            r5 = r19
            r17 = -1
            r7 = r34
            if (r11 != 0) goto L_0x013f
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r7, r4, r9)
            int r3 = r9.zza
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((int) r3)
            r2.putInt(r1, r5, r3)
            r3 = r27 | r23
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x0139:
            r5 = r36
        L_0x013b:
            r6 = r9
            r8 = r13
            goto L_0x01b5
        L_0x013f:
            r8 = r13
            goto L_0x01b9
        L_0x0142:
            r4 = r2
            r2 = r1
            r1 = r4
            r9 = r6
            r8 = r7
            r4 = r18
            r5 = r19
            r17 = -1
            r7 = r34
            if (r11 != 0) goto L_0x01b9
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r7, r4, r9)
            int r3 = r9.zza
            com.google.android.gms.internal.firebase-auth-api.zzalj r11 = r0.zzd((int) r8)
            r18 = -2147483648(0xffffffff80000000, float:-0.0)
            r13 = r13 & r18
            if (r13 == 0) goto L_0x0187
            if (r11 == 0) goto L_0x0187
            boolean r11 = r11.zza(r3)
            if (r11 == 0) goto L_0x016a
            goto L_0x0187
        L_0x016a:
            com.google.android.gms.internal.firebase-auth-api.zzanx r5 = zzc((java.lang.Object) r1)
            r35 = r4
            long r3 = (long) r3
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r5.zza((int) r15, (java.lang.Object) r3)
            r3 = r2
            r2 = r1
            r1 = r3
            r4 = r35
            r5 = r36
            r3 = r7
            r6 = r9
            r7 = r12
            r9 = r14
            r14 = r27
            goto L_0x0018
        L_0x0187:
            r35 = r4
            r2.putInt(r1, r5, r3)
            r3 = r27 | r23
            r4 = r2
            r2 = r1
            r1 = r4
            r4 = r35
            goto L_0x01b2
        L_0x0194:
            r3 = r2
            r2 = r1
            r1 = r3
            r9 = r6
            r8 = r7
            r4 = r18
            r5 = r19
            r3 = 2
            r17 = -1
            r7 = r34
            if (r11 != r3) goto L_0x01b9
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(r7, r4, r9)
            java.lang.Object r3 = r9.zzc
            r2.putObject(r1, r5, r3)
            r3 = r27 | r23
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x01b2:
            r5 = r36
            r6 = r9
        L_0x01b5:
            r9 = r14
            r14 = r3
            r3 = r7
            goto L_0x01f3
        L_0x01b9:
            r35 = r14
            r18 = r15
            r15 = r9
            goto L_0x029d
        L_0x01c0:
            r3 = r2
            r2 = r1
            r1 = r3
            r9 = r6
            r8 = r7
            r4 = r18
            r3 = 2
            r17 = -1
            r7 = r34
            if (r11 != r3) goto L_0x01f6
            r5 = r1
            java.lang.Object r1 = r0.zza(r5, (int) r8)
            r3 = r2
            com.google.android.gms.internal.firebase-auth-api.zzanb r2 = r0.zze((int) r8)
            r6 = r9
            r9 = r3
            r3 = r7
            r7 = r5
            r5 = r36
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((java.lang.Object) r1, r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
            r2 = r3
            r3 = r1
            r1 = r2
            r2 = r6
            r0.zza(r7, (int) r8, (java.lang.Object) r3)
            r3 = r27 | r23
            r5 = r3
            r3 = r1
            r1 = r9
            r9 = r14
            r14 = r5
            r5 = r36
            r2 = r7
        L_0x01f3:
            r7 = r12
            goto L_0x0018
        L_0x01f6:
            r29 = r7
            r7 = r1
            r1 = r29
            r29 = r9
            r9 = r2
            r2 = r29
            r35 = r7
            r7 = r1
            r1 = r35
            r35 = r14
            r18 = r15
            goto L_0x029b
        L_0x020b:
            r9 = r1
            r8 = r7
            r35 = r14
            r4 = r18
            r3 = 2
            r17 = -1
            r1 = r34
            r7 = r2
            r2 = r6
            r18 = r15
            r14 = r19
            if (r11 != r3) goto L_0x0298
            boolean r3 = zzg((int) r13)
            if (r3 == 0) goto L_0x022a
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzb(r1, r4, r2)
        L_0x0228:
            r4 = r3
            goto L_0x0242
        L_0x022a:
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r1, r4, r2)
            int r4 = r2.zza
            if (r4 < 0) goto L_0x0248
            if (r4 != 0) goto L_0x0237
            r2.zzc = r5
            goto L_0x0228
        L_0x0237:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza
            r5.<init>(r1, r3, r4, r6)
            r2.zzc = r5
            int r3 = r3 + r4
            goto L_0x0228
        L_0x0242:
            java.lang.Object r3 = r2.zzc
            r9.putObject(r7, r14, r3)
            goto L_0x028d
        L_0x0248:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzf()
            throw r1
        L_0x024d:
            r9 = r1
            r8 = r7
            r35 = r14
            r4 = r18
            r17 = -1
            r1 = r34
            r7 = r2
            r2 = r6
            r18 = r15
            r14 = r19
            if (r11 != 0) goto L_0x0298
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r1, r4, r2)
            long r5 = r2.zzb
            int r3 = (r5 > r21 ? 1 : (r5 == r21 ? 0 : -1))
            if (r3 == 0) goto L_0x026c
            r3 = r25
            goto L_0x026d
        L_0x026c:
            r3 = 0
        L_0x026d:
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc((java.lang.Object) r7, (long) r14, (boolean) r3)
            goto L_0x028d
        L_0x0271:
            r9 = r1
            r8 = r7
            r35 = r14
            r4 = r18
            r3 = 5
            r17 = -1
            r1 = r34
            r7 = r2
            r2 = r6
            r18 = r15
            r14 = r19
            if (r11 != r3) goto L_0x0298
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r1, r4)
            r9.putInt(r7, r14, r3)
            int r4 = r4 + 4
        L_0x028d:
            r14 = r27 | r23
            r5 = r36
            r3 = r1
            r6 = r2
            r2 = r7
            r1 = r9
            r7 = r12
            goto L_0x0321
        L_0x0298:
            r15 = r7
            r7 = r1
            r1 = r15
        L_0x029b:
            r15 = r2
            r2 = r9
        L_0x029d:
            r9 = r4
            goto L_0x037e
        L_0x02a0:
            r9 = r1
            r8 = r7
            r35 = r14
            r4 = r18
            r3 = r25
            r17 = -1
            r1 = r34
            r7 = r2
            r2 = r6
            r18 = r15
            r14 = r19
            if (r11 != r3) goto L_0x02ca
            long r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r1, r4)
            r29 = r7
            r7 = r1
            r1 = r9
            r9 = r4
            r3 = r14
            r15 = r2
            r2 = r29
            r1.putLong(r2, r3, r5)
            int r4 = r9 + 8
            r14 = r27 | r23
            goto L_0x0373
        L_0x02ca:
            r15 = r2
            r2 = r7
            r7 = r1
            r1 = r9
            r9 = r4
            goto L_0x0327
        L_0x02d1:
            r8 = r7
            r35 = r14
            r9 = r18
            r3 = r19
            r17 = -1
            r7 = r34
            r18 = r15
            r15 = r6
            if (r11 != 0) goto L_0x0327
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r7, r9, r15)
            int r6 = r15.zza
            r1.putInt(r2, r3, r6)
            r14 = r27 | r23
            r9 = r35
            r4 = r5
            r3 = r7
            r7 = r12
            r6 = r15
            r15 = r18
        L_0x02f4:
            r5 = r36
            goto L_0x0018
        L_0x02f8:
            r8 = r7
            r35 = r14
            r9 = r18
            r3 = r19
            r17 = -1
            r7 = r34
            r18 = r15
            r15 = r6
            if (r11 != 0) goto L_0x0327
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r7, r9, r15)
            long r5 = r15.zzb
            r1.putLong(r2, r3, r5)
            r29 = r2
            r2 = r1
            r1 = r29
            r14 = r27 | r23
            r3 = r2
            r2 = r1
            r1 = r3
            r5 = r36
            r3 = r7
            r4 = r9
            r7 = r12
            r6 = r15
        L_0x0321:
            r15 = r18
            r9 = r35
            goto L_0x0018
        L_0x0327:
            r29 = r2
            r2 = r1
            r1 = r29
            goto L_0x037e
        L_0x032e:
            r35 = r2
            r2 = r1
            r1 = r35
            r8 = r7
            r35 = r14
            r9 = r18
            r3 = r19
            r5 = 5
            r17 = -1
            r7 = r34
            r18 = r15
            r15 = r6
            if (r11 != r5) goto L_0x037e
            float r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzb(r7, r9)
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r3, (float) r5)
            int r4 = r9 + 4
            goto L_0x036e
        L_0x034e:
            r35 = r2
            r2 = r1
            r1 = r35
            r8 = r7
            r35 = r14
            r9 = r18
            r3 = r19
            r5 = r25
            r17 = -1
            r7 = r34
            r18 = r15
            r15 = r6
            if (r11 != r5) goto L_0x037e
            double r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(r7, r9)
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r3, (double) r5)
            int r4 = r9 + 8
        L_0x036e:
            r14 = r27 | r23
            r3 = r2
            r2 = r1
            r1 = r3
        L_0x0373:
            r9 = r35
            r5 = r36
            r3 = r7
            r7 = r12
            r6 = r15
            r15 = r18
            goto L_0x0018
        L_0x037e:
            r10 = r37
            r19 = r2
            r3 = r9
            r14 = r15
            r15 = r18
            r18 = r27
            r27 = r35
            r9 = r8
            r8 = r12
            r12 = r1
            r1 = r7
            goto L_0x0ce1
        L_0x0390:
            r4 = r2
            r2 = r1
            r1 = r4
            r4 = r7
            r17 = -1
            r29 = r15
            r15 = r6
            r6 = r19
            r20 = r8
            r19 = r18
            r18 = r29
            r8 = 27
            if (r3 != r8) goto L_0x03fe
            r8 = 2
            if (r11 != r8) goto L_0x03e7
            java.lang.Object r3 = r2.getObject(r1, r6)
            com.google.android.gms.internal.firebase-auth-api.zzalm r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzalm) r3
            boolean r5 = r3.zzc()
            if (r5 != 0) goto L_0x03c6
            int r5 = r3.size()
            if (r5 != 0) goto L_0x03bd
            r5 = 10
            goto L_0x03bf
        L_0x03bd:
            int r5 = r5 << 1
        L_0x03bf:
            com.google.android.gms.internal.firebase-auth-api.zzalm r3 = r3.zza(r5)
            r2.putObject(r1, r6, r3)
        L_0x03c6:
            r6 = r3
            com.google.android.gms.internal.firebase-auth-api.zzanb r1 = r0.zze((int) r4)
            r8 = r33
            r3 = r34
            r5 = r36
            r13 = r4
            r7 = r15
            r4 = r19
            r15 = r2
            r2 = r18
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzb(r1, r2, r3, r4, r5, r6, r7)
            r1 = r2
            r2 = r15
            r15 = r1
            r1 = r2
            r6 = r38
            r2 = r8
            r7 = r12
            r8 = r13
            goto L_0x0018
        L_0x03e7:
            r8 = r1
            r1 = r12
            r12 = r8
            r8 = r1
            r1 = r34
            r5 = r38
            r27 = r9
            r15 = r18
            r9 = r4
            r18 = r14
            r14 = r19
            r4 = r36
            r19 = r2
            goto L_0x0af7
        L_0x03fe:
            r8 = r1
            r15 = r2
            r2 = r4
            r4 = r19
            r1 = 49
            if (r3 > r1) goto L_0x09ff
            r19 = r12
            long r12 = (long) r13
            sun.misc.Unsafe r1 = zzb
            java.lang.Object r20 = r1.getObject(r8, r6)
            r23 = r4
            r4 = r20
            com.google.android.gms.internal.firebase-auth-api.zzalm r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzalm) r4
            boolean r20 = r4.zzc()
            if (r20 != 0) goto L_0x042e
            int r20 = r4.size()
            r27 = r9
            r25 = 1
            int r9 = r20 << 1
            com.google.android.gms.internal.firebase-auth-api.zzalm r4 = r4.zza(r9)
            r1.putObject(r8, r6, r4)
            goto L_0x0430
        L_0x042e:
            r27 = r9
        L_0x0430:
            r6 = r4
            switch(r3) {
                case 18: goto L_0x097d;
                case 19: goto L_0x0912;
                case 20: goto L_0x08bb;
                case 21: goto L_0x08bb;
                case 22: goto L_0x088e;
                case 23: goto L_0x0821;
                case 24: goto L_0x07b6;
                case 25: goto L_0x074a;
                case 26: goto L_0x0668;
                case 27: goto L_0x062c;
                case 28: goto L_0x05ac;
                case 29: goto L_0x088e;
                case 30: goto L_0x0548;
                case 31: goto L_0x07b6;
                case 32: goto L_0x0821;
                case 33: goto L_0x04d2;
                case 34: goto L_0x0478;
                case 35: goto L_0x097d;
                case 36: goto L_0x0912;
                case 37: goto L_0x08bb;
                case 38: goto L_0x08bb;
                case 39: goto L_0x088e;
                case 40: goto L_0x0821;
                case 41: goto L_0x07b6;
                case 42: goto L_0x074a;
                case 43: goto L_0x088e;
                case 44: goto L_0x0548;
                case 45: goto L_0x07b6;
                case 46: goto L_0x0821;
                case 47: goto L_0x04d2;
                case 48: goto L_0x0478;
                case 49: goto L_0x0448;
                default: goto L_0x0434;
            }
        L_0x0434:
            r4 = r36
            r1 = r38
            r9 = r2
            r12 = r8
            r8 = r19
            r2 = r34
        L_0x043e:
            r19 = r15
            r15 = r18
            r18 = r14
            r14 = r23
            goto L_0x09e7
        L_0x0448:
            r3 = 3
            if (r11 != r3) goto L_0x046d
            com.google.android.gms.internal.firebase-auth-api.zzanb r1 = r0.zze((int) r2)
            r3 = r34
            r5 = r36
            r7 = r38
            r9 = r2
            r2 = r18
            r4 = r23
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((com.google.android.gms.internal.p002firebaseauthapi.zzanb<?>) r1, (int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzalm<java.lang.Object>) r6, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r7)
            r12 = r8
            r18 = r14
            r8 = r19
            r14 = r4
            r4 = r5
            r19 = r15
            r15 = r2
            r2 = r3
            r3 = r1
            r1 = r7
            goto L_0x09e8
        L_0x046d:
            r9 = r2
            r2 = r34
            r4 = r36
            r1 = r38
            r12 = r8
            r8 = r19
            goto L_0x043e
        L_0x0478:
            r3 = r34
            r5 = r36
            r9 = r2
            r1 = r6
            r2 = r18
            r4 = r23
            r7 = 2
            r6 = r38
            if (r11 != r7) goto L_0x04a9
            com.google.android.gms.internal.firebase-auth-api.zzalx r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzalx) r1
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r3, r4, r6)
            int r11 = r6.zza
            int r11 = r11 + r7
        L_0x0490:
            if (r7 >= r11) goto L_0x04a0
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r3, r7, r6)
            long r12 = r6.zzb
            long r12 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((long) r12)
            r1.zza((long) r12)
            goto L_0x0490
        L_0x04a0:
            if (r7 != r11) goto L_0x04a4
            goto L_0x052b
        L_0x04a4:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x04a9:
            if (r11 != 0) goto L_0x053a
            com.google.android.gms.internal.firebase-auth-api.zzalx r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzalx) r1
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r3, r4, r6)
            long r11 = r6.zzb
            long r11 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((long) r11)
            r1.zza((long) r11)
        L_0x04ba:
            if (r7 >= r5) goto L_0x052b
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r3, r7, r6)
            int r12 = r6.zza
            if (r2 != r12) goto L_0x052b
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r3, r11, r6)
            long r11 = r6.zzb
            long r11 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((long) r11)
            r1.zza((long) r11)
            goto L_0x04ba
        L_0x04d2:
            r3 = r34
            r5 = r36
            r9 = r2
            r1 = r6
            r2 = r18
            r4 = r23
            r7 = 2
            r6 = r38
            if (r11 != r7) goto L_0x0502
            com.google.android.gms.internal.firebase-auth-api.zzali r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzali) r1
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r3, r4, r6)
            int r11 = r6.zza
            int r11 = r11 + r7
        L_0x04ea:
            if (r7 >= r11) goto L_0x04fa
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r3, r7, r6)
            int r12 = r6.zza
            int r12 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((int) r12)
            r1.zzc(r12)
            goto L_0x04ea
        L_0x04fa:
            if (r7 != r11) goto L_0x04fd
            goto L_0x052b
        L_0x04fd:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x0502:
            if (r11 != 0) goto L_0x053a
            com.google.android.gms.internal.firebase-auth-api.zzali r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzali) r1
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r3, r4, r6)
            int r11 = r6.zza
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((int) r11)
            r1.zzc(r11)
        L_0x0513:
            if (r7 >= r5) goto L_0x052b
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r3, r7, r6)
            int r12 = r6.zza
            if (r2 != r12) goto L_0x052b
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r3, r11, r6)
            int r11 = r6.zza
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((int) r11)
            r1.zzc(r11)
            goto L_0x0513
        L_0x052b:
            r1 = r6
            r12 = r8
            r18 = r14
            r8 = r19
            r14 = r4
            r4 = r5
            r19 = r15
            r15 = r2
            r2 = r3
            r3 = r7
            goto L_0x09e8
        L_0x053a:
            r1 = r6
            r12 = r8
            r18 = r14
            r8 = r19
            r14 = r4
            r4 = r5
            r19 = r15
            r15 = r2
            r2 = r3
            goto L_0x09e7
        L_0x0548:
            r3 = r34
            r5 = r36
            r9 = r2
            r1 = r6
            r2 = r18
            r4 = r23
            r7 = 2
            r6 = r38
            if (r11 != r7) goto L_0x0565
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzalm<?>) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
            r18 = r2
            r12 = r3
            r23 = r4
            r13 = r5
            r11 = r7
            r5 = r1
        L_0x0563:
            r7 = r6
            goto L_0x057c
        L_0x0565:
            if (r11 != 0) goto L_0x059d
            r29 = r5
            r5 = r1
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r29
            int r7 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((int) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzalm<?>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
            r18 = r1
            r12 = r2
            r23 = r3
            r13 = r4
            r1 = r7
            r11 = r1
            goto L_0x0563
        L_0x057c:
            com.google.android.gms.internal.firebase-auth-api.zzalj r4 = r0.zzd((int) r9)
            r6 = r5
            r5 = 0
            r1 = r6
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r6 = r0.zzp
            r3 = r1
            r1 = r8
            r2 = r19
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(r1, r2, r3, r4, r5, r6)
            r8 = r2
            r1 = r7
            r3 = r11
            r2 = r12
            r4 = r13
            r19 = r15
            r15 = r18
            r12 = r33
            r18 = r14
            r14 = r23
            goto L_0x09e8
        L_0x059d:
            r8 = r19
            r12 = r33
            r1 = r6
            r18 = r14
            r19 = r15
            r15 = r2
            r2 = r3
            r14 = r4
            r4 = r5
            goto L_0x09e7
        L_0x05ac:
            r12 = r34
            r13 = r36
            r7 = r38
            r9 = r2
            r5 = r6
            r1 = r18
            r8 = r19
            r4 = r23
            r3 = 2
            if (r11 != r3) goto L_0x0621
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r12, r4, r7)
            int r3 = r7.zza
            if (r3 < 0) goto L_0x061c
            int r6 = r12.length
            int r6 = r6 - r2
            if (r3 > r6) goto L_0x0617
            if (r3 != 0) goto L_0x05d1
            com.google.android.gms.internal.firebase-auth-api.zzajv r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza
            r5.add(r3)
            goto L_0x05d9
        L_0x05d1:
            com.google.android.gms.internal.firebase-auth-api.zzajv r6 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza((byte[]) r12, (int) r2, (int) r3)
            r5.add(r6)
        L_0x05d8:
            int r2 = r2 + r3
        L_0x05d9:
            if (r2 >= r13) goto L_0x0609
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r12, r2, r7)
            int r6 = r7.zza
            if (r1 != r6) goto L_0x0609
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r12, r3, r7)
            int r3 = r7.zza
            if (r3 < 0) goto L_0x0604
            int r6 = r12.length
            int r6 = r6 - r2
            if (r3 > r6) goto L_0x05ff
            if (r3 != 0) goto L_0x05f7
            com.google.android.gms.internal.firebase-auth-api.zzajv r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza
            r5.add(r3)
            goto L_0x05d9
        L_0x05f7:
            com.google.android.gms.internal.firebase-auth-api.zzajv r6 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza((byte[]) r12, (int) r2, (int) r3)
            r5.add(r6)
            goto L_0x05d8
        L_0x05ff:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x0604:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzf()
            throw r1
        L_0x0609:
            r3 = r2
            r2 = r12
            r18 = r14
            r19 = r15
            r12 = r33
            r15 = r1
            r14 = r4
            r1 = r7
            r4 = r13
            goto L_0x09e8
        L_0x0617:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x061c:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzf()
            throw r1
        L_0x0621:
            r2 = r12
            r18 = r14
            r19 = r15
            r12 = r33
            r15 = r1
            r14 = r4
            r1 = r7
            goto L_0x0665
        L_0x062c:
            r12 = r34
            r13 = r36
            r7 = r38
            r9 = r2
            r5 = r6
            r1 = r18
            r8 = r19
            r4 = r23
            r3 = 2
            if (r11 != r3) goto L_0x065a
            r2 = r1
            com.google.android.gms.internal.firebase-auth-api.zzanb r1 = r0.zze((int) r9)
            r6 = r5
            r3 = r12
            r5 = r13
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzb(r1, r2, r3, r4, r5, r6, r7)
            r6 = r3
            r3 = r1
            r1 = r2
            r2 = r6
            r6 = r7
            r12 = r33
            r18 = r14
            r19 = r15
            r15 = r1
            r14 = r4
            r4 = r5
            r1 = r6
            goto L_0x09e8
        L_0x065a:
            r6 = r7
            r2 = r12
            r18 = r14
            r19 = r15
            r12 = r33
            r15 = r1
            r14 = r4
            r1 = r6
        L_0x0665:
            r4 = r13
            goto L_0x09e7
        L_0x0668:
            r4 = r36
            r9 = r2
            r1 = r18
            r7 = r23
            r3 = 2
            r2 = r34
            r29 = r6
            r6 = r38
            r30 = r12
            r13 = r29
            r12 = r8
            r8 = r19
            r18 = r30
            if (r11 != r3) goto L_0x0741
            r23 = 536870912(0x20000000, double:2.652494739E-315)
            long r18 = r18 & r23
            int r3 = (r18 > r21 ? 1 : (r18 == r21 ? 0 : -1))
            if (r3 != 0) goto L_0x06d8
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r7, r6)
            int r11 = r6.zza
            if (r11 < 0) goto L_0x06d3
            if (r11 != 0) goto L_0x069c
            r13.add(r5)
            r18 = r14
            r19 = r15
            goto L_0x06ab
        L_0x069c:
            r18 = r14
            java.lang.String r14 = new java.lang.String
            r19 = r15
            java.nio.charset.Charset r15 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza
            r14.<init>(r2, r3, r11, r15)
            r13.add(r14)
        L_0x06aa:
            int r3 = r3 + r11
        L_0x06ab:
            if (r3 >= r4) goto L_0x08a8
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r3, r6)
            int r14 = r6.zza
            if (r1 != r14) goto L_0x08a8
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r11, r6)
            int r11 = r6.zza
            if (r11 < 0) goto L_0x06ce
            if (r11 != 0) goto L_0x06c3
            r13.add(r5)
            goto L_0x06ab
        L_0x06c3:
            java.lang.String r14 = new java.lang.String
            java.nio.charset.Charset r15 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza
            r14.<init>(r2, r3, r11, r15)
            r13.add(r14)
            goto L_0x06aa
        L_0x06ce:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzf()
            throw r1
        L_0x06d3:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzf()
            throw r1
        L_0x06d8:
            r18 = r14
            r19 = r15
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r7, r6)
            int r11 = r6.zza
            if (r11 < 0) goto L_0x073c
            if (r11 != 0) goto L_0x06ea
            r13.add(r5)
            goto L_0x0700
        L_0x06ea:
            int r14 = r3 + r11
            boolean r15 = com.google.android.gms.internal.p002firebaseauthapi.zzaoa.zzc(r2, r3, r14)
            if (r15 == 0) goto L_0x0737
            java.lang.String r15 = new java.lang.String
            r35 = r14
            java.nio.charset.Charset r14 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza
            r15.<init>(r2, r3, r11, r14)
            r13.add(r15)
        L_0x06fe:
            r3 = r35
        L_0x0700:
            if (r3 >= r4) goto L_0x08a8
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r3, r6)
            int r14 = r6.zza
            if (r1 != r14) goto L_0x08a8
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r11, r6)
            int r11 = r6.zza
            if (r11 < 0) goto L_0x0732
            if (r11 != 0) goto L_0x0718
            r13.add(r5)
            goto L_0x0700
        L_0x0718:
            int r14 = r3 + r11
            boolean r15 = com.google.android.gms.internal.p002firebaseauthapi.zzaoa.zzc(r2, r3, r14)
            if (r15 == 0) goto L_0x072d
            java.lang.String r15 = new java.lang.String
            r35 = r14
            java.nio.charset.Charset r14 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza
            r15.<init>(r2, r3, r11, r14)
            r13.add(r15)
            goto L_0x06fe
        L_0x072d:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzd()
            throw r1
        L_0x0732:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzf()
            throw r1
        L_0x0737:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzd()
            throw r1
        L_0x073c:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzf()
            throw r1
        L_0x0741:
            r18 = r14
            r19 = r15
        L_0x0745:
            r15 = r1
            r1 = r6
            r14 = r7
            goto L_0x09e7
        L_0x074a:
            r4 = r36
            r9 = r2
            r13 = r6
            r12 = r8
            r1 = r18
            r8 = r19
            r7 = r23
            r3 = 2
            r2 = r34
            r6 = r38
            r18 = r14
            r19 = r15
            if (r11 != r3) goto L_0x0786
            r3 = r13
            com.google.android.gms.internal.firebase-auth-api.zzajt r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzajt) r3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r7, r6)
            int r11 = r6.zza
            int r11 = r11 + r5
        L_0x076a:
            if (r5 >= r11) goto L_0x077d
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r2, r5, r6)
            long r13 = r6.zzb
            int r13 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1))
            if (r13 == 0) goto L_0x0778
            r13 = 1
            goto L_0x0779
        L_0x0778:
            r13 = 0
        L_0x0779:
            r3.zza((boolean) r13)
            goto L_0x076a
        L_0x077d:
            if (r5 != r11) goto L_0x0781
            goto L_0x088b
        L_0x0781:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x0786:
            if (r11 != 0) goto L_0x0745
            r3 = r13
            com.google.android.gms.internal.firebase-auth-api.zzajt r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzajt) r3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r2, r7, r6)
            long r13 = r6.zzb
            int r11 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1))
            if (r11 == 0) goto L_0x0797
            r11 = 1
            goto L_0x0798
        L_0x0797:
            r11 = 0
        L_0x0798:
            r3.zza((boolean) r11)
        L_0x079b:
            if (r5 >= r4) goto L_0x088b
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r5, r6)
            int r13 = r6.zza
            if (r1 != r13) goto L_0x088b
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r2, r11, r6)
            long r13 = r6.zzb
            int r11 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1))
            if (r11 == 0) goto L_0x07b1
            r11 = 1
            goto L_0x07b2
        L_0x07b1:
            r11 = 0
        L_0x07b2:
            r3.zza((boolean) r11)
            goto L_0x079b
        L_0x07b6:
            r4 = r36
            r9 = r2
            r13 = r6
            r12 = r8
            r1 = r18
            r8 = r19
            r7 = r23
            r3 = 2
            r2 = r34
            r6 = r38
            r18 = r14
            r19 = r15
            if (r11 != r3) goto L_0x07fe
            r3 = r13
            com.google.android.gms.internal.firebase-auth-api.zzali r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzali) r3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r7, r6)
            int r11 = r6.zza
            int r13 = r5 + r11
            int r14 = r2.length
            if (r13 > r14) goto L_0x07f9
            int r14 = r3.size()
            int r11 = r11 / 4
            int r14 = r14 + r11
            r3.zzd(r14)
        L_0x07e4:
            if (r5 >= r13) goto L_0x07f0
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r5)
            r3.zzc(r11)
            int r5 = r5 + 4
            goto L_0x07e4
        L_0x07f0:
            if (r5 != r13) goto L_0x07f4
            goto L_0x088b
        L_0x07f4:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x07f9:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x07fe:
            r3 = 5
            if (r11 != r3) goto L_0x0745
            r3 = r13
            com.google.android.gms.internal.firebase-auth-api.zzali r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzali) r3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r7)
            r3.zzc(r5)
            int r5 = r7 + 4
        L_0x080d:
            if (r5 >= r4) goto L_0x088b
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r5, r6)
            int r13 = r6.zza
            if (r1 != r13) goto L_0x088b
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r11)
            r3.zzc(r5)
            int r5 = r11 + 4
            goto L_0x080d
        L_0x0821:
            r4 = r36
            r9 = r2
            r13 = r6
            r12 = r8
            r1 = r18
            r8 = r19
            r7 = r23
            r3 = 2
            r2 = r34
            r6 = r38
            r18 = r14
            r19 = r15
            if (r11 != r3) goto L_0x0868
            r3 = r13
            com.google.android.gms.internal.firebase-auth-api.zzalx r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzalx) r3
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r7, r6)
            int r11 = r6.zza
            int r13 = r5 + r11
            int r14 = r2.length
            if (r13 > r14) goto L_0x0863
            int r14 = r3.size()
            int r11 = r11 / 8
            int r14 = r14 + r11
            r3.zzc(r14)
        L_0x084f:
            if (r5 >= r13) goto L_0x085b
            long r14 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r2, r5)
            r3.zza((long) r14)
            int r5 = r5 + 8
            goto L_0x084f
        L_0x085b:
            if (r5 != r13) goto L_0x085e
            goto L_0x088b
        L_0x085e:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x0863:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x0868:
            r3 = 1
            if (r11 != r3) goto L_0x0745
            r3 = r13
            com.google.android.gms.internal.firebase-auth-api.zzalx r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzalx) r3
            long r13 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r2, r7)
            r3.zza((long) r13)
            int r5 = r7 + 8
        L_0x0877:
            if (r5 >= r4) goto L_0x088b
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r5, r6)
            int r13 = r6.zza
            if (r1 != r13) goto L_0x088b
            long r13 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r2, r11)
            r3.zza((long) r13)
            int r5 = r11 + 8
            goto L_0x0877
        L_0x088b:
            r15 = r1
            r3 = r5
            goto L_0x08a9
        L_0x088e:
            r4 = r36
            r9 = r2
            r13 = r6
            r12 = r8
            r1 = r18
            r8 = r19
            r7 = r23
            r3 = 2
            r2 = r34
            r6 = r38
            r18 = r14
            r19 = r15
            if (r11 != r3) goto L_0x08ad
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((byte[]) r2, (int) r7, (com.google.android.gms.internal.p002firebaseauthapi.zzalm<?>) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
        L_0x08a8:
            r15 = r1
        L_0x08a9:
            r1 = r6
            r14 = r7
            goto L_0x09e8
        L_0x08ad:
            if (r11 != 0) goto L_0x0745
            r3 = r7
            r5 = r13
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((int) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzalm<?>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
            r15 = r1
            r14 = r3
            r1 = r6
            r3 = r5
            goto L_0x09e8
        L_0x08bb:
            r4 = r36
            r1 = r38
            r9 = r2
            r5 = r6
            r12 = r8
            r8 = r19
            r3 = 2
            r2 = r34
            r19 = r15
            r15 = r18
            r18 = r14
            r14 = r23
            if (r11 != r3) goto L_0x08f0
            r6 = r5
            com.google.android.gms.internal.firebase-auth-api.zzalx r6 = (com.google.android.gms.internal.p002firebaseauthapi.zzalx) r6
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r14, r1)
            int r5 = r1.zza
            int r5 = r5 + r3
        L_0x08db:
            if (r3 >= r5) goto L_0x08e7
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r2, r3, r1)
            long r10 = r1.zzb
            r6.zza((long) r10)
            goto L_0x08db
        L_0x08e7:
            if (r3 != r5) goto L_0x08eb
            goto L_0x09e8
        L_0x08eb:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x08f0:
            if (r11 != 0) goto L_0x09e7
            r6 = r5
            com.google.android.gms.internal.firebase-auth-api.zzalx r6 = (com.google.android.gms.internal.p002firebaseauthapi.zzalx) r6
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r2, r14, r1)
            long r10 = r1.zzb
            r6.zza((long) r10)
        L_0x08fe:
            if (r3 >= r4) goto L_0x09e8
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r3, r1)
            int r7 = r1.zza
            if (r15 != r7) goto L_0x09e8
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r2, r5, r1)
            long r10 = r1.zzb
            r6.zza((long) r10)
            goto L_0x08fe
        L_0x0912:
            r4 = r36
            r1 = r38
            r9 = r2
            r5 = r6
            r12 = r8
            r8 = r19
            r3 = 2
            r2 = r34
            r19 = r15
            r15 = r18
            r18 = r14
            r14 = r23
            if (r11 != r3) goto L_0x095a
            r6 = r5
            com.google.android.gms.internal.firebase-auth-api.zzald r6 = (com.google.android.gms.internal.p002firebaseauthapi.zzald) r6
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r14, r1)
            int r5 = r1.zza
            int r7 = r3 + r5
            int r10 = r2.length
            if (r7 > r10) goto L_0x0955
            int r10 = r6.size()
            int r5 = r5 / 4
            int r10 = r10 + r5
            r6.zzc(r10)
        L_0x0940:
            if (r3 >= r7) goto L_0x094c
            float r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzb(r2, r3)
            r6.zza((float) r5)
            int r3 = r3 + 4
            goto L_0x0940
        L_0x094c:
            if (r3 != r7) goto L_0x0950
            goto L_0x09e8
        L_0x0950:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x0955:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x095a:
            r3 = 5
            if (r11 != r3) goto L_0x09e7
            r6 = r5
            com.google.android.gms.internal.firebase-auth-api.zzald r6 = (com.google.android.gms.internal.p002firebaseauthapi.zzald) r6
            float r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzb(r2, r14)
            r6.zza((float) r3)
            int r3 = r14 + 4
        L_0x0969:
            if (r3 >= r4) goto L_0x09e8
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r3, r1)
            int r7 = r1.zza
            if (r15 != r7) goto L_0x09e8
            float r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzb(r2, r5)
            r6.zza((float) r3)
            int r3 = r5 + 4
            goto L_0x0969
        L_0x097d:
            r4 = r36
            r1 = r38
            r9 = r2
            r5 = r6
            r12 = r8
            r8 = r19
            r3 = 2
            r2 = r34
            r19 = r15
            r15 = r18
            r18 = r14
            r14 = r23
            if (r11 != r3) goto L_0x09c4
            r6 = r5
            com.google.android.gms.internal.firebase-auth-api.zzaks r6 = (com.google.android.gms.internal.p002firebaseauthapi.zzaks) r6
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r14, r1)
            int r5 = r1.zza
            int r7 = r3 + r5
            int r10 = r2.length
            if (r7 > r10) goto L_0x09bf
            int r10 = r6.size()
            int r5 = r5 / 8
            int r10 = r10 + r5
            r6.zzc(r10)
        L_0x09ab:
            if (r3 >= r7) goto L_0x09b7
            double r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(r2, r3)
            r6.zza((double) r10)
            int r3 = r3 + 8
            goto L_0x09ab
        L_0x09b7:
            if (r3 != r7) goto L_0x09ba
            goto L_0x09e8
        L_0x09ba:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x09bf:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x09c4:
            r3 = 1
            if (r11 != r3) goto L_0x09e7
            r6 = r5
            com.google.android.gms.internal.firebase-auth-api.zzaks r6 = (com.google.android.gms.internal.p002firebaseauthapi.zzaks) r6
            double r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(r2, r14)
            r6.zza((double) r10)
            int r3 = r14 + 8
        L_0x09d3:
            if (r3 >= r4) goto L_0x09e8
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r3, r1)
            int r7 = r1.zza
            if (r15 != r7) goto L_0x09e8
            double r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(r2, r5)
            r6.zza((double) r10)
            int r3 = r5 + 8
            goto L_0x09d3
        L_0x09e7:
            r3 = r14
        L_0x09e8:
            if (r3 != r14) goto L_0x09f0
            r10 = r37
            r14 = r1
            r1 = r2
            goto L_0x0ce1
        L_0x09f0:
            r6 = r1
            r5 = r4
            r7 = r8
            r8 = r9
            r14 = r18
            r1 = r19
            r9 = r27
            r4 = r3
            r3 = r2
            r2 = r12
            goto L_0x0018
        L_0x09ff:
            r1 = r12
            r12 = r8
            r8 = r1
            r1 = r38
            r27 = r9
            r19 = r15
            r15 = r18
            r9 = r2
            r18 = r14
            r2 = r34
            r14 = r4
            r4 = r36
            r10 = 50
            if (r3 != r10) goto L_0x0afd
            r10 = 2
            if (r11 != r10) goto L_0x0af5
            sun.misc.Unsafe r3 = zzb
            java.lang.Object r5 = r0.zzf((int) r9)
            java.lang.Object r10 = r3.getObject(r12, r6)
            com.google.android.gms.internal.firebase-auth-api.zzamf r11 = r0.zzr
            boolean r11 = r11.zzf(r10)
            if (r11 == 0) goto L_0x0a3a
            com.google.android.gms.internal.firebase-auth-api.zzamf r11 = r0.zzr
            java.lang.Object r11 = r11.zzb(r5)
            com.google.android.gms.internal.firebase-auth-api.zzamf r13 = r0.zzr
            r13.zza(r11, r10)
            r3.putObject(r12, r6, r11)
            r10 = r11
        L_0x0a3a:
            com.google.android.gms.internal.firebase-auth-api.zzamf r3 = r0.zzr
            com.google.android.gms.internal.firebase-auth-api.zzamd r7 = r3.zza(r5)
            com.google.android.gms.internal.firebase-auth-api.zzamf r3 = r0.zzr
            java.util.Map r10 = r3.zze(r10)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r2, r14, r1)
            int r5 = r1.zza
            if (r5 < 0) goto L_0x0af0
            int r6 = r4 - r3
            if (r5 > r6) goto L_0x0af0
            int r11 = r3 + r5
            K r5 = r7.zzb
            V r6 = r7.zzd
            r13 = r5
        L_0x0a59:
            if (r3 >= r11) goto L_0x0acd
            int r5 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0a67
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((int) r3, (byte[]) r2, (int) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r1)
            int r3 = r1.zza
        L_0x0a67:
            int r1 = r3 >>> 3
            r2 = r3 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0aa0
            r4 = 2
            if (r1 == r4) goto L_0x0a79
        L_0x0a71:
            r1 = r34
            r4 = r36
            r2 = r5
            r5 = r38
            goto L_0x0ac6
        L_0x0a79:
            com.google.android.gms.internal.firebase-auth-api.zzaog r1 = r7.zzc
            int r1 = r1.zza()
            if (r2 != r1) goto L_0x0a71
            r26 = r4
            com.google.android.gms.internal.firebase-auth-api.zzaog r4 = r7.zzc
            V r1 = r7.zzd
            java.lang.Class r1 = r1.getClass()
            r3 = r36
            r6 = r38
            r2 = r5
            r5 = r1
            r1 = r34
            int r2 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzaog) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
            r1 = r6
            java.lang.Object r6 = r1.zzc
            r4 = r36
            r3 = r2
            r2 = r34
            goto L_0x0a59
        L_0x0aa0:
            r1 = r38
            com.google.android.gms.internal.firebase-auth-api.zzaog r4 = r7.zza
            int r4 = r4.zza()
            if (r2 != r4) goto L_0x0ac0
            com.google.android.gms.internal.firebase-auth-api.zzaog r4 = r7.zza
            r2 = r5
            r5 = 0
            r3 = r36
            r13 = r6
            r6 = r1
            r1 = r34
            int r2 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzaog) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
            r4 = r3
            r5 = r6
            java.lang.Object r3 = r5.zzc
            r6 = r13
            r13 = r3
            r3 = r2
            goto L_0x0aca
        L_0x0ac0:
            r4 = r36
            r2 = r5
            r5 = r1
            r1 = r34
        L_0x0ac6:
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((int) r3, (byte[]) r1, (int) r2, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r5)
        L_0x0aca:
            r2 = r1
            r1 = r5
            goto L_0x0a59
        L_0x0acd:
            r5 = r1
            r1 = r2
            if (r3 != r11) goto L_0x0aeb
            r10.put(r13, r6)
            if (r11 != r14) goto L_0x0adc
            r10 = r37
            r14 = r5
            r3 = r11
            goto L_0x0ce1
        L_0x0adc:
            r3 = r1
            r6 = r5
            r7 = r8
            r8 = r9
            r2 = r12
            r14 = r18
            r1 = r19
            r9 = r27
            r5 = r4
            r4 = r11
            goto L_0x0018
        L_0x0aeb:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzg()
            throw r1
        L_0x0af0:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r1
        L_0x0af5:
            r5 = r1
            r1 = r2
        L_0x0af7:
            r10 = r37
            r3 = r14
            r14 = r5
            goto L_0x0ce1
        L_0x0afd:
            r1 = r2
            sun.misc.Unsafe r2 = zzb
            int r10 = r9 + 2
            r10 = r20[r10]
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r16
            r20 = r3
            long r3 = (long) r10
            switch(r20) {
                case 51: goto L_0x0cbf;
                case 52: goto L_0x0ca6;
                case 53: goto L_0x0c8e;
                case 54: goto L_0x0c8e;
                case 55: goto L_0x0c76;
                case 56: goto L_0x0c5d;
                case 57: goto L_0x0c43;
                case 58: goto L_0x0c21;
                case 59: goto L_0x0be9;
                case 60: goto L_0x0bbe;
                case 61: goto L_0x0ba0;
                case 62: goto L_0x0c76;
                case 63: goto L_0x0b71;
                case 64: goto L_0x0c43;
                case 65: goto L_0x0c5d;
                case 66: goto L_0x0b58;
                case 67: goto L_0x0b39;
                case 68: goto L_0x0b16;
                default: goto L_0x0b0f;
            }
        L_0x0b0f:
            r20 = r9
            r9 = r14
            r14 = r38
            goto L_0x0cd9
        L_0x0b16:
            r10 = 3
            if (r11 != r10) goto L_0x0b0f
            java.lang.Object r1 = r0.zza(r12, (int) r8, (int) r9)
            r2 = r15 & -8
            r6 = r2 | 4
            com.google.android.gms.internal.firebase-auth-api.zzanb r2 = r0.zze((int) r9)
            r3 = r34
            r5 = r36
            r7 = r38
            r4 = r14
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((java.lang.Object) r1, r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r7)
            r5 = r3
            r3 = r1
            r1 = r5
            r5 = r7
            r0.zza(r12, (int) r8, (int) r9, (java.lang.Object) r3)
            r4 = r2
            goto L_0x0b55
        L_0x0b39:
            r5 = r38
            if (r11 != 0) goto L_0x0bb8
            int r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r1, r14, r5)
            r35 = r10
            long r10 = r5.zzb
            long r10 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((long) r10)
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r2.putObject(r12, r6, r10)
            r2.putInt(r12, r3, r8)
            r4 = r35
        L_0x0b55:
            r20 = r9
            goto L_0x0bb4
        L_0x0b58:
            r5 = r38
            if (r11 != 0) goto L_0x0bb8
            int r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r1, r14, r5)
            int r11 = r5.zza
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzakh.zza((int) r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r2.putObject(r12, r6, r11)
            r2.putInt(r12, r3, r8)
            goto L_0x0bb1
        L_0x0b71:
            r5 = r38
            if (r11 != 0) goto L_0x0bb8
            int r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r1, r14, r5)
            int r11 = r5.zza
            com.google.android.gms.internal.firebase-auth-api.zzalj r13 = r0.zzd((int) r9)
            if (r13 == 0) goto L_0x0b95
            boolean r13 = r13.zza(r11)
            if (r13 == 0) goto L_0x0b88
            goto L_0x0b95
        L_0x0b88:
            com.google.android.gms.internal.firebase-auth-api.zzanx r2 = zzc((java.lang.Object) r12)
            long r3 = (long) r11
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.zza((int) r15, (java.lang.Object) r3)
            goto L_0x0bb1
        L_0x0b95:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r2.putObject(r12, r6, r11)
            r2.putInt(r12, r3, r8)
            goto L_0x0bb1
        L_0x0ba0:
            r5 = r38
            r10 = 2
            if (r11 != r10) goto L_0x0bb8
            int r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(r1, r14, r5)
            java.lang.Object r11 = r5.zzc
            r2.putObject(r12, r6, r11)
            r2.putInt(r12, r3, r8)
        L_0x0bb1:
            r20 = r9
            r4 = r10
        L_0x0bb4:
            r9 = r14
            r14 = r5
            goto L_0x0cda
        L_0x0bb8:
            r20 = r9
            r9 = r14
            r14 = r5
            goto L_0x0cd9
        L_0x0bbe:
            r5 = r38
            r10 = 2
            if (r11 != r10) goto L_0x0be2
            java.lang.Object r1 = r0.zza(r12, (int) r8, (int) r9)
            com.google.android.gms.internal.firebase-auth-api.zzanb r2 = r0.zze((int) r9)
            r3 = r34
            r6 = r5
            r4 = r14
            r5 = r36
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((java.lang.Object) r1, r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
            r14 = r3
            r3 = r1
            r1 = r14
            r14 = r6
            r0.zza(r12, (int) r8, (int) r9, (java.lang.Object) r3)
            r20 = r9
            r9 = r4
            r4 = r2
            goto L_0x0cda
        L_0x0be2:
            r4 = r14
            r14 = r5
            r20 = r9
            r9 = r4
            goto L_0x0cd9
        L_0x0be9:
            r20 = r9
            r9 = r14
            r10 = 2
            r14 = r38
            if (r11 != r10) goto L_0x0cd9
            int r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r1, r9, r14)
            int r11 = r14.zza
            if (r11 != 0) goto L_0x0bfd
            r2.putObject(r12, r6, r5)
            goto L_0x0c1b
        L_0x0bfd:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r5 & r13
            if (r5 == 0) goto L_0x0c10
            int r5 = r10 + r11
            boolean r5 = com.google.android.gms.internal.p002firebaseauthapi.zzaoa.zzc(r1, r10, r5)
            if (r5 == 0) goto L_0x0c0b
            goto L_0x0c10
        L_0x0c0b:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzd()
            throw r1
        L_0x0c10:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r13 = com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza
            r5.<init>(r1, r10, r11, r13)
            r2.putObject(r12, r6, r5)
            int r10 = r10 + r11
        L_0x0c1b:
            r2.putInt(r12, r3, r8)
            r4 = r10
            goto L_0x0cda
        L_0x0c21:
            r20 = r9
            r9 = r14
            r14 = r38
            if (r11 != 0) goto L_0x0cd9
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r1, r9, r14)
            long r10 = r14.zzb
            int r10 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r10 == 0) goto L_0x0c35
            r28 = 1
            goto L_0x0c37
        L_0x0c35:
            r28 = 0
        L_0x0c37:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r28)
            r2.putObject(r12, r6, r10)
            r2.putInt(r12, r3, r8)
            goto L_0x0cd7
        L_0x0c43:
            r20 = r9
            r9 = r14
            r5 = 5
            r14 = r38
            if (r11 != r5) goto L_0x0cd9
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r1, r9)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2.putObject(r12, r6, r5)
            int r5 = r9 + 4
            r2.putInt(r12, r3, r8)
            goto L_0x0cd7
        L_0x0c5d:
            r20 = r9
            r9 = r14
            r5 = 1
            r14 = r38
            if (r11 != r5) goto L_0x0cd9
            long r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r1, r9)
            java.lang.Long r5 = java.lang.Long.valueOf(r10)
            r2.putObject(r12, r6, r5)
            int r5 = r9 + 8
            r2.putInt(r12, r3, r8)
            goto L_0x0cd7
        L_0x0c76:
            r20 = r9
            r9 = r14
            r14 = r38
            if (r11 != 0) goto L_0x0cd9
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzc(r1, r9, r14)
            int r10 = r14.zza
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r2.putObject(r12, r6, r10)
            r2.putInt(r12, r3, r8)
            goto L_0x0cd7
        L_0x0c8e:
            r20 = r9
            r9 = r14
            r14 = r38
            if (r11 != 0) goto L_0x0cd9
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzd(r1, r9, r14)
            long r10 = r14.zzb
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r2.putObject(r12, r6, r10)
            r2.putInt(r12, r3, r8)
            goto L_0x0cd7
        L_0x0ca6:
            r20 = r9
            r9 = r14
            r5 = 5
            r14 = r38
            if (r11 != r5) goto L_0x0cd9
            float r5 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zzb(r1, r9)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r2.putObject(r12, r6, r5)
            int r5 = r9 + 4
            r2.putInt(r12, r3, r8)
            goto L_0x0cd7
        L_0x0cbf:
            r20 = r9
            r9 = r14
            r5 = 1
            r14 = r38
            if (r11 != r5) goto L_0x0cd9
            double r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(r1, r9)
            java.lang.Double r5 = java.lang.Double.valueOf(r10)
            r2.putObject(r12, r6, r5)
            int r5 = r9 + 8
            r2.putInt(r12, r3, r8)
        L_0x0cd7:
            r4 = r5
            goto L_0x0cda
        L_0x0cd9:
            r4 = r9
        L_0x0cda:
            r10 = r37
            if (r4 != r9) goto L_0x0d3a
            r3 = r4
            r9 = r20
        L_0x0ce1:
            if (r15 != r10) goto L_0x0cf1
            if (r10 != 0) goto L_0x0ce6
            goto L_0x0cf1
        L_0x0ce6:
            r13 = r36
            r6 = r3
            r1 = r19
            r14 = r18
            r9 = r27
            goto L_0x0d57
        L_0x0cf1:
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x0d1a
            com.google.android.gms.internal.firebase-auth-api.zzaku r2 = r14.zzd
            com.google.android.gms.internal.firebase-auth-api.zzaku r4 = com.google.android.gms.internal.p002firebaseauthapi.zzaku.zza
            if (r2 == r4) goto L_0x0d1a
            com.google.android.gms.internal.firebase-auth-api.zzamm r6 = r0.zzg
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r7 = r0.zzp
            r4 = r36
            r2 = r1
            r11 = r8
            r5 = r12
            r8 = r14
            r1 = r15
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r38
            r4 = r3
            r2 = r5
            r8 = r9
            r7 = r11
            r14 = r18
            r1 = r19
            r9 = r27
            r3 = r34
            goto L_0x02f4
        L_0x0d1a:
            r11 = r8
            r1 = r15
            com.google.android.gms.internal.firebase-auth-api.zzanx r5 = zzc((java.lang.Object) r12)
            r2 = r34
            r4 = r36
            r6 = r38
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza((int) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzanx) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r6)
            r15 = r1
            r5 = r4
            r8 = r9
            r7 = r11
            r2 = r12
            r14 = r18
            r1 = r19
            r9 = r27
            r4 = r3
            r3 = r34
            goto L_0x0018
        L_0x0d3a:
            r11 = r8
            r1 = r15
            r3 = r34
            r5 = r36
            r6 = r38
            r7 = r11
            r2 = r12
            r14 = r18
            r1 = r19
            r8 = r20
            r9 = r27
            goto L_0x0018
        L_0x0d4e:
            r10 = r37
            r12 = r2
            r13 = r5
            r27 = r9
            r18 = r14
            r6 = r4
        L_0x0d57:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            if (r9 == r8) goto L_0x0d60
            long r2 = (long) r9
            r1.putInt(r12, r2, r14)
        L_0x0d60:
            int r1 = r0.zzl
            r2 = 0
            r7 = r1
            r3 = r2
        L_0x0d65:
            int r1 = r0.zzm
            if (r7 >= r1) goto L_0x0d7c
            int[] r1 = r0.zzk
            r2 = r1[r7]
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r4 = r0.zzp
            r5 = r33
            r1 = r12
            java.lang.Object r2 = r0.zza((java.lang.Object) r1, (int) r2, r3, r4, (java.lang.Object) r5)
            r3 = r2
            com.google.android.gms.internal.firebase-auth-api.zzanx r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzanx) r3
            int r7 = r7 + 1
            goto L_0x0d65
        L_0x0d7c:
            r1 = r12
            if (r3 == 0) goto L_0x0d84
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r2 = r0.zzp
            r2.zzb((java.lang.Object) r1, r3)
        L_0x0d84:
            if (r10 != 0) goto L_0x0d8e
            if (r6 != r13) goto L_0x0d89
            goto L_0x0d92
        L_0x0d89:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzg()
            throw r1
        L_0x0d8e:
            if (r6 > r13) goto L_0x0d93
            if (r15 != r10) goto L_0x0d93
        L_0x0d92:
            return r6
        L_0x0d93:
            com.google.android.gms.internal.firebase-auth-api.zzall r1 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzg()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamq.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzaju):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzanz.zze(t, j)).longValue();
    }

    private final zzalj zzd(int i) {
        return (zzalj) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0288  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.p002firebaseauthapi.zzamq<T> zza(java.lang.Class<T> r32, com.google.android.gms.internal.p002firebaseauthapi.zzamk r33, com.google.android.gms.internal.p002firebaseauthapi.zzamu r34, com.google.android.gms.internal.p002firebaseauthapi.zzalw r35, com.google.android.gms.internal.p002firebaseauthapi.zzanu<?, ?> r36, com.google.android.gms.internal.p002firebaseauthapi.zzakw<?> r37, com.google.android.gms.internal.p002firebaseauthapi.zzamf r38) {
        /*
            r0 = r33
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzamz
            if (r1 == 0) goto L_0x03f9
            com.google.android.gms.internal.firebase-auth-api.zzamz r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzamz) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0056
            int[] r7 = zza
            r9 = r3
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r17 = r13
            r16 = r7
            r7 = r17
            goto L_0x016b
        L_0x0056:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0062:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0072
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0062
        L_0x0072:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0075:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0094
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0081:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0091
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0081
        L_0x0091:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0094:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b0
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a0
        L_0x00b0:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b3:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 << 1
            int r16 = r16 + r7
            r7 = r12
            r12 = r9
            r9 = r7
            r7 = r13
            r13 = r10
            r10 = r16
            r16 = r7
            r7 = r4
            r17 = r14
            r4 = r15
        L_0x016b:
            sun.misc.Unsafe r14 = zzb
            java.lang.Object[] r15 = r0.zze()
            com.google.android.gms.internal.firebase-auth-api.zzamm r18 = r0.zza()
            java.lang.Class r3 = r18.getClass()
            r33 = 1
            int r6 = r11 * 3
            int[] r6 = new int[r6]
            int r11 = r11 << 1
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r18 = r17 + r9
            r20 = r17
            r21 = r18
            r9 = 0
            r19 = 0
        L_0x018c:
            if (r4 >= r2) goto L_0x03de
            int r22 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01b4
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = r22
            r22 = 13
        L_0x019c:
            int r24 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01ae
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r22
            r4 = r4 | r8
            int r22 = r22 + 13
            r8 = r24
            goto L_0x019c
        L_0x01ae:
            int r8 = r8 << r22
            r4 = r4 | r8
            r8 = r24
            goto L_0x01b6
        L_0x01b4:
            r8 = r22
        L_0x01b6:
            int r22 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01e3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r5 = r22
            r22 = 13
        L_0x01c4:
            int r25 = r5 + 1
            char r5 = r1.charAt(r5)
            r26 = r0
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r0) goto L_0x01dd
            r0 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r0 = r0 << r22
            r8 = r8 | r0
            int r22 = r22 + 13
            r5 = r25
            r0 = r26
            goto L_0x01c4
        L_0x01dd:
            int r0 = r5 << r22
            r8 = r8 | r0
            r0 = r25
            goto L_0x01e7
        L_0x01e3:
            r26 = r0
            r0 = r22
        L_0x01e7:
            r5 = r8 & 255(0xff, float:3.57E-43)
            r22 = r2
            r2 = r8 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x01f5
            int r2 = r19 + 1
            r16[r19] = r9
            r19 = r2
        L_0x01f5:
            r2 = 51
            r28 = r4
            if (r5 < r2) goto L_0x029a
            int r2 = r0 + 1
            char r0 = r1.charAt(r0)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r0 < r4) goto L_0x0224
            r0 = r0 & 8191(0x1fff, float:1.1478E-41)
            r29 = 13
        L_0x020a:
            int r30 = r2 + 1
            char r2 = r1.charAt(r2)
            if (r2 < r4) goto L_0x021f
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r29
            r0 = r0 | r2
            int r29 = r29 + 13
            r2 = r30
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x020a
        L_0x021f:
            int r2 = r2 << r29
            r0 = r0 | r2
            r2 = r30
        L_0x0224:
            int r4 = r5 + -51
            r29 = r0
            r0 = 9
            if (r4 == r0) goto L_0x0252
            r0 = 17
            if (r4 != r0) goto L_0x0231
            goto L_0x0252
        L_0x0231:
            r0 = 12
            if (r4 != r0) goto L_0x025f
            com.google.android.gms.internal.firebase-auth-api.zzamy r0 = r26.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzamy r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamy.PROTO2
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0245
            r0 = r8 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x025f
        L_0x0245:
            int r0 = r9 / 3
            int r0 = r0 << 1
            int r0 = r0 + 1
            int r4 = r10 + 1
            r10 = r15[r10]
            r11[r0] = r10
            goto L_0x025e
        L_0x0252:
            int r0 = r9 / 3
            int r0 = r0 << 1
            int r0 = r0 + 1
            int r4 = r10 + 1
            r10 = r15[r10]
            r11[r0] = r10
        L_0x025e:
            r10 = r4
        L_0x025f:
            int r0 = r29 << 1
            r4 = r15[r0]
            r25 = r0
            boolean r0 = r4 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x026c
            java.lang.reflect.Field r4 = (java.lang.reflect.Field) r4
            goto L_0x0274
        L_0x026c:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = zza((java.lang.Class<?>) r3, (java.lang.String) r4)
            r15[r25] = r4
        L_0x0274:
            r30 = r6
            r29 = r7
            long r6 = r14.objectFieldOffset(r4)
            int r0 = (int) r6
            int r4 = r25 + 1
            r6 = r15[r4]
            boolean r7 = r6 instanceof java.lang.reflect.Field
            if (r7 == 0) goto L_0x0288
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            goto L_0x0290
        L_0x0288:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zza((java.lang.Class<?>) r3, (java.lang.String) r6)
            r15[r4] = r6
        L_0x0290:
            long r6 = r14.objectFieldOffset(r6)
            int r4 = (int) r6
            r6 = r10
            r10 = r1
            r1 = 0
            goto L_0x039b
        L_0x029a:
            r30 = r6
            r29 = r7
            int r2 = r10 + 1
            r4 = r15[r10]
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = zza((java.lang.Class<?>) r3, (java.lang.String) r4)
            r6 = 49
            r7 = 9
            if (r5 == r7) goto L_0x0314
            r7 = 17
            if (r5 != r7) goto L_0x02b3
            goto L_0x0314
        L_0x02b3:
            r7 = 27
            if (r5 == r7) goto L_0x0306
            if (r5 != r6) goto L_0x02ba
            goto L_0x0306
        L_0x02ba:
            r7 = 12
            if (r5 == r7) goto L_0x02ed
            r7 = 30
            if (r5 == r7) goto L_0x02ed
            r7 = 44
            if (r5 != r7) goto L_0x02c7
            goto L_0x02ed
        L_0x02c7:
            r7 = 50
            if (r5 != r7) goto L_0x0320
            int r7 = r20 + 1
            r16[r20] = r9
            int r20 = r9 / 3
            int r20 = r20 << 1
            int r25 = r10 + 2
            r2 = r15[r2]
            r11[r20] = r2
            r2 = r8 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x02e8
            int r20 = r20 + 1
            int r2 = r10 + 3
            r10 = r15[r25]
            r11[r20] = r10
            r20 = r7
            goto L_0x0320
        L_0x02e8:
            r20 = r7
            r2 = r25
            goto L_0x0320
        L_0x02ed:
            com.google.android.gms.internal.firebase-auth-api.zzamy r7 = r26.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzamy r6 = com.google.android.gms.internal.p002firebaseauthapi.zzamy.PROTO2
            if (r7 == r6) goto L_0x02f9
            r6 = r8 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0320
        L_0x02f9:
            int r6 = r9 / 3
            int r6 = r6 << 1
            int r6 = r6 + 1
            int r10 = r10 + 2
            r2 = r15[r2]
            r11[r6] = r2
            goto L_0x0312
        L_0x0306:
            int r6 = r9 / 3
            int r6 = r6 << 1
            int r6 = r6 + 1
            int r10 = r10 + 2
            r2 = r15[r2]
            r11[r6] = r2
        L_0x0312:
            r2 = r10
            goto L_0x0320
        L_0x0314:
            int r6 = r9 / 3
            int r6 = r6 << 1
            int r6 = r6 + 1
            java.lang.Class r7 = r4.getType()
            r11[r6] = r7
        L_0x0320:
            long r6 = r14.objectFieldOffset(r4)
            int r4 = (int) r6
            r6 = r8 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r6 = r0 + 1
            char r0 = r1.charAt(r0)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r0 < r7) goto L_0x0351
            r0 = r0 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x033c:
            int r24 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r7) goto L_0x034d
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r10
            r0 = r0 | r6
            int r10 = r10 + 13
            r6 = r24
            goto L_0x033c
        L_0x034d:
            int r6 = r6 << r10
            r0 = r0 | r6
            r6 = r24
        L_0x0351:
            int r10 = r29 << 1
            int r24 = r0 / 32
            int r10 = r10 + r24
            r7 = r15[r10]
            r27 = r0
            boolean r0 = r7 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0362
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x036a
        L_0x0362:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zza((java.lang.Class<?>) r3, (java.lang.String) r7)
            r15[r10] = r7
        L_0x036a:
            r10 = r1
            long r0 = r14.objectFieldOffset(r7)
            int r0 = (int) r0
            int r1 = r27 % 32
            r31 = r6
            r6 = r0
            r0 = r31
            goto L_0x037e
        L_0x0378:
            r10 = r1
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r1
            r1 = 0
        L_0x037e:
            r7 = 18
            if (r5 < r7) goto L_0x0394
            r7 = 49
            if (r5 > r7) goto L_0x0394
            int r7 = r21 + 1
            r16[r21] = r4
            r21 = r2
            r2 = r0
            r0 = r4
            r4 = r6
            r6 = r21
            r21 = r7
            goto L_0x039b
        L_0x0394:
            r31 = r2
            r2 = r0
            r0 = r4
            r4 = r6
            r6 = r31
        L_0x039b:
            int r7 = r9 + 1
            r30[r9] = r28
            int r25 = r9 + 2
            r27 = r0
            r0 = r8 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03aa
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03ab
        L_0x03aa:
            r0 = 0
        L_0x03ab:
            r28 = r0
            r0 = r8 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x03b4
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03b5
        L_0x03b4:
            r0 = 0
        L_0x03b5:
            r0 = r28 | r0
            r8 = r8 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x03be
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03bf
        L_0x03be:
            r8 = 0
        L_0x03bf:
            r0 = r0 | r8
            int r5 = r5 << 20
            r0 = r0 | r5
            r0 = r0 | r27
            r30[r7] = r0
            int r9 = r9 + 3
            int r0 = r1 << 20
            r0 = r0 | r4
            r30[r25] = r0
            r4 = r2
            r1 = r10
            r2 = r22
            r0 = r26
            r7 = r29
            r5 = 55296(0xd800, float:7.7486E-41)
            r10 = r6
            r6 = r30
            goto L_0x018c
        L_0x03de:
            r26 = r0
            r30 = r6
            com.google.android.gms.internal.firebase-auth-api.zzamq r9 = new com.google.android.gms.internal.firebase-auth-api.zzamq
            com.google.android.gms.internal.firebase-auth-api.zzamm r14 = r26.zza()
            r15 = 0
            r19 = r34
            r20 = r35
            r21 = r36
            r22 = r37
            r23 = r38
            r10 = r30
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r9
        L_0x03f9:
            com.google.android.gms.internal.firebase-auth-api.zzano r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzano) r0
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamq.zza(java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzamk, com.google.android.gms.internal.firebase-auth-api.zzamu, com.google.android.gms.internal.firebase-auth-api.zzalw, com.google.android.gms.internal.firebase-auth-api.zzanu, com.google.android.gms.internal.firebase-auth-api.zzakw, com.google.android.gms.internal.firebase-auth-api.zzamf):com.google.android.gms.internal.firebase-auth-api.zzamq");
    }

    private final zzanb zze(int i) {
        int i2 = (i / 3) << 1;
        zzanb zzanb = (zzanb) this.zzd[i2];
        if (zzanb != null) {
            return zzanb;
        }
        zzanb zza2 = zzamx.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    static zzanx zzc(Object obj) {
        zzalf zzalf = (zzalf) obj;
        zzanx zzanx = zzalf.zzb;
        if (zzanx != zzanx.zzc()) {
            return zzanx;
        }
        zzanx zzd2 = zzanx.zzd();
        zzalf.zzb = zzd2;
        return zzd2;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzanu<UT, UB> zzanu, Object obj2) {
        zzalj zzd2;
        int i2 = this.zzc[i];
        Object zze2 = zzanz.zze(obj, (long) (zzc(i) & 1048575));
        if (zze2 == null || (zzd2 = zzd(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzr.zze(zze2), zzd2, ub, zzanu, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzalj zzalj, UB ub, zzanu<UT, UB> zzanu, Object obj) {
        zzamd<?, ?> zza2 = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzalj.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzanu.zzc(obj);
                }
                zzake zzc2 = zzajv.zzc(zzame.zza(zza2, next.getKey(), next.getValue()));
                try {
                    zzame.zza(zzc2.zzb(), zza2, next.getKey(), next.getValue());
                    zzanu.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final Object zza(T t, int i) {
        zzanb zze2 = zze(i);
        long zzc2 = (long) (zzc(i) & 1048575);
        if (!zzc(t, i)) {
            return zze2.zza();
        }
        Object object = zzb.getObject(t, zzc2);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze2.zza();
        if (object != null) {
            zze2.zza(zza2, object);
        }
        return zza2;
    }

    private final Object zza(T t, int i, int i2) {
        zzanb zze2 = zze(i2);
        if (!zzc(t, i, i2)) {
            return zze2.zza();
        }
        Object object = zzb.getObject(t, (long) (zzc(i2) & 1048575));
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze2.zza();
        if (object != null) {
            zze2.zza(zza2, object);
        }
        return zza2;
    }

    public final T zza() {
        return this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    private zzamq(int[] iArr, Object[] objArr, int i, int i2, zzamm zzamm, boolean z, int[] iArr2, int i3, int i4, zzamu zzamu, zzalw zzalw, zzanu<?, ?> zzanu, zzakw<?> zzakw, zzamf zzamf) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzamm instanceof zzalf;
        this.zzh = zzakw != null && zzakw.zza(zzamm);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzamu;
        this.zzo = zzalw;
        this.zzp = zzanu;
        this.zzq = zzakw;
        this.zzg = zzamm;
        this.zzr = zzamf;
    }

    private static void zzf(Object obj) {
        if (!zzg(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
        }
    }

    public final void zzd(T t) {
        if (zzg((Object) t)) {
            if (t instanceof zzalf) {
                zzalf zzalf = (zzalf) t;
                zzalf.zzb(Integer.MAX_VALUE);
                zzalf.zza = 0;
                zzalf.zzu();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzc2 = zzc(i);
                long j = (long) (1048575 & zzc2);
                int i2 = (zzc2 & 267386880) >>> 20;
                if (i2 != 9) {
                    if (i2 == 60 || i2 == 68) {
                        if (zzc(t, this.zzc[i], i)) {
                            zze(i).zzd(zzb.getObject(t, j));
                        }
                    } else {
                        switch (i2) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                                this.zzo.zzb(t, j);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t, j);
                                if (object != null) {
                                    unsafe.putObject(t, j, this.zzr.zzc(object));
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzc(t, i)) {
                    zze(i).zzd(zzb.getObject(t, j));
                }
            }
            this.zzp.zzf(t);
            if (this.zzh) {
                this.zzq.zzc(t);
            }
        }
    }

    public final void zza(T t, T t2) {
        zzf((Object) t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzc2 = zzc(i);
            long j = (long) (1048575 & zzc2);
            int i2 = this.zzc[i];
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zza((Object) t2, j));
                        zzb(t, i);
                        break;
                    }
                case 1:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzb(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 2:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 3:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 4:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 5:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 6:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 7:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zzc((Object) t, j, zzanz.zzh(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 8:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zze(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zze(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 11:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 12:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 13:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 14:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 15:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 16:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    this.zzo.zza(t, t2, j);
                    break;
                case 50:
                    zzand.zza(this.zzr, t, t2, j);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                case 53:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzc(t2, i2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zze(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT:
                case 64:
                case 65:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                    if (!zzc(t2, i2, i)) {
                        break;
                    } else {
                        zzanz.zza((Object) t, j, zzanz.zze(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzand.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzand.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x038c, code lost:
        r6 = r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x05a2 A[Catch:{ all -> 0x05d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x05cf  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x05e2 A[LOOP:5: B:203:0x05de->B:205:0x05e2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x05f5  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x05ae A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r19, com.google.android.gms.internal.p002firebaseauthapi.zzanc r20, com.google.android.gms.internal.p002firebaseauthapi.zzaku r21) throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            r4 = r21
            r4.getClass()
            zzf((java.lang.Object) r19)
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r5 = r1.zzp
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r0 = r1.zzq
            r6 = 0
            r7 = 0
        L_0x0010:
            int r2 = r20.zzc()     // Catch:{ all -> 0x05d7 }
            int r3 = r1.zza((int) r2)     // Catch:{ all -> 0x05d7 }
            r9 = 0
            if (r3 >= 0) goto L_0x00af
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x0044
            int r0 = r1.zzl
            r4 = r6
        L_0x0023:
            int r2 = r1.zzm
            if (r0 >= r2) goto L_0x0039
            int[] r2 = r1.zzk
            r3 = r2[r0]
            r6 = r19
            r2 = r19
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            r10 = r1
            r1 = r2
            int r0 = r0 + 1
            r1 = r10
            goto L_0x0023
        L_0x0039:
            r10 = r1
            r1 = r19
            if (r4 == 0) goto L_0x0041
            r5.zzb((java.lang.Object) r1, r4)
        L_0x0041:
            r1 = r10
            goto L_0x05ce
        L_0x0044:
            r10 = r1
            r1 = r19
            boolean r3 = r10.zzh     // Catch:{ all -> 0x05d3 }
            if (r3 != 0) goto L_0x004d
            r3 = 0
            goto L_0x0054
        L_0x004d:
            com.google.android.gms.internal.firebase-auth-api.zzamm r3 = r10.zzg     // Catch:{ all -> 0x05d3 }
            java.lang.Object r2 = r0.zza(r4, r3, r2)     // Catch:{ all -> 0x05d3 }
            r3 = r2
        L_0x0054:
            if (r3 == 0) goto L_0x0073
            if (r7 != 0) goto L_0x005c
            com.google.android.gms.internal.firebase-auth-api.zzakx r7 = r0.zzb(r1)     // Catch:{ all -> 0x05d3 }
        L_0x005c:
            r2 = r7
            r7 = r5
            r5 = r2
            r2 = r20
            java.lang.Object r6 = r0.zza(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006e }
            r11 = r7
            r7 = r5
            r5 = r11
            r12 = r0
            r0 = r2
            r11 = r4
            r2 = r1
            goto L_0x0567
        L_0x006e:
            r0 = move-exception
            r2 = r1
            r5 = r7
            goto L_0x05d5
        L_0x0073:
            r12 = r0
            r2 = r1
            r11 = r4
            r0 = r20
            r5.zza((com.google.android.gms.internal.p002firebaseauthapi.zzanc) r0)     // Catch:{ all -> 0x00ab }
            if (r6 != 0) goto L_0x0085
            java.lang.Object r6 = r5.zzc(r2)     // Catch:{ all -> 0x0082 }
            goto L_0x0085
        L_0x0082:
            r0 = move-exception
            goto L_0x05d5
        L_0x0085:
            boolean r1 = r5.zza(r6, (com.google.android.gms.internal.p002firebaseauthapi.zzanc) r0, (int) r9)     // Catch:{ all -> 0x00ab }
            if (r1 != 0) goto L_0x00a8
            int r0 = r10.zzl
            r4 = r6
        L_0x008e:
            int r1 = r10.zzm
            if (r0 >= r1) goto L_0x00a1
            int[] r1 = r10.zzk
            r3 = r1[r0]
            r6 = r19
            r1 = r10
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            r1 = r2
            int r0 = r0 + 1
            goto L_0x008e
        L_0x00a1:
            r1 = r2
            if (r4 == 0) goto L_0x0041
            r5.zzb((java.lang.Object) r1, r4)
            goto L_0x0041
        L_0x00a8:
            r1 = r2
            goto L_0x0567
        L_0x00ab:
            r0 = move-exception
            r1 = r2
            goto L_0x05d5
        L_0x00af:
            r12 = r0
            r10 = r1
            r11 = r4
            r1 = r19
            r0 = r20
            int r4 = r10.zzc((int) r3)     // Catch:{ all -> 0x05d3 }
            r13 = 267386880(0xff00000, float:2.3665827E-29)
            r13 = r13 & r4
            int r13 = r13 >>> 20
            r14 = 1048575(0xfffff, float:1.469367E-39)
            switch(r13) {
                case 0: goto L_0x055b;
                case 1: goto L_0x054e;
                case 2: goto L_0x0541;
                case 3: goto L_0x0534;
                case 4: goto L_0x0527;
                case 5: goto L_0x051a;
                case 6: goto L_0x050d;
                case 7: goto L_0x0500;
                case 8: goto L_0x04f9;
                case 9: goto L_0x04e7;
                case 10: goto L_0x04d9;
                case 11: goto L_0x04cb;
                case 12: goto L_0x04a9;
                case 13: goto L_0x049b;
                case 14: goto L_0x048d;
                case 15: goto L_0x047f;
                case 16: goto L_0x0470;
                case 17: goto L_0x045e;
                case 18: goto L_0x0450;
                case 19: goto L_0x0442;
                case 20: goto L_0x0434;
                case 21: goto L_0x0426;
                case 22: goto L_0x0418;
                case 23: goto L_0x040a;
                case 24: goto L_0x03fc;
                case 25: goto L_0x03ee;
                case 26: goto L_0x03cc;
                case 27: goto L_0x03ba;
                case 28: goto L_0x03ac;
                case 29: goto L_0x039e;
                case 30: goto L_0x0373;
                case 31: goto L_0x0365;
                case 32: goto L_0x0357;
                case 33: goto L_0x0349;
                case 34: goto L_0x033b;
                case 35: goto L_0x032d;
                case 36: goto L_0x031f;
                case 37: goto L_0x0311;
                case 38: goto L_0x0303;
                case 39: goto L_0x02f5;
                case 40: goto L_0x02e7;
                case 41: goto L_0x02d9;
                case 42: goto L_0x02cb;
                case 43: goto L_0x02bd;
                case 44: goto L_0x02a2;
                case 45: goto L_0x0294;
                case 46: goto L_0x0286;
                case 47: goto L_0x0278;
                case 48: goto L_0x026a;
                case 49: goto L_0x0258;
                case 50: goto L_0x0216;
                case 51: goto L_0x0204;
                case 52: goto L_0x01f2;
                case 53: goto L_0x01e0;
                case 54: goto L_0x01ce;
                case 55: goto L_0x01bc;
                case 56: goto L_0x01aa;
                case 57: goto L_0x0198;
                case 58: goto L_0x0186;
                case 59: goto L_0x017e;
                case 60: goto L_0x016c;
                case 61: goto L_0x015e;
                case 62: goto L_0x014c;
                case 63: goto L_0x0127;
                case 64: goto L_0x0115;
                case 65: goto L_0x0103;
                case 66: goto L_0x00f1;
                case 67: goto L_0x00df;
                case 68: goto L_0x00cd;
                default: goto L_0x00c5;
            }
        L_0x00c5:
            if (r6 != 0) goto L_0x056f
            java.lang.Object r6 = r5.zzc(r1)     // Catch:{ zzalo -> 0x056c }
            goto L_0x056f
        L_0x00cd:
            java.lang.Object r4 = r10.zza(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzamm r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzamm) r4     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzanb r13 = r10.zze((int) r3)     // Catch:{ zzalo -> 0x056c }
            r0.zza(r4, r13, (com.google.android.gms.internal.p002firebaseauthapi.zzaku) r11)     // Catch:{ zzalo -> 0x056c }
            r10.zza(r1, (int) r2, (int) r3, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x00df:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            long r15 = r0.zzn()     // Catch:{ zzalo -> 0x056c }
            java.lang.Long r4 = java.lang.Long.valueOf(r15)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x00f1:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzi()     // Catch:{ zzalo -> 0x056c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0103:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            long r15 = r0.zzm()     // Catch:{ zzalo -> 0x056c }
            java.lang.Long r4 = java.lang.Long.valueOf(r15)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0115:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzh()     // Catch:{ zzalo -> 0x056c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0127:
            int r13 = r0.zze()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzalj r15 = r10.zzd((int) r3)     // Catch:{ zzalo -> 0x056c }
            if (r15 == 0) goto L_0x013e
            boolean r15 = r15.zza(r13)     // Catch:{ zzalo -> 0x056c }
            if (r15 == 0) goto L_0x0138
            goto L_0x013e
        L_0x0138:
            java.lang.Object r6 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(r1, r2, r13, r6, r5)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x013e:
            r4 = r4 & r14
            long r14 = (long) r4     // Catch:{ zzalo -> 0x056c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r14, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x014c:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzj()     // Catch:{ zzalo -> 0x056c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x015e:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzajv r4 = r0.zzp()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x016c:
            java.lang.Object r4 = r10.zza(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzamm r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzamm) r4     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzanb r13 = r10.zze((int) r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzb(r4, r13, (com.google.android.gms.internal.p002firebaseauthapi.zzaku) r11)     // Catch:{ zzalo -> 0x056c }
            r10.zza(r1, (int) r2, (int) r3, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x017e:
            r10.zza((java.lang.Object) r1, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzanc) r0)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0186:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            boolean r4 = r0.zzs()     // Catch:{ zzalo -> 0x056c }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0198:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzf()     // Catch:{ zzalo -> 0x056c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x01aa:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            long r15 = r0.zzk()     // Catch:{ zzalo -> 0x056c }
            java.lang.Long r4 = java.lang.Long.valueOf(r15)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x01bc:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzg()     // Catch:{ zzalo -> 0x056c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x01ce:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            long r15 = r0.zzo()     // Catch:{ zzalo -> 0x056c }
            java.lang.Long r4 = java.lang.Long.valueOf(r15)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x01e0:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            long r15 = r0.zzl()     // Catch:{ zzalo -> 0x056c }
            java.lang.Long r4 = java.lang.Long.valueOf(r15)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x01f2:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            float r4 = r0.zzb()     // Catch:{ zzalo -> 0x056c }
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0204:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            double r15 = r0.zza()     // Catch:{ zzalo -> 0x056c }
            java.lang.Double r4 = java.lang.Double.valueOf(r15)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r2, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0216:
            java.lang.Object r2 = r10.zzf((int) r3)     // Catch:{ zzalo -> 0x056c }
            int r3 = r10.zzc((int) r3)     // Catch:{ zzalo -> 0x056c }
            r3 = r3 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.lang.Object r13 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r3)     // Catch:{ zzalo -> 0x056c }
            if (r13 != 0) goto L_0x0230
            com.google.android.gms.internal.firebase-auth-api.zzamf r13 = r10.zzr     // Catch:{ zzalo -> 0x056c }
            java.lang.Object r13 = r13.zzb(r2)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r3, (java.lang.Object) r13)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0247
        L_0x0230:
            com.google.android.gms.internal.firebase-auth-api.zzamf r14 = r10.zzr     // Catch:{ zzalo -> 0x056c }
            boolean r14 = r14.zzf(r13)     // Catch:{ zzalo -> 0x056c }
            if (r14 == 0) goto L_0x0247
            com.google.android.gms.internal.firebase-auth-api.zzamf r14 = r10.zzr     // Catch:{ zzalo -> 0x056c }
            java.lang.Object r14 = r14.zzb(r2)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzamf r15 = r10.zzr     // Catch:{ zzalo -> 0x056c }
            r15.zza(r14, r13)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r3, (java.lang.Object) r14)     // Catch:{ zzalo -> 0x056c }
            r13 = r14
        L_0x0247:
            com.google.android.gms.internal.firebase-auth-api.zzamf r3 = r10.zzr     // Catch:{ zzalo -> 0x056c }
            java.util.Map r3 = r3.zze(r13)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzamf r4 = r10.zzr     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzamd r2 = r4.zza(r2)     // Catch:{ zzalo -> 0x056c }
            r0.zza(r3, r2, (com.google.android.gms.internal.p002firebaseauthapi.zzaku) r11)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0258:
            r2 = r4 & r14
            long r13 = (long) r2     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzanb r2 = r10.zze((int) r3)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzalw r3 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            java.util.List r3 = r3.zza(r1, r13)     // Catch:{ zzalo -> 0x056c }
            r0.zza(r3, r2, (com.google.android.gms.internal.p002firebaseauthapi.zzaku) r11)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x026a:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzm(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0278:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzl(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0286:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzk(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0294:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzj(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x02a2:
            com.google.android.gms.internal.firebase-auth-api.zzalw r13 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r4 = r4 & r14
            long r14 = (long) r4     // Catch:{ zzalo -> 0x056c }
            java.util.List r4 = r13.zza(r1, r14)     // Catch:{ zzalo -> 0x056c }
            r0.zzd(r4)     // Catch:{ zzalo -> 0x056c }
            r13 = r4
            com.google.android.gms.internal.firebase-auth-api.zzalj r4 = r10.zzd((int) r3)     // Catch:{ zzalo -> 0x056c }
            r3 = r6
            r6 = r5
            r5 = r3
            r3 = r13
            java.lang.Object r2 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ zzalo -> 0x0397, all -> 0x038f }
            r5 = r6
            goto L_0x038c
        L_0x02bd:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzp(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x02cb:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zza(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x02d9:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zze(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x02e7:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzf(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x02f5:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzh(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0303:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzq(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0311:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzi(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x031f:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzg(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x032d:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzc(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x033b:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzm(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0349:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzl(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0357:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzk(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0365:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzj(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0373:
            com.google.android.gms.internal.firebase-auth-api.zzalw r13 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r4 = r4 & r14
            long r14 = (long) r4     // Catch:{ zzalo -> 0x056c }
            java.util.List r4 = r13.zza(r1, r14)     // Catch:{ zzalo -> 0x056c }
            r0.zzd(r4)     // Catch:{ zzalo -> 0x056c }
            r13 = r4
            com.google.android.gms.internal.firebase-auth-api.zzalj r4 = r10.zzd((int) r3)     // Catch:{ zzalo -> 0x056c }
            r3 = r6
            r6 = r5
            r5 = r3
            r3 = r13
            java.lang.Object r2 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ zzalo -> 0x0397, all -> 0x038f }
            r5 = r6
        L_0x038c:
            r6 = r2
            goto L_0x0567
        L_0x038f:
            r0 = move-exception
            r17 = r6
            r6 = r5
            r5 = r17
            goto L_0x05d4
        L_0x0397:
            r17 = r6
            r6 = r5
            r5 = r17
            goto L_0x056c
        L_0x039e:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzp(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x03ac:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzb(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x03ba:
            com.google.android.gms.internal.firebase-auth-api.zzanb r2 = r10.zze((int) r3)     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzalw r13 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            java.util.List r3 = r13.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzb(r3, r2, (com.google.android.gms.internal.p002firebaseauthapi.zzaku) r11)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x03cc:
            boolean r2 = zzg((int) r4)     // Catch:{ zzalo -> 0x056c }
            if (r2 == 0) goto L_0x03e0
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzo(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x03e0:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzn(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x03ee:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zza(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x03fc:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zze(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x040a:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzf(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0418:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzh(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0426:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzq(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0434:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzi(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0442:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzg(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0450:
            com.google.android.gms.internal.firebase-auth-api.zzalw r2 = r10.zzo     // Catch:{ zzalo -> 0x056c }
            r3 = r4 & r14
            long r3 = (long) r3     // Catch:{ zzalo -> 0x056c }
            java.util.List r2 = r2.zza(r1, r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzc(r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x045e:
            java.lang.Object r2 = r10.zza(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzamm r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzamm) r2     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzanb r4 = r10.zze((int) r3)     // Catch:{ zzalo -> 0x056c }
            r0.zza(r2, r4, (com.google.android.gms.internal.p002firebaseauthapi.zzaku) r11)     // Catch:{ zzalo -> 0x056c }
            r10.zza(r1, (int) r3, (java.lang.Object) r2)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0470:
            r2 = r4 & r14
            long r13 = (long) r2     // Catch:{ zzalo -> 0x056c }
            long r8 = r0.zzn()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (long) r8)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x047f:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzi()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (int) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x048d:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            long r13 = r0.zzm()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (long) r13)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x049b:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzh()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (int) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x04a9:
            r8 = r2
            int r9 = r0.zze()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzalj r13 = r10.zzd((int) r3)     // Catch:{ zzalo -> 0x056c }
            if (r13 == 0) goto L_0x04c1
            boolean r13 = r13.zza(r9)     // Catch:{ zzalo -> 0x056c }
            if (r13 == 0) goto L_0x04bb
            goto L_0x04c1
        L_0x04bb:
            java.lang.Object r6 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(r1, r8, r9, r6, r5)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x04c1:
            r4 = r4 & r14
            long r13 = (long) r4     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13, (int) r9)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x04cb:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzj()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (int) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x04d9:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzajv r4 = r0.zzp()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x04e7:
            java.lang.Object r4 = r10.zza(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzamm r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzamm) r4     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.firebase-auth-api.zzanb r8 = r10.zze((int) r3)     // Catch:{ zzalo -> 0x056c }
            r0.zzb(r4, r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaku) r11)     // Catch:{ zzalo -> 0x056c }
            r10.zza(r1, (int) r3, (java.lang.Object) r4)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x04f9:
            r10.zza((java.lang.Object) r1, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzanc) r0)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0500:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            boolean r4 = r0.zzs()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc((java.lang.Object) r1, (long) r8, (boolean) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x050d:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzf()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (int) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x051a:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            long r13 = r0.zzk()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (long) r13)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0527:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            int r4 = r0.zzg()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (int) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0534:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            long r13 = r0.zzo()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (long) r13)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x0541:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            long r13 = r0.zzl()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (long) r13)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x054e:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            float r4 = r0.zzb()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (float) r4)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
            goto L_0x0567
        L_0x055b:
            r4 = r4 & r14
            long r8 = (long) r4     // Catch:{ zzalo -> 0x056c }
            double r13 = r0.zza()     // Catch:{ zzalo -> 0x056c }
            com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r8, (double) r13)     // Catch:{ zzalo -> 0x056c }
            r10.zzb(r1, (int) r3)     // Catch:{ zzalo -> 0x056c }
        L_0x0567:
            r1 = r10
        L_0x0568:
            r4 = r11
            r0 = r12
            goto L_0x0010
        L_0x056c:
            r3 = r1
            r1 = r10
            goto L_0x059d
        L_0x056f:
            r2 = 0
            boolean r2 = r5.zza(r6, (com.google.android.gms.internal.p002firebaseauthapi.zzanc) r0, (int) r2)     // Catch:{ all -> 0x0598 }
            if (r2 != 0) goto L_0x0596
            int r0 = r10.zzl
            r4 = r6
        L_0x0579:
            int r2 = r10.zzm
            if (r0 >= r2) goto L_0x058e
            int[] r2 = r10.zzk
            r3 = r2[r0]
            r6 = r19
            r2 = r1
            r1 = r10
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            r3 = r2
            int r0 = r0 + 1
            r1 = r3
            goto L_0x0579
        L_0x058e:
            r3 = r1
            r1 = r10
            if (r4 == 0) goto L_0x05ce
            r5.zzb((java.lang.Object) r3, r4)
            goto L_0x05ce
        L_0x0596:
            r3 = r1
            goto L_0x0567
        L_0x0598:
            r0 = move-exception
            r3 = r1
            r1 = r10
        L_0x059b:
            r2 = r3
            goto L_0x05da
        L_0x059d:
            r5.zza((com.google.android.gms.internal.p002firebaseauthapi.zzanc) r0)     // Catch:{ all -> 0x05d1 }
            if (r6 != 0) goto L_0x05a7
            java.lang.Object r4 = r5.zzc(r3)     // Catch:{ all -> 0x05d1 }
            r6 = r4
        L_0x05a7:
            r2 = 0
            boolean r2 = r5.zza(r6, (com.google.android.gms.internal.p002firebaseauthapi.zzanc) r0, (int) r2)     // Catch:{ all -> 0x05d1 }
            if (r2 != 0) goto L_0x05cf
            int r0 = r1.zzl
            r4 = r6
        L_0x05b1:
            int r2 = r1.zzm
            if (r0 >= r2) goto L_0x05c8
            int[] r2 = r1.zzk
            r2 = r2[r0]
            r6 = r19
            r17 = r3
            r3 = r2
            r2 = r17
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            int r0 = r0 + 1
            r3 = r2
            goto L_0x05b1
        L_0x05c8:
            r2 = r3
            if (r4 == 0) goto L_0x05ce
            r5.zzb((java.lang.Object) r2, r4)
        L_0x05ce:
            return
        L_0x05cf:
            r2 = r3
            goto L_0x0568
        L_0x05d1:
            r0 = move-exception
            goto L_0x059b
        L_0x05d3:
            r0 = move-exception
        L_0x05d4:
            r2 = r1
        L_0x05d5:
            r1 = r10
            goto L_0x05da
        L_0x05d7:
            r0 = move-exception
            r2 = r19
        L_0x05da:
            int r3 = r1.zzl
            r7 = r3
            r4 = r6
        L_0x05de:
            int r3 = r1.zzm
            if (r7 >= r3) goto L_0x05f2
            int[] r3 = r1.zzk
            r3 = r3[r7]
            r6 = r19
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            r1 = r2
            int r7 = r7 + 1
            r1 = r18
            goto L_0x05de
        L_0x05f2:
            r1 = r2
            if (r4 == 0) goto L_0x05f8
            r5.zzb((java.lang.Object) r1, r4)
        L_0x05f8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamq.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzanc, com.google.android.gms.internal.firebase-auth-api.zzaku):void");
    }

    public final void zza(T t, byte[] bArr, int i, int i2, zzaju zzaju) throws IOException {
        zza(t, bArr, i, i2, 0, zzaju);
    }

    private final void zza(T t, T t2, int i) {
        if (zzc(t2, i)) {
            long zzc2 = (long) (zzc(i) & 1048575);
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, zzc2);
            if (object != null) {
                zzanb zze2 = zze(i);
                if (!zzc(t, i)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t, zzc2, object);
                    } else {
                        Object zza2 = zze2.zza();
                        zze2.zza(zza2, object);
                        unsafe.putObject(t, zzc2, zza2);
                    }
                    zzb(t, i);
                    return;
                }
                Object object2 = unsafe.getObject(t, zzc2);
                if (!zzg(object2)) {
                    Object zza3 = zze2.zza();
                    zze2.zza(zza3, object2);
                    unsafe.putObject(t, zzc2, zza3);
                    object2 = zza3;
                }
                zze2.zza(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + String.valueOf(t2));
        }
    }

    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc(t2, i2, i)) {
            long zzc2 = (long) (zzc(i) & 1048575);
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, zzc2);
            if (object != null) {
                zzanb zze2 = zze(i);
                if (!zzc(t, i2, i)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t, zzc2, object);
                    } else {
                        Object zza2 = zze2.zza();
                        zze2.zza(zza2, object);
                        unsafe.putObject(t, zzc2, zza2);
                    }
                    zzb(t, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(t, zzc2);
                if (!zzg(object2)) {
                    Object zza3 = zze2.zza();
                    zze2.zza(zza3, object2);
                    unsafe.putObject(t, zzc2, zza3);
                    object2 = zza3;
                }
                zze2.zza(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + String.valueOf(t2));
        }
    }

    private final void zza(Object obj, int i, zzanc zzanc) throws IOException {
        if (zzg(i)) {
            zzanz.zza(obj, (long) (i & 1048575), (Object) zzanc.zzr());
        } else if (this.zzi) {
            zzanz.zza(obj, (long) (i & 1048575), (Object) zzanc.zzq());
        } else {
            zzanz.zza(obj, (long) (i & 1048575), (Object) zzanc.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int zzb2 = zzb(i);
        long j = (long) (1048575 & zzb2);
        if (j != 1048575) {
            zzanz.zza((Object) t, j, (1 << (zzb2 >>> 20)) | zzanz.zzc(t, j));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzanz.zza((Object) t, (long) (zzb(i2) & 1048575), i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, (long) (zzc(i) & 1048575), obj);
        zzb(t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, (long) (zzc(i2) & 1048575), obj);
        zzb(t, i, i2);
    }

    private final <K, V> void zza(zzaol zzaol, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzaol.zza(i, this.zzr.zza(zzf(i2)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zzaol zzaol) throws IOException {
        if (obj instanceof String) {
            zzaol.zza(i, (String) obj);
        } else {
            zzaol.zza(i, (zzajv) obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:195:0x05b4, code lost:
        r9 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x0a3a, code lost:
        r0 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x0a4d, code lost:
        r2 = r2 + 3;
        r5 = r4;
        r12 = r18;
        r11 = 1048575;
        r4 = r3;
        r3 = r7;
        r7 = r16;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0a5f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r21, com.google.android.gms.internal.p002firebaseauthapi.zzaol r22) throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r6 = r22
            int r2 = r6.zza()
            r3 = 2
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r9 = 1
            r10 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            if (r2 != r3) goto L_0x052d
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r2 = r0.zzp
            zza(r2, r1, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x0036
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r2 = r0.zzq
            com.google.android.gms.internal.firebase-auth-api.zzakx r2 = r2.zza((java.lang.Object) r1)
            com.google.android.gms.internal.firebase-auth-api.zzang<T, java.lang.Object> r3 = r2.zza
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0036
            java.util.Iterator r2 = r2.zzc()
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            goto L_0x0038
        L_0x0036:
            r2 = 0
            r3 = 0
        L_0x0038:
            int[] r4 = r0.zzc
            int r4 = r4.length
            int r4 = r4 + -3
        L_0x003d:
            if (r4 < 0) goto L_0x0515
            int r5 = r0.zzc((int) r4)
            int[] r12 = r0.zzc
            r12 = r12[r4]
        L_0x0047:
            if (r3 == 0) goto L_0x0065
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r13 = r0.zzq
            int r13 = r13.zza((java.util.Map.Entry<?, ?>) r3)
            if (r13 <= r12) goto L_0x0065
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r13 = r0.zzq
            r13.zza(r6, r3)
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            goto L_0x0047
        L_0x0063:
            r3 = 0
            goto L_0x0047
        L_0x0065:
            r13 = r5 & r7
            int r13 = r13 >>> 20
            switch(r13) {
                case 0: goto L_0x0502;
                case 1: goto L_0x04f2;
                case 2: goto L_0x04e2;
                case 3: goto L_0x04d2;
                case 4: goto L_0x04c2;
                case 5: goto L_0x04b2;
                case 6: goto L_0x04a2;
                case 7: goto L_0x0491;
                case 8: goto L_0x0480;
                case 9: goto L_0x046b;
                case 10: goto L_0x0458;
                case 11: goto L_0x0447;
                case 12: goto L_0x0436;
                case 13: goto L_0x0425;
                case 14: goto L_0x0414;
                case 15: goto L_0x0403;
                case 16: goto L_0x03f2;
                case 17: goto L_0x03dd;
                case 18: goto L_0x03cc;
                case 19: goto L_0x03bb;
                case 20: goto L_0x03aa;
                case 21: goto L_0x0399;
                case 22: goto L_0x0388;
                case 23: goto L_0x0377;
                case 24: goto L_0x0366;
                case 25: goto L_0x0355;
                case 26: goto L_0x0344;
                case 27: goto L_0x032f;
                case 28: goto L_0x031e;
                case 29: goto L_0x030d;
                case 30: goto L_0x02fc;
                case 31: goto L_0x02eb;
                case 32: goto L_0x02da;
                case 33: goto L_0x02c9;
                case 34: goto L_0x02b8;
                case 35: goto L_0x02a7;
                case 36: goto L_0x0296;
                case 37: goto L_0x0285;
                case 38: goto L_0x0274;
                case 39: goto L_0x0263;
                case 40: goto L_0x0252;
                case 41: goto L_0x0241;
                case 42: goto L_0x0230;
                case 43: goto L_0x021f;
                case 44: goto L_0x020e;
                case 45: goto L_0x01fd;
                case 46: goto L_0x01ec;
                case 47: goto L_0x01db;
                case 48: goto L_0x01ca;
                case 49: goto L_0x01b5;
                case 50: goto L_0x01aa;
                case 51: goto L_0x0199;
                case 52: goto L_0x0188;
                case 53: goto L_0x0177;
                case 54: goto L_0x0166;
                case 55: goto L_0x0155;
                case 56: goto L_0x0144;
                case 57: goto L_0x0133;
                case 58: goto L_0x0122;
                case 59: goto L_0x0111;
                case 60: goto L_0x00fc;
                case 61: goto L_0x00e9;
                case 62: goto L_0x00d8;
                case 63: goto L_0x00c7;
                case 64: goto L_0x00b6;
                case 65: goto L_0x00a5;
                case 66: goto L_0x0094;
                case 67: goto L_0x0083;
                case 68: goto L_0x006e;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x0511
        L_0x006e:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzanb r13 = r0.zze((int) r4)
            r6.zza((int) r12, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r13)
            goto L_0x0511
        L_0x0083:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = zzd(r1, r13)
            r6.zzd((int) r12, (long) r13)
            goto L_0x0511
        L_0x0094:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = zzc(r1, (long) r13)
            r6.zze((int) r12, (int) r5)
            goto L_0x0511
        L_0x00a5:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = zzd(r1, r13)
            r6.zzc((int) r12, (long) r13)
            goto L_0x0511
        L_0x00b6:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = zzc(r1, (long) r13)
            r6.zzd((int) r12, (int) r5)
            goto L_0x0511
        L_0x00c7:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = zzc(r1, (long) r13)
            r6.zza((int) r12, (int) r5)
            goto L_0x0511
        L_0x00d8:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = zzc(r1, (long) r13)
            r6.zzf(r12, r5)
            goto L_0x0511
        L_0x00e9:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzajv r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5
            r6.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5)
            goto L_0x0511
        L_0x00fc:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzanb r13 = r0.zze((int) r4)
            r6.zzb((int) r12, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r13)
            goto L_0x0511
        L_0x0111:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            zza((int) r12, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            goto L_0x0511
        L_0x0122:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            boolean r5 = zze(r1, r13)
            r6.zza((int) r12, (boolean) r5)
            goto L_0x0511
        L_0x0133:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = zzc(r1, (long) r13)
            r6.zzb((int) r12, (int) r5)
            goto L_0x0511
        L_0x0144:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = zzd(r1, r13)
            r6.zza((int) r12, (long) r13)
            goto L_0x0511
        L_0x0155:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = zzc(r1, (long) r13)
            r6.zzc((int) r12, (int) r5)
            goto L_0x0511
        L_0x0166:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = zzd(r1, r13)
            r6.zze((int) r12, (long) r13)
            goto L_0x0511
        L_0x0177:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = zzd(r1, r13)
            r6.zzb((int) r12, (long) r13)
            goto L_0x0511
        L_0x0188:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            float r5 = zzb(r1, (long) r13)
            r6.zza((int) r12, (float) r5)
            goto L_0x0511
        L_0x0199:
            boolean r13 = r0.zzc(r1, (int) r12, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            double r13 = zza(r1, (long) r13)
            r6.zza((int) r12, (double) r13)
            goto L_0x0511
        L_0x01aa:
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            r0.zza((com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (int) r12, (java.lang.Object) r5, (int) r4)
            goto L_0x0511
        L_0x01b5:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.firebase-auth-api.zzanb r13 = r0.zze((int) r4)
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (java.util.List<?>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (com.google.android.gms.internal.p002firebaseauthapi.zzanb<?>) r13)
            goto L_0x0511
        L_0x01ca:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzl(r12, r5, r6, r9)
            goto L_0x0511
        L_0x01db:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzk(r12, r5, r6, r9)
            goto L_0x0511
        L_0x01ec:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzj(r12, r5, r6, r9)
            goto L_0x0511
        L_0x01fd:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzi(r12, r5, r6, r9)
            goto L_0x0511
        L_0x020e:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r12, r5, r6, r9)
            goto L_0x0511
        L_0x021f:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzm(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0230:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (java.util.List<java.lang.Boolean>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (boolean) r9)
            goto L_0x0511
        L_0x0241:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0252:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zze(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0263:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzg(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0274:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzn(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0285:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzh(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0296:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzf(r12, r5, r6, r9)
            goto L_0x0511
        L_0x02a7:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r12, (java.util.List<java.lang.Double>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (boolean) r9)
            goto L_0x0511
        L_0x02b8:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzl(r12, r5, r6, r10)
            goto L_0x0511
        L_0x02c9:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzk(r12, r5, r6, r10)
            goto L_0x0511
        L_0x02da:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzj(r12, r5, r6, r10)
            goto L_0x0511
        L_0x02eb:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzi(r12, r5, r6, r10)
            goto L_0x0511
        L_0x02fc:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r12, r5, r6, r10)
            goto L_0x0511
        L_0x030d:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzm(r12, r5, r6, r10)
            goto L_0x0511
        L_0x031e:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzajv>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            goto L_0x0511
        L_0x032f:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.firebase-auth-api.zzanb r13 = r0.zze((int) r4)
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r12, (java.util.List<?>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (com.google.android.gms.internal.p002firebaseauthapi.zzanb<?>) r13)
            goto L_0x0511
        L_0x0344:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r12, (java.util.List<java.lang.String>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            goto L_0x0511
        L_0x0355:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r12, (java.util.List<java.lang.Boolean>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (boolean) r10)
            goto L_0x0511
        L_0x0366:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r12, r5, r6, r10)
            goto L_0x0511
        L_0x0377:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zze(r12, r5, r6, r10)
            goto L_0x0511
        L_0x0388:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzg(r12, r5, r6, r10)
            goto L_0x0511
        L_0x0399:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzn(r12, r5, r6, r10)
            goto L_0x0511
        L_0x03aa:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzh(r12, r5, r6, r10)
            goto L_0x0511
        L_0x03bb:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzf(r12, r5, r6, r10)
            goto L_0x0511
        L_0x03cc:
            int[] r12 = r0.zzc
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r12, (java.util.List<java.lang.Double>) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (boolean) r10)
            goto L_0x0511
        L_0x03dd:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzanb r13 = r0.zze((int) r4)
            r6.zza((int) r12, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r13)
            goto L_0x0511
        L_0x03f2:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r1, r13)
            r6.zzd((int) r12, (long) r13)
            goto L_0x0511
        L_0x0403:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r1, r13)
            r6.zze((int) r12, (int) r5)
            goto L_0x0511
        L_0x0414:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r1, r13)
            r6.zzc((int) r12, (long) r13)
            goto L_0x0511
        L_0x0425:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r1, r13)
            r6.zzd((int) r12, (int) r5)
            goto L_0x0511
        L_0x0436:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r1, r13)
            r6.zza((int) r12, (int) r5)
            goto L_0x0511
        L_0x0447:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r1, r13)
            r6.zzf(r12, r5)
            goto L_0x0511
        L_0x0458:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzajv r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5
            r6.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5)
            goto L_0x0511
        L_0x046b:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            com.google.android.gms.internal.firebase-auth-api.zzanb r13 = r0.zze((int) r4)
            r6.zzb((int) r12, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r13)
            goto L_0x0511
        L_0x0480:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r1, r13)
            zza((int) r12, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            goto L_0x0511
        L_0x0491:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            boolean r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzh(r1, r13)
            r6.zza((int) r12, (boolean) r5)
            goto L_0x0511
        L_0x04a2:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r1, r13)
            r6.zzb((int) r12, (int) r5)
            goto L_0x0511
        L_0x04b2:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r1, r13)
            r6.zza((int) r12, (long) r13)
            goto L_0x0511
        L_0x04c2:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r1, r13)
            r6.zzc((int) r12, (int) r5)
            goto L_0x0511
        L_0x04d2:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r1, r13)
            r6.zze((int) r12, (long) r13)
            goto L_0x0511
        L_0x04e2:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r1, r13)
            r6.zzb((int) r12, (long) r13)
            goto L_0x0511
        L_0x04f2:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            float r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzb(r1, r13)
            r6.zza((int) r12, (float) r5)
            goto L_0x0511
        L_0x0502:
            boolean r13 = r0.zzc(r1, (int) r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            double r13 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r13)
            r6.zza((int) r12, (double) r13)
        L_0x0511:
            int r4 = r4 + -3
            goto L_0x003d
        L_0x0515:
            if (r3 == 0) goto L_0x052c
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r1 = r0.zzq
            r1.zza(r6, r3)
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x052a
            java.lang.Object r1 = r2.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r3 = r1
            goto L_0x0515
        L_0x052a:
            r3 = 0
            goto L_0x0515
        L_0x052c:
            return
        L_0x052d:
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x054b
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r2 = r0.zzq
            com.google.android.gms.internal.firebase-auth-api.zzakx r2 = r2.zza((java.lang.Object) r1)
            com.google.android.gms.internal.firebase-auth-api.zzang<T, java.lang.Object> r3 = r2.zza
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x054b
            java.util.Iterator r2 = r2.zzd()
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            r12 = r2
            goto L_0x054d
        L_0x054b:
            r3 = 0
            r12 = 0
        L_0x054d:
            int[] r2 = r0.zzc
            int r13 = r2.length
            sun.misc.Unsafe r14 = zzb
            r2 = r10
            r5 = r2
            r4 = r11
        L_0x0555:
            if (r2 >= r13) goto L_0x0a5b
            int r15 = r0.zzc((int) r2)
            r16 = r7
            int[] r7 = r0.zzc
            r8 = r7[r2]
            r17 = r15 & r16
            int r10 = r17 >>> 20
            r17 = r9
            r9 = 17
            if (r10 > r9) goto L_0x058a
            int r9 = r2 + 2
            r7 = r7[r9]
            r9 = r7 & r11
            if (r9 == r4) goto L_0x057e
            if (r9 != r11) goto L_0x0577
            r5 = 0
            goto L_0x057d
        L_0x0577:
            long r4 = (long) r9
            int r4 = r14.getInt(r1, r4)
            r5 = r4
        L_0x057d:
            r4 = r9
        L_0x057e:
            int r7 = r7 >>> 20
            int r7 = r17 << r7
            r19 = r7
            r7 = r3
            r3 = r4
            r4 = r5
            r5 = r19
            goto L_0x058e
        L_0x058a:
            r7 = r3
            r3 = r4
            r4 = r5
            r5 = 0
        L_0x058e:
            if (r7 == 0) goto L_0x05ac
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r9 = r0.zzq
            int r9 = r9.zza((java.util.Map.Entry<?, ?>) r7)
            if (r9 > r8) goto L_0x05ac
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r9 = r0.zzq
            r9.zza(r6, r7)
            boolean r7 = r12.hasNext()
            if (r7 == 0) goto L_0x05aa
            java.lang.Object r7 = r12.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            goto L_0x058e
        L_0x05aa:
            r7 = 0
            goto L_0x058e
        L_0x05ac:
            r9 = r15 & r11
            r18 = r12
            long r11 = (long) r9
            switch(r10) {
                case 0: goto L_0x0a3d;
                case 1: goto L_0x0a2a;
                case 2: goto L_0x0a19;
                case 3: goto L_0x0a08;
                case 4: goto L_0x09f7;
                case 5: goto L_0x09e6;
                case 6: goto L_0x09d5;
                case 7: goto L_0x09c4;
                case 8: goto L_0x09b2;
                case 9: goto L_0x099c;
                case 10: goto L_0x0988;
                case 11: goto L_0x0976;
                case 12: goto L_0x0964;
                case 13: goto L_0x0952;
                case 14: goto L_0x0940;
                case 15: goto L_0x092e;
                case 16: goto L_0x091c;
                case 17: goto L_0x0906;
                case 18: goto L_0x08f4;
                case 19: goto L_0x08e2;
                case 20: goto L_0x08d0;
                case 21: goto L_0x08be;
                case 22: goto L_0x08ac;
                case 23: goto L_0x089a;
                case 24: goto L_0x0888;
                case 25: goto L_0x0876;
                case 26: goto L_0x0865;
                case 27: goto L_0x0850;
                case 28: goto L_0x083f;
                case 29: goto L_0x082d;
                case 30: goto L_0x081b;
                case 31: goto L_0x0809;
                case 32: goto L_0x07f7;
                case 33: goto L_0x07e5;
                case 34: goto L_0x07d3;
                case 35: goto L_0x07c2;
                case 36: goto L_0x07b1;
                case 37: goto L_0x07a0;
                case 38: goto L_0x078f;
                case 39: goto L_0x077e;
                case 40: goto L_0x076d;
                case 41: goto L_0x075c;
                case 42: goto L_0x074b;
                case 43: goto L_0x073a;
                case 44: goto L_0x0729;
                case 45: goto L_0x0718;
                case 46: goto L_0x0707;
                case 47: goto L_0x06f6;
                case 48: goto L_0x06e5;
                case 49: goto L_0x06d2;
                case 50: goto L_0x06c9;
                case 51: goto L_0x06ba;
                case 52: goto L_0x06ab;
                case 53: goto L_0x069c;
                case 54: goto L_0x068d;
                case 55: goto L_0x067e;
                case 56: goto L_0x066f;
                case 57: goto L_0x0660;
                case 58: goto L_0x0651;
                case 59: goto L_0x0642;
                case 60: goto L_0x062f;
                case 61: goto L_0x061f;
                case 62: goto L_0x0611;
                case 63: goto L_0x0603;
                case 64: goto L_0x05f5;
                case 65: goto L_0x05e7;
                case 66: goto L_0x05d9;
                case 67: goto L_0x05cb;
                case 68: goto L_0x05b9;
                default: goto L_0x05b4;
            }
        L_0x05b4:
            r9 = r17
        L_0x05b6:
            r10 = 0
            goto L_0x0a4d
        L_0x05b9:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.firebase-auth-api.zzanb r9 = r0.zze((int) r2)
            r6.zza((int) r8, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r9)
            goto L_0x05b4
        L_0x05cb:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            long r9 = zzd(r1, r11)
            r6.zzd((int) r8, (long) r9)
            goto L_0x05b4
        L_0x05d9:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            int r5 = zzc(r1, (long) r11)
            r6.zze((int) r8, (int) r5)
            goto L_0x05b4
        L_0x05e7:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            long r9 = zzd(r1, r11)
            r6.zzc((int) r8, (long) r9)
            goto L_0x05b4
        L_0x05f5:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            int r5 = zzc(r1, (long) r11)
            r6.zzd((int) r8, (int) r5)
            goto L_0x05b4
        L_0x0603:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            int r5 = zzc(r1, (long) r11)
            r6.zza((int) r8, (int) r5)
            goto L_0x05b4
        L_0x0611:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            int r5 = zzc(r1, (long) r11)
            r6.zzf(r8, r5)
            goto L_0x05b4
        L_0x061f:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.firebase-auth-api.zzajv r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5
            r6.zza((int) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r5)
            goto L_0x05b4
        L_0x062f:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.firebase-auth-api.zzanb r9 = r0.zze((int) r2)
            r6.zzb((int) r8, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r9)
            goto L_0x05b4
        L_0x0642:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            java.lang.Object r5 = r14.getObject(r1, r11)
            zza((int) r8, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            goto L_0x05b4
        L_0x0651:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            boolean r5 = zze(r1, r11)
            r6.zza((int) r8, (boolean) r5)
            goto L_0x05b4
        L_0x0660:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            int r5 = zzc(r1, (long) r11)
            r6.zzb((int) r8, (int) r5)
            goto L_0x05b4
        L_0x066f:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            long r9 = zzd(r1, r11)
            r6.zza((int) r8, (long) r9)
            goto L_0x05b4
        L_0x067e:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            int r5 = zzc(r1, (long) r11)
            r6.zzc((int) r8, (int) r5)
            goto L_0x05b4
        L_0x068d:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            long r9 = zzd(r1, r11)
            r6.zze((int) r8, (long) r9)
            goto L_0x05b4
        L_0x069c:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            long r9 = zzd(r1, r11)
            r6.zzb((int) r8, (long) r9)
            goto L_0x05b4
        L_0x06ab:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            float r5 = zzb(r1, (long) r11)
            r6.zza((int) r8, (float) r5)
            goto L_0x05b4
        L_0x06ba:
            boolean r5 = r0.zzc(r1, (int) r8, (int) r2)
            if (r5 == 0) goto L_0x05b4
            double r9 = zza(r1, (long) r11)
            r6.zza((int) r8, (double) r9)
            goto L_0x05b4
        L_0x06c9:
            java.lang.Object r5 = r14.getObject(r1, r11)
            r0.zza((com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (int) r8, (java.lang.Object) r5, (int) r2)
            goto L_0x05b4
        L_0x06d2:
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-auth-api.zzanb r9 = r0.zze((int) r2)
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r5, (java.util.List<?>) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (com.google.android.gms.internal.p002firebaseauthapi.zzanb<?>) r9)
            goto L_0x05b4
        L_0x06e5:
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            r9 = r17
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzl(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x06f6:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzk(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x0707:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzj(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x0718:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzi(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x0729:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x073a:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzm(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x074b:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r5, (java.util.List<java.lang.Boolean>) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (boolean) r9)
            goto L_0x05b6
        L_0x075c:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x076d:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zze(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x077e:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzg(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x078f:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzn(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x07a0:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzh(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x07b1:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzf(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x07c2:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r5, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (boolean) r9)
            goto L_0x05b6
        L_0x07d3:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            r10 = 0
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzl(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x07e5:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzk(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x07f7:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzj(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x0809:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzi(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x081b:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzc(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x082d:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzm(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x083f:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r5, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzajv>) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            goto L_0x05b6
        L_0x0850:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-auth-api.zzanb r10 = r0.zze((int) r2)
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r5, (java.util.List<?>) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (com.google.android.gms.internal.p002firebaseauthapi.zzanb<?>) r10)
            goto L_0x05b6
        L_0x0865:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r5, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            goto L_0x05b6
        L_0x0876:
            r9 = r17
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            r10 = 0
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((int) r5, (java.util.List<java.lang.Boolean>) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (boolean) r10)
            goto L_0x0a4d
        L_0x0888:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzd(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x089a:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zze(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x08ac:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzg(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x08be:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzn(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x08d0:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzh(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x08e2:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzf(r5, r8, r6, r10)
            goto L_0x0a4d
        L_0x08f4:
            r9 = r17
            r10 = 0
            int[] r5 = r0.zzc
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p002firebaseauthapi.zzand.zzb((int) r5, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6, (boolean) r10)
            goto L_0x0a4d
        L_0x0906:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a4d
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.firebase-auth-api.zzanb r11 = r0.zze((int) r2)
            r6.zza((int) r8, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r11)
            goto L_0x0a4d
        L_0x091c:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            long r11 = r14.getLong(r1, r11)
            r6.zzd((int) r8, (long) r11)
            goto L_0x0a3a
        L_0x092e:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            int r0 = r14.getInt(r1, r11)
            r6.zze((int) r8, (int) r0)
            goto L_0x0a3a
        L_0x0940:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            long r11 = r14.getLong(r1, r11)
            r6.zzc((int) r8, (long) r11)
            goto L_0x0a3a
        L_0x0952:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            int r0 = r14.getInt(r1, r11)
            r6.zzd((int) r8, (int) r0)
            goto L_0x0a3a
        L_0x0964:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            int r0 = r14.getInt(r1, r11)
            r6.zza((int) r8, (int) r0)
            goto L_0x0a3a
        L_0x0976:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            int r0 = r14.getInt(r1, r11)
            r6.zzf(r8, r0)
            goto L_0x0a3a
        L_0x0988:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            java.lang.Object r0 = r14.getObject(r1, r11)
            com.google.android.gms.internal.firebase-auth-api.zzajv r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r0
            r6.zza((int) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r0)
            goto L_0x0a3a
        L_0x099c:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a4d
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.firebase-auth-api.zzanb r11 = r0.zze((int) r2)
            r6.zzb((int) r8, (java.lang.Object) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r11)
            goto L_0x0a4d
        L_0x09b2:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            java.lang.Object r0 = r14.getObject(r1, r11)
            zza((int) r8, (java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            goto L_0x0a3a
        L_0x09c4:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            boolean r0 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzh(r1, r11)
            r6.zza((int) r8, (boolean) r0)
            goto L_0x0a3a
        L_0x09d5:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            int r0 = r14.getInt(r1, r11)
            r6.zzb((int) r8, (int) r0)
            goto L_0x0a3a
        L_0x09e6:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            long r11 = r14.getLong(r1, r11)
            r6.zza((int) r8, (long) r11)
            goto L_0x0a3a
        L_0x09f7:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            int r0 = r14.getInt(r1, r11)
            r6.zzc((int) r8, (int) r0)
            goto L_0x0a3a
        L_0x0a08:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            long r11 = r14.getLong(r1, r11)
            r6.zze((int) r8, (long) r11)
            goto L_0x0a3a
        L_0x0a19:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            long r11 = r14.getLong(r1, r11)
            r6.zzb((int) r8, (long) r11)
            goto L_0x0a3a
        L_0x0a2a:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a3a
            float r0 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzb(r1, r11)
            r6.zza((int) r8, (float) r0)
        L_0x0a3a:
            r0 = r20
            goto L_0x0a4d
        L_0x0a3d:
            r9 = r17
            r10 = 0
            boolean r5 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r5 == 0) goto L_0x0a4d
            double r11 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r1, (long) r11)
            r6.zza((int) r8, (double) r11)
        L_0x0a4d:
            int r2 = r2 + 3
            r5 = r4
            r12 = r18
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r3
            r3 = r7
            r7 = r16
            goto L_0x0555
        L_0x0a5b:
            r18 = r12
        L_0x0a5d:
            if (r3 == 0) goto L_0x0a74
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r2 = r0.zzq
            r2.zza(r6, r3)
            boolean r2 = r18.hasNext()
            if (r2 == 0) goto L_0x0a72
            java.lang.Object r2 = r18.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            r3 = r2
            goto L_0x0a5d
        L_0x0a72:
            r3 = 0
            goto L_0x0a5d
        L_0x0a74:
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r2 = r0.zzp
            zza(r2, r1, (com.google.android.gms.internal.p002firebaseauthapi.zzaol) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamq.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzaol):void");
    }

    private static <UT, UB> void zza(zzanu<UT, UB> zzanu, T t, zzaol zzaol) throws IOException {
        zzanu.zzb(zzanu.zzd(t), zzaol);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc(t, i) == zzc(t2, i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzh(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzh(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzb(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzb(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzand.zza(com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzc((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzb((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r4)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzand.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzh(r10, r6)
            boolean r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzh(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzb(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zzb(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r10, (long) r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.p002firebaseauthapi.zzanz.zza((java.lang.Object) r11, (long) r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = r1
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r0 = r9.zzp
            java.lang.Object r0 = r0.zzd(r10)
            com.google.android.gms.internal.firebase-auth-api.zzanu<?, ?> r2 = r9.zzp
            java.lang.Object r2 = r2.zzd(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r0 = r9.zzq
            com.google.android.gms.internal.firebase-auth-api.zzakx r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.firebase-auth-api.zzakw<?> r0 = r9.zzq
            com.google.android.gms.internal.firebase-auth-api.zzakx r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamq.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    private final boolean zzc(T t, int i) {
        int zzb2 = zzb(i);
        long j = (long) (zzb2 & 1048575);
        if (j == 1048575) {
            int zzc2 = zzc(i);
            long j2 = (long) (zzc2 & 1048575);
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    return Double.doubleToRawLongBits(zzanz.zza((Object) t, j2)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zzanz.zzb(t, j2)) != 0;
                case 2:
                    return zzanz.zzd(t, j2) != 0;
                case 3:
                    return zzanz.zzd(t, j2) != 0;
                case 4:
                    return zzanz.zzc(t, j2) != 0;
                case 5:
                    return zzanz.zzd(t, j2) != 0;
                case 6:
                    return zzanz.zzc(t, j2) != 0;
                case 7:
                    return zzanz.zzh(t, j2);
                case 8:
                    Object zze2 = zzanz.zze(t, j2);
                    if (zze2 instanceof String) {
                        return !((String) zze2).isEmpty();
                    }
                    if (zze2 instanceof zzajv) {
                        return !zzajv.zza.equals(zze2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzanz.zze(t, j2) != null;
                case 10:
                    return !zzajv.zza.equals(zzanz.zze(t, j2));
                case 11:
                    return zzanz.zzc(t, j2) != 0;
                case 12:
                    return zzanz.zzc(t, j2) != 0;
                case 13:
                    return zzanz.zzc(t, j2) != 0;
                case 14:
                    return zzanz.zzd(t, j2) != 0;
                case 15:
                    return zzanz.zzc(t, j2) != 0;
                case 16:
                    return zzanz.zzd(t, j2) != 0;
                case 17:
                    return zzanz.zze(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzanz.zzc(t, j) & (1 << (zzb2 >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc(t, i);
        }
        return (i3 & i4) != 0;
    }

    public final boolean zze(T t) {
        int i;
        int i2;
        T t2;
        zzamq zzamq;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.zzl) {
            int i6 = this.zzk[i4];
            int i7 = this.zzc[i6];
            int zzc2 = zzc(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i5 = zzb.getInt(t, (long) i9);
                }
                i = i5;
                i2 = i9;
            } else {
                i2 = i3;
                i = i5;
            }
            if ((268435456 & zzc2) != 0) {
                zzamq = this;
                t2 = t;
                if (!zzamq.zza(t2, i6, i2, i, i10)) {
                    return false;
                }
            } else {
                zzamq = this;
                t2 = t;
            }
            int i11 = (267386880 & zzc2) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zzc(t2, i7, i6) && !zza((Object) t2, zzc2, zze(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzd2 = zzamq.zzr.zzd(zzanz.zze(t2, (long) (zzc2 & 1048575)));
                            if (!zzd2.isEmpty()) {
                                if (zzamq.zzr.zza(zzf(i6)).zzc.zzb() == zzaoj.MESSAGE) {
                                    zzanb<?> zzanb = null;
                                    for (Object next : zzd2.values()) {
                                        if (zzanb == null) {
                                            zzanb = zzamx.zza().zza(next.getClass());
                                        }
                                        if (!zzanb.zze(next)) {
                                            return false;
                                        }
                                    }
                                    continue;
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                List list = (List) zzanz.zze(t2, (long) (zzc2 & 1048575));
                if (!list.isEmpty()) {
                    zzanb zze2 = zze(i6);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!zze2.zze(list.get(i12))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzamq.zza(t2, i6, i2, i, i10) && !zza((Object) t2, zzc2, zze(i6))) {
                return false;
            }
            i4++;
            t = t2;
            i3 = i2;
            i5 = i;
        }
        return !this.zzh || this.zzq.zza((Object) t).zzg();
    }

    private static boolean zza(Object obj, int i, zzanb zzanb) {
        return zzanb.zze(zzanz.zze(obj, (long) (i & 1048575)));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzalf) {
            return ((zzalf) obj).zzw();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzanz.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzanz.zze(t, j)).booleanValue();
    }
}
