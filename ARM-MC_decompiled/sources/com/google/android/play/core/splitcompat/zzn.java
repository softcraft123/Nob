package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzn {
    private static final Pattern zza = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    private final zze zzb;

    zzn(zze zze) throws IOException {
        this.zzb = zze;
    }

    static /* bridge */ /* synthetic */ Set zza(zzn zzn, Set set, zzt zzt, ZipFile zipFile) {
        HashSet hashSet = new HashSet();
        zzn.zzf(zzt, set, new zzj(zzn, hashSet, zzt, zipFile));
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ed A[SYNTHETIC, Splitter:B:33:0x00ed] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zze(com.google.android.play.core.splitcompat.zzt r10, com.google.android.play.core.splitcompat.zzk r11) throws java.io.IOException {
        /*
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00e9 }
            java.io.File r1 = r10.zza()     // Catch:{ IOException -> 0x00e9 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00e9 }
            java.lang.String r10 = r10.zzb()     // Catch:{ IOException -> 0x00e7 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ IOException -> 0x00e7 }
            r1.<init>()     // Catch:{ IOException -> 0x00e7 }
            java.util.Enumeration r2 = r0.entries()     // Catch:{ IOException -> 0x00e7 }
        L_0x0016:
            boolean r3 = r2.hasMoreElements()     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = "SplitCompat"
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r2.nextElement()     // Catch:{ IOException -> 0x00e7 }
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r5 = r3.getName()     // Catch:{ IOException -> 0x00e7 }
            java.util.regex.Pattern r6 = zza     // Catch:{ IOException -> 0x00e7 }
            java.util.regex.Matcher r5 = r6.matcher(r5)     // Catch:{ IOException -> 0x00e7 }
            boolean r6 = r5.matches()     // Catch:{ IOException -> 0x00e7 }
            if (r6 == 0) goto L_0x0016
            r6 = 1
            java.lang.String r6 = r5.group(r6)     // Catch:{ IOException -> 0x00e7 }
            r7 = 2
            java.lang.String r5 = r5.group(r7)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r7 = "NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'"
            java.lang.Object[] r8 = new java.lang.Object[]{r10, r5, r6}     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ IOException -> 0x00e7 }
            android.util.Log.d(r4, r7)     // Catch:{ IOException -> 0x00e7 }
            java.lang.Object r4 = r1.get(r6)     // Catch:{ IOException -> 0x00e7 }
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ IOException -> 0x00e7 }
            if (r4 != 0) goto L_0x005b
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ IOException -> 0x00e7 }
            r4.<init>()     // Catch:{ IOException -> 0x00e7 }
            r1.put(r6, r4)     // Catch:{ IOException -> 0x00e7 }
        L_0x005b:
            com.google.android.play.core.splitcompat.zzm r6 = new com.google.android.play.core.splitcompat.zzm     // Catch:{ IOException -> 0x00e7 }
            r6.<init>(r3, r5)     // Catch:{ IOException -> 0x00e7 }
            r4.add(r6)     // Catch:{ IOException -> 0x00e7 }
            goto L_0x0016
        L_0x0064:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ IOException -> 0x00e7 }
            r10.<init>()     // Catch:{ IOException -> 0x00e7 }
            java.lang.String[] r2 = android.os.Build.SUPPORTED_ABIS     // Catch:{ IOException -> 0x00e7 }
            int r3 = r2.length     // Catch:{ IOException -> 0x00e7 }
            r5 = 0
        L_0x006d:
            if (r5 >= r3) goto L_0x00d7
            r6 = r2[r5]     // Catch:{ IOException -> 0x00e7 }
            boolean r7 = r1.containsKey(r6)     // Catch:{ IOException -> 0x00e7 }
            if (r7 == 0) goto L_0x00c7
            java.lang.String r7 = "NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI"
            java.lang.Object[] r8 = new java.lang.Object[]{r6}     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ IOException -> 0x00e7 }
            android.util.Log.d(r4, r7)     // Catch:{ IOException -> 0x00e7 }
            java.lang.Object r7 = r1.get(r6)     // Catch:{ IOException -> 0x00e7 }
            java.util.Set r7 = (java.util.Set) r7     // Catch:{ IOException -> 0x00e7 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ IOException -> 0x00e7 }
        L_0x008e:
            boolean r8 = r7.hasNext()     // Catch:{ IOException -> 0x00e7 }
            if (r8 == 0) goto L_0x00d4
            java.lang.Object r8 = r7.next()     // Catch:{ IOException -> 0x00e7 }
            com.google.android.play.core.splitcompat.zzm r8 = (com.google.android.play.core.splitcompat.zzm) r8     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r9 = r8.zza     // Catch:{ IOException -> 0x00e7 }
            boolean r9 = r10.containsKey(r9)     // Catch:{ IOException -> 0x00e7 }
            if (r9 == 0) goto L_0x00b2
            java.lang.String r9 = "NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI"
            java.lang.String r8 = r8.zza     // Catch:{ IOException -> 0x00e7 }
            java.lang.Object[] r8 = new java.lang.Object[]{r8, r6}     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r8 = java.lang.String.format(r9, r8)     // Catch:{ IOException -> 0x00e7 }
            android.util.Log.d(r4, r8)     // Catch:{ IOException -> 0x00e7 }
            goto L_0x008e
        L_0x00b2:
            java.lang.String r9 = r8.zza     // Catch:{ IOException -> 0x00e7 }
            r10.put(r9, r8)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r9 = "NativeLibraryExtractor: using library %s for ABI %s"
            java.lang.String r8 = r8.zza     // Catch:{ IOException -> 0x00e7 }
            java.lang.Object[] r8 = new java.lang.Object[]{r8, r6}     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r8 = java.lang.String.format(r9, r8)     // Catch:{ IOException -> 0x00e7 }
            android.util.Log.d(r4, r8)     // Catch:{ IOException -> 0x00e7 }
            goto L_0x008e
        L_0x00c7:
            java.lang.String r7 = "NativeLibraryExtractor: there are no native libraries for supported ABI %s"
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r6 = java.lang.String.format(r7, r6)     // Catch:{ IOException -> 0x00e7 }
            android.util.Log.d(r4, r6)     // Catch:{ IOException -> 0x00e7 }
        L_0x00d4:
            int r5 = r5 + 1
            goto L_0x006d
        L_0x00d7:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ IOException -> 0x00e7 }
            java.util.Collection r10 = r10.values()     // Catch:{ IOException -> 0x00e7 }
            r1.<init>(r10)     // Catch:{ IOException -> 0x00e7 }
            r11.zza(r0, r1)     // Catch:{ IOException -> 0x00e7 }
            r0.close()     // Catch:{ IOException -> 0x00e7 }
            return
        L_0x00e7:
            r10 = move-exception
            goto L_0x00eb
        L_0x00e9:
            r10 = move-exception
            r0 = 0
        L_0x00eb:
            if (r0 == 0) goto L_0x00f5
            r0.close()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x00f5
        L_0x00f1:
            r11 = move-exception
            com.google.android.play.core.splitcompat.zzf.zza(r10, r11)
        L_0x00f5:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.zzn.zze(com.google.android.play.core.splitcompat.zzt, com.google.android.play.core.splitcompat.zzk):void");
    }

    /* access modifiers changed from: private */
    public final void zzf(zzt zzt, Set set, zzl zzl) throws IOException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzm zzm = (zzm) it.next();
            File zzc = this.zzb.zzc(zzt.zzb(), zzm.zza);
            boolean z = false;
            if (zzc.exists() && zzc.length() == zzm.zzb.getSize() && zze.zzp(zzc)) {
                z = true;
            }
            zzl.zza(zzm, zzc, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final Set zzb(zzt zzt) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        zze(zzt, new zzh(this, zzt, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Set zzc() throws IOException {
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<zzt> zzj = this.zzb.zzj();
        for (String str : this.zzb.zzh()) {
            Iterator it = zzj.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((zzt) it.next()).zzb().equals(str)) {
                        break;
                    }
                } else {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", new Object[]{str}));
                    this.zzb.zzn(str);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (zzt zzt : zzj) {
            HashSet hashSet2 = new HashSet();
            zze(zzt, new zzi(this, hashSet2, zzt));
            for (File file : this.zzb.zzi(zzt.zzb())) {
                if (!hashSet2.contains(file)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", new Object[]{file.getAbsolutePath(), zzt.zzb(), zzt.zza().getAbsolutePath()}));
                    this.zzb.zzo(file);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }
}
