package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaErrorCode;
import com.google.android.recaptcha.RecaptchaException;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzbd extends Exception {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final Map zzb = MapsKt.mapOf(TuplesKt.to(zztv.JS_NETWORK_ERROR, new zzbd(zzbb.zzc, zzba.zzd, (String) null)), TuplesKt.to(zztv.JS_INTERNAL_ERROR, new zzbd(zzbb.zzb, zzba.zzc, (String) null)), TuplesKt.to(zztv.JS_INVALID_SITE_KEY, new zzbd(zzbb.zzd, zzba.zze, (String) null)), TuplesKt.to(zztv.JS_INVALID_SITE_KEY_TYPE, new zzbd(zzbb.zze, zzba.zzf, (String) null)), TuplesKt.to(zztv.JS_THIRD_PARTY_APP_PACKAGE_NAME_NOT_ALLOWED, new zzbd(zzbb.zzf, zzba.zzg, (String) null)), TuplesKt.to(zztv.JS_INVALID_ACTION, new zzbd(zzbb.zzg, zzba.zzh, (String) null)), TuplesKt.to(zztv.JS_PROGRAM_ERROR, new zzbd(zzbb.zzb, zzba.zzj, (String) null)));
    private final zzbb zzc;
    private final zzba zzd;
    private final String zze;
    private final Map zzf = MapsKt.mapOf(TuplesKt.to(zzbb.zzc, new RecaptchaException(RecaptchaErrorCode.NETWORK_ERROR, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzbb.zzh, new RecaptchaException(RecaptchaErrorCode.NETWORK_ERROR, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzbb.zzi, new RecaptchaException(RecaptchaErrorCode.NETWORK_ERROR, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzbb.zzd, new RecaptchaException(RecaptchaErrorCode.INVALID_SITEKEY, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzbb.zze, new RecaptchaException(RecaptchaErrorCode.INVALID_KEYTYPE, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzbb.zzf, new RecaptchaException(RecaptchaErrorCode.INVALID_PACKAGE_NAME, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzbb.zzg, new RecaptchaException(RecaptchaErrorCode.INVALID_ACTION, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzbb.zzb, new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, (String) null, 2, (DefaultConstructorMarker) null)), TuplesKt.to(zzbb.zzj, new RecaptchaException(RecaptchaErrorCode.INVALID_TIMEOUT, (String) null, 2, (DefaultConstructorMarker) null)));

    public zzbd(zzbb zzbb, zzba zzba, String str) {
        this.zzc = zzbb;
        this.zzd = zzba;
        this.zze = str;
    }

    public final zzba zza() {
        return this.zzd;
    }

    public final zzbb zzb() {
        return this.zzc;
    }

    public final RecaptchaException zzc() {
        zzba zzba = this.zzd;
        if (Intrinsics.areEqual((Object) zzba, (Object) zzba.zzI)) {
            return new RecaptchaException(RecaptchaErrorCode.INVALID_TIMEOUT, (String) null, 2, (DefaultConstructorMarker) null);
        }
        if (Intrinsics.areEqual((Object) zzba, (Object) zzba.zzao)) {
            return new RecaptchaException(RecaptchaErrorCode.NO_NETWORK_FOUND, (String) null, 2, (DefaultConstructorMarker) null);
        }
        RecaptchaException recaptchaException = (RecaptchaException) this.zzf.get(this.zzc);
        return recaptchaException == null ? new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, (String) null, 2, (DefaultConstructorMarker) null) : recaptchaException;
    }

    public final String zzd() {
        return this.zze;
    }
}
