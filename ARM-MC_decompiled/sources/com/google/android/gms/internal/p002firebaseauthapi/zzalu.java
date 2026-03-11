package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class zzalu {
    private volatile zzamm zza;
    private volatile zzajv zzb;
    private volatile boolean zzc;

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return this.zzb.zzb();
        }
        if (this.zza != null) {
            return this.zza.zzl();
        }
        return 0;
    }

    public final zzajv zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                zzajv zzajv = this.zzb;
                return zzajv;
            }
            if (this.zza == null) {
                this.zzb = zzajv.zza;
            } else {
                this.zzb = this.zza.zzj();
            }
            zzajv zzajv2 = this.zzb;
            return zzajv2;
        }
    }

    private final zzamm zzb(zzamm zzamm) {
        if (this.zza == null) {
            synchronized (this) {
                if (this.zza == null) {
                    try {
                        this.zza = zzamm;
                        this.zzb = zzajv.zza;
                    } catch (zzall unused) {
                        this.zzc = true;
                        this.zza = zzamm;
                        this.zzb = zzajv.zza;
                    }
                }
            }
        }
        return this.zza;
    }

    public final zzamm zza(zzamm zzamm) {
        zzamm zzamm2 = this.zza;
        this.zzb = null;
        this.zza = zzamm;
        return zzamm2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzalu)) {
            return false;
        }
        zzalu zzalu = (zzalu) obj;
        zzamm zzamm = this.zza;
        zzamm zzamm2 = zzalu.zza;
        if (zzamm == null && zzamm2 == null) {
            return zzb().equals(zzalu.zzb());
        }
        if (zzamm != null && zzamm2 != null) {
            return zzamm.equals(zzamm2);
        }
        if (zzamm != null) {
            return zzamm.equals(zzalu.zzb(zzamm.zzs()));
        }
        return zzb(zzamm2.zzs()).equals(zzamm2);
    }
}
