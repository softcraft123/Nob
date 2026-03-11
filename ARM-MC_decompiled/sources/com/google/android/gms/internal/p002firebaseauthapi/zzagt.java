package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.armmc.app.LogManager;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class zzagt implements zzaez<zzagt> {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzagt";
    private String zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzagt zza(String str) throws zzacn {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString(LogManager.EXTRA_MESSAGE);
            return this;
        } catch (NullPointerException | JSONException e) {
            Log.e(zza, "Failed to parse error for string [" + str + "] with exception: " + e.getMessage());
            throw new zzacn("Failed to parse error for string [" + str + "]", e);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return !TextUtils.isEmpty(this.zzb);
    }
}
