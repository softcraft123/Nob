package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zze;
import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaaz implements zzafv<zzahl> {
    private final /* synthetic */ zzafs zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ zze zze;
    private final /* synthetic */ zzael zzf;
    private final /* synthetic */ zzahv zzg;

    zzaaz(zzaar zzaar, zzafs zzafs, String str, String str2, Boolean bool, zze zze2, zzael zzael, zzahv zzahv) {
        this.zza = zzafs;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zze2;
        this.zzf = zzael;
        this.zzg = zzahv;
        Objects.requireNonNull(zzaar);
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzahk> zza2 = ((zzahl) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        boolean z = false;
        zzahk zzahk = zza2.get(0);
        zzaia zzf2 = zzahk.zzf();
        List<zzaib> zza3 = zzf2 != null ? zzf2.zza() : null;
        if (zza3 != null && !zza3.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                int i = 0;
                while (true) {
                    if (i >= zza3.size()) {
                        break;
                    } else if (zza3.get(i).zzf().equals(this.zzb)) {
                        zza3.get(i).zza(this.zzc);
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                zza3.get(0).zza(this.zzc);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzahk.zza(bool.booleanValue());
        } else {
            if (zzahk.zzb() - zzahk.zza() < 1000) {
                z = true;
            }
            zzahk.zza(z);
        }
        zzahk.zza(this.zze);
        this.zzf.zza(this.zzg, zzahk);
    }
}
