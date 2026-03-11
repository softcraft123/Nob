package com.google.android.gms.internal.fido;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzbi {
    private final String zza;
    private final zzbg zzb;
    private zzbg zzc;

    /* synthetic */ zzbi(String str, zzbh zzbh) {
        zzbg zzbg = new zzbg();
        this.zzb = zzbg;
        this.zzc = zzbg;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzbg zzbg = this.zzb.zzc;
        String str = "";
        while (zzbg != null) {
            Object obj = zzbg.zzb;
            sb.append(str);
            String str2 = zzbg.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzbg = zzbg.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzbi zza(String str, int i) {
        String valueOf = String.valueOf(i);
        zzbf zzbf = new zzbf((zzbe) null);
        this.zzc.zzc = zzbf;
        this.zzc = zzbf;
        zzbf.zzb = valueOf;
        zzbf.zza = "errorCode";
        return this;
    }

    public final zzbi zzb(String str, @CheckForNull Object obj) {
        zzbg zzbg = new zzbg();
        this.zzc.zzc = zzbg;
        this.zzc = zzbg;
        zzbg.zzb = obj;
        zzbg.zza = str;
        return this;
    }
}
