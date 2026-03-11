package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.firebase.auth.zzan;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaba  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaba implements zzafv<zzaik> {
    private final /* synthetic */ zzail zza;
    private final /* synthetic */ zzahk zzb;
    private final /* synthetic */ zzael zzc;
    private final /* synthetic */ zzahv zzd;
    private final /* synthetic */ zzafs zze;
    private final /* synthetic */ zzaar zzf;

    zzaba(zzaar zzaar, zzail zzail, zzahk zzahk, zzael zzael, zzahv zzahv, zzafs zzafs) {
        this.zza = zzail;
        this.zzb = zzahk;
        this.zzc = zzael;
        this.zzd = zzahv;
        this.zze = zzafs;
        Objects.requireNonNull(zzaar);
        this.zzf = zzaar;
    }

    public final void zza(String str) {
        this.zze.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaik zzaik = (zzaik) obj;
        if (this.zza.zzi("EMAIL")) {
            this.zzb.zzb((String) null);
        } else if (this.zza.zzc() != null) {
            this.zzb.zzb(this.zza.zzc());
        }
        if (this.zza.zzi("DISPLAY_NAME")) {
            this.zzb.zza((String) null);
        } else if (this.zza.zzb() != null) {
            this.zzb.zza(this.zza.zzb());
        }
        if (this.zza.zzi("PHOTO_URL")) {
            this.zzb.zzc((String) null);
        } else if (this.zza.zze() != null) {
            this.zzb.zzc(this.zza.zze());
        }
        if (!TextUtils.isEmpty(this.zza.zzd())) {
            Preconditions.checkNotEmpty(Base64Utils.encode("redacted".getBytes()));
        }
        if (this.zza.zzi("delete_passkey")) {
            this.zzb.zza((zzah<zzan>) zzah.zzg());
        }
        List zze2 = zzaik.zze();
        if (zze2 == null) {
            zze2 = new ArrayList();
        }
        this.zzb.zza((List<zzaib>) zze2);
        zzael zzael = this.zzc;
        zzahv zzahv = this.zzd;
        Preconditions.checkNotNull(zzahv);
        Preconditions.checkNotNull(zzaik);
        String zzc2 = zzaik.zzc();
        String zzd2 = zzaik.zzd();
        if (!TextUtils.isEmpty(zzc2) && !TextUtils.isEmpty(zzd2)) {
            zzahv = new zzahv(zzd2, zzc2, Long.valueOf(zzaik.zza()), zzahv.zze());
        }
        zzael.zza(zzahv, this.zzb);
    }
}
