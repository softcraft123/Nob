package com.google.android.gms.internal.p002firebaseauthapi;

import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zznd implements zzbx {
    private static final Object zza = new Object();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zznd$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza {
        public zza() {
            zznd.zza();
        }
    }

    static /* synthetic */ boolean zza() {
        return true;
    }

    public final zzba zza(String str) throws GeneralSecurityException {
        zznb zznb;
        try {
            synchronized (zza) {
                zznb = new zznb(zzaai.zza("android-keystore://", str));
                byte[] zza2 = zzqd.zza(10);
                byte[] bArr = new byte[0];
                if (!Arrays.equals(zza2, zznb.zza(zznb.zzb(zza2, bArr), bArr))) {
                    throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
                }
            }
            return zznb;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public zznd() throws GeneralSecurityException {
        this(new zza());
    }

    private zznd(zza zza2) {
    }

    public final boolean zzb(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    static boolean zzc(String str) throws GeneralSecurityException {
        synchronized (zza) {
            String zza2 = zzaai.zza("android-keystore://", str);
            if (zzmz.zzb(zza2)) {
                return false;
            }
            KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(zza2, 3).setKeySize(256).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build();
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init(build);
            instance.generateKey();
            return true;
        }
    }
}
