package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzahy;
import com.google.android.gms.internal.p002firebaseauthapi.zzaiz;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzbk {
    public static MultiFactorInfo zza(zzahy zzahy) {
        if (zzahy == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzahy.zze())) {
            return new PhoneMultiFactorInfo(zzahy.zzd(), zzahy.zzc(), zzahy.zza(), Preconditions.checkNotEmpty(zzahy.zze()));
        }
        if (zzahy.zzb() != null) {
            return new TotpMultiFactorInfo(zzahy.zzd(), zzahy.zzc(), zzahy.zza(), (zzaiz) Preconditions.checkNotNull(zzahy.zzb(), "totpInfo cannot be null."));
        }
        return null;
    }

    public static List<MultiFactorInfo> zza(List<zzahy> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (zzahy zza : list) {
            MultiFactorInfo zza2 = zza(zza);
            if (zza2 != null) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }
}
