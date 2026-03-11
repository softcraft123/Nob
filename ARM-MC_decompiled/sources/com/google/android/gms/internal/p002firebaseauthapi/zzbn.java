package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxh;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzbn {
    private final List<zzbq> zza = new ArrayList();
    private zzok zzb = zzok.zza;
    private boolean zzc = false;

    public final zzbn zza(zzbq zzbq) {
        if (zzbq.zze == null) {
            if (zzbq.zza) {
                zzb();
            }
            zzbq.zze = this;
            this.zza.add(zzbq);
            return this;
        }
        throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
    }

    public final zzbm zza() throws GeneralSecurityException {
        int i;
        if (!this.zzc) {
            this.zzc = true;
            zzxh.zza zzc2 = zzxh.zzc();
            ArrayList arrayList = new ArrayList(this.zza.size());
            List<zzbq> list = this.zza;
            int i2 = 0;
            while (i2 < list.size() - 1) {
                if (list.get(i2).zzd != zzbp.zza || list.get(i2 + 1).zzd == zzbp.zza) {
                    i2++;
                } else {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
            HashSet hashSet = new HashSet();
            Integer num = null;
            for (zzbq next : this.zza) {
                if (next.zzb == null) {
                    throw new GeneralSecurityException("Key Status not set.");
                } else if (next.zzd != null) {
                    if (next.zzd == zzbp.zza) {
                        i = 0;
                        while (true) {
                            if (i != 0 && !hashSet.contains(Integer.valueOf(i))) {
                                break;
                            }
                            i = zzqn.zza();
                        }
                    } else {
                        i = zzbp.zza(next.zzd);
                    }
                    int i3 = i;
                    if (!hashSet.contains(Integer.valueOf(i3))) {
                        hashSet.add(Integer.valueOf(i3));
                        zzbi zza2 = zzop.zza().zza(next.zzc, next.zzc.zza() ? Integer.valueOf(i3) : null);
                        zzbs zzbs = new zzbs(zza2, zzbm.zza(next.zzb), i3, next.zza, false, zzbs.zza);
                        zzc2.zza(zzbm.zzb(zza2, zzbm.zza(next.zzb), i3));
                        if (next.zza) {
                            if (num == null) {
                                num = Integer.valueOf(i3);
                                if (next.zzb != zzbk.zza) {
                                    throw new GeneralSecurityException("Primary key is not enabled");
                                }
                            } else {
                                throw new GeneralSecurityException("Two primaries were set");
                            }
                        }
                        arrayList.add(zzbs);
                    } else {
                        throw new GeneralSecurityException("Id " + i3 + " is used twice in the keyset");
                    }
                } else {
                    throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
                }
            }
            if (num != null) {
                zzc2.zza(num.intValue());
                zzxh zzxh = (zzxh) ((zzalf) zzc2.zze());
                zzbm.zzd(zzxh);
                return zzbm.zzb(new zzbm(zzxh, arrayList, this.zzb));
            }
            throw new GeneralSecurityException("No primary was set");
        }
        throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
    }

    /* access modifiers changed from: private */
    public final void zzb() {
        for (zzbq zza2 : this.zza) {
            zza2.zza = false;
        }
    }
}
