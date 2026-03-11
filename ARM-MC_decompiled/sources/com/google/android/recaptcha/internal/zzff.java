package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzff {
    private final Lazy zza = LazyKt.lazy(zzfc.zza);
    private final Lazy zzb = LazyKt.lazy(zzfd.zza);
    private final Lazy zzc = LazyKt.lazy(zzfe.zza);

    public zzff() {
        int i = zzav.zza;
    }

    public static final /* synthetic */ zzfk zzb(zzff zzff) {
        return (zzfk) zzff.zza.getValue();
    }

    static /* synthetic */ Object zze(zzff zzff, zzsc zzsc, zzek zzek, Continuation continuation) throws zzbd {
        zzen zzf;
        try {
            String zzl = zzsc.zzl();
            String zzM = zzsc.zzM();
            zzaq zzf2 = zzff.zzf();
            String str = null;
            if (zzf2 != null && zzf2.zzd(zzM)) {
                zzen zzf3 = zzek.zzf(25);
                try {
                    String zza2 = zzff.zzf().zza(zzM);
                    if (zza2 != null) {
                        zzf3.zza();
                        str = zza2;
                    }
                } catch (Exception e) {
                    zzf3.zzb(new zzbd(zzbb.zzk, zzba.zzR, e.getMessage()));
                }
                zzf3.zzb(new zzbd(zzbb.zzk, zzba.zzS, (String) null));
            }
            if (str == null) {
                zzaq zzf4 = zzff.zzf();
                if (zzf4 != null) {
                    zzf4.zzb();
                }
                zzf = zzek.zzf(23);
                String zzb2 = zzff.zzg().zzb(zzl);
                zzf.zza();
                zzen zzf5 = zzek.zzf(24);
                try {
                    zzaq zzf6 = zzff.zzf();
                    if (zzf6 != null) {
                        zzf6.zzc(zzM, zzb2);
                    }
                    zzf5.zza();
                } catch (Exception e2) {
                    zzf5.zzb(new zzbd(zzbb.zzk, zzba.zzT, e2.getMessage()));
                }
                str = zzb2;
            }
            return StringsKt.replace$default(zzsc.zzk(), "JAVASCRIPT_TAG", str, false, 4, (Object) null);
        } catch (zzbd e3) {
            zzbd zzbd = e3;
            zzf.zzb(zzbd);
            throw zzbd;
        } catch (Exception e4) {
            Exception exc = e4;
            if (exc instanceof zzbd) {
                throw exc;
            }
            throw new zzbd(zzbb.zzb, zzba.zzL, exc.getMessage());
        }
    }

    private final zzaq zzf() {
        return (zzaq) this.zzb.getValue();
    }

    /* access modifiers changed from: private */
    public final zzey zzg() {
        return (zzey) this.zzc.getValue();
    }

    public final Object zzc(String str, zzto zzto, Continuation continuation) throws RecaptchaException {
        return CoroutineScopeKt.coroutineScope(new zzfb(this, str, zzto, (Continuation) null), continuation);
    }

    public final Object zzd(zzsc zzsc, zzek zzek, Continuation continuation) throws zzbd {
        return zze(this, zzsc, zzek, continuation);
    }
}
