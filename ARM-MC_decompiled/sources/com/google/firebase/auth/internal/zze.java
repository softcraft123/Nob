package com.google.firebase.auth.internal;

import android.util.Base64;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.google.android.gms.internal.p002firebaseauthapi.zzahr;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import java.security.MessageDigest;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zze implements Continuation<zzahr, Task<IntegrityTokenResponse>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ IntegrityManager zzb;
    private final /* synthetic */ zzb zzc;

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful()) {
            this.zzc.zzc = ((zzahr) task.getResult()).zza();
            return this.zzb.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(((zzahr) task.getResult()).zza())).setNonce(new String(Base64.encode(MessageDigest.getInstance("SHA-256").digest(this.zza.getBytes(Key.STRING_CHARSET_NAME)), 11))).build());
        }
        Log.e(zzb.zza, "Problem retrieving Play Integrity producer project:  " + task.getException().getMessage());
        return Tasks.forException(task.getException());
    }

    zze(zzb zzb2, String str, IntegrityManager integrityManager) {
        this.zza = str;
        this.zzb = integrityManager;
        Objects.requireNonNull(zzb2);
        this.zzc = zzb2;
    }
}
