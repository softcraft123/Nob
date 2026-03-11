package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import com.google.firebase.auth.TotpMultiFactorInfo;
import com.google.firebase.auth.zzan;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzcb {
    private Context zza;
    private String zzb;
    private SharedPreferences zzc = this.zza.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.zzb}), 0);
    private Logger zzd = new Logger("StorageHelpers", new String[0]);

    public final FirebaseUser zza() {
        String zza2 = zza("com.google.firebase.auth.FIREBASE_USER");
        if (TextUtils.isEmpty(zza2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(zza2);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return zza(jSONObject);
            }
        } catch (Exception unused) {
            this.zzd.i("Failed to restore user data from persistent storage.", new Object[0]);
        }
        return null;
    }

    public final zzahv zza(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String zza2 = zza(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
        if (zza2 == null) {
            return null;
        }
        try {
            return zzahv.zzb(zza2);
        } catch (zzaao unused) {
            this.zzd.i("Failed to restore token data from persistent storage.", new Object[0]);
            return null;
        }
    }

    private final zzaf zza(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Object obj;
        zzah zza2;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String str = ExifInterface.GPS_MEASUREMENT_2D;
            String string3 = jSONObject.getString("version");
            if (string3 != null) {
                str = string3;
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzab.zza(jSONArray3.getString(i)));
            }
            zzaf zzaf = new zzaf(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzaf.zza(zzahv.zzb(string));
            }
            if (!z) {
                zzaf.zzb();
            }
            zzaf.zza(str);
            if (jSONObject.has("userMetadata") && (zza2 = zzah.zza(jSONObject.getJSONObject("userMetadata"))) != null) {
                zzaf.zza(zza2);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i2));
                    String optString = jSONObject2.optString(MultiFactorInfo.FACTOR_ID_KEY);
                    if ("phone".equals(optString)) {
                        obj = PhoneMultiFactorInfo.zza(jSONObject2);
                    } else {
                        obj = Objects.equals(optString, TotpMultiFactorGenerator.FACTOR_ID) ? TotpMultiFactorInfo.zza(jSONObject2) : null;
                    }
                    arrayList2.add(obj);
                }
                zzaf.zzc(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList3.add(zzan.zza(new JSONObject(jSONArray.getString(i3))));
                }
                zzaf.zzb(arrayList3);
            }
            return zzaf;
        } catch (zzaao | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e) {
            this.zzd.wtf(e);
            return null;
        }
    }

    private final String zza(String str) {
        String string = this.zzc.getString(str, (String) null);
        if (string != null) {
            return string.startsWith("ENCRYPTED:") ? zzby.zza(this.zza, this.zzb).zza(string.substring(10)) : string;
        }
        return null;
    }

    private final String zzd(FirebaseUser firebaseUser) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (!(firebaseUser instanceof zzaf)) {
            return null;
        }
        zzaf zzaf = (zzaf) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", zzaf.zze());
            jSONObject.put("applicationName", zzaf.zza().getName());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zzaf.zzj() != null) {
                JSONArray jSONArray = new JSONArray();
                List<zzab> zzj = zzaf.zzj();
                int size = zzj.size();
                if (zzj.size() > 30) {
                    this.zzd.w("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(zzj.size()));
                    size = 30;
                }
                int i = 0;
                boolean z2 = false;
                while (true) {
                    z = true;
                    if (i >= size) {
                        break;
                    }
                    zzab zzab = zzj.get(i);
                    if (zzab.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                        z2 = true;
                    }
                    if (i == size - 1 && !z2) {
                        break;
                    }
                    jSONArray.put(zzab.zzb());
                    i++;
                }
                if (!z2) {
                    int i2 = size - 1;
                    while (true) {
                        if (i2 >= zzj.size() || i2 < 0) {
                            z = z2;
                        } else {
                            zzab zzab2 = zzj.get(i2);
                            if (zzab2.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                                jSONArray.put(zzab2.zzb());
                                break;
                            }
                            if (i2 == zzj.size() - 1) {
                                jSONArray.put(zzab2.zzb());
                            }
                            i2++;
                        }
                    }
                    z = z2;
                    if (!z) {
                        this.zzd.w("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(zzj.size()), Integer.valueOf(size));
                        if (zzj.size() < 5) {
                            StringBuilder sb = new StringBuilder("Provider user info list:\n");
                            for (zzab providerId : zzj) {
                                sb.append(String.format("Provider - %s\n", new Object[]{providerId.getProviderId()}));
                            }
                            this.zzd.w(sb.toString(), new Object[0]);
                        }
                    }
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", zzaf.isAnonymous());
            jSONObject.put("version", ExifInterface.GPS_MEASUREMENT_2D);
            if (zzaf.getMetadata() != null) {
                jSONObject.put("userMetadata", ((zzah) zzaf.getMetadata()).zza());
            }
            List<MultiFactorInfo> enrolledFactors = ((zzaj) zzaf.getMultiFactor()).getEnrolledFactors();
            if (enrolledFactors != null && !enrolledFactors.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < enrolledFactors.size(); i3++) {
                    jSONArray2.put(enrolledFactors.get(i3).toJson());
                }
                jSONObject.put("userMultiFactorInfo", jSONArray2);
            }
            List<zzan> zzf = zzaf.zzf();
            if (zzf != null && !zzf.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i4 = 0; i4 < zzf.size(); i4++) {
                    jSONArray3.put(zzan.zza(zzf.get(i4)));
                }
                jSONObject.put("passkeyInfo", jSONArray3);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            this.zzd.wtf("Failed to turn object into JSON", e, new Object[0]);
            throw new zzaao(e);
        }
    }

    public zzcb(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zza = context.getApplicationContext();
    }

    private final void zzb(String str) {
        this.zzc.edit().remove(str).apply();
    }

    public final void zzb() {
        zzb("com.google.firebase.auth.FIREBASE_USER");
    }

    public final void zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        zzb(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
    }

    private final void zza(String str, String str2) {
        String zzb2 = zzby.zza(this.zza, this.zzb).zzb(str2);
        if (zzb2 != null) {
            this.zzc.edit().putString(str, "ENCRYPTED:" + zzb2).apply();
        }
    }

    public final void zzc(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String zzd2 = zzd(firebaseUser);
        if (!TextUtils.isEmpty(zzd2)) {
            zza("com.google.firebase.auth.FIREBASE_USER", zzd2);
        }
    }

    public final void zza(FirebaseUser firebaseUser, zzahv zzahv) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzahv);
        zza(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), zzahv.zzf());
    }
}
