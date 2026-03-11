package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaiv extends zzair {
    private static final String zza = "zzaiv";
    private String zzb;

    public final /* synthetic */ zzaez zza(String str) throws zzacn {
        return (zzaiv) zza(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final zzaiv zzb(String str) throws zzacn {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
                this.zzb = zzac.zza(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajk.zza(e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }
}
