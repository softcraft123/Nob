package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zza;

    public UnsupportedApiCallException(Feature feature) {
        this.zza = feature;
    }

    public String getMessage() {
        String valueOf = String.valueOf(this.zza);
        String.valueOf(valueOf);
        return "Missing ".concat(String.valueOf(valueOf));
    }
}
