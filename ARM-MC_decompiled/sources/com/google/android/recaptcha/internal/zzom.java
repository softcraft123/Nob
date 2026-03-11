package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzom implements zzow {
    private final zzoi zza;
    private final zzpl zzb;
    private final boolean zzc;
    private final zzmp zzd;

    private zzom(zzpl zzpl, zzmp zzmp, zzoi zzoi) {
        this.zzb = zzpl;
        this.zzc = zzoi instanceof zzna;
        this.zzd = zzmp;
        this.zza = zzoi;
    }

    static zzom zzc(zzpl zzpl, zzmp zzmp, zzoi zzoi) {
        return new zzom(zzpl, zzmp, zzoi);
    }

    public final int zza(Object obj) {
        zzpm zzpm = ((zznd) obj).zzc;
        zzpm zzpm2 = zzpm;
        int zzb2 = zzpm.zzb();
        return this.zzc ? zzb2 + ((zzna) obj).zzb.zzb() : zzb2;
    }

    public final int zzb(Object obj) {
        int hashCode = ((zznd) obj).zzc.hashCode();
        return this.zzc ? (hashCode * 53) + ((zzna) obj).zzb.zza.hashCode() : hashCode;
    }

    public final Object zze() {
        zzoi zzoi = this.zza;
        if (zzoi instanceof zznd) {
            return ((zznd) zzoi).zzv();
        }
        return zzoi.zzad().zzl();
    }

    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzoy.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzoy.zzp(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, zzov zzov, zzmo zzmo) throws IOException {
        boolean z;
        zzpl zzpl = this.zzb;
        Object zza2 = zzpl.zza(obj);
        ((zzna) obj).zzi();
        while (true) {
            if (zzov.zzc() == Integer.MAX_VALUE) {
                break;
            }
            int zzd2 = zzov.zzd();
            int i = 0;
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    zznc zza3 = zzmo.zza(this.zza, zzd2 >>> 3);
                    if (zza3 == null) {
                        z = zzpl.zzk(zza2, zzov, 0);
                    } else {
                        zznc zznc = zza3;
                        throw null;
                    }
                } else {
                    z = zzov.zzO();
                }
                if (!z) {
                    break;
                }
            } else {
                zznc zznc2 = null;
                zzle zzle = null;
                while (true) {
                    try {
                        if (zzov.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd3 = zzov.zzd();
                        if (zzd3 == 16) {
                            i = zzov.zzj();
                            zznc2 = zzmo.zza(this.zza, i);
                        } else if (zzd3 == 26) {
                            if (zznc2 == null) {
                                zzle = zzov.zzp();
                            } else {
                                zznc zznc3 = zznc2;
                                throw null;
                            }
                        } else if (!zzov.zzO()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzpl.zzj(obj, zza2);
                        throw th;
                    }
                }
                if (zzov.zzd() != 12) {
                    throw new zznn("Protocol message end-group tag did not match expected tag.");
                } else if (zzle == null) {
                    continue;
                } else if (zznc2 == null) {
                    zzpl.zzg(zza2, i, zzle);
                } else {
                    zznc zznc4 = zznc2;
                    throw null;
                }
            }
        }
        zzpl.zzj(obj, zza2);
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkt zzkt) throws IOException {
        int i3;
        zznd zznd = (zznd) obj;
        zzpm zzpm = zznd.zzc;
        if (zzpm == zzpm.zzc()) {
            zzpm = zzpm.zzf();
            zznd.zzc = zzpm;
        }
        zzpm zzpm2 = zzpm;
        ((zzna) obj).zzi();
        zznc zznc = null;
        while (i < i2) {
            int zzi = zzku.zzi(bArr, i, zzkt);
            int i4 = zzkt.zza;
            if (i4 == 11) {
                byte[] bArr2 = bArr;
                int i5 = i2;
                zzkt zzkt2 = zzkt;
                int i6 = 0;
                zzle zzle = null;
                while (true) {
                    if (zzi >= i5) {
                        i3 = zzi;
                        break;
                    }
                    i3 = zzku.zzi(bArr2, zzi, zzkt2);
                    int i7 = zzkt2.zza;
                    int i8 = i7 >>> 3;
                    int i9 = i7 & 7;
                    if (i8 != 2) {
                        if (i8 == 3) {
                            if (zznc != null) {
                                int i10 = zzos.zza;
                                throw null;
                            } else if (i9 == 2) {
                                zzi = zzku.zza(bArr2, i3, zzkt2);
                                zzle = (zzle) zzkt2.zzc;
                            }
                        }
                    } else if (i9 == 0) {
                        zzi = zzku.zzi(bArr2, i3, zzkt2);
                        i6 = zzkt2.zza;
                        zznc = zzkt2.zzd.zza(this.zza, i6);
                        zznc zznc2 = zznc;
                    }
                    if (i7 == 12) {
                        break;
                    }
                    zzi = zzku.zzo(i7, bArr2, i3, i5, zzkt2);
                }
                if (zzle != null) {
                    zzpm2.zzj((i6 << 3) | 2, zzle);
                }
                i = i3;
                bArr = bArr2;
                i2 = i5;
                zzkt = zzkt2;
            } else if ((i4 & 7) == 2) {
                zznc = zzkt.zzd.zza(this.zza, i4 >>> 3);
                zznc zznc3 = zznc;
                if (zznc == null) {
                    i = zzku.zzh(i4, bArr, zzi, i2, zzpm2, zzkt);
                } else {
                    int i11 = zzos.zza;
                    throw null;
                }
            } else {
                i = zzku.zzo(i4, bArr, zzi, i2, zzkt);
            }
        }
        if (i != i2) {
            throw new zznn("Failed to parse the message.");
        }
    }

    public final void zzj(Object obj, zzpy zzpy) throws IOException {
        Iterator zzf = ((zzna) obj).zzb.zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzms zzms = (zzms) entry.getKey();
            if (zzms.zze() == zzpx.MESSAGE) {
                zzms.zzg();
                zzms.zzf();
                if (entry instanceof zznp) {
                    zzpy.zzw(zzms.zza(), ((zznp) entry).zza().zzb());
                } else {
                    zzpy.zzw(zzms.zza(), entry.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        zzpm zzpm = ((zznd) obj).zzc;
        zzpm zzpm2 = zzpm;
        zzpm.zzk(zzpy);
    }

    public final boolean zzk(Object obj, Object obj2) {
        if (!((zznd) obj).zzc.equals(((zznd) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzna) obj).zzb.equals(((zzna) obj2).zzb);
        }
        return true;
    }

    public final boolean zzl(Object obj) {
        return ((zzna) obj).zzb.zzk();
    }
}
