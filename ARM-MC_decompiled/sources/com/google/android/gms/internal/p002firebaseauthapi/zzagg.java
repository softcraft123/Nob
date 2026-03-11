package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzagg extends BroadcastReceiver {
    private final String zza;
    private final /* synthetic */ zzagc zzb;

    public zzagg(zzagc zzagc, String str) {
        Objects.requireNonNull(zzagc);
        this.zzb = zzagc;
        this.zza = str;
    }

    public final void onReceive(Context context, Intent intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                zzagj zzagj = (zzagj) this.zzb.zzd.get(this.zza);
                if (zzagj == null) {
                    zzagc.zza.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    zzagj.zze = zzagc.zza(str);
                    if (zzagj.zze == null) {
                        zzagc.zza.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzac.zzc(zzagj.zzd)) {
                        zzagc.zzb(this.zzb, this.zza);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
