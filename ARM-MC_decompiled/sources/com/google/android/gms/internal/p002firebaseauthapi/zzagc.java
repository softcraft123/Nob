package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzagc {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final HashMap<String, zzagj> zzd = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final zzael zza(zzael zzael, String str) {
        return new zzagh(this, zzael, str);
    }

    static String zza(String str) {
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        Signature[] signatureArr;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures;
            } else {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
            }
            String zza2 = zza(packageName, signatureArr[0].toCharsString());
            if (zza2 != null) {
                return zza2;
            }
            zza.e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    private static String zza(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str3.getBytes(StandardCharsets.UTF_8));
            String substring = Base64.encodeToString(Arrays.copyOf(instance.digest(), 9), 3).substring(0, 11);
            zza.d("Package: " + str + " -- Hash: " + substring, new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e) {
            zza.e("NoSuchAlgorithm: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    static /* synthetic */ void zzb(zzagc zzagc, String str) {
        zzagj zzagj = zzagc.zzd.get(str);
        if (zzagj != null && !zzac.zzc(zzagj.zzd) && !zzac.zzc(zzagj.zze) && !zzagj.zzb.isEmpty()) {
            for (zzael zza2 : zzagj.zzb) {
                zza2.zza(PhoneAuthCredential.zza(zzagj.zzd, zzagj.zze));
            }
            zzagj.zzh = true;
        }
    }

    zzagc(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    public final void zzd(String str) {
        zzagj zzagj = this.zzd.get(str);
        if (zzagj != null && !zzagj.zzh && !zzac.zzc(zzagj.zzd)) {
            zza.w("Timed out waiting for SMS.", new Object[0]);
            for (zzael zza2 : zzagj.zzb) {
                zza2.zza(zzagj.zzd);
            }
            zzagj.zzi = true;
        }
    }

    /* access modifiers changed from: private */
    public final void zze(String str) {
        zzagj zzagj = this.zzd.get(str);
        if (zzagj != null) {
            if (!zzagj.zzi) {
                zzd(str);
            }
            zzb(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzael zzael, String str) {
        zzagj zzagj = this.zzd.get(str);
        if (zzagj != null) {
            zzagj.zzb.add(zzael);
            if (zzagj.zzg) {
                zzael.zzb(zzagj.zzd);
            }
            if (zzagj.zzh) {
                zzael.zza(PhoneAuthCredential.zza(zzagj.zzd, zzagj.zze));
            }
            if (zzagj.zzi) {
                zzael.zza(zzagj.zzd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str) {
        zzagj zzagj = this.zzd.get(str);
        if (zzagj != null) {
            if (zzagj.zzf != null && !zzagj.zzf.isDone()) {
                zzagj.zzf.cancel(false);
            }
            zzagj.zzb.clear();
            this.zzd.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzael zzael, long j, boolean z) {
        this.zzd.put(str, new zzagj(j, z));
        zzb(zzael, str);
        zzagj zzagj = this.zzd.get(str);
        if (zzagj.zza <= 0) {
            zza.w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagj.zzf = this.zzc.schedule(new zzagf(this, str), zzagj.zza, TimeUnit.SECONDS);
        if (!zzagj.zzc) {
            zza.w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagg zzagg = new zzagg(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        ContextCompat.registerReceiver(this.zzb.getApplicationContext(), zzagg, intentFilter, 2);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzage(this));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(String str) {
        return this.zzd.get(str) != null;
    }
}
