package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public abstract class zzcf extends zzby implements Set {
    @CheckForNull
    private transient zzcc zza;

    zzcf() {
    }

    static int zzh(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return 1073741824;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    public static zzcf zzk() {
        return zzcu.zza;
    }

    public static zzcf zzl(Object obj) {
        return new zzcz("FIDO");
    }

    public static zzcf zzm(Object obj, Object obj2) {
        return zzf(2, obj, obj2);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzcf) && zzg() && ((zzcf) obj).zzg() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                return size() == set.size() && containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return zzcy.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzdc iterator();

    /* access modifiers changed from: package-private */
    public boolean zzg() {
        return false;
    }

    public zzcc zzi() {
        zzcc zzcc = this.zza;
        if (zzcc != null) {
            return zzcc;
        }
        zzcc zzj = zzj();
        this.zza = zzj;
        return zzj;
    }

    /* access modifiers changed from: package-private */
    public zzcc zzj() {
        Object[] array = toArray();
        int i = zzcc.zzd;
        return zzcc.zzh(array, array.length);
    }

    private static zzcf zzf(int i, Object... objArr) {
        if (i == 0) {
            return zzcu.zza;
        }
        if (i == 1) {
            return new zzcz(Objects.requireNonNull(objArr[0]));
        }
        int zzh = zzh(i);
        Object[] objArr2 = new Object[zzh];
        int i2 = zzh - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzcr.zza(obj, i5);
            int hashCode = obj.hashCode();
            int zza2 = zzbx.zza(hashCode);
            while (true) {
                int i6 = zza2 & i2;
                Object obj2 = objArr2[i6];
                if (obj2 != null) {
                    if (obj2.equals(obj)) {
                        break;
                    }
                    zza2++;
                } else {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += hashCode;
                    i4++;
                    break;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzcz(Objects.requireNonNull(objArr[0]));
        }
        if (zzh(i4) < zzh / 2) {
            return zzf(i4, objArr);
        }
        if (i4 <= 0) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzcu(objArr, i3, objArr2, i2, i4);
    }
}
