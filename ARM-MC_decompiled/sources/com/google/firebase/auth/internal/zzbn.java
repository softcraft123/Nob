package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final /* synthetic */ class zzbn implements OnCompleteListener {
    private /* synthetic */ RecaptchaActivity zza;
    private /* synthetic */ String zzb;

    public /* synthetic */ zzbn(RecaptchaActivity recaptchaActivity, String str) {
        this.zza = recaptchaActivity;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        RecaptchaActivity.zza(this.zza, this.zzb, task);
    }
}
