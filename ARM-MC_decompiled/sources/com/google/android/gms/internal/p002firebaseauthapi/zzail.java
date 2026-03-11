package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzail  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzail implements zzafa {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private zzaiw zzg = new zzaiw();
    private boolean zzh = true;
    private zzaiw zzi = new zzaiw();
    private String zzj;

    public final zzail zza(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzi.zzb().add(str);
        return this;
    }

    public final zzail zzb(String str) {
        if (str == null) {
            this.zzg.zzb().add("DISPLAY_NAME");
            return this;
        }
        this.zzb = str;
        return this;
    }

    public final zzail zzc(String str) {
        if (str == null) {
            this.zzg.zzb().add("EMAIL");
            return this;
        }
        this.zzc = str;
        return this;
    }

    public final zzail zzd(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzail zze(String str) {
        this.zze = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzail zzf(String str) {
        if (str == null) {
            this.zzg.zzb().add("PASSWORD");
            return this;
        }
        this.zzd = str;
        return this;
    }

    public final zzail zzg(String str) {
        if (str == null) {
            this.zzg.zzb().add("PHOTO_URL");
            return this;
        }
        this.zzf = str;
        return this;
    }

    public final zzail zzh(String str) {
        this.zzj = str;
        return this;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zzf;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("returnSecureToken", this.zzh);
        if (!this.zzi.zzb().isEmpty()) {
            List<String> zzb2 = this.zzi.zzb();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < zzb2.size(); i++) {
                jSONArray.put(zzb2.get(i));
            }
            jSONObject.put("deleteProvider", jSONArray);
        }
        List<String> zzb3 = this.zzg.zzb();
        int size = zzb3.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < zzb3.size(); i2++) {
            String str = zzb3.get(i2);
            str.hashCode();
            int i3 = 2;
            char c = 65535;
            switch (str.hashCode()) {
                case -333046776:
                    if (str.equals("DISPLAY_NAME")) {
                        c = 0;
                        break;
                    }
                    break;
                case 66081660:
                    if (str.equals("EMAIL")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1939891618:
                    if (str.equals("PHOTO_URL")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1999612571:
                    if (str.equals("PASSWORD")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    break;
                case 1:
                    i3 = 1;
                    break;
                case 2:
                    i3 = 4;
                    break;
                case 3:
                    i3 = 5;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            iArr[i2] = i3;
        }
        if (size > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i4 = 0; i4 < size; i4++) {
                jSONArray2.put(iArr[i4]);
            }
            jSONObject.put("deleteAttribute", jSONArray2);
        }
        String str2 = this.zza;
        if (str2 != null) {
            jSONObject.put("idToken", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("email", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("password", str4);
        }
        String str5 = this.zzb;
        if (str5 != null) {
            jSONObject.put("displayName", str5);
        }
        String str6 = this.zzf;
        if (str6 != null) {
            jSONObject.put("photoUrl", str6);
        }
        String str7 = this.zze;
        if (str7 != null) {
            jSONObject.put("oobCode", str7);
        }
        String str8 = this.zzj;
        if (str8 != null) {
            jSONObject.put("tenantId", str8);
        }
        return jSONObject.toString();
    }

    public final boolean zzi(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzg.zzb().contains(str);
    }
}
