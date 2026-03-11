package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.play.core.splitinstall.internal.zzah;
import com.google.android.play.core.splitinstall.internal.zzak;
import com.google.android.play.core.splitinstall.internal.zzam;
import com.google.android.play.core.splitinstall.internal.zzbh;
import com.google.android.play.core.splitinstall.zzbe;
import com.google.android.play.core.splitinstall.zzo;
import com.google.android.play.core.splitinstall.zzr;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public class SplitCompat {
    public static final /* synthetic */ int zza = 0;
    private static final AtomicReference zzb = new AtomicReference((Object) null);
    /* access modifiers changed from: private */
    public final zze zzc;
    private final zzbe zzd;
    private final Set zze = new HashSet();
    private final zza zzf;

    private SplitCompat(Context context) {
        try {
            zze zze2 = new zze(context);
            this.zzc = zze2;
            this.zzf = new zza(zze2);
            this.zzd = new zzbe(context);
        } catch (PackageManager.NameNotFoundException e) {
            throw new zzbh("Failed to initialize FileStorage", e);
        }
    }

    public static boolean install(Context context) {
        return zzi(context, false);
    }

    public static boolean installActivity(Context context) {
        if (zzj()) {
            return false;
        }
        SplitCompat splitCompat = (SplitCompat) zzb.get();
        if (splitCompat != null) {
            return splitCompat.zzf.zzb(context, splitCompat.zzf());
        }
        if (context.getApplicationContext() != null) {
            install(context.getApplicationContext());
        }
        return install(context);
    }

    public static boolean zzd(Context context) {
        return zzi(context, true);
    }

    public static boolean zze() {
        return zzb.get() != null;
    }

    /* access modifiers changed from: private */
    public final Set zzf() {
        HashSet hashSet;
        synchronized (this.zze) {
            hashSet = new HashSet(this.zze);
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public final void zzg(Set set) throws IOException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zze.zzl(this.zzc.zzg((String) it.next()));
        }
        this.zzd.zzb();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x01ae */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0193 A[SYNTHETIC, Splitter:B:75:0x0193] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzh(android.content.Context r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            if (r11 == 0) goto L_0x0009
            com.google.android.play.core.splitcompat.zze r0 = r9.zzc     // Catch:{ all -> 0x0239 }
            r0.zzk()     // Catch:{ all -> 0x0239 }
            goto L_0x0015
        L_0x0009:
            java.util.concurrent.Executor r0 = com.google.android.play.core.splitcompat.zzd.zza()     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitcompat.zzq r1 = new com.google.android.play.core.splitcompat.zzq     // Catch:{ all -> 0x0239 }
            r1.<init>(r9)     // Catch:{ all -> 0x0239 }
            r0.execute(r1)     // Catch:{ all -> 0x0239 }
        L_0x0015:
            java.lang.String r0 = r10.getPackageName()     // Catch:{ all -> 0x0239 }
            android.content.pm.PackageManager r1 = r10.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0228 }
            r2 = 0
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r0, r2)     // Catch:{ NameNotFoundException -> 0x0228 }
            java.lang.String[] r3 = r1.splitNames     // Catch:{ NameNotFoundException -> 0x0228 }
            if (r3 != 0) goto L_0x002c
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ NameNotFoundException -> 0x0228 }
            r1.<init>()     // Catch:{ NameNotFoundException -> 0x0228 }
            goto L_0x0032
        L_0x002c:
            java.lang.String[] r1 = r1.splitNames     // Catch:{ NameNotFoundException -> 0x0228 }
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch:{ NameNotFoundException -> 0x0228 }
        L_0x0032:
            com.google.android.play.core.splitcompat.zze r0 = r9.zzc     // Catch:{ all -> 0x0239 }
            java.util.Set r0 = r0.zzj()     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitinstall.zzbe r3 = r9.zzd     // Catch:{ all -> 0x0239 }
            java.util.Set r3 = r3.zza()     // Catch:{ all -> 0x0239 }
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ all -> 0x0239 }
            r4.<init>()     // Catch:{ all -> 0x0239 }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0239 }
        L_0x0047:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0239 }
            if (r6 == 0) goto L_0x006e
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitcompat.zzt r6 = (com.google.android.play.core.splitcompat.zzt) r6     // Catch:{ all -> 0x0239 }
            java.lang.String r6 = r6.zzb()     // Catch:{ all -> 0x0239 }
            boolean r7 = r1.contains(r6)     // Catch:{ all -> 0x0239 }
            if (r7 != 0) goto L_0x0067
            java.lang.String r7 = com.google.android.play.core.splitinstall.zzs.zzb(r6)     // Catch:{ all -> 0x0239 }
            boolean r7 = r3.contains(r7)     // Catch:{ all -> 0x0239 }
            if (r7 == 0) goto L_0x0047
        L_0x0067:
            r4.add(r6)     // Catch:{ all -> 0x0239 }
            r5.remove()     // Catch:{ all -> 0x0239 }
            goto L_0x0047
        L_0x006e:
            if (r11 == 0) goto L_0x0074
            r9.zzg(r4)     // Catch:{ all -> 0x0239 }
            goto L_0x0086
        L_0x0074:
            boolean r3 = r4.isEmpty()     // Catch:{ all -> 0x0239 }
            if (r3 != 0) goto L_0x0086
            java.util.concurrent.Executor r3 = com.google.android.play.core.splitcompat.zzd.zza()     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitcompat.zzr r5 = new com.google.android.play.core.splitcompat.zzr     // Catch:{ all -> 0x0239 }
            r5.<init>(r9, r4)     // Catch:{ all -> 0x0239 }
            r3.execute(r5)     // Catch:{ all -> 0x0239 }
        L_0x0086:
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x0239 }
            r3.<init>()     // Catch:{ all -> 0x0239 }
            java.util.Iterator r4 = r0.iterator()     // Catch:{ all -> 0x0239 }
        L_0x008f:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0239 }
            if (r5 == 0) goto L_0x00a9
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitcompat.zzt r5 = (com.google.android.play.core.splitcompat.zzt) r5     // Catch:{ all -> 0x0239 }
            java.lang.String r5 = r5.zzb()     // Catch:{ all -> 0x0239 }
            boolean r6 = com.google.android.play.core.splitinstall.zzs.zze(r5)     // Catch:{ all -> 0x0239 }
            if (r6 != 0) goto L_0x008f
            r3.add(r5)     // Catch:{ all -> 0x0239 }
            goto L_0x008f
        L_0x00a9:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0239 }
        L_0x00ad:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x0239 }
            if (r4 == 0) goto L_0x00c3
            java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x0239 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0239 }
            boolean r5 = com.google.android.play.core.splitinstall.zzs.zze(r4)     // Catch:{ all -> 0x0239 }
            if (r5 != 0) goto L_0x00ad
            r3.add(r4)     // Catch:{ all -> 0x0239 }
            goto L_0x00ad
        L_0x00c3:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0239 }
            int r4 = r0.size()     // Catch:{ all -> 0x0239 }
            r1.<init>(r4)     // Catch:{ all -> 0x0239 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0239 }
        L_0x00d0:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0239 }
            if (r4 == 0) goto L_0x00fc
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitcompat.zzt r4 = (com.google.android.play.core.splitcompat.zzt) r4     // Catch:{ all -> 0x0239 }
            java.lang.String r5 = r4.zzb()     // Catch:{ all -> 0x0239 }
            int r6 = com.google.android.play.core.splitinstall.zzs.zza     // Catch:{ all -> 0x0239 }
            java.lang.String r6 = "config."
            boolean r5 = r5.startsWith(r6)     // Catch:{ all -> 0x0239 }
            if (r5 != 0) goto L_0x00f8
            java.lang.String r5 = r4.zzb()     // Catch:{ all -> 0x0239 }
            java.lang.String r5 = com.google.android.play.core.splitinstall.zzs.zzb(r5)     // Catch:{ all -> 0x0239 }
            boolean r5 = r3.contains(r5)     // Catch:{ all -> 0x0239 }
            if (r5 == 0) goto L_0x00d0
        L_0x00f8:
            r1.add(r4)     // Catch:{ all -> 0x0239 }
            goto L_0x00d0
        L_0x00fc:
            com.google.android.play.core.splitcompat.zzn r0 = new com.google.android.play.core.splitcompat.zzn     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitcompat.zze r3 = r9.zzc     // Catch:{ all -> 0x0239 }
            r0.<init>(r3)     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitinstall.internal.zzan r3 = com.google.android.play.core.splitinstall.internal.zzao.zza()     // Catch:{ all -> 0x0239 }
            java.lang.ClassLoader r4 = r10.getClassLoader()     // Catch:{ all -> 0x0239 }
            if (r11 == 0) goto L_0x0115
            java.util.Set r0 = r0.zzc()     // Catch:{ all -> 0x0239 }
            r3.zza(r4, r0)     // Catch:{ all -> 0x0239 }
            goto L_0x0133
        L_0x0115:
            java.util.Iterator r5 = r1.iterator()     // Catch:{ all -> 0x0239 }
        L_0x0119:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0239 }
            if (r6 == 0) goto L_0x0133
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitcompat.zzt r6 = (com.google.android.play.core.splitcompat.zzt) r6     // Catch:{ all -> 0x0239 }
            java.util.Set r6 = r0.zzb(r6)     // Catch:{ all -> 0x0239 }
            if (r6 != 0) goto L_0x012f
            r5.remove()     // Catch:{ all -> 0x0239 }
            goto L_0x0119
        L_0x012f:
            r3.zza(r4, r6)     // Catch:{ all -> 0x0239 }
            goto L_0x0119
        L_0x0133:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0239 }
            r0.<init>()     // Catch:{ all -> 0x0239 }
            java.util.Iterator r5 = r1.iterator()     // Catch:{ all -> 0x0239 }
        L_0x013c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0239 }
            if (r6 == 0) goto L_0x01af
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitcompat.zzt r6 = (com.google.android.play.core.splitcompat.zzt) r6     // Catch:{ all -> 0x0239 }
            java.util.zip.ZipFile r7 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x018f }
            java.io.File r8 = r6.zza()     // Catch:{ IOException -> 0x018f }
            r7.<init>(r8)     // Catch:{ IOException -> 0x018f }
            java.lang.String r8 = "classes.dex"
            java.util.zip.ZipEntry r8 = r7.getEntry(r8)     // Catch:{ IOException -> 0x018d }
            r7.close()     // Catch:{ IOException -> 0x018d }
            if (r8 == 0) goto L_0x0185
            com.google.android.play.core.splitcompat.zze r7 = r9.zzc     // Catch:{ all -> 0x0239 }
            java.lang.String r8 = r6.zzb()     // Catch:{ all -> 0x0239 }
            java.io.File r7 = r7.zza(r8)     // Catch:{ all -> 0x0239 }
            java.io.File r8 = r6.zza()     // Catch:{ all -> 0x0239 }
            boolean r7 = r3.zzb(r4, r7, r8, r11)     // Catch:{ all -> 0x0239 }
            if (r7 == 0) goto L_0x0171
            goto L_0x0185
        L_0x0171:
            java.io.File r6 = r6.zza()     // Catch:{ all -> 0x0239 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0239 }
            java.lang.String r7 = "split was not installed "
            java.lang.String r6 = r7.concat(r6)     // Catch:{ all -> 0x0239 }
            java.lang.String r7 = "SplitCompat"
            android.util.Log.w(r7, r6)     // Catch:{ all -> 0x0239 }
            goto L_0x013c
        L_0x0185:
            java.io.File r6 = r6.zza()     // Catch:{ all -> 0x0239 }
            r0.add(r6)     // Catch:{ all -> 0x0239 }
            goto L_0x013c
        L_0x018d:
            r10 = move-exception
            goto L_0x0191
        L_0x018f:
            r10 = move-exception
            r7 = 0
        L_0x0191:
            if (r7 == 0) goto L_0x01ae
            r7.close()     // Catch:{ IOException -> 0x0197 }
            goto L_0x01ae
        L_0x0197:
            r11 = move-exception
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            java.lang.String r1 = "addSuppressed"
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x01ae }
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            r3[r2] = r4     // Catch:{ Exception -> 0x01ae }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r3)     // Catch:{ Exception -> 0x01ae }
            java.lang.Object[] r11 = new java.lang.Object[]{r11}     // Catch:{ Exception -> 0x01ae }
            r0.invoke(r10, r11)     // Catch:{ Exception -> 0x01ae }
        L_0x01ae:
            throw r10     // Catch:{ all -> 0x0239 }
        L_0x01af:
            com.google.android.play.core.splitcompat.zza r11 = r9.zzf     // Catch:{ all -> 0x0239 }
            r11.zza(r10, r0)     // Catch:{ all -> 0x0239 }
            java.util.HashSet r10 = new java.util.HashSet     // Catch:{ all -> 0x0239 }
            r10.<init>()     // Catch:{ all -> 0x0239 }
            java.util.Iterator r11 = r1.iterator()     // Catch:{ all -> 0x0239 }
        L_0x01bd:
            boolean r1 = r11.hasNext()     // Catch:{ all -> 0x0239 }
            if (r1 == 0) goto L_0x021a
            java.lang.Object r1 = r11.next()     // Catch:{ all -> 0x0239 }
            com.google.android.play.core.splitcompat.zzt r1 = (com.google.android.play.core.splitcompat.zzt) r1     // Catch:{ all -> 0x0239 }
            java.io.File r2 = r1.zza()     // Catch:{ all -> 0x0239 }
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x0239 }
            if (r2 == 0) goto L_0x01fa
            java.lang.String r2 = r1.zzb()     // Catch:{ all -> 0x0239 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0239 }
            r3.<init>()     // Catch:{ all -> 0x0239 }
            java.lang.String r4 = "Split '"
            r3.append(r4)     // Catch:{ all -> 0x0239 }
            r3.append(r2)     // Catch:{ all -> 0x0239 }
            java.lang.String r2 = "' installation emulated"
            r3.append(r2)     // Catch:{ all -> 0x0239 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0239 }
            java.lang.String r3 = "SplitCompat"
            android.util.Log.d(r3, r2)     // Catch:{ all -> 0x0239 }
            java.lang.String r1 = r1.zzb()     // Catch:{ all -> 0x0239 }
            r10.add(r1)     // Catch:{ all -> 0x0239 }
            goto L_0x01bd
        L_0x01fa:
            java.lang.String r1 = r1.zzb()     // Catch:{ all -> 0x0239 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0239 }
            r2.<init>()     // Catch:{ all -> 0x0239 }
            java.lang.String r3 = "Split '"
            r2.append(r3)     // Catch:{ all -> 0x0239 }
            r2.append(r1)     // Catch:{ all -> 0x0239 }
            java.lang.String r1 = "' installation not emulated."
            r2.append(r1)     // Catch:{ all -> 0x0239 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0239 }
            java.lang.String r2 = "SplitCompat"
            android.util.Log.d(r2, r1)     // Catch:{ all -> 0x0239 }
            goto L_0x01bd
        L_0x021a:
            java.util.Set r11 = r9.zze     // Catch:{ all -> 0x0239 }
            monitor-enter(r11)     // Catch:{ all -> 0x0239 }
            java.util.Set r0 = r9.zze     // Catch:{ all -> 0x0225 }
            r0.addAll(r10)     // Catch:{ all -> 0x0225 }
            monitor-exit(r11)     // Catch:{ all -> 0x0225 }
            monitor-exit(r9)
            return
        L_0x0225:
            r10 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0225 }
            throw r10     // Catch:{ all -> 0x0239 }
        L_0x0228:
            r10 = move-exception
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x0239 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x0239 }
            java.lang.String r1 = "Cannot load data for application '%s'"
            java.lang.String r0 = java.lang.String.format(r1, r0)     // Catch:{ all -> 0x0239 }
            r11.<init>(r0, r10)     // Catch:{ all -> 0x0239 }
            throw r11     // Catch:{ all -> 0x0239 }
        L_0x0239:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0239 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.SplitCompat.zzh(android.content.Context, boolean):void");
    }

    private static boolean zzi(Context context, boolean z) {
        boolean z2;
        Context context2;
        if (zzj()) {
            return false;
        }
        AtomicReference atomicReference = zzb;
        SplitCompat splitCompat = new SplitCompat(context);
        while (true) {
            if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, (Object) null, splitCompat)) {
                if (atomicReference.get() != null) {
                    z2 = false;
                    break;
                }
            } else {
                z2 = true;
                break;
            }
        }
        SplitCompat splitCompat2 = (SplitCompat) zzb.get();
        if (z2) {
            context2 = context;
            zzo.INSTANCE.zzb(new zzak(context2, zzd.zza(), new zzam(context, splitCompat2.zzc, new zzah()), splitCompat2.zzc, new zzs()));
            zzr.zzb(new zzp(splitCompat2));
            zzd.zza().execute(new zzo(context2));
        } else {
            context2 = context;
        }
        try {
            splitCompat2.zzh(context2, z);
            return true;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error installing additional splits", e);
            return false;
        }
    }

    private static boolean zzj() {
        return false;
    }
}
