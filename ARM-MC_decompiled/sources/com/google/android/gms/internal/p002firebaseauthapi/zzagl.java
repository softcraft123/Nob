package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.collection.ArrayMap;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.firebase.FirebaseApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzagl {
    private static final Map<String, zzagk> zza = new ArrayMap();
    private static final Map<String, List<WeakReference<zzagn>>> zzb = new ArrayMap();

    private static String zza(String str, int i, boolean z) {
        if (z) {
            return "http://[" + str + "]:" + i + DomExceptionUtils.SEPARATOR;
        }
        return "http://" + str + ":" + i + DomExceptionUtils.SEPARATOR;
    }

    public static String zza(String str) {
        zzagk zzagk;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagk = map.get(str);
        }
        if (zzagk != null) {
            return zza(zzagk.zzb(), zzagk.zza(), zzagk.zzb().contains(":")) + "emulator/auth/handler";
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    public static String zzb(String str) {
        zzagk zzagk;
        String str2;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagk = map.get(str);
        }
        if (zzagk != null) {
            str2 = "" + zza(zzagk.zzb(), zzagk.zza(), zzagk.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "www.googleapis.com/identitytoolkit/v3/relyingparty";
    }

    public static String zzc(String str) {
        zzagk zzagk;
        String str2;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagk = map.get(str);
        }
        if (zzagk != null) {
            str2 = "" + zza(zzagk.zzb(), zzagk.zza(), zzagk.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "identitytoolkit.googleapis.com/v2";
    }

    public static String zzd(String str) {
        zzagk zzagk;
        String str2;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagk = map.get(str);
        }
        if (zzagk != null) {
            str2 = "" + zza(zzagk.zzb(), zzagk.zza(), zzagk.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "securetoken.googleapis.com/v1";
    }

    public static void zza(String str, zzagn zzagn) {
        Map<String, List<WeakReference<zzagn>>> map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                map.get(str).add(new WeakReference(zzagn));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference(zzagn));
                map.put(str, arrayList);
            }
        }
    }

    public static void zza(FirebaseApp firebaseApp, String str, int i) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map<String, zzagk> map = zza;
        synchronized (map) {
            map.put(apiKey, new zzagk(str, i));
        }
        Map<String, List<WeakReference<zzagn>>> map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                boolean z = false;
                for (WeakReference weakReference : map2.get(apiKey)) {
                    zzagn zzagn = (zzagn) weakReference.get();
                    if (zzagn != null) {
                        zzagn.zza();
                        z = true;
                    }
                }
                if (!z) {
                    zza.remove(apiKey);
                }
            }
        }
    }

    public static boolean zza(FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }
}
