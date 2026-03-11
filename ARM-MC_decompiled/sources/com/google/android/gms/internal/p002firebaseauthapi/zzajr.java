package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzajr {
    private static volatile int zza = 100;

    static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    static int zza(byte[] bArr, int i, zzaju zzaju) throws zzall {
        int zzc = zzc(bArr, i, zzaju);
        int i2 = zzaju.zza;
        if (i2 < 0) {
            throw zzall.zzf();
        } else if (i2 > bArr.length - zzc) {
            throw zzall.zzj();
        } else if (i2 == 0) {
            zzaju.zzc = zzajv.zza;
            return zzc;
        } else {
            zzaju.zzc = zzajv.zza(bArr, zzc, i2);
            return zzc + i2;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzamm zzamm, zzanu<zzanx, zzanx> zzanu, zzaju zzaju) throws IOException {
        if (zzaju.zzd.zza(zzamm, i >>> 3) == null) {
            return zza(i, bArr, i2, i3, zzamq.zzc(obj), zzaju);
        }
        zzalf.zzd zzd = (zzalf.zzd) obj;
        zzd.zza();
        zzakx<zzalf.zzc> zzakx = zzd.zzc;
        throw new NoSuchMethodError();
    }

    static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    private static <T> int zza(zzanb<T> zzanb, byte[] bArr, int i, int i2, int i3, zzaju zzaju) throws IOException {
        T zza2 = zzanb.zza();
        zzanb<T> zzanb2 = zzanb;
        zzaju zzaju2 = zzaju;
        int zza3 = zza((Object) zza2, zzanb2, bArr, i, i2, i3, zzaju2);
        zzanb2.zzd(zza2);
        zzaju2.zzc = zza2;
        return zza3;
    }

    static int zza(zzanb<?> zzanb, int i, byte[] bArr, int i2, int i3, zzalm<Object> zzalm, zzaju zzaju) throws IOException {
        int i4 = (i & -8) | 4;
        zzanb<?> zzanb2 = zzanb;
        byte[] bArr2 = bArr;
        int i5 = i3;
        zzaju zzaju2 = zzaju;
        int zza2 = zza(zzanb2, bArr2, i2, i5, i4, zzaju2);
        zzalm.add(zzaju2.zzc);
        while (zza2 < i5) {
            int zzc = zzc(bArr2, zza2, zzaju2);
            if (i != zzaju2.zza) {
                break;
            }
            zza2 = zza(zzanb2, bArr2, zzc, i5, i4, zzaju2);
            zzalm.add(zzaju2.zzc);
        }
        return zza2;
    }

    static <T> int zza(zzanb<T> zzanb, byte[] bArr, int i, int i2, zzaju zzaju) throws IOException {
        T zza2 = zzanb.zza();
        zzanb<T> zzanb2 = zzanb;
        zzaju zzaju2 = zzaju;
        int zza3 = zza((Object) zza2, zzanb2, bArr, i, i2, zzaju2);
        zzanb2.zzd(zza2);
        zzaju2.zzc = zza2;
        return zza3;
    }

    static int zzb(zzanb<?> zzanb, int i, byte[] bArr, int i2, int i3, zzalm<?> zzalm, zzaju zzaju) throws IOException {
        int zza2 = zza(zzanb, bArr, i2, i3, zzaju);
        zzalm.add(zzaju.zzc);
        while (zza2 < i3) {
            int zzc = zzc(bArr, zza2, zzaju);
            if (i != zzaju.zza) {
                break;
            }
            zza2 = zza(zzanb, bArr, zzc, i3, zzaju);
            zzalm.add(zzaju.zzc);
        }
        return zza2;
    }

    static int zza(byte[] bArr, int i, zzalm<?> zzalm, zzaju zzaju) throws IOException {
        zzali zzali = (zzali) zzalm;
        int zzc = zzc(bArr, i, zzaju);
        int i2 = zzaju.zza + zzc;
        while (zzc < i2) {
            zzc = zzc(bArr, zzc, zzaju);
            zzali.zzc(zzaju.zza);
        }
        if (zzc == i2) {
            return zzc;
        }
        throw zzall.zzj();
    }

    static int zzb(byte[] bArr, int i, zzaju zzaju) throws zzall {
        int zzc = zzc(bArr, i, zzaju);
        int i2 = zzaju.zza;
        if (i2 < 0) {
            throw zzall.zzf();
        } else if (i2 == 0) {
            zzaju.zzc = "";
            return zzc;
        } else {
            zzaju.zzc = zzaoa.zzb(bArr, zzc, i2);
            return zzc + i2;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzanx zzanx, zzaju zzaju) throws zzall {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                zzaju zzaju2 = zzaju;
                int zzd = zzd(bArr, i2, zzaju2);
                zzanx.zza(i, (Object) Long.valueOf(zzaju2.zzb));
                return zzd;
            } else if (i4 == 1) {
                zzanx.zza(i, (Object) Long.valueOf(zzd(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                byte[] bArr2 = bArr;
                zzaju zzaju3 = zzaju;
                int zzc = zzc(bArr2, i2, zzaju3);
                int i5 = zzaju3.zza;
                if (i5 < 0) {
                    throw zzall.zzf();
                } else if (i5 <= bArr2.length - zzc) {
                    if (i5 == 0) {
                        zzanx.zza(i, (Object) zzajv.zza);
                    } else {
                        zzanx.zza(i, (Object) zzajv.zza(bArr2, zzc, i5));
                    }
                    return zzc + i5;
                } else {
                    throw zzall.zzj();
                }
            } else if (i4 == 3) {
                zzanx zzd2 = zzanx.zzd();
                int i6 = (i & -8) | 4;
                zzaju.zze++;
                zza(zzaju.zze);
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzc2 = zzc(bArr, i2, zzaju);
                    i7 = zzaju.zza;
                    if (i7 == i6) {
                        i2 = zzc2;
                        break;
                    }
                    i2 = zza(i7, bArr, zzc2, i3, zzd2, zzaju);
                }
                int i8 = i3;
                zzaju.zze--;
                if (i2 > i8 || i7 != i6) {
                    throw zzall.zzg();
                }
                zzanx.zza(i, (Object) zzd2);
                return i2;
            } else if (i4 == 5) {
                zzanx.zza(i, (Object) Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzall.zzc();
            }
        } else {
            throw zzall.zzc();
        }
    }

    static int zzc(byte[] bArr, int i, zzaju zzaju) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzaju);
        }
        zzaju.zza = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzaju zzaju) {
        int i3 = i & WorkQueueKt.MASK;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzaju.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzaju.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzaju.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzaju.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzaju.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzalm<?> zzalm, zzaju zzaju) {
        zzali zzali = (zzali) zzalm;
        int zzc = zzc(bArr, i2, zzaju);
        zzali.zzc(zzaju.zza);
        while (zzc < i3) {
            int zzc2 = zzc(bArr, zzc, zzaju);
            if (i != zzaju.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzaju);
            zzali.zzc(zzaju.zza);
        }
        return zzc;
    }

    static int zzd(byte[] bArr, int i, zzaju zzaju) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzaju.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzaju.zzb = j2;
        return i3;
    }

    static <T> int zza(Object obj, zzanb<T> zzanb, byte[] bArr, int i, int i2, int i3, zzaju zzaju) throws IOException {
        zzaju.zze++;
        zza(zzaju.zze);
        zzamq zzamq = (zzamq) zzanb;
        Object obj2 = obj;
        int zza2 = zzamq.zza(obj2, bArr, i, i2, i3, zzaju);
        zzaju.zze--;
        zzaju.zzc = obj2;
        return zza2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> int zza(java.lang.Object r6, com.google.android.gms.internal.p002firebaseauthapi.zzanb<T> r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.p002firebaseauthapi.zzaju r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zza((int) r9, (byte[]) r8, (int) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzaju) r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x002f
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x002f
            int r10 = r11.zze
            int r10 = r10 + 1
            r11.zze = r10
            int r10 = r11.zze
            zza(r10)
            int r4 = r3 + r9
            r1 = r6
            r0 = r7
            r2 = r8
            r5 = r11
            r0.zza(r1, r2, r3, r4, r5)
            int r6 = r5.zze
            int r6 = r6 + -1
            r5.zze = r6
            r5.zzc = r1
            return r4
        L_0x002f:
            com.google.android.gms.internal.firebase-auth-api.zzall r6 = com.google.android.gms.internal.p002firebaseauthapi.zzall.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzajr.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzanb, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzaju):int");
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzaju zzaju) throws zzall {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzd(bArr, i2, zzaju);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zzc(bArr, i2, zzaju) + zzaju.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zzc(bArr, i2, zzaju);
                    i6 = zzaju.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzaju);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzall.zzg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzall.zzc();
            }
        } else {
            throw zzall.zzc();
        }
    }

    static long zzd(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private static void zza(int i) throws zzall {
        if (i >= zza) {
            throw zzall.zzh();
        }
    }
}
