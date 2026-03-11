package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzii implements zzih {
    private final Context zza;
    private final Map zzb = MapsKt.mapOf(TuplesKt.to(2, Context.ACTIVITY_SERVICE), TuplesKt.to(3, Context.TELEPHONY_SERVICE), TuplesKt.to(4, Context.INPUT_METHOD_SERVICE), TuplesKt.to(5, Context.AUDIO_SERVICE));

    public zzii(Context context) {
        this.zza = context;
    }

    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzie.zza(this, objArr);
    }

    public final Object zza(Object... objArr) {
        Integer num = objArr[0];
        if (true != (num instanceof Integer)) {
            num = null;
        }
        Integer num2 = num;
        if (num2 != null) {
            Object obj = this.zzb.get(Integer.valueOf(num2.intValue()));
            if (obj != null) {
                return this.zza.getSystemService((String) obj);
            }
            throw new zzce(4, 4, (Throwable) null);
        }
        throw new zzce(4, 5, (Throwable) null);
    }
}
