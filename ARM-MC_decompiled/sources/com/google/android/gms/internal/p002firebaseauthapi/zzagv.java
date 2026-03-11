package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class zzagv implements zzaez<zzagv> {
    private static final String zza = "zzagv";
    private List<String> zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzagv zza(String str) throws zzacn {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("authUri", (String) null);
            jSONObject.optBoolean("registered", false);
            jSONObject.optString("providerId", (String) null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (!jSONObject.has("allProviders")) {
                zzaiw.zza();
            } else {
                new zzaiw(1, zzajk.zza(jSONObject.optJSONArray("allProviders")));
            }
            this.zzb = zzajk.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajk.zza(e, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }

    public zzagv() {
        zzaiw.zza();
    }
}
