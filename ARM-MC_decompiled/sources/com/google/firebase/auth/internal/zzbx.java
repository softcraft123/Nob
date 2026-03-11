package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.internal.p002firebaseauthapi.zzahs;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzbx {
    FirebaseApp zza;
    zzbs zzb;
    private final Object zzc;
    private final Map<String, Task<RecaptchaTasksClient>> zzd;
    private zzahs zze;
    private FirebaseAuth zzf;

    private final Task<RecaptchaTasksClient> zzc(String str) {
        Task<RecaptchaTasksClient> task;
        synchronized (this.zzc) {
            task = this.zzd.get(str);
        }
        return task;
    }

    public final Task<String> zza(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String zzd2 = zzd(str);
        Task<RecaptchaTasksClient> zzc2 = zzc(zzd2);
        if (bool.booleanValue() || zzc2 == null) {
            zzc2 = zza(zzd2, bool);
        }
        return zzc2.continueWithTask(new zzbz(this, recaptchaAction));
    }

    public final Task<RecaptchaTasksClient> zza(String str, Boolean bool) {
        Task<RecaptchaTasksClient> zzc2;
        String zzd2 = zzd(str);
        if (bool.booleanValue() || (zzc2 = zzc(zzd2)) == null) {
            return this.zzf.zza("RECAPTCHA_ENTERPRISE").continueWithTask(new zzbw(this, zzd2));
        }
        return zzc2;
    }

    private static String zzd(String str) {
        return zzac.zzc(str) ? "*" : str;
    }

    static /* synthetic */ void zza(zzbx zzbx, zzahs zzahs, Task task, String str) {
        synchronized (zzbx.zzc) {
            zzbx.zze = zzahs;
            zzbx.zzd.put(str, task);
        }
    }

    public zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth) {
        this(firebaseApp, firebaseAuth, new zzbv());
    }

    private zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth, zzbs zzbs) {
        this.zzc = new Object();
        this.zzd = new HashMap();
        this.zza = firebaseApp;
        this.zzf = firebaseAuth;
        this.zzb = zzbs;
    }

    public final boolean zza(String str) {
        String zzb2;
        Preconditions.checkNotNull(str);
        zzahs zzahs = this.zze;
        if (zzahs == null || (zzb2 = zzahs.zzb(str)) == null) {
            return false;
        }
        return zzb2.equals("AUDIT");
    }

    public final boolean zzb(String str) {
        boolean z;
        synchronized (this.zzc) {
            zzahs zzahs = this.zze;
            z = zzahs != null && zzahs.zzc(str);
        }
        return z;
    }
}
