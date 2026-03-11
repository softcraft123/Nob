package com.google.android.recaptcha.internal;

import com.google.common.net.HttpHeaders;
import java.net.HttpURLConnection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzex {
    private final zzfm zza;

    public zzex() {
        this((zzfm) null, 1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ zzex(zzfm zzfm, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this.zza = new zzfm();
    }

    public final zzew zza(String str) {
        try {
            HttpURLConnection zza2 = this.zza.zza(str);
            zza2.setRequestMethod("POST");
            zza2.setDoOutput(true);
            zza2.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-protobuffer");
            return new zzew(zza2);
        } catch (zzbd e) {
            throw e;
        } catch (Exception e2) {
            throw new zzbd(zzbb.zzc, zzba.zzai, e2.getMessage());
        }
    }
}
