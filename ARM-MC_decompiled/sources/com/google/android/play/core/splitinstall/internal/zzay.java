package com.google.android.play.core.splitinstall.internal;

import com.google.android.play.core.splitinstall.zzn;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzay implements zzan {
    zzay() {
    }

    public static void zzc(ClassLoader classLoader, Set set, zzax zzax) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(((File) it.next()).getParentFile());
            }
            Object zzc = zzat.zzc(classLoader);
            zzbj zzb = zzbk.zzb(zzc, "nativeLibraryDirectories", List.class);
            synchronized (zzn.class) {
                ArrayList arrayList = new ArrayList((Collection) zzb.zzc());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                zzb.zze(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] zza = zzax.zza(zzc, new ArrayList(hashSet), (File) null, arrayList2);
            if (!arrayList2.isEmpty()) {
                zzbh zzbh = new zzbh("Error in makePathElements");
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class}).invoke(zzbh, new Object[]{(IOException) arrayList2.get(i)});
                    } catch (Exception unused) {
                    }
                }
                throw zzbh;
            }
            synchronized (zzn.class) {
                zzbk.zza(zzc, "nativeLibraryPathElements", Object.class).zzb(Arrays.asList(zza));
            }
        }
    }

    public static boolean zzd(ClassLoader classLoader, File file, File file2, boolean z, String str) {
        return zzat.zze(classLoader, file, file2, z, new zzav(), "zip", new zzaq());
    }

    public final void zza(ClassLoader classLoader, Set set) {
        zzc(classLoader, set, new zzaw());
    }

    public final boolean zzb(ClassLoader classLoader, File file, File file2, boolean z) {
        return zzd(classLoader, file, file2, z, "zip");
    }
}
