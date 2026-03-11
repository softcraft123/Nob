package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzb;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzj implements OnCompleteListener<com.google.firebase.auth.internal.zzj> {
    private final /* synthetic */ PhoneAuthOptions zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    zzj(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zza = phoneAuthOptions;
        this.zzb = str;
        Objects.requireNonNull(firebaseAuth);
        this.zzc = firebaseAuth;
    }

    public final void onComplete(Task<com.google.firebase.auth.internal.zzj> task) {
        String str;
        String str2;
        String str3;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            String str4 = "Error while validating application identity: ";
            if (exception != null) {
                str4 = str4 + exception.getMessage();
            }
            Log.e("FirebaseAuth", str4);
            if (exception == null || !zzb.zza(exception)) {
                Log.e("FirebaseAuth", "Proceeding without any application identifier.");
                str3 = null;
                str2 = null;
                str = null;
            } else {
                FirebaseAuth.zza((FirebaseException) exception, this.zza, this.zzb);
                return;
            }
        } else {
            str2 = task.getResult().zzd();
            str = task.getResult().zzb();
            str3 = task.getResult().zzc();
        }
        long longValue = this.zza.zzg().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = this.zzc.zza(this.zza.zzh(), this.zza.zze());
        if (TextUtils.isEmpty(str2)) {
            zza2 = this.zzc.zza(this.zza, zza2, task.getResult());
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = zza2;
        zzam zzam = (zzam) Preconditions.checkNotNull(this.zza.zzc());
        if (zzac.zzc(str3) && this.zzc.zzb() != null && this.zzc.zzb().zza("PHONE_PROVIDER")) {
            str3 = "NO_RECAPTCHA";
        }
        String str5 = str3;
        if (zzam.zzd()) {
            this.zzc.zzd.zza(zzam, (String) Preconditions.checkNotNull(this.zza.zzh()), this.zzc.zzj, longValue, this.zza.zzd() != null, this.zza.zzk(), str2, str, str5, this.zzc.zzh(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        } else {
            this.zzc.zzd.zza(zzam, (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzf()), this.zzc.zzj, longValue, this.zza.zzd() != null, this.zza.zzk(), str2, str, str5, this.zzc.zzh(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        }
    }
}
