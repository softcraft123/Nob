package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.splitcompat.zzd;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.internal.zzbs;
import com.google.android.play.core.splitinstall.internal.zzbw;
import com.google.android.play.core.splitinstall.internal.zzbx;
import com.google.android.play.core.splitinstall.internal.zzby;
import com.google.android.play.core.splitinstall.internal.zzt;
import com.google.android.play.core.splitinstall.zzg;
import com.google.android.play.core.splitinstall.zzk;
import com.google.android.play.core.splitinstall.zzo;
import com.google.android.play.core.splitinstall.zzs;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public class FakeSplitInstallManager implements SplitInstallManager {
    public static final /* synthetic */ int zza = 0;
    private static final long zzb = TimeUnit.SECONDS.toMillis(1);
    private final Handler zzc;
    private final Context zzd;
    private final zzs zze;
    private final zzby zzf;
    private final zzbs zzg;
    private final zzt zzh;
    private final zzt zzi;
    private final Executor zzj;
    private final zzg zzk;
    private final File zzl;
    private final AtomicReference zzm;
    private final Set zzn;
    private final Set zzo;
    private final AtomicBoolean zzp;
    private final zzj zzq;

    @Deprecated
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, new zzs(context, context.getPackageName()), zze.zza);
    }

    private final Task zzk(int i) {
        zzn(new zzp(i));
        return Tasks.forException(new SplitInstallException(i));
    }

    private final zzk zzl() {
        try {
            zzk zza2 = this.zze.zza(this.zzd.getPackageManager().getPackageInfo(this.zzd.getPackageName(), 128).applicationInfo.metaData);
            if (zza2 != null) {
                return zza2;
            }
            throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("App is not found in PackageManager", e);
        }
    }

    private final SplitInstallSessionState zzm() {
        return (SplitInstallSessionState) this.zzm.get();
    }

    private final synchronized SplitInstallSessionState zzn(zzr zzr) {
        SplitInstallSessionState zzm2 = zzm();
        SplitInstallSessionState zza2 = zzr.zza(zzm2);
        AtomicReference atomicReference = this.zzm;
        while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, zzm2, zza2)) {
            if (atomicReference.get() != zzm2) {
                return null;
            }
        }
        return zza2;
    }

    private static String zzo(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    /* access modifiers changed from: private */
    public final void zzp(List list, List list2, List list3, long j, boolean z) {
        List list4 = list;
        this.zzk.zza().zzd(list4, new zzq(this, list2, list3, j, z, list4));
    }

    private final void zzq(SplitInstallSessionState splitInstallSessionState) {
        this.zzc.post(new zzf(this, splitInstallSessionState));
    }

    /* access modifiers changed from: private */
    public final void zzr(List list, List list2, long j) {
        this.zzn.addAll(list);
        this.zzo.addAll(list2);
        Long valueOf = Long.valueOf(j);
        zzs(5, 0, valueOf, valueOf, (List) null, (Integer) null, (List) null);
    }

    /* access modifiers changed from: private */
    public final boolean zzs(int i, int i2, Long l, Long l2, List list, Integer num, List list2) {
        SplitInstallSessionState zzn2 = zzn(new zzg(num, i, i2, l, l2, list, list2));
        if (zzn2 == null) {
            return false;
        }
        zzq(zzn2);
        return true;
    }

    public final Task<Void> cancelInstall(int i) {
        try {
            SplitInstallSessionState zzn2 = zzn(new zzh(i));
            if (zzn2 != null) {
                zzq(zzn2);
            }
            return Tasks.forResult(null);
        } catch (zzbx e) {
            return Tasks.forException(e.zzb(SplitInstallException.class));
        }
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.forException(new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.forException(new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.forException(new SplitInstallException(-5));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.forException(new SplitInstallException(-5));
    }

    public final Set<String> getInstalledLanguages() {
        HashSet hashSet = new HashSet();
        if (this.zze.zzd() != null) {
            hashSet.addAll(this.zze.zzd());
        }
        hashSet.addAll(this.zzo);
        return hashSet;
    }

    public final Set<String> getInstalledModules() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.zze.zzc());
        hashSet.addAll(this.zzn);
        return hashSet;
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        SplitInstallSessionState zzm2 = zzm();
        if (zzm2 == null || zzm2.sessionId() != i) {
            return Tasks.forException(new SplitInstallException(-4));
        }
        return Tasks.forResult(zzm2);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState zzm2 = zzm();
        return Tasks.forResult(zzm2 != null ? Collections.singletonList(zzm2) : Collections.emptyList());
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzi.zza(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.zzp.set(z);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return false;
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, ActivityResultLauncher<IntentSenderRequest> activityResultLauncher) {
        return false;
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0120, code lost:
        if (r0.contains(r6) == false) goto L_0x0127;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r24) {
        /*
            r23 = this;
            r1 = r23
            com.google.android.play.core.splitinstall.testing.zzk r0 = new com.google.android.play.core.splitinstall.testing.zzk     // Catch:{ zzbx -> 0x0240 }
            r2 = r24
            r0.<init>(r2)     // Catch:{ zzbx -> 0x0240 }
            com.google.android.play.core.splitinstall.SplitInstallSessionState r0 = r1.zzn(r0)     // Catch:{ zzbx -> 0x0240 }
            if (r0 == 0) goto L_0x0239
            int r0 = r0.sessionId()     // Catch:{ zzbx -> 0x0240 }
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r3 = r2.getLanguages()
            java.util.Iterator r3 = r3.iterator()
        L_0x0020:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0034
            java.lang.Object r4 = r3.next()
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r4 = r4.getLanguage()
            r8.add(r4)
            goto L_0x0020
        L_0x0034:
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.io.File r4 = r1.zzl
            com.google.android.play.core.splitinstall.testing.zzl r5 = com.google.android.play.core.splitinstall.testing.zzl.zza
            java.io.File[] r4 = r4.listFiles(r5)
            java.lang.String r5 = "FakeSplitInstallManager"
            if (r4 == 0) goto L_0x022e
            r11 = 0
            r12 = 0
        L_0x004d:
            int r14 = r4.length
            if (r11 >= r14) goto L_0x018a
            r14 = r4[r11]
            r16 = 0
            java.lang.String r6 = com.google.android.play.core.splitinstall.internal.zzbw.zza(r14)
            java.lang.String r7 = zzo(r6)
            r3.add(r6)
            r18 = 0
            java.util.List r10 = r2.getModuleNames()
            boolean r7 = r10.contains(r7)
            if (r7 == 0) goto L_0x0123
            java.lang.String r7 = zzo(r6)
            java.util.HashSet r10 = new java.util.HashSet
            com.google.android.play.core.splitinstall.internal.zzbs r15 = r1.zzg
            java.util.List r15 = r15.zza()
            r10.<init>(r15)
            com.google.android.play.core.splitinstall.zzk r15 = r1.zzl()
            r20 = r0
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]
            r2[r18] = r7
            java.util.List r0 = java.util.Arrays.asList(r2)
            java.util.Map r0 = r15.zza(r0)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.Collection r7 = r0.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x009a:
            boolean r15 = r7.hasNext()
            if (r15 == 0) goto L_0x00aa
            java.lang.Object r15 = r7.next()
            java.util.Set r15 = (java.util.Set) r15
            r2.addAll(r15)
            goto L_0x009a
        L_0x00aa:
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00b3:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x00dd
            java.lang.Object r15 = r10.next()
            java.lang.String r15 = (java.lang.String) r15
            r21 = r0
            java.lang.String r0 = "_"
            boolean r22 = r15.contains(r0)
            if (r22 == 0) goto L_0x00d3
            r22 = r4
            r4 = -1
            java.lang.String[] r0 = r15.split(r0, r4)
            r15 = r0[r18]
            goto L_0x00d5
        L_0x00d3:
            r22 = r4
        L_0x00d5:
            r7.add(r15)
            r0 = r21
            r4 = r22
            goto L_0x00b3
        L_0x00dd:
            r21 = r0
            r22 = r4
            java.util.Set r0 = r1.zzo
            r7.addAll(r0)
            r7.addAll(r8)
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Set r4 = r21.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x00f6:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x0116
            java.lang.Object r10 = r4.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r15 = r10.getKey()
            boolean r15 = r7.contains(r15)
            if (r15 == 0) goto L_0x00f6
            java.lang.Object r10 = r10.getValue()
            java.util.Collection r10 = (java.util.Collection) r10
            r0.addAll(r10)
            goto L_0x00f6
        L_0x0116:
            boolean r2 = r2.contains(r6)
            if (r2 == 0) goto L_0x0178
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x0127
            goto L_0x0178
        L_0x0123:
            r20 = r0
            r22 = r4
        L_0x0127:
            java.util.List r0 = r24.getLanguages()
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.Set r4 = r1.zzn
            r2.<init>(r4)
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.String r7 = ""
            r4[r18] = r7
            java.lang.String r7 = "base"
            r19 = 1
            r4[r19] = r7
            java.util.List r4 = java.util.Arrays.asList(r4)
            r2.addAll(r4)
            com.google.android.play.core.splitinstall.zzk r4 = r1.zzl()
            java.util.Map r2 = r4.zza(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x0152:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0180
            java.lang.Object r4 = r0.next()
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r7 = r4.getLanguage()
            boolean r7 = r2.containsKey(r7)
            if (r7 == 0) goto L_0x0152
            java.lang.String r4 = r4.getLanguage()
            java.lang.Object r4 = r2.get(r4)
            java.util.Set r4 = (java.util.Set) r4
            boolean r4 = r4.contains(r6)
            if (r4 == 0) goto L_0x0152
        L_0x0178:
            long r6 = r14.length()
            long r12 = r12 + r6
            r9.add(r14)
        L_0x0180:
            int r11 = r11 + 1
            r2 = r24
            r0 = r20
            r4 = r22
            goto L_0x004d
        L_0x018a:
            r20 = r0
            r16 = 0
            r18 = 0
            java.lang.String r0 = r3.toString()
            java.util.List r2 = r24.getModuleNames()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "availableSplits "
            r4.<init>(r6)
            r4.append(r0)
            java.lang.String r0 = " want "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            android.util.Log.i(r5, r0)
            java.util.List r0 = r24.getModuleNames()
            int r0 = r0.size()
            r2 = 1
            if (r0 != r2) goto L_0x01de
            com.google.android.play.core.splitinstall.internal.zzby r0 = r1.zzf
            java.lang.Object r0 = r0.zza()
            com.google.android.play.core.splitinstall.testing.zzv r0 = (com.google.android.play.core.splitinstall.testing.zzv) r0
            java.util.Map r0 = r0.zzb()
            java.util.List r2 = r24.getModuleNames()
            r4 = r18
            java.lang.Object r2 = r2.get(r4)
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 != 0) goto L_0x01ea
        L_0x01de:
            com.google.android.play.core.splitinstall.internal.zzby r0 = r1.zzf
            java.lang.Object r0 = r0.zza()
            com.google.android.play.core.splitinstall.testing.zzv r0 = (com.google.android.play.core.splitinstall.testing.zzv) r0
            java.lang.Integer r0 = r0.zza()
        L_0x01ea:
            if (r0 == 0) goto L_0x01f5
            int r0 = r0.intValue()
            com.google.android.gms.tasks.Task r0 = r1.zzk(r0)
            return r0
        L_0x01f5:
            java.util.HashSet r0 = new java.util.HashSet
            java.util.List r2 = r24.getModuleNames()
            r0.<init>(r2)
            boolean r0 = r3.containsAll(r0)
            if (r0 != 0) goto L_0x020a
            r0 = -2
            com.google.android.gms.tasks.Task r0 = r1.zzk(r0)
            return r0
        L_0x020a:
            java.lang.Long r4 = java.lang.Long.valueOf(r16)
            java.lang.Long r5 = java.lang.Long.valueOf(r12)
            java.util.List r6 = r24.getModuleNames()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r20)
            r2 = 1
            r3 = 0
            r1.zzs(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Executor r0 = r1.zzj
            com.google.android.play.core.splitinstall.testing.zzm r2 = new com.google.android.play.core.splitinstall.testing.zzm
            r2.<init>(r1, r9, r8)
            r0.execute(r2)
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forResult(r7)
            return r0
        L_0x022e:
            java.lang.String r0 = "Specified splits directory does not exist."
            android.util.Log.w(r5, r0)
            r0 = -5
            com.google.android.gms.tasks.Task r0 = r1.zzk(r0)
            return r0
        L_0x0239:
            r0 = -100
            com.google.android.gms.tasks.Task r0 = r1.zzk(r0)     // Catch:{ zzbx -> 0x0240 }
            return r0
        L_0x0240:
            r0 = move-exception
            java.lang.Class<com.google.android.play.core.splitinstall.SplitInstallException> r2 = com.google.android.play.core.splitinstall.SplitInstallException.class
            java.lang.Exception r0 = r0.zzb(r2)
            com.google.android.play.core.splitinstall.SplitInstallException r0 = (com.google.android.play.core.splitinstall.SplitInstallException) r0
            int r0 = r0.getErrorCode()
            com.google.android.gms.tasks.Task r0 = r1.zzk(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.gms.tasks.Task");
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzi.zzb(splitInstallStateUpdatedListener);
    }

    public final void zza(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzh.zza(splitInstallStateUpdatedListener);
    }

    public final void zzb(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzh.zzb(splitInstallStateUpdatedListener);
    }

    /* access modifiers changed from: package-private */
    public final File zzc() {
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(long j, List list, List list2, List list3) {
        long j2 = j;
        int i = 0;
        long j3 = 0;
        while (i < 3) {
            j3 = Math.min(j2, j3 + (j2 / 3));
            zzs(2, 0, Long.valueOf(j3), Long.valueOf(j2), (List) null, (Integer) null, (List) null);
            SystemClock.sleep(zzb);
            SplitInstallSessionState zzm2 = zzm();
            if (zzm2.status() != 9 && zzm2.status() != 7 && zzm2.status() != 6) {
                i++;
            } else {
                return;
            }
        }
        this.zzj.execute(new zzd(this, list, list2, list3, j2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(SplitInstallSessionState splitInstallSessionState) {
        this.zzh.zzc(splitInstallSessionState);
        this.zzi.zzc(splitInstallSessionState);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(List list, List list2, List list3, long j) {
        if (this.zzp.get()) {
            zzs(6, -6, (Long) null, (Long) null, (List) null, (Integer) null, (List) null);
        } else if (this.zzk.zza() != null) {
            zzp(list, list2, list3, j, false);
        } else {
            zzr(list2, list3, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String zza2 = zzbw.zza(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, this.zzd.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", zzo(zza2));
            intent.putExtra("split_id", zza2);
            arrayList.add(intent);
            arrayList2.add(zzo(zzbw.zza(file)));
        }
        SplitInstallSessionState zzm2 = zzm();
        if (zzm2 != null) {
            this.zzj.execute(new zzi(this, zzm2.totalBytesToDownload(), arrayList, arrayList2, list2));
        }
    }

    FakeSplitInstallManager(Context context, File file, zzs zzs, zzby zzby) {
        Executor zza2 = zzd.zza();
        zzbs zzbs = new zzbs(context);
        zzj zzj2 = zzj.zza;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzm = new AtomicReference();
        this.zzn = Collections.synchronizedSet(new HashSet());
        this.zzo = Collections.synchronizedSet(new HashSet());
        this.zzp = new AtomicBoolean(false);
        this.zzd = context;
        this.zzl = file;
        this.zze = zzs;
        this.zzf = zzby;
        this.zzj = zza2;
        this.zzg = zzbs;
        this.zzq = zzj2;
        this.zzi = new zzt();
        this.zzh = new zzt();
        this.zzk = zzo.INSTANCE;
    }
}
