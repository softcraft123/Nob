package com.google.android.recaptcha.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzbs {
    private final GoogleApiAvailabilityLight zza;

    public zzbs() {
        this.zza = GoogleApiAvailabilityLight.getInstance();
    }

    public zzbs(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zza = googleApiAvailabilityLight;
    }

    public final int zza(Context context) {
        int isGooglePlayServicesAvailable = this.zza.isGooglePlayServicesAvailable(context);
        return (isGooglePlayServicesAvailable == 1 || isGooglePlayServicesAvailable == 3 || isGooglePlayServicesAvailable == 9) ? 4 : 3;
    }
}
