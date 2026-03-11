package com.armmc.app;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\tH\u0002J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010$\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/armmc/app/SplitInstallHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "splitInstallManager", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "currentSessionId", "", "statusListener", "Lcom/google/android/play/core/splitinstall/SplitInstallStateUpdatedListener;", "isModuleInstalled", "", "moduleName", "", "getInstalledModules", "", "installModule", "", "callback", "Lcom/armmc/app/SplitInstallHelper$InstallCallback;", "handleInstallState", "state", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "startUserConfirmation", "activity", "Landroid/app/Activity;", "requestCode", "cancelInstall", "unregisterListener", "getErrorMessage", "errorCode", "versionToModuleName", "version", "moduleNameToVersion", "cleanup", "Companion", "InstallCallback", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SplitInstallHelper.kt */
public final class SplitInstallHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "SplitInstallHelper";
    private final Context context;
    private int currentSessionId;
    private final SplitInstallManager splitInstallManager;
    private SplitInstallStateUpdatedListener statusListener;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/armmc/app/SplitInstallHelper$InstallCallback;", "", "onProgress", "", "bytesDownloaded", "", "totalBytes", "onComplete", "onError", "errorCode", "", "message", "", "onRequiresUserConfirmation", "state", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SplitInstallHelper.kt */
    public interface InstallCallback {
        void onComplete();

        void onError(int i, String str);

        void onProgress(long j, long j2);

        void onRequiresUserConfirmation(SplitInstallSessionState splitInstallSessionState);
    }

    public SplitInstallHelper(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        SplitInstallManager create = SplitInstallManagerFactory.create(context2);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.splitInstallManager = create;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/armmc/app/SplitInstallHelper$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SplitInstallHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isModuleInstalled(String str) {
        Intrinsics.checkNotNullParameter(str, PumpkinService.EXTRA_MODULE_NAME);
        Set<String> installedModules = this.splitInstallManager.getInstalledModules();
        Intrinsics.checkNotNullExpressionValue(installedModules, "getInstalledModules(...)");
        boolean contains = installedModules.contains(str);
        Log.d(TAG, "Module '" + str + "' installed: " + contains + " (installed modules: " + installedModules + ")");
        return contains;
    }

    public final Set<String> getInstalledModules() {
        Set<String> installedModules = this.splitInstallManager.getInstalledModules();
        Intrinsics.checkNotNullExpressionValue(installedModules, "getInstalledModules(...)");
        return installedModules;
    }

    public final void installModule(String str, InstallCallback installCallback) {
        Intrinsics.checkNotNullParameter(str, PumpkinService.EXTRA_MODULE_NAME);
        Intrinsics.checkNotNullParameter(installCallback, "callback");
        Log.d(TAG, "Requesting installation of module: " + str);
        if (isModuleInstalled(str)) {
            Log.d(TAG, "Module '" + str + "' is already installed");
            installCallback.onComplete();
            return;
        }
        SplitInstallRequest build = SplitInstallRequest.newBuilder().addModule(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        SplitInstallHelper$$ExternalSyntheticLambda0 splitInstallHelper$$ExternalSyntheticLambda0 = new SplitInstallHelper$$ExternalSyntheticLambda0(this, installCallback);
        this.statusListener = splitInstallHelper$$ExternalSyntheticLambda0;
        SplitInstallManager splitInstallManager2 = this.splitInstallManager;
        Intrinsics.checkNotNull(splitInstallHelper$$ExternalSyntheticLambda0);
        splitInstallManager2.registerListener(splitInstallHelper$$ExternalSyntheticLambda0);
        this.splitInstallManager.startInstall(build).addOnSuccessListener(new SplitInstallHelper$$ExternalSyntheticLambda2(new SplitInstallHelper$$ExternalSyntheticLambda1(this))).addOnFailureListener(new SplitInstallHelper$$ExternalSyntheticLambda3(this, installCallback));
    }

    /* access modifiers changed from: private */
    public static final void installModule$lambda$0(SplitInstallHelper splitInstallHelper, InstallCallback installCallback, SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "state");
        if (splitInstallSessionState.sessionId() == splitInstallHelper.currentSessionId) {
            splitInstallHelper.handleInstallState(splitInstallSessionState, installCallback);
        }
    }

    /* access modifiers changed from: private */
    public static final void installModule$lambda$2(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit installModule$lambda$1(SplitInstallHelper splitInstallHelper, Integer num) {
        splitInstallHelper.currentSessionId = num.intValue();
        Log.d(TAG, "Installation started with session ID: " + num);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void installModule$lambda$3(SplitInstallHelper splitInstallHelper, InstallCallback installCallback, Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "exception");
        Log.e(TAG, "Failed to start installation", exc);
        splitInstallHelper.unregisterListener();
        SplitInstallException splitInstallException = exc instanceof SplitInstallException ? (SplitInstallException) exc : null;
        int errorCode = splitInstallException != null ? splitInstallException.getErrorCode() : -1;
        String message = exc.getMessage();
        if (message == null) {
            message = "Installation failed";
        }
        installCallback.onError(errorCode, message);
    }

    private final void handleInstallState(SplitInstallSessionState splitInstallSessionState, InstallCallback installCallback) {
        switch (splitInstallSessionState.status()) {
            case 1:
                Log.d(TAG, "Installation pending...");
                return;
            case 2:
                long bytesDownloaded = splitInstallSessionState.bytesDownloaded();
                long j = splitInstallSessionState.totalBytesToDownload();
                Log.d(TAG, "Downloading: " + bytesDownloaded + " / " + j);
                installCallback.onProgress(bytesDownloaded, j);
                return;
            case 3:
                Log.d(TAG, "Download complete, installing...");
                return;
            case 4:
                Log.d(TAG, "Installing module...");
                return;
            case 5:
                Log.d(TAG, "Module installed successfully");
                unregisterListener();
                installCallback.onComplete();
                return;
            case 6:
                int errorCode = splitInstallSessionState.errorCode();
                Log.e(TAG, "Installation failed with error code: " + errorCode);
                unregisterListener();
                installCallback.onError(errorCode, getErrorMessage(errorCode));
                return;
            case 7:
                Log.d(TAG, "Installation canceled");
                unregisterListener();
                installCallback.onError(-1, "Installation was canceled");
                return;
            case 8:
                Log.d(TAG, "User confirmation required");
                installCallback.onRequiresUserConfirmation(splitInstallSessionState);
                return;
            case 9:
                Log.d(TAG, "Installation canceling...");
                return;
            default:
                return;
        }
    }

    public final void startUserConfirmation(Activity activity, SplitInstallSessionState splitInstallSessionState, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "state");
        try {
            this.splitInstallManager.startConfirmationDialogForResult(splitInstallSessionState, activity, i);
        } catch (Exception e) {
            Log.e(TAG, "Failed to start confirmation dialog", e);
        }
    }

    public final void cancelInstall() {
        int i = this.currentSessionId;
        if (i != 0) {
            this.splitInstallManager.cancelInstall(i);
            unregisterListener();
        }
    }

    private final void unregisterListener() {
        SplitInstallStateUpdatedListener splitInstallStateUpdatedListener = this.statusListener;
        if (splitInstallStateUpdatedListener != null) {
            this.splitInstallManager.unregisterListener(splitInstallStateUpdatedListener);
            this.statusListener = null;
        }
    }

    private final String getErrorMessage(int i) {
        switch (i) {
            case -13:
                return "Failed to copy module";
            case -12:
                return "Emulation error";
            case -11:
                return "Verification failed";
            case -10:
                return "Not enough storage space";
            case -9:
                return "Service error, please try again";
            case -8:
                return "Incompatible with existing session";
            case -7:
                return "Access denied to download feature";
            case -6:
                return "Network error, please check your connection";
            case -5:
                return "Feature delivery not available on this device";
            case -4:
                return "Session not found";
            case -3:
                return "Invalid install request";
            case -2:
                return "Module not available";
            case -1:
                return "Too many active downloads";
            case 0:
                return "No error";
            default:
                return "Unknown error (code: " + i + ")";
        }
    }

    public final String versionToModuleName(String str) {
        Intrinsics.checkNotNullParameter(str, "version");
        return "pumpkin_" + StringsKt.replace$default(str, ".", "_", false, 4, (Object) null);
    }

    public final String moduleNameToVersion(String str) {
        Intrinsics.checkNotNullParameter(str, PumpkinService.EXTRA_MODULE_NAME);
        return StringsKt.replace$default(StringsKt.removePrefix(str, (CharSequence) "pumpkin_"), "_", ".", false, 4, (Object) null);
    }

    public final void cleanup() {
        unregisterListener();
    }
}
