package com.google.android.gms.common.signatureverification;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class zzd {
    private static SignatureVerificationConfiguration zza;

    public static synchronized void zza(SignatureVerificationConfiguration signatureVerificationConfiguration) {
        synchronized (zzd.class) {
            if (zza == null) {
                zza = signatureVerificationConfiguration;
            } else {
                throw new IllegalStateException("Redundantly setting SignatureVerificationConfiguration");
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized SignatureVerificationConfiguration zzc() {
        SignatureVerificationConfiguration signatureVerificationConfiguration;
        synchronized (zzd.class) {
            if (zza == null) {
                zza(new zzb());
            }
            signatureVerificationConfiguration = zza;
        }
        return signatureVerificationConfiguration;
    }
}
