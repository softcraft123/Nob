package com.google.android.gms.internal.p002firebaseauthapi;

import com.armmc.app.billing.UserSubscriptionManager;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zzan;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class zzahl implements zzaez<zzahl> {
    private static final String zza = "zzahl";
    private zzahn zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzahl zza(String str) throws zzacn {
        zzahn zzahn;
        int i;
        zzahk zzahk;
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("users")) {
                zzahn = new zzahn();
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        boolean z = false;
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 == null) {
                                zzahk = new zzahk();
                                i = i2;
                            } else {
                                i = i2;
                                zzahk = new zzahk(Strings.emptyToNull(jSONObject2.optString("localId", (String) null)), Strings.emptyToNull(jSONObject2.optString("email", (String) null)), jSONObject2.optBoolean("emailVerified", z), Strings.emptyToNull(jSONObject2.optString("displayName", (String) null)), Strings.emptyToNull(jSONObject2.optString("photoUrl", (String) null)), zzaia.zza(jSONObject2.optJSONArray("providerUserInfo")), Strings.emptyToNull(jSONObject2.optString("rawPassword", (String) null)), Strings.emptyToNull(jSONObject2.optString("phoneNumber", (String) null)), jSONObject2.optLong(UserSubscriptionManager.FIELD_CREATED_AT, 0), jSONObject2.optLong("lastLoginAt", 0), false, (zze) null, zzahy.zza(jSONObject2.optJSONArray("mfaInfo")), zzan.zza(jSONObject2.optJSONArray("passkeyInfo")));
                            }
                            arrayList.add(zzahk);
                            i2 = i + 1;
                            z = false;
                        }
                        zzahn = new zzahn(arrayList);
                    }
                }
                zzahn = new zzahn(new ArrayList());
            }
            this.zzb = zzahn;
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajk.zza(e, zza, str2);
        }
    }

    public final List<zzahk> zza() {
        return this.zzb.zza();
    }
}
