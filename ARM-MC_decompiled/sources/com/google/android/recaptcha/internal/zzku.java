package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzku {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzkt zzkt) throws zznn {
        int zzi = zzi(bArr, i, zzkt);
        int i2 = zzkt.zza;
        if (i2 < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i2 > bArr.length - zzi) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } else if (i2 == 0) {
            zzkt.zzc = zzle.zzb;
            return zzi;
        } else {
            zzkt.zzc = zzle.zzk(bArr, zzi, i2);
            return zzi + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    static int zzc(zzow zzow, byte[] bArr, int i, int i2, int i3, zzkt zzkt) throws IOException {
        Object zze = zzow.zze();
        zzow zzow2 = zzow;
        zzkt zzkt2 = zzkt;
        int zzm = zzm(zze, zzow2, bArr, i, i2, i3, zzkt2);
        zzow2.zzf(zze);
        zzkt2.zzc = zze;
        return zzm;
    }

    static int zzd(zzow zzow, byte[] bArr, int i, int i2, zzkt zzkt) throws IOException {
        Object zze = zzow.zze();
        zzow zzow2 = zzow;
        zzkt zzkt2 = zzkt;
        int zzn = zzn(zze, zzow2, bArr, i, i2, zzkt2);
        zzow2.zzf(zze);
        zzkt2.zzc = zze;
        return zzn;
    }

    static int zze(zzow zzow, int i, byte[] bArr, int i2, int i3, zznk zznk, zzkt zzkt) throws IOException {
        int zzd = zzd(zzow, bArr, i2, i3, zzkt);
        zznk.add(zzkt.zzc);
        while (zzd < i3) {
            int zzi = zzi(bArr, zzd, zzkt);
            if (i != zzkt.zza) {
                break;
            }
            zzd = zzd(zzow, bArr, zzi, i3, zzkt);
            zznk.add(zzkt.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zznk zznk, zzkt zzkt) throws IOException {
        zzne zzne = (zzne) zznk;
        int zzi = zzi(bArr, i, zzkt);
        int i2 = zzkt.zza + zzi;
        while (zzi < i2) {
            zzi = zzi(bArr, zzi, zzkt);
            zzne.zzh(zzkt.zza);
        }
        if (zzi == i2) {
            return zzi;
        }
        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(byte[] bArr, int i, zzkt zzkt) throws zznn {
        int zzi = zzi(bArr, i, zzkt);
        int i2 = zzkt.zza;
        if (i2 < 0) {
            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i2 == 0) {
            zzkt.zzc = "";
            return zzi;
        } else {
            zzkt.zzc = new String(bArr, zzi, i2, zznl.zza);
            return zzi + i2;
        }
    }

    static int zzh(int i, byte[] bArr, int i2, int i3, zzpm zzpm, zzkt zzkt) throws zznn {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                zzkt zzkt2 = zzkt;
                int zzl = zzl(bArr, i2, zzkt2);
                zzpm.zzj(i, Long.valueOf(zzkt2.zzb));
                return zzl;
            } else if (i4 == 1) {
                zzpm.zzj(i, Long.valueOf(zzp(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                byte[] bArr2 = bArr;
                zzkt zzkt3 = zzkt;
                int zzi = zzi(bArr2, i2, zzkt3);
                int i5 = zzkt3.zza;
                if (i5 < 0) {
                    throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                } else if (i5 <= bArr2.length - zzi) {
                    if (i5 == 0) {
                        zzpm.zzj(i, zzle.zzb);
                    } else {
                        zzpm.zzj(i, zzle.zzk(bArr2, zzi, i5));
                    }
                    return zzi + i5;
                } else {
                    throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzpm zzf = zzpm.zzf();
                int i7 = zzkt.zze + 1;
                zzkt.zze = i7;
                zzq(i7);
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzi2 = zzi(bArr, i2, zzkt);
                    int i9 = zzkt.zza;
                    if (i9 == i6) {
                        i8 = i9;
                        i2 = zzi2;
                        break;
                    }
                    i2 = zzh(i9, bArr, zzi2, i3, zzf, zzkt);
                    i8 = i9;
                }
                zzkt zzkt4 = zzkt;
                zzkt4.zze--;
                if (i2 > i3 || i8 != i6) {
                    throw new zznn("Failed to parse the message.");
                }
                zzpm.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzpm.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw new zznn("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new zznn("Protocol message contained an invalid tag (zero).");
        }
    }

    static int zzi(byte[] bArr, int i, zzkt zzkt) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzj(b, bArr, i2, zzkt);
        }
        zzkt.zza = b;
        return i2;
    }

    static int zzj(int i, byte[] bArr, int i2, zzkt zzkt) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & WorkQueueKt.MASK;
        if (b >= 0) {
            zzkt.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzkt.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzkt.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzkt.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzkt.zza = i11;
                return i12;
            }
        }
    }

    static int zzk(int i, byte[] bArr, int i2, int i3, zznk zznk, zzkt zzkt) {
        zzne zzne = (zzne) zznk;
        int zzi = zzi(bArr, i2, zzkt);
        zzne.zzh(zzkt.zza);
        while (zzi < i3) {
            int zzi2 = zzi(bArr, zzi, zzkt);
            if (i != zzkt.zza) {
                break;
            }
            zzi = zzi(bArr, zzi2, zzkt);
            zzne.zzh(zzkt.zza);
        }
        return zzi;
    }

    static int zzl(byte[] bArr, int i, zzkt zzkt) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzkt.zzb = j;
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
        zzkt.zzb = j2;
        return i3;
    }

    static int zzm(Object obj, zzow zzow, byte[] bArr, int i, int i2, int i3, zzkt zzkt) throws IOException {
        int i4 = zzkt.zze + 1;
        zzkt.zze = i4;
        zzq(i4);
        zzol zzol = (zzol) zzow;
        Object obj2 = obj;
        int zzc = zzol.zzc(obj2, bArr, i, i2, i3, zzkt);
        zzkt.zze--;
        zzkt.zzc = obj2;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzn(java.lang.Object r6, com.google.android.recaptcha.internal.zzow r7, byte[] r8, int r9, int r10, com.google.android.recaptcha.internal.zzkt r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzj(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x002d
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x002d
            int r10 = r11.zze
            int r10 = r10 + 1
            r11.zze = r10
            zzq(r10)
            int r4 = r3 + r9
            r1 = r6
            r0 = r7
            r2 = r8
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            int r6 = r5.zze
            int r6 = r6 + -1
            r5.zze = r6
            r5.zzc = r1
            return r4
        L_0x002d:
            com.google.android.recaptcha.internal.zznn r6 = new com.google.android.recaptcha.internal.zznn
            java.lang.String r7 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            r6.<init>((java.lang.String) r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzku.zzn(java.lang.Object, com.google.android.recaptcha.internal.zzow, byte[], int, int, com.google.android.recaptcha.internal.zzkt):int");
    }

    static int zzo(int i, byte[] bArr, int i2, int i3, zzkt zzkt) throws zznn {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzl(bArr, i2, zzkt);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zzi(bArr, i2, zzkt) + zzkt.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zzi(bArr, i2, zzkt);
                    i6 = zzkt.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zzo(i6, bArr, i2, i3, zzkt);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw new zznn("Failed to parse the message.");
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw new zznn("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new zznn("Protocol message contained an invalid tag (zero).");
        }
    }

    static long zzp(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzq(int i) throws zznn {
        if (i >= zzb) {
            throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
