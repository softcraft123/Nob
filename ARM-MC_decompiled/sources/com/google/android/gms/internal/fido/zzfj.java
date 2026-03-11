package com.google.android.gms.internal.fido;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzfj {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzfn zzb;

    static {
        zzfn zzfo;
        int i = 0;
        while (true) {
            if (i >= 2) {
                zzfo = new zzfo();
                break;
            }
            try {
                zzfo = (zzfn) Class.forName(zza[i]).asSubclass(zzfn.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
                zzfo = null;
            }
            if (zzfo != null) {
                break;
            }
            i++;
        }
        zzb = zzfo;
    }

    @NullableDecl
    public static StackTraceElement zza(Class cls, int i) {
        zzfk.zza(cls, TypedValues.AttributesType.S_TARGET);
        return zzb.zza(cls, 2);
    }
}
