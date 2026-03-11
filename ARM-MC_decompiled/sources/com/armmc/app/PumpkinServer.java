package com.armmc.app;

import android.content.Context;
import android.util.Log;
import com.google.android.play.core.splitcompat.SplitCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H J\t\u0010\u0018\u001a\u00020\u0005H J\u0011\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0007H ¨\u0006\u001c"}, d2 = {"Lcom/armmc/app/PumpkinServer;", "", "<init>", "()V", "startServer", "", "path", "", "ip", "port", "", "viewDistance", "simulationDistance", "maxPlayers", "seed", "motd", "defaultDifficulty", "defaultGamemode", "onlineMode", "", "hardcore", "whiteList", "enforceWhitelist", "whitelistEntries", "stopServer", "executeCommand", "command", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: PumpkinServer.kt */
public final class PumpkinServer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "PumpkinServer";
    /* access modifiers changed from: private */
    public static volatile boolean isLibraryLoaded;
    /* access modifiers changed from: private */
    public static String loadedLibraryPath;
    /* access modifiers changed from: private */
    public static String loadedModuleName;

    public final native boolean executeCommand(String str);

    public final native void startServer(String str, String str2, int i, int i2, int i3, int i4, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, boolean z4, String str7);

    public final native void stopServer();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0007J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/armmc/app/PumpkinServer$Companion;", "", "<init>", "()V", "TAG", "", "isLibraryLoaded", "", "loadedLibraryPath", "loadedModuleName", "loadLibraryFromModule", "context", "Landroid/content/Context;", "moduleName", "libraryFileName", "loadLibrary", "libraryPath", "isLoaded", "getLoadedLibraryPath", "getLoadedModuleName", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: PumpkinServer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ boolean loadLibraryFromModule$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = "libpumpkin.so";
            }
            return companion.loadLibraryFromModule(context, str, str2);
        }

        public final synchronized boolean loadLibraryFromModule(Context context, String str, String str2) {
            boolean z;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, PumpkinService.EXTRA_MODULE_NAME);
            Intrinsics.checkNotNullParameter(str2, "libraryFileName");
            boolean z2 = true;
            if (!PumpkinServer.isLibraryLoaded || !Intrinsics.areEqual((Object) PumpkinServer.loadedModuleName, (Object) str)) {
                z = false;
                if (!PumpkinServer.isLibraryLoaded || Intrinsics.areEqual((Object) PumpkinServer.loadedModuleName, (Object) str)) {
                    SplitCompat.installActivity(context);
                    LibraryManager libraryManager = new LibraryManager(context);
                    try {
                        Log.d(PumpkinServer.TAG, "Loading native library from module: " + str);
                        if (libraryManager.loadLibraryFromModule(str, str2)) {
                            PumpkinServer.isLibraryLoaded = true;
                            PumpkinServer.loadedModuleName = str;
                            PumpkinServer.loadedLibraryPath = null;
                            Log.d(PumpkinServer.TAG, "Native library loaded successfully from module");
                        } else {
                            Log.e(PumpkinServer.TAG, "Failed to load native library from module: " + str);
                            z2 = false;
                        }
                        z = z2;
                    } catch (UnsatisfiedLinkError e) {
                        Log.e(PumpkinServer.TAG, "Failed to load native library from module", e);
                    } catch (Exception e2) {
                        Log.e(PumpkinServer.TAG, "Error loading native library from module", e2);
                    }
                } else {
                    Log.w(PumpkinServer.TAG, "A different library is already loaded from module: " + PumpkinServer.loadedModuleName);
                    Log.w(PumpkinServer.TAG, "Cannot load new library from module: " + str);
                    Log.w(PumpkinServer.TAG, "App restart required to load a different library version");
                    return false;
                }
            } else {
                Log.d(PumpkinServer.TAG, "Library already loaded from module: " + str);
                return true;
            }
            return z;
        }

        public final synchronized boolean loadLibrary(String str) {
            boolean z;
            Intrinsics.checkNotNullParameter(str, PumpkinService.EXTRA_LIBRARY_PATH);
            z = true;
            if (PumpkinServer.isLibraryLoaded && Intrinsics.areEqual((Object) PumpkinServer.loadedLibraryPath, (Object) str)) {
                Log.d(PumpkinServer.TAG, "Library already loaded from: " + str);
                return true;
            } else if (!PumpkinServer.isLibraryLoaded || Intrinsics.areEqual((Object) PumpkinServer.loadedLibraryPath, (Object) str)) {
                try {
                    Log.d(PumpkinServer.TAG, "Loading native library from: " + str);
                    System.load(str);
                    PumpkinServer.isLibraryLoaded = true;
                    PumpkinServer.loadedLibraryPath = str;
                    PumpkinServer.loadedModuleName = null;
                    Log.d(PumpkinServer.TAG, "Native library loaded successfully");
                } catch (UnsatisfiedLinkError e) {
                    Log.e(PumpkinServer.TAG, "Failed to load native library", e);
                    PumpkinServer.isLibraryLoaded = false;
                    PumpkinServer.loadedLibraryPath = null;
                } catch (Exception e2) {
                    Log.e(PumpkinServer.TAG, "Error loading native library", e2);
                    PumpkinServer.isLibraryLoaded = false;
                    PumpkinServer.loadedLibraryPath = null;
                }
            } else {
                Log.w(PumpkinServer.TAG, "A different library is already loaded: " + PumpkinServer.loadedLibraryPath);
                Log.w(PumpkinServer.TAG, "Cannot load new library: " + str);
                Log.w(PumpkinServer.TAG, "App restart required to load a different library version");
                return false;
            }
            z = false;
            return z;
        }

        public final boolean isLoaded() {
            return PumpkinServer.isLibraryLoaded;
        }

        public final String getLoadedLibraryPath() {
            return PumpkinServer.loadedLibraryPath;
        }

        public final String getLoadedModuleName() {
            return PumpkinServer.loadedModuleName;
        }
    }
}
