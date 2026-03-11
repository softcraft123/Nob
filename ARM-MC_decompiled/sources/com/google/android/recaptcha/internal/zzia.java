package com.google.android.recaptcha.internal;

import android.content.Context;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzia implements zzih {
    private final Context zza;

    public zzia(Context context) {
        this.zza = context;
    }

    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzie.zza(this, objArr);
    }

    public final Object zza(Object... objArr) {
        return zzap.zza(this.zza.getContentResolver());
    }
}
