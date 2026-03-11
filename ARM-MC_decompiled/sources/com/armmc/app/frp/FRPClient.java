package com.armmc.app.frp;

import android.util.Log;
import com.armmc.app.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \"2\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ>\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u0007J\"\u0010\u001d\u001a\u00020\b2\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005J\u0016\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0007R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/armmc/app/frp/FRPClient;", "", "<init>", "()V", "statusListener", "Lkotlin/Function2;", "", "", "", "callbackRegistered", "", "initialize", "configure", "config", "Lcom/armmc/app/frp/FRPConfig;", "configureSimple", "serverAddr", "serverPort", "authToken", "localIP", "localPort", "remotePort", "start", "stop", "getStatus", "getStatusString", "getLastError", "isRunning", "getVersion", "setStatusListener", "listener", "onStatusChanged", "status", "message", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FRPClient.kt */
public final class FRPClient {
    public static final Companion Companion;
    public static final int STATUS_CONNECTING = 5;
    public static final int STATUS_ERROR = 4;
    public static final int STATUS_RECONNECTING = 6;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_STARTING = 1;
    public static final int STATUS_STOPPED = 0;
    public static final int STATUS_STOPPING = 3;
    private static final String TAG = "FRPClient";
    /* access modifiers changed from: private */
    public static volatile FRPClient instance;
    private static boolean nativesRegistered;
    private boolean callbackRegistered;
    private Function2<? super Integer, ? super String, Unit> statusListener;

