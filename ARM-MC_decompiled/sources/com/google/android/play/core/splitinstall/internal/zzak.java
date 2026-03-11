package com.google.android.play.core.splitinstall.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitcompat.zze;
import com.google.android.play.core.splitcompat.zzs;
import com.google.android.play.core.splitinstall.zzf;
import com.google.android.play.core.splitinstall.zzh;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzak implements zzh {
    private final Context zza;
    private final zze zzb;
    /* access modifiers changed from: private */
    public final zzam zzc;
    private final Executor zzd;
    private final zzs zze;

    public zzak(Context context, Executor executor, zzam zzam, zze zze2, zzs zzs) {
        this.zza = context;
        this.zzb = zze2;
        this.zzc = zzam;
        this.zzd = executor;
        this.zze = zzs;
    }

    static /* bridge */ /* synthetic */ void zzb(zzak zzak, List list, zzf zzf) {
        Integer zze2 = zzak.zze(list);
        if (zze2 != null) {
            if (zze2.intValue() == 0) {
                zzf.zzc();
            } else {
                zzf.zzb(zze2.intValue());
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzc(zzak zzak, zzf zzf) {
        try {
            if (!SplitCompat.zzd(zzbr.zza(zzak.zza))) {
                Log.e("SplitCompat", "Emulating splits failed.");
                zzf.zzb(-12);
                return;
            }
            Log.i("SplitCompat", "Splits installed.");
            zzf.zza();
        } catch (Exception e) {
            Log.e("SplitCompat", "Error emulating splits.", e);
            zzf.zzb(-12);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (r7.exists() == false) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0144 A[Catch:{ all -> 0x001b, all -> 0x013d, Exception -> 0x0148 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Integer zze(java.util.List r13) {
        /*
            r12 = this;
            java.lang.String r0 = "SplitCompat"
            r1 = -13
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0148 }
            com.google.android.play.core.splitcompat.zze r3 = r12.zzb     // Catch:{ Exception -> 0x0148 }
            java.io.File r3 = r3.zzd()     // Catch:{ Exception -> 0x0148 }
            java.lang.String r4 = "rw"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0148 }
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ Exception -> 0x0148 }
            r3 = 0
            java.nio.channels.FileLock r4 = r2.tryLock()     // Catch:{ OverlappingFileLockException -> 0x001e }
            goto L_0x001f
        L_0x001b:
            r13 = move-exception
            goto L_0x0137
        L_0x001e:
            r4 = r3
        L_0x001f:
            if (r4 == 0) goto L_0x0142
            java.lang.String r3 = "Copying splits."
            android.util.Log.i(r0, r3)     // Catch:{ Exception -> 0x0128 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x0128 }
        L_0x002a:
            boolean r3 = r13.hasNext()     // Catch:{ Exception -> 0x0128 }
            r5 = 0
            if (r3 == 0) goto L_0x00c2
            java.lang.Object r3 = r13.next()     // Catch:{ Exception -> 0x0128 }
            android.content.Intent r3 = (android.content.Intent) r3     // Catch:{ Exception -> 0x0128 }
            java.lang.String r6 = "split_id"
            java.lang.String r6 = r3.getStringExtra(r6)     // Catch:{ Exception -> 0x0128 }
            android.content.Context r7 = r12.zza     // Catch:{ Exception -> 0x0128 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ Exception -> 0x0128 }
            android.net.Uri r3 = r3.getData()     // Catch:{ Exception -> 0x0128 }
            java.lang.String r8 = "r"
            android.content.res.AssetFileDescriptor r3 = r7.openAssetFileDescriptor(r3, r8)     // Catch:{ Exception -> 0x0128 }
            com.google.android.play.core.splitcompat.zze r7 = r12.zzb     // Catch:{ all -> 0x00b6 }
            java.io.File r7 = r7.zze(r6)     // Catch:{ all -> 0x00b6 }
            boolean r8 = r7.exists()     // Catch:{ all -> 0x00b6 }
            if (r8 == 0) goto L_0x0066
            long r8 = r7.length()     // Catch:{ all -> 0x00b6 }
            long r10 = r3.getLength()     // Catch:{ all -> 0x00b6 }
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0066
            goto L_0x006c
        L_0x0066:
            boolean r8 = r7.exists()     // Catch:{ all -> 0x00b6 }
            if (r8 != 0) goto L_0x00af
        L_0x006c:
            com.google.android.play.core.splitcompat.zze r8 = r12.zzb     // Catch:{ all -> 0x00b6 }
            java.io.File r6 = r8.zzg(r6)     // Catch:{ all -> 0x00b6 }
            boolean r6 = r6.exists()     // Catch:{ all -> 0x00b6 }
            if (r6 != 0) goto L_0x00af
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00b6 }
            java.io.FileInputStream r8 = r3.createInputStream()     // Catch:{ all -> 0x00b6 }
            r6.<init>(r8)     // Catch:{ all -> 0x00b6 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x00a5 }
            r8.<init>(r7)     // Catch:{ all -> 0x00a5 }
            r7 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x009b }
        L_0x008a:
            int r9 = r6.read(r7)     // Catch:{ all -> 0x009b }
            if (r9 <= 0) goto L_0x0094
            r8.write(r7, r5, r9)     // Catch:{ all -> 0x009b }
            goto L_0x008a
        L_0x0094:
            r8.close()     // Catch:{ all -> 0x00a5 }
            r6.close()     // Catch:{ all -> 0x00b6 }
            goto L_0x00af
        L_0x009b:
            r13 = move-exception
            r8.close()     // Catch:{ all -> 0x00a0 }
            goto L_0x00a4
        L_0x00a0:
            r5 = move-exception
            com.google.android.play.core.splitinstall.internal.zzai.zza(r13, r5)     // Catch:{ all -> 0x00a5 }
        L_0x00a4:
            throw r13     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r13 = move-exception
            r6.close()     // Catch:{ all -> 0x00aa }
            goto L_0x00ae
        L_0x00aa:
            r5 = move-exception
            com.google.android.play.core.splitinstall.internal.zzai.zza(r13, r5)     // Catch:{ all -> 0x00b6 }
        L_0x00ae:
            throw r13     // Catch:{ all -> 0x00b6 }
        L_0x00af:
            if (r3 == 0) goto L_0x002a
            r3.close()     // Catch:{ Exception -> 0x0128 }
            goto L_0x002a
        L_0x00b6:
            r13 = move-exception
            if (r3 == 0) goto L_0x00c1
            r3.close()     // Catch:{ all -> 0x00bd }
            goto L_0x00c1
        L_0x00bd:
            r3 = move-exception
            com.google.android.play.core.splitinstall.internal.zzai.zza(r13, r3)     // Catch:{ Exception -> 0x0128 }
        L_0x00c1:
            throw r13     // Catch:{ Exception -> 0x0128 }
        L_0x00c2:
            java.lang.String r13 = "Splits copied."
            android.util.Log.i(r0, r13)     // Catch:{ Exception -> 0x0128 }
            com.google.android.play.core.splitcompat.zze r13 = r12.zzb     // Catch:{ IOException -> 0x0121 }
            java.io.File r13 = r13.zzb()     // Catch:{ IOException -> 0x0121 }
            java.io.File[] r13 = r13.listFiles()     // Catch:{ IOException -> 0x0121 }
            r3 = -11
            com.google.android.play.core.splitinstall.internal.zzam r6 = r12.zzc     // Catch:{ Exception -> 0x0119 }
            boolean r6 = r6.zzc(r13)     // Catch:{ Exception -> 0x0119 }
            if (r6 == 0) goto L_0x0113
            com.google.android.play.core.splitinstall.internal.zzam r6 = r12.zzc     // Catch:{ Exception -> 0x0119 }
            boolean r13 = r6.zza(r13)     // Catch:{ Exception -> 0x0119 }
            if (r13 == 0) goto L_0x0113
            com.google.android.play.core.splitcompat.zze r13 = r12.zzb     // Catch:{ IOException -> 0x010c }
            java.io.File r13 = r13.zzb()     // Catch:{ IOException -> 0x010c }
            java.io.File[] r13 = r13.listFiles()     // Catch:{ IOException -> 0x010c }
            java.util.Arrays.sort(r13)     // Catch:{ IOException -> 0x010c }
            int r3 = r13.length     // Catch:{ IOException -> 0x010c }
        L_0x00f1:
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x0106
            r6 = r13[r3]     // Catch:{ IOException -> 0x010c }
            com.google.android.play.core.splitcompat.zze.zzm(r6)     // Catch:{ IOException -> 0x010c }
            r6 = r13[r3]     // Catch:{ IOException -> 0x010c }
            com.google.android.play.core.splitcompat.zze r7 = r12.zzb     // Catch:{ IOException -> 0x010c }
            java.io.File r7 = r7.zzf(r6)     // Catch:{ IOException -> 0x010c }
            r6.renameTo(r7)     // Catch:{ IOException -> 0x010c }
            goto L_0x00f1
        L_0x0106:
            java.lang.String r13 = "Splits verified."
            android.util.Log.i(r0, r13)     // Catch:{ all -> 0x001b }
            goto L_0x012f
        L_0x010c:
            r13 = move-exception
            java.lang.String r3 = "Cannot write verified split."
            android.util.Log.e(r0, r3, r13)     // Catch:{ all -> 0x001b }
            goto L_0x012e
        L_0x0113:
            java.lang.String r13 = "Split verification failed."
            android.util.Log.e(r0, r13)     // Catch:{ all -> 0x001b }
            goto L_0x011f
        L_0x0119:
            r13 = move-exception
            java.lang.String r5 = "Error verifying splits."
            android.util.Log.e(r0, r5, r13)     // Catch:{ all -> 0x001b }
        L_0x011f:
            r5 = r3
            goto L_0x012f
        L_0x0121:
            r13 = move-exception
            java.lang.String r3 = "Cannot access directory for unverified splits."
            android.util.Log.e(r0, r3, r13)     // Catch:{ all -> 0x001b }
            goto L_0x012e
        L_0x0128:
            r13 = move-exception
            java.lang.String r3 = "Error copying splits."
            android.util.Log.e(r0, r3, r13)     // Catch:{ all -> 0x001b }
        L_0x012e:
            r5 = r1
        L_0x012f:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x001b }
            r4.release()     // Catch:{ all -> 0x001b }
            goto L_0x0142
        L_0x0137:
            if (r2 == 0) goto L_0x0141
            r2.close()     // Catch:{ all -> 0x013d }
            goto L_0x0141
        L_0x013d:
            r2 = move-exception
            com.google.android.play.core.splitinstall.internal.zzai.zza(r13, r2)     // Catch:{ Exception -> 0x0148 }
        L_0x0141:
            throw r13     // Catch:{ Exception -> 0x0148 }
        L_0x0142:
            if (r2 == 0) goto L_0x0147
            r2.close()     // Catch:{ Exception -> 0x0148 }
        L_0x0147:
            return r3
        L_0x0148:
            r13 = move-exception
            java.lang.String r2 = "Error locking files."
            android.util.Log.e(r0, r2, r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.internal.zzak.zze(java.util.List):java.lang.Integer");
    }

    public final void zzd(List list, zzf zzf) {
        if (SplitCompat.zze()) {
            this.zzd.execute(new zzaj(this, list, zzf));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }
}
