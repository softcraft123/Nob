package com.armmc.app;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\t\u0010\u000b\u001a\u00020\tH J\t\u0010\f\u001a\u00020\tH R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/armmc/app/CrashGuard;", "", "<init>", "()V", "TAG", "", "installed", "", "install", "", "reinstall", "nativeInstallSignalHandlers", "nativeReinstallSignalHandlers", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CrashGuard.kt */
public final class CrashGuard {
    public static final CrashGuard INSTANCE = new CrashGuard();
    private static final String TAG = "CrashGuard";
    private static volatile boolean installed;

    @JvmStatic
    private static final native void nativeInstallSignalHandlers();

    @JvmStatic
    private static final native void nativeReinstallSignalHandlers();

    private CrashGuard() {
    }

    public final synchronized void install() {
        if (installed) {
            Log.d(TAG, "Signal handlers already installed");
            return;
        }
        try {
            System.loadLibrary("crashguard");
            nativeInstallSignalHandlers();
            installed = true;
            Log.i(TAG, "Native signal handlers installed successfully");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Failed to load crashguard library", e);
        } catch (Exception e2) {
            Log.e(TAG, "Failed to install signal handlers", e2);
        }
    }

    public final void reinstall() {
        if (installed) {
            try {
                nativeReinstallSignalHandlers();
                Log.i(TAG, "Signal handlers re-installed");
            } catch (Exception e) {
                Log.e(TAG, "Failed to re-install signal handlers", e);
            }
        }
    }
}
