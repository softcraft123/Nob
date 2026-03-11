package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzeu extends zzei {
    /* access modifiers changed from: private */
    public static final Set zza;
    /* access modifiers changed from: private */
    public static final zzea zzb;
    private static final zzer zzc = new zzer((zzeq) null);
    private final String zzd;
    private final zzdn zze;
    private final Level zzf;
    private final Set zzg;
    private final zzea zzh;

    static {
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new zzdk[]{zzdh.zza, zzdm.zza})));
        zza = unmodifiableSet;
        zzb = zzed.zza(unmodifiableSet).zzd();
    }

    /* synthetic */ zzeu(String str, String str2, boolean z, zzdn zzdn, Level level, Set set, zzea zzea, zzet zzet) {
        super(str2);
        if (str2.length() > 23) {
            int i = -1;
            int length = str2.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                char charAt = str2.charAt(length);
                if (charAt == '.' || charAt == '$') {
                    i = length;
                } else {
                    length--;
                }
            }
            i = length;
            str2 = str2.substring(i + 1);
        }
        String concat = "".concat(String.valueOf(str2));
        this.zzd = concat.substring(0, Math.min(concat.length(), 23));
        this.zze = zzdn;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzea;
    }

    public static zzer zzc() {
        return zzc;
    }
}
