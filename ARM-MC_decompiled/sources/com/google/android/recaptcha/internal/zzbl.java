package com.google.android.recaptcha.internal;

import androidx.core.view.PointerIconCompat;
import com.google.android.gms.location.GeofenceStatusCodes;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzbl {
    public static final zzbl zza = new zzbl(9999);
    public static final zzbl zzb = new zzbl(1004);
    public static final zzbl zzc = new zzbl(GeofenceStatusCodes.GEOFENCE_REQUEST_TOO_FREQUENT);
    public static final zzbl zzd = new zzbl(PointerIconCompat.TYPE_CELL);
    public static final zzbl zze = new zzbl(PointerIconCompat.TYPE_CROSSHAIR);
    public static final zzbl zzf = new zzbl(PointerIconCompat.TYPE_TEXT);
    public static final zzbl zzg = new zzbl(PointerIconCompat.TYPE_VERTICAL_TEXT);
    public static final zzbl zzh = new zzbl(PointerIconCompat.TYPE_ALIAS);
    private final int zzi;

    private zzbl(int i) {
        this.zzi = i;
    }

    public final int zza() {
        return this.zzi;
    }
}
