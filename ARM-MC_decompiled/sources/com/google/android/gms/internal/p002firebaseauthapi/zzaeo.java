package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaeo {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzaar zzb;
    private final zzagc zzc;

    zzaeo(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = new zzaar(new zzafb(firebaseApp, zzafc.zza()));
        this.zzc = new zzagc(applicationContext, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(str, str2, new zzael(zzaem, zza));
    }

    public final void zzb(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzb(str, str2, new zzael(zzaem, zza));
    }

    public final void zzc(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzc(str, str2, new zzael(zzaem, zza));
    }

    public final void zzd(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzd(str, str2, new zzael(zzaem, zza));
    }

    public final void zza(zzaic zzaic, zzaem zzaem) {
        Preconditions.checkNotNull(zzaic);
        Preconditions.checkNotEmpty(zzaic.zzb());
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(zzaic, new zzael(zzaem, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(str, str2, str3, str4, new zzael(zzaem, zza));
    }

    public final void zza(String str, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(str, new zzael(zzaem, zza));
    }

    public final void zza(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3, zzaem zzaem) {
        zzagz zzagz;
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotNull(zzaem);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            zzagz = zzahd.zza(str, (String) Preconditions.checkNotNull(zza2.zzc()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zzagz = zzahf.zza(str, Preconditions.checkNotEmpty(str2), Preconditions.checkNotEmpty(((TotpSecret) Preconditions.checkNotNull(totpMultiFactorAssertion.zza())).getSessionInfo()), Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zzagz, str, new zzael(zzaem, zza));
    }

    public final void zza(String str, MultiFactorAssertion multiFactorAssertion, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzaem);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zza((zzahb) zzahc.zza(str, (String) Preconditions.checkNotNull(zza2.zzc()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2), new zzael(zzaem, zza));
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            this.zzb.zza((zzahb) zzahe.zza(str, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str2, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzb())), new zzael(zzaem, zza));
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zzb(String str, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzb(str, new zzael(zzaem, zza));
    }

    public final void zza(zzaho zzaho, zzaem zzaem) {
        Preconditions.checkNotNull(zzaho);
        this.zzb.zza(zzaho, new zzael(zzaem, zza));
    }

    public final void zze(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        this.zzb.zze(str, str2, new zzael(zzaem, zza));
    }

    public final void zza(zzaht zzaht, zzaem zzaem) {
        Preconditions.checkNotNull(zzaht);
        this.zzb.zza(zzaht, new zzael(zzaem, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(str, str2, str3, str4, str5, new zzael(zzaem, zza));
    }

    public final void zza(String str, zzajb zzajb, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzajb);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(str, zzajb, new zzael(zzaem, zza));
    }

    public final void zza(zzahz zzahz, zzaem zzaem) {
        Preconditions.checkNotNull(zzaem);
        Preconditions.checkNotNull(zzahz);
        this.zzb.zza(Preconditions.checkNotEmpty(zzahz.zzb()), zzahz.zza(), new zzael(zzaem, zza));
    }

    public final void zzc(String str, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzc(str, new zzael(zzaem, zza));
    }

    public final void zza(zzaie zzaie, zzaem zzaem) {
        Preconditions.checkNotNull(zzaie);
        this.zzb.zza(zzaie, new zzael(zzaem, zza));
    }

    public final void zza(zzahm zzahm, zzaem zzaem) {
        Preconditions.checkNotNull(zzahm);
        Preconditions.checkNotEmpty(zzahm.zzd());
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(zzahm, new zzael(zzaem, zza));
    }

    public final void zzb(zzahm zzahm, zzaem zzaem) {
        Preconditions.checkNotNull(zzahm);
        Preconditions.checkNotEmpty(zzahm.zzc());
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzb(zzahm, new zzael(zzaem, zza));
    }

    public final void zza(zzaij zzaij, zzaem zzaem) {
        Preconditions.checkNotNull(zzaem);
        Preconditions.checkNotNull(zzaij);
        String zzd = zzaij.zzd();
        zzael zzael = new zzael(zzaem, zza);
        if (this.zzc.zzc(zzd)) {
            if (zzaij.zze()) {
                this.zzc.zzb(zzd);
            } else {
                this.zzc.zzb(zzael, zzd);
                return;
            }
        }
        long zzb2 = zzaij.zzb();
        boolean zzf = zzaij.zzf();
        if (zza(zzb2, zzf)) {
            zzaij.zza(new zzagm(this.zzc.zzb()));
        }
        this.zzc.zza(zzd, zzael, zzb2, zzf);
        this.zzb.zza(zzaij, this.zzc.zza(zzael, zzd));
    }

    public final void zza(zzain zzain, zzaem zzaem) {
        Preconditions.checkNotNull(zzain);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzd(zzain.zza(), new zzael(zzaem, zza));
    }

    public final void zzd(String str, zzaem zzaem) {
        Preconditions.checkNotNull(zzaem);
        this.zzb.zze(str, new zzael(zzaem, zza));
    }

    public final void zza(zzajb zzajb, zzaem zzaem) {
        Preconditions.checkNotNull(zzajb);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(zzajb, new zzael(zzaem, zza));
    }

    public final void zza(zzajc zzajc, zzaem zzaem) {
        Preconditions.checkNotNull(zzajc);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(zzajc, new zzael(zzaem, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzb(str, str2, str3, str4, new zzael(zzaem, zza));
    }

    public final void zza(zzagx zzagx, zzaem zzaem) {
        Preconditions.checkNotNull(zzaem);
        Preconditions.checkNotNull(zzagx.zzb());
        this.zzb.zza(zzagx.zzb(), zzagx.zzc(), new zzael(zzaem, zza));
    }

    public final void zza(zzaan zzaan, zzaem zzaem) {
        Preconditions.checkNotNull(zzaem);
        Preconditions.checkNotNull(zzaan);
        this.zzb.zza(zzafw.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzaan.zza())), new zzael(zzaem, zza));
    }

    public final void zza(String str, String str2, String str3, long j, boolean z, boolean z2, String str4, String str5, String str6, boolean z3, zzaem zzaem) {
        Preconditions.checkNotEmpty(str, "idToken should not be empty.");
        Preconditions.checkNotNull(zzaem);
        zzael zzael = new zzael(zzaem, zza);
        if (this.zzc.zzc(str2)) {
            if (z) {
                this.zzc.zzb(str2);
            } else {
                this.zzc.zzb(zzael, str2);
                return;
            }
        }
        zzais zza2 = zzais.zza(str, str2, str3, str4, str5, str6, (String) null);
        boolean z4 = z3;
        if (zza(j, z4)) {
            zza2.zza(new zzagm(this.zzc.zzb()));
        }
        zzael zzael2 = zzael;
        this.zzc.zza(str2, zzael2, j, z4);
        this.zzb.zza((zzaio) zza2, this.zzc.zza(zzael2, str2));
    }

    public final void zza(zzaaq zzaaq, zzaem zzaem) {
        Preconditions.checkNotNull(zzaaq);
        Preconditions.checkNotNull(zzaem);
        String phoneNumber = zzaaq.zzb().getPhoneNumber();
        zzael zzael = new zzael(zzaem, zza);
        if (this.zzc.zzc(phoneNumber)) {
            if (zzaaq.zzh()) {
                this.zzc.zzb(phoneNumber);
            } else {
                this.zzc.zzb(zzael, phoneNumber);
                return;
            }
        }
        long zza2 = zzaaq.zza();
        boolean zzi = zzaaq.zzi();
        zzaiq zza3 = zzaiq.zza(zzaaq.zze(), zzaaq.zzb().getUid(), zzaaq.zzb().getPhoneNumber(), zzaaq.zzd(), zzaaq.zzg(), zzaaq.zzf(), zzaaq.zzc());
        if (zza(zza2, zzi)) {
            zza3.zza(new zzagm(this.zzc.zzb()));
        }
        this.zzc.zza(phoneNumber, zzael, zza2, zzi);
        this.zzb.zza(zza3, this.zzc.zza(zzael, phoneNumber));
    }

    public final void zza(zzaiu zzaiu, zzaem zzaem) {
        this.zzb.zza((zzaio) zzaiu, new zzael((zzaem) Preconditions.checkNotNull(zzaem), zza));
    }

    public final void zza(String str, String str2, String str3, zzaem zzaem) {
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotEmpty(str2, "uid should not be empty.");
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(str, str2, str3, new zzael(zzaem, zza));
    }

    public final void zze(String str, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzf(str, new zzael(zzaem, zza));
    }

    public final void zzf(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zzf(str, str2, new zzael(zzaem, zza));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaem);
        this.zzb.zza(str, userProfileChangeRequest, new zzael(zzaem, zza));
    }

    public final void zzc(zzahm zzahm, zzaem zzaem) {
        Preconditions.checkNotNull(zzahm);
        this.zzb.zzc(zzahm, new zzael(zzaem, zza));
    }

    private static boolean zza(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
