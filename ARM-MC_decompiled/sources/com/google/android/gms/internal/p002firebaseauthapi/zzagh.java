package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzagh extends zzael {
    private final String zza;
    private final /* synthetic */ zzagc zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzagh(zzagc zzagc, zzael zzael, String str) {
        super(zzael);
        Objects.requireNonNull(zzagc);
        this.zzb = zzagc;
        this.zza = str;
    }

    public final void zzb(String str) {
        zzagc.zza.d("onCodeSent", new Object[0]);
        zzagj zzagj = (zzagj) this.zzb.zzd.get(this.zza);
        if (zzagj != null) {
            for (zzael zzb2 : zzagj.zzb) {
                zzb2.zzb(str);
            }
            zzagj.zzg = true;
            zzagj.zzd = str;
            if (zzagj.zza <= 0) {
                this.zzb.zze(this.zza);
            } else if (!zzagj.zzc) {
                this.zzb.zzd(this.zza);
            } else if (!zzac.zzc(zzagj.zze)) {
                zzagc.zzb(this.zzb, this.zza);
            }
        }
    }

    public final void zza(Status status) {
        Logger zza2 = zzagc.zza;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(status.getStatusCode());
        int i = 0;
        zza2.e("SMS verification code request failed: " + statusCodeString + " " + status.getStatusMessage(), new Object[0]);
        zzagj zzagj = (zzagj) this.zzb.zzd.get(this.zza);
        if (zzagj != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(zzagj.zzb);
            this.zzb.zzb(this.zza);
            ArrayList arrayList2 = arrayList;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzael) obj).zza(status);
            }
        }
    }
}
