package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzeg {
    private zzeg() {
        throw null;
    }

    public /* synthetic */ zzeg(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* access modifiers changed from: private */
    public static final int zzc(String str) {
        return Integer.parseInt(StringsKt.substringBefore$default(StringsKt.replace$default("18.6.1", ".", "", false, 4, (Object) null), "-", (String) null, 2, (Object) null));
    }

    /* access modifiers changed from: private */
    public static final String zzd(String str) {
        return "cesdb".concat(String.valueOf(StringsKt.substringAfter("18.6.1", "-", "")));
    }
}
