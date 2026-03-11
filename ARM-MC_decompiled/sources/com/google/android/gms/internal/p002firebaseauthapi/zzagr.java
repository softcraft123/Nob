package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzagr extends zzaih {
    private String zza;
    private String zzb;
    private String zzc;
    private zzahg zzd;
    private String zze;

    public final zzaih zza(String str) {
        if (str != null) {
            this.zze = str;
            return this;
        }
        throw new NullPointerException("Null idToken");
    }

    public final zzaih zzb(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null providerId");
    }

    public final zzaih zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzaih zzd(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw new NullPointerException("Null token");
    }

    public final zzaih zza(zzahg zzahg) {
        if (zzahg != null) {
            this.zzd = zzahg;
            return this;
        }
        throw new NullPointerException("Null tokenType");
    }

    public final zzaie zza() {
        if (this.zza != null && this.zzc != null && this.zzd != null && this.zze != null) {
            return new zzago(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" providerId");
        }
        if (this.zzc == null) {
            sb.append(" token");
        }
        if (this.zzd == null) {
            sb.append(" tokenType");
        }
        if (this.zze == null) {
            sb.append(" idToken");
        }
        throw new IllegalStateException("Missing required properties:" + String.valueOf(sb));
    }

    zzagr() {
    }
}
