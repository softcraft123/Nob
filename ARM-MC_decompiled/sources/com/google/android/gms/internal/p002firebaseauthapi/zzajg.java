package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzajg implements zzafa {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    public static zzajg zza(String str, String str2, boolean z) {
        zzajg zzajg = new zzajg();
        zzajg.zzb = Preconditions.checkNotEmpty(str);
        zzajg.zzc = Preconditions.checkNotEmpty(str2);
        zzajg.zzf = z;
        return zzajg;
    }

    public static zzajg zzb(String str, String str2, boolean z) {
        zzajg zzajg = new zzajg();
        zzajg.zza = Preconditions.checkNotEmpty(str);
        zzajg.zzd = Preconditions.checkNotEmpty(str2);
        zzajg.zzf = z;
        return zzajg;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    private zzajg() {
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
