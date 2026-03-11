package com.google.android.gms.common;

import com.google.android.gms.internal.common.zzah;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class GmsSignatureVerifier {
    private static final zzab zza;
    private static final zzab zzb;
    private static final HashMap zzc = new HashMap();

    static {
        zzaa zzaa = new zzaa();
        zzaa.zza("com.google.android.gms");
        zzaa.zzb(204200000);
        zzaa.zzc(zzah.zzm(zzo.zzf.zzc(), zzo.zzd.zzc(), zzo.zzb.zzc()));
        zzaa.zzd(zzah.zzm(zzo.zze.zzc(), zzo.zzc.zzc(), zzo.zza.zzc()));
        zza = zzaa.zze();
        zzaa zzaa2 = new zzaa();
        zzaa2.zza("com.android.vending");
        zzaa2.zzb(82240000);
        zzaa2.zzc(zzah.zzk(zzo.zzf.zzc()));
        zzaa2.zzd(zzah.zzl(zzo.zze.zzc(), zzo.zzc.zzc()));
        zzb = zzaa2.zze();
    }
}
