package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzagb {
    private static final Map<String, zzagd> zza = new ArrayMap();

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, zzaff zzaff) {
        zza(str, zzaff);
        return new zzaga(onVerificationStateChangedCallbacks, str);
    }

    public static void zza() {
        zza.clear();
    }

    private static void zza(String str, zzaff zzaff) {
        zza.put(str, new zzagd(zzaff, DefaultClock.getInstance().currentTimeMillis()));
    }

    public static boolean zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        Map<String, zzagd> map = zza;
        if (map.containsKey(str)) {
            zzagd zzagd = map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzagd.zzb >= 120000) {
                zza(str, (zzaff) null);
                return false;
            } else if (zzagd.zza == null) {
                return true;
            } else {
                zzagd.zza.zza(onVerificationStateChangedCallbacks, activity, executor, str);
                return true;
            }
        } else {
            zza(str, (zzaff) null);
            return false;
        }
    }
}
