package com.google.firebase.auth.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzafz;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.internal.p002firebaseauthapi.zzahr;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class zzb {
    /* access modifiers changed from: private */
    public static final String zza = "zzb";
    private static final zzb zzb = new zzb();
    /* access modifiers changed from: private */
    public String zzc;

    public final Task<zzj> zza(FirebaseAuth firebaseAuth, String str, Activity activity, boolean z, boolean z2, boolean z3, RecaptchaAction recaptchaAction) {
        boolean z4 = z2;
        zzac zzac = (zzac) firebaseAuth.getFirebaseAuthSettings();
        zzcg zzc2 = zzcg.zzc();
        if (zzagl.zza(firebaseAuth.getApp()) || zzac.zze()) {
            return Tasks.forResult(new zzm().zza());
        }
        String str2 = zza;
        Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z4 + ", ForceRecaptchav2Flow from firebaseSettings = " + zzac.zzc());
        boolean z5 = z4 || zzac.zzc();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task<String> zzb2 = zzc2.zzb();
        if (zzb2 != null) {
            if (zzb2.isSuccessful()) {
                return Tasks.forResult(new zzm().zzc(zzb2.getResult()).zza());
            }
            Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + zzb2.getException().getMessage());
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (z5 || z3) {
            zza(firebaseAuth, str, activity, z, z5, zzc2, (TaskCompletionSource<zzj>) taskCompletionSource);
        } else {
            TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
            taskCompletionSource = taskCompletionSource2;
            firebaseAuth.initializeRecaptchaConfig().addOnCompleteListener(new zza(this, taskCompletionSource2, firebaseAuth, recaptchaAction, str, activity, z, false, zzc2));
        }
        return taskCompletionSource.getTask();
    }

    public static zzb zza() {
        return zzb;
    }

    public static /* synthetic */ void zza(zzb zzb2, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z, boolean z2, zzcg zzcg, Task task) {
        if (!task.isSuccessful()) {
            Log.e(zza, "Failed to initialize reCAPTCHA config: " + task.getException().getMessage());
        }
        if (firebaseAuth.zzb() == null || !firebaseAuth.zzb().zzb("PHONE_PROVIDER")) {
            zzb2.zza(firebaseAuth, str, activity, z, z2, zzcg, (TaskCompletionSource<zzj>) taskCompletionSource);
            return;
        }
        firebaseAuth.zzb().zza(firebaseAuth.getTenantId(), false, recaptchaAction).addOnSuccessListener(new zzf(zzb2, taskCompletionSource)).addOnFailureListener(new zzc(zzb2, firebaseAuth, str, activity, z, z2, zzcg, taskCompletionSource));
    }

    public static /* synthetic */ void zza(zzb zzb2, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzcg zzcg, Activity activity, Task task) {
        if (!task.isSuccessful() || task.getResult() == null || TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            Log.e(zza, "Play Integrity Token fetch failed, falling back to Recaptcha" + (task.getException() == null ? "" : task.getException().getMessage()));
            zzb2.zza(firebaseAuth, zzcg, activity, taskCompletionSource);
            return;
        }
        taskCompletionSource.setResult(new zzm().zza(((IntegrityTokenResponse) task.getResult()).token()).zza());
    }

    private zzb() {
    }

    private final void zza(FirebaseAuth firebaseAuth, zzcg zzcg, Activity activity, TaskCompletionSource<zzj> taskCompletionSource) {
        Task task;
        if (activity == null) {
            taskCompletionSource.setException(new FirebaseAuthMissingActivityForRecaptchaException());
            return;
        }
        zzbl.zza(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        if (!zzax.zza().zza(activity, (TaskCompletionSource<String>) taskCompletionSource2)) {
            task = Tasks.forException(zzaen.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        } else {
            new zzafz(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        }
        task.addOnSuccessListener(new zzg(this, taskCompletionSource)).addOnFailureListener(new zzh(this, taskCompletionSource));
    }

    /* access modifiers changed from: private */
    public final void zza(FirebaseAuth firebaseAuth, String str, Activity activity, boolean z, boolean z2, zzcg zzcg, TaskCompletionSource<zzj> taskCompletionSource) {
        Task<zzahr> task;
        if (!z || z2) {
            zza(firebaseAuth, zzcg, activity, taskCompletionSource);
            return;
        }
        IntegrityManager create = IntegrityManagerFactory.create(firebaseAuth.getApp().getApplicationContext());
        if (!TextUtils.isEmpty(this.zzc)) {
            task = Tasks.forResult(new zzahr(this.zzc));
        } else {
            task = firebaseAuth.zza();
        }
        TaskCompletionSource<zzj> taskCompletionSource2 = taskCompletionSource;
        task.continueWithTask(firebaseAuth.zzf(), new zze(this, str, create)).addOnCompleteListener(new zzd(this, taskCompletionSource2, firebaseAuth, zzcg, activity));
    }

    public static boolean zza(Exception exc) {
        if (!(exc instanceof FirebaseAuthMissingActivityForRecaptchaException)) {
            return (exc instanceof FirebaseAuthException) && ((FirebaseAuthException) exc).getErrorCode().endsWith("UNAUTHORIZED_DOMAIN");
        }
        return true;
    }
}