    public /* synthetic */ FRPClient(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeConfigure(String str);

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeConfigureSimple(String str, int i, String str2, String str3, int i2, int i3);

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native String nativeGetLastError();

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeGetStatus();

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native String nativeGetStatusString();

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native String nativeGetVersion();

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeInitialize();

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeIsRunning();

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeSetStatusCallback(Object obj);

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeStart();

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeStop();

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native int registerNativeMethods();

    private FRPClient() {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u000fJ\t\u0010\u0013\u001a\u00020\u0007H J\t\u0010\u0014\u001a\u00020\u0007H J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005H J9\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H J\t\u0010\u001e\u001a\u00020\u0007H J\t\u0010\u001f\u001a\u00020\u0007H J\t\u0010 \u001a\u00020\u0007H J\t\u0010!\u001a\u00020\u0005H J\t\u0010\"\u001a\u00020\u0005H J\t\u0010#\u001a\u00020\u0007H J\t\u0010$\u001a\u00020\u0005H J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001H R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/armmc/app/frp/FRPClient$Companion;", "", "<init>", "()V", "TAG", "", "STATUS_STOPPED", "", "STATUS_STARTING", "STATUS_RUNNING", "STATUS_STOPPING", "STATUS_ERROR", "STATUS_CONNECTING", "STATUS_RECONNECTING", "instance", "Lcom/armmc/app/frp/FRPClient;", "nativesRegistered", "", "getInstance", "registerNativeMethods", "nativeInitialize", "nativeConfigure", "configJson", "nativeConfigureSimple", "serverAddr", "serverPort", "authToken", "localIP", "localPort", "remotePort", "nativeStart", "nativeStop", "nativeGetStatus", "nativeGetStatusString", "nativeGetLastError", "nativeIsRunning", "nativeGetVersion", "nativeSetStatusCallback", "callbackObject", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FRPClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int nativeConfigure(String str) {
            return FRPClient.nativeConfigure(str);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int nativeConfigureSimple(String str, int i, String str2, String str3, int i2, int i3) {
            return FRPClient.nativeConfigureSimple(str, i, str2, str3, i2, i3);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final String nativeGetLastError() {
            return FRPClient.nativeGetLastError();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int nativeGetStatus() {
            return FRPClient.nativeGetStatus();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final String nativeGetStatusString() {
            return FRPClient.nativeGetStatusString();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final String nativeGetVersion() {
            return FRPClient.nativeGetVersion();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int nativeInitialize() {
            return FRPClient.nativeInitialize();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int nativeIsRunning() {
            return FRPClient.nativeIsRunning();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int nativeSetStatusCallback(Object obj) {
            return FRPClient.nativeSetStatusCallback(obj);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int nativeStart() {
            return FRPClient.nativeStart();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int nativeStop() {
            return FRPClient.nativeStop();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int registerNativeMethods() {
            return FRPClient.registerNativeMethods();
        }

        private Companion() {
        }

        public final FRPClient getInstance() {
            FRPClient access$getInstance$cp;
            FRPClient access$getInstance$cp2 = FRPClient.instance;
            if (access$getInstance$cp2 != null) {
                return access$getInstance$cp2;
            }
            synchronized (this) {
                access$getInstance$cp = FRPClient.instance;
                if (access$getInstance$cp == null) {
                    access$getInstance$cp = new FRPClient((DefaultConstructorMarker) null);
                    Companion companion = FRPClient.Companion;
                    FRPClient.instance = access$getInstance$cp;
                    boolean unused = access$getInstance$cp.initialize();
                }
            }
            return access$getInstance$cp;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        nativesRegistered = true;
        android.util.Log.d(TAG, "Native methods already registered by JNI_OnLoad");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0020 */
    static {
        /*
            java.lang.String r0 = "FRPClient"
            com.armmc.app.frp.FRPClient$Companion r1 = new com.armmc.app.frp.FRPClient$Companion
            r2 = 0
            r1.<init>(r2)
            Companion = r1
            java.lang.String r2 = "frp"
            java.lang.System.loadLibrary(r2)     // Catch:{ UnsatisfiedLinkError -> 0x0028 }
            java.lang.String r2 = "FRP native library loaded successfully"
            android.util.Log.i(r0, r2)     // Catch:{ UnsatisfiedLinkError -> 0x0028 }
            r2 = 1
            int unused = r1.registerNativeMethods()     // Catch:{ UnsatisfiedLinkError -> 0x0020 }
            nativesRegistered = r2     // Catch:{ UnsatisfiedLinkError -> 0x0020 }
            java.lang.String r1 = "Native methods registered via explicit registration"
            android.util.Log.i(r0, r1)     // Catch:{ UnsatisfiedLinkError -> 0x0020 }
            return
        L_0x0020:
            nativesRegistered = r2     // Catch:{ UnsatisfiedLinkError -> 0x0028 }
            java.lang.String r1 = "Native methods already registered by JNI_OnLoad"
            android.util.Log.d(r0, r1)     // Catch:{ UnsatisfiedLinkError -> 0x0028 }
            return
        L_0x0028:
            r1 = move-exception
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.String r2 = "Failed to load FRP native library"
            android.util.Log.e(r0, r2, r1)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r2 = "Failed to load libfrp.so"
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.frp.FRPClient.<clinit>():void");
    }

    /* access modifiers changed from: private */
    public final boolean initialize() {
        if (Companion.nativeInitialize() != 0) {
            Log.e(TAG, "Failed to initialize FRP client");
            return false;
        }
        Log.i(TAG, "FRP client initialized, version: " + getVersion());
        return true;
    }

    public final boolean configure(FRPConfig fRPConfig) {
        Intrinsics.checkNotNullParameter(fRPConfig, "config");
        String json = fRPConfig.toJson();
        Log.d(TAG, "Configuring FRP client: " + json);
        if (Companion.nativeConfigure(json) == 0) {
            return true;
        }
        Log.e(TAG, "Failed to configure FRP client: " + getLastError());
        return false;
    }

    public static /* synthetic */ boolean configureSimple$default(FRPClient fRPClient, String str, int i, String str2, String str3, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 7000;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            str3 = "127.0.0.1";
        }
        return fRPClient.configureSimple(str, i5, str2, str3, (i4 & 16) != 0 ? 25565 : i2, (i4 & 32) != 0 ? 25565 : i3);
    }

    public final boolean configureSimple(String str, int i, String str2, String str3, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "serverAddr");
        Intrinsics.checkNotNullParameter(str2, "authToken");
        Intrinsics.checkNotNullParameter(str3, "localIP");
        Log.d(TAG, "Configuring FRP client: " + str + ":" + i + " -> " + str3 + ":" + i2 + " (remote: " + i3 + ")");
        if (Companion.nativeConfigureSimple(str, i, str2, str3, i2, i3) == 0) {
            return true;
        }
        Log.e(TAG, "Failed to configure FRP client: " + getLastError());
        return false;
    }

    public final boolean start() {
        Log.i(TAG, "Starting FRP client");
        if (Companion.nativeStart() != 0) {
            Log.e(TAG, "Failed to start FRP client: " + getLastError());
            return false;
        }
        Log.i(TAG, "FRP client started successfully");
        return true;
    }

    public final boolean stop() {
        Log.i(TAG, "Stopping FRP client");
        if (Companion.nativeStop() != 0) {
            Log.e(TAG, "Failed to stop FRP client: " + getLastError());
            return false;
        }
        Log.i(TAG, "FRP client stopped successfully");
        return true;
    }

    public final int getStatus() {
        return Companion.nativeGetStatus();
    }

    public final String getStatusString() {
        return Companion.nativeGetStatusString();
    }

    public final String getLastError() {
        return Companion.nativeGetLastError();
    }

    public final boolean isRunning() {
        return Companion.nativeIsRunning() == 1;
    }

    public final String getVersion() {
        return Companion.nativeGetVersion();
    }

    public final void setStatusListener(Function2<? super Integer, ? super String, Unit> function2) {
        this.statusListener = function2;
        if (function2 != null && !this.callbackRegistered) {
            int access$nativeSetStatusCallback = Companion.nativeSetStatusCallback(this);
            if (access$nativeSetStatusCallback == 0) {
                this.callbackRegistered = true;
                Log.i(TAG, "Native status callback registered successfully");
                return;
            }
            Log.e(TAG, "Failed to register native status callback: " + access$nativeSetStatusCallback);
        } else if (function2 == null && this.callbackRegistered) {
            int unused = Companion.nativeSetStatusCallback((Object) null);
            this.callbackRegistered = false;
            Log.i(TAG, "Native status callback cleared");
        }
    }

    public final void onStatusChanged(int i, String str) {
        Intrinsics.checkNotNullParameter(str, LogManager.EXTRA_MESSAGE);
        Log.d(TAG, "Status changed: " + i + " - " + str);
        Function2<? super Integer, ? super String, Unit> function2 = this.statusListener;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i), str);
        }
    }
}
