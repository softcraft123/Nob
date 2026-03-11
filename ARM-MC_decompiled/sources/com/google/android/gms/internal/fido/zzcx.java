package com.google.android.gms.internal.fido;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzcx extends zzcs implements Serializable {
    final zzcs zza;

    zzcx(zzcs zzcs) {
        this.zza = zzcs;
    }

    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcx) {
            return this.zza.equals(((zzcx) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }

    public final zzcs zza() {
        return this.zza;
    }
}
