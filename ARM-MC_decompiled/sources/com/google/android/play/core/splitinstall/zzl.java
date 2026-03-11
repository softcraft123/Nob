package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.IntentSender;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.splitinstall.internal.zzby;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzl implements SplitInstallManager {
    private final zzby zza;
    private final zzby zzb;
    private final zzby zzc;

    zzl(zzby zzby, zzby zzby2, zzby zzby3) {
        this.zza = zzby;
        this.zzb = zzby2;
        this.zzc = zzby3;
    }

    private final SplitInstallManager zzc() {
        if (this.zzc.zza() != null) {
            return (SplitInstallManager) this.zzb.zza();
        }
        return (SplitInstallManager) this.zza.zza();
    }

    public final Task<Void> cancelInstall(int i) {
        return zzc().cancelInstall(i);
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return zzc().deferredInstall(list);
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return zzc().deferredLanguageInstall(list);
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return zzc().deferredLanguageUninstall(list);
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return zzc().deferredUninstall(list);
    }

    public final Set<String> getInstalledLanguages() {
        return zzc().getInstalledLanguages();
    }

    public final Set<String> getInstalledModules() {
        return zzc().getInstalledModules();
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return zzc().getSessionState(i);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return zzc().getSessionStates();
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        zzc().registerListener(splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return zzc().startConfirmationDialogForResult(splitInstallSessionState, activity, i);
    }

    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        return zzc().startInstall(splitInstallRequest);
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        zzc().unregisterListener(splitInstallStateUpdatedListener);
    }

    public final void zza(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        zzc().zza(splitInstallStateUpdatedListener);
    }

    public final void zzb(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        zzc().zzb(splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, ActivityResultLauncher<IntentSenderRequest> activityResultLauncher) {
        return zzc().startConfirmationDialogForResult(splitInstallSessionState, activityResultLauncher);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return zzc().startConfirmationDialogForResult(splitInstallSessionState, intentSenderForResultStarter, i);
    }
}
