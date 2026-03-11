package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzaa implements SplitInstallManager {
    private final zzbc zza;
    /* access modifiers changed from: private */
    public final zzx zzb;
    private final zzs zzc;
    private final zzbe zzd;
    private final Handler zze = new Handler(Looper.getMainLooper());

    zzaa(zzbc zzbc, zzx zzx, zzs zzs, zzbe zzbe) {
        this.zza = zzbc;
        this.zzb = zzx;
        this.zzc = zzs;
        this.zzd = zzbe;
    }

    /* access modifiers changed from: private */
    public static List zze(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Locale) it.next()).toLanguageTag());
        }
        return arrayList;
    }

    public final Task<Void> cancelInstall(int i) {
        return this.zza.zzc(i);
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return this.zza.zzd(list);
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return this.zza.zze(zze(list));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return this.zza.zzf(zze(list));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        this.zzd.zzc(list);
        return this.zza.zzg(list);
    }

    public final Set<String> getInstalledLanguages() {
        Set<String> zzd2 = this.zzc.zzd();
        return zzd2 == null ? Collections.emptySet() : zzd2;
    }

    public final Set<String> getInstalledModules() {
        return this.zzc.zzc();
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return this.zza.zzh(i);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return this.zza.zzi();
    }

    public final synchronized void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzb.zzb(splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return startConfirmationDialogForResult(splitInstallSessionState, (IntentSenderForResultStarter) new zzz(this, activity), i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
        if (r2.containsAll(r3) != false) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r6) {
        /*
            r5 = this;
            com.google.android.play.core.splitinstall.internal.zzn r0 = new com.google.android.play.core.splitinstall.internal.zzn
            r0.<init>()
            r1 = 1
            r0.zzb(r1)
            java.util.List r1 = r6.getLanguages()
            r1.isEmpty()
            java.util.List r1 = r6.getLanguages()
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x001b
            goto L_0x0046
        L_0x001b:
            com.google.android.play.core.splitinstall.zzs r2 = r5.zzc
            java.util.Set r2 = r2.zzd()
            if (r2 == 0) goto L_0x0046
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x002c:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0040
            java.lang.Object r4 = r1.next()
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r4 = r4.getLanguage()
            r3.add(r4)
            goto L_0x002c
        L_0x0040:
            boolean r1 = r2.containsAll(r3)
            if (r1 == 0) goto L_0x007b
        L_0x0046:
            java.util.List r1 = r6.getModuleNames()
            com.google.android.play.core.splitinstall.zzs r2 = r5.zzc
            java.util.Set r2 = r2.zzc()
            boolean r1 = r2.containsAll(r1)
            if (r1 == 0) goto L_0x007b
            java.util.List r1 = r6.getModuleNames()
            com.google.android.play.core.splitinstall.zzbe r2 = r5.zzd
            java.util.Set r2 = r2.zza()
            boolean r1 = java.util.Collections.disjoint(r1, r2)
            if (r1 != 0) goto L_0x0067
            goto L_0x007b
        L_0x0067:
            android.os.Handler r0 = r5.zze
            com.google.android.play.core.splitinstall.zzy r1 = new com.google.android.play.core.splitinstall.zzy
            r1.<init>(r5, r6)
            r0.post(r1)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.google.android.gms.tasks.Task r6 = com.google.android.gms.tasks.Tasks.forResult(r6)
            return r6
        L_0x007b:
            com.google.android.play.core.splitinstall.zzbe r1 = r5.zzd
            java.util.List r2 = r6.getModuleNames()
            r1.zzd(r2)
            com.google.android.play.core.splitinstall.zzbc r1 = r5.zza
            java.util.List r2 = r6.getModuleNames()
            java.util.List r6 = r6.getLanguages()
            java.util.List r6 = zze(r6)
            com.google.android.gms.tasks.Task r6 = r1.zzj(r2, r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.zzaa.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.gms.tasks.Task");
    }

    public final synchronized void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzb.zzd(splitInstallStateUpdatedListener);
    }

    public final synchronized void zza(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzb.zzi(splitInstallStateUpdatedListener);
    }

    public final synchronized void zzb(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzb.zzj(splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, ActivityResultLauncher<IntentSenderRequest> activityResultLauncher) {
        if (splitInstallSessionState.status() != 8 || splitInstallSessionState.resolutionIntent() == null) {
            return false;
        }
        activityResultLauncher.launch(new IntentSenderRequest.Builder(splitInstallSessionState.resolutionIntent().getIntentSender()).build());
        return true;
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        if (splitInstallSessionState.status() != 8 || splitInstallSessionState.resolutionIntent() == null) {
            return false;
        }
        intentSenderForResultStarter.startIntentSenderForResult(splitInstallSessionState.resolutionIntent().getIntentSender(), i, (Intent) null, 0, 0, 0, (Bundle) null);
        return true;
    }
}
