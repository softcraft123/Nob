package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final /* synthetic */ class zzbg implements OnCompleteListener {
    private /* synthetic */ GenericIdpActivity zza;
    private /* synthetic */ String zzb;

    public /* synthetic */ zzbg(GenericIdpActivity genericIdpActivity, String str) {
        this.zza = genericIdpActivity;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        GenericIdpActivity.zza(this.zza, this.zzb, task);
    }
}
