package com.google.android.recaptcha.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final /* synthetic */ class zzdz extends FunctionReferenceImpl implements Function1 {
    zzdz(Object obj) {
        super(1, obj, zzec.class, "isRetriable", "isRetriable(Ljava/lang/Exception;)Z", 0);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(zzec.zzo((Exception) obj));
    }
}
