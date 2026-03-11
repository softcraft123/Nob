package com.google.android.play.core.splitinstall.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.zzn;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzat implements zzan {
    zzat() {
    }

    static Object zzc(ClassLoader classLoader) {
        return zzbk.zzb(classLoader, "pathList", Object.class).zzc();
    }

    static void zzd(ClassLoader classLoader, Set set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                Log.d("Splitcompat", "Adding native library parent directory: ".concat(String.valueOf(file.getParentFile().getAbsolutePath())));
                hashSet.add(file.getParentFile());
            }
            zzbi zza = zzbk.zza(zzc(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) zza.zzc()));
            synchronized (zzn.class) {
                int size = hashSet.size();
                Log.d("Splitcompat", "Adding directories " + size);
                zza.zzb(hashSet);
            }
        }
    }

    static boolean zze(ClassLoader classLoader, File file, File file2, boolean z, zzas zzas, String str, zzar zzar) {
        ArrayList arrayList = new ArrayList();
        Object zzc = zzc(classLoader);
        zzbi zza = zzbk.zza(zzc, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) zza.zzc());
        ArrayList arrayList2 = new ArrayList();
        for (Object zzb : asList) {
            arrayList2.add((File) zzbk.zzb(zzb, str, File.class).zzc());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (z || zzar.zza(zzc, file2, file)) {
            zza.zza(Arrays.asList(zzas.zza(zzc, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (arrayList.isEmpty()) {
                return true;
            }
            zzbh zzbh = new zzbh("DexPathList.makeDexElement failed");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                IOException iOException = (IOException) arrayList.get(i);
                Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class}).invoke(zzbh, new Object[]{iOException});
                } catch (Exception unused) {
                }
            }
            zzbk.zza(zzc, "dexElementsSuppressedExceptions", IOException.class).zza(arrayList);
            throw zzbh;
        }
        Log.w("SplitCompat", "Should be optimized ".concat(String.valueOf(file2.getPath())));
        return false;
    }

    public final void zza(ClassLoader classLoader, Set set) {
        zzd(classLoader, set);
    }

    public final boolean zzb(ClassLoader classLoader, File file, File file2, boolean z) {
        return zze(classLoader, file, file2, z, new zzap(), "zip", new zzaq());
    }
}
