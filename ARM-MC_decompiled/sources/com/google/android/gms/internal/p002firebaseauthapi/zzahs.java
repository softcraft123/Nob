package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class zzahs implements zzaez<zzahs> {
    private static final String zza = "zzahs";
    private String zzb;
    private zzah<zzaid> zzc;

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzahs zza(String str) throws zzacn {
        zzah<zzaid> zzah;
        zzaid zzaid;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        zzak zzf = zzah.zzf();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 == null) {
                                zzaid = zzaid.zza((String) null, (String) null);
                            } else {
                                zzaid = zzaid.zza(Strings.emptyToNull(jSONObject2.optString("provider")), Strings.emptyToNull(jSONObject2.optString("enforcementState")));
                            }
                            zzf.zza(zzaid);
                        }
                        zzah = zzf.zza();
                        this.zzc = zzah;
                    }
                }
                zzah = zzah.zzg();
                this.zzc = zzah;
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajk.zza(e, zza, str);
        }
    }

    public final String zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzah<zzaid> zzah = this.zzc;
        if (zzah != null && !zzah.isEmpty()) {
            zzah<zzaid> zzah2 = this.zzc;
            zzah zzah3 = zzah2;
            int size = zzah2.size();
            int i = 0;
            while (i < size) {
                Object obj = zzah2.get(i);
                i++;
                zzaid zzaid = (zzaid) obj;
                String zza2 = zzaid.zza();
                String zzb2 = zzaid.zzb();
                if (zza2 != null && zzb2 != null && zzb2.equals(str)) {
                    return zzaid.zza();
                }
            }
        }
        return null;
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzc(String str) {
        String zzb2 = zzb(str);
        if (zzb2 == null) {
            return false;
        }
        if (zzb2.equals("ENFORCE") || zzb2.equals("AUDIT")) {
            return true;
        }
        return false;
    }
}
