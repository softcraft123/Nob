package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaia  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaia {
    private List<zzaib> zza;

    public static zzaia zza(JSONArray jSONArray) throws JSONException {
        zzaib zzaib;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzaia(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject == null) {
                zzaib = new zzaib();
            } else {
                zzaib = new zzaib(Strings.emptyToNull(jSONObject.optString("federatedId")), Strings.emptyToNull(jSONObject.optString("displayName")), Strings.emptyToNull(jSONObject.optString("photoUrl")), Strings.emptyToNull(jSONObject.optString("providerId")), (String) null, Strings.emptyToNull(jSONObject.optString("phoneNumber")), Strings.emptyToNull(jSONObject.optString("email")));
            }
            arrayList.add(zzaib);
        }
        return new zzaia(arrayList);
    }

    public final List<zzaib> zza() {
        return this.zza;
    }

    public zzaia() {
        this.zza = new ArrayList();
    }

    private zzaia(List<zzaib> list) {
        if (!list.isEmpty()) {
            this.zza = Collections.unmodifiableList(list);
        } else {
            this.zza = Collections.emptyList();
        }
    }
}
