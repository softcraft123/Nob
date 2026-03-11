package com.google.android.gms.internal.p002firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zzan;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzahk {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzaia zzf;
    private String zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private zze zzk;
    private List<zzahy> zzl;
    private zzah<zzan> zzm;

    public final long zza() {
        return this.zzh;
    }

    public final long zzb() {
        return this.zzi;
    }

    public final Uri zzc() {
        if (!TextUtils.isEmpty(this.zze)) {
            return Uri.parse(this.zze);
        }
        return null;
    }

    public final zzah<zzan> zzd() {
        return this.zzm;
    }

    public final zze zze() {
        return this.zzk;
    }

    public final zzahk zza(zze zze2) {
        this.zzk = zze2;
        return this;
    }

    public final zzahk zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzahk zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzahk zza(boolean z) {
        this.zzj = z;
        return this;
    }

    public final zzahk zza(zzah<zzan> zzah) {
        Preconditions.checkNotNull(zzah);
        this.zzm = zzah;
        return this;
    }

    public final zzahk zzc(String str) {
        this.zze = str;
        return this;
    }

    public final zzahk zza(List<zzaib> list) {
        Preconditions.checkNotNull(list);
        zzaia zzaia = new zzaia();
        this.zzf = zzaia;
        zzaia.zza().addAll(list);
        return this;
    }

    public final zzaia zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return this.zza;
    }

    public final String zzj() {
        return this.zzg;
    }

    public final List<zzahy> zzk() {
        return this.zzl;
    }

    public final List<zzaib> zzl() {
        return this.zzf.zza();
    }

    public zzahk() {
        this.zzf = new zzaia();
        this.zzm = zzah.zzg();
    }

    public zzahk(String str, String str2, boolean z, String str3, String str4, zzaia zzaia, String str5, String str6, long j, long j2, boolean z2, zze zze2, List<zzahy> list, zzah<zzan> zzah) {
        zzaia zzaia2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = str4;
        if (zzaia == null) {
            zzaia2 = new zzaia();
        } else {
            List<zzaib> zza2 = zzaia.zza();
            zzaia zzaia3 = new zzaia();
            if (zza2 != null) {
                zzaia3.zza().addAll(zza2);
            }
            zzaia2 = zzaia3;
        }
        this.zzf = zzaia2;
        this.zzg = str6;
        this.zzh = j;
        this.zzi = j2;
        this.zzj = false;
        this.zzk = null;
        this.zzl = list == null ? new ArrayList<>() : list;
        this.zzm = zzah;
    }

    public final boolean zzm() {
        return this.zzc;
    }

    public final boolean zzn() {
        return this.zzj;
    }
}
