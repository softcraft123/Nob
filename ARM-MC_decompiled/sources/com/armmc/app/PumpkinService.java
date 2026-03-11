package com.armmc.app;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.armmc.app.PumpkinServer;
import com.armmc.app.ui.servers.ServerRepository;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/armmc/app/PumpkinService;", "Landroid/app/Service;", "<init>", "()V", "binder", "Landroid/os/Binder;", "server", "Lcom/armmc/app/PumpkinServer;", "currentServerId", "", "isServerRunning", "", "lowMemoryStop", "onCreate", "", "onStartCommand", "intent", "Landroid/content/Intent;", "flags", "startId", "startMemoryWatchdog", "onServerStopped", "onDestroy", "onBind", "Landroid/os/IBinder;", "stopServerAndCleanup", "startForegroundService", "updateNotificationWithActions", "createNotificationWithActions", "Landroid/app/Notification;", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: PumpkinService.kt */
public final class PumpkinService extends Service {
    public static final String ACTION_EXECUTE_COMMAND = "com.armmc.app.ACTION_EXECUTE_COMMAND";
    public static final String ACTION_OPEN_APP = "com.armmc.app.ACTION_OPEN_APP";
    public static final String ACTION_SERVER_CRASHED = "com.armmc.app.SERVER_CRASHED";
    public static final String ACTION_SERVER_STOPPED = "com.armmc.app.SERVER_STOPPED";
    public static final String ACTION_STOP_SERVER = "com.armmc.app.ACTION_STOP_SERVER";
    private static final String CHANNEL_ID = "pumpkin_service_channel";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_COMMAND = "command";
    public static final String EXTRA_CRASH_MESSAGE = "crashMessage";
    public static final String EXTRA_LIBRARY_PATH = "libraryPath";
    public static final String EXTRA_LOW_MEMORY = "lowMemory";
    public static final String EXTRA_MODULE_NAME = "moduleName";
    public static final String EXTRA_SERVER_ID = "serverId";
    private static final int NOTIFICATION_ID = 1;
    private static final String TAG = "PumpkinService";
    private final Binder binder = new Binder();
    private int currentServerId = -1;
    private volatile boolean isServerRunning;
    private volatile boolean lowMemoryStop;
    private final PumpkinServer server = new PumpkinServer();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u00020\u00058\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003¨\u0006\u0015"}, d2 = {"Lcom/armmc/app/PumpkinService$Companion;", "", "<init>", "()V", "TAG", "", "NOTIFICATION_ID", "", "CHANNEL_ID", "EXTRA_MODULE_NAME", "EXTRA_SERVER_ID", "ACTION_SERVER_CRASHED", "ACTION_SERVER_STOPPED", "ACTION_STOP_SERVER", "ACTION_OPEN_APP", "ACTION_EXECUTE_COMMAND", "EXTRA_COMMAND", "EXTRA_CRASH_MESSAGE", "EXTRA_LOW_MEMORY", "EXTRA_LIBRARY_PATH", "getEXTRA_LIBRARY_PATH$annotations", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: PumpkinService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use EXTRA_MODULE_NAME instead")
        public static /* synthetic */ void getEXTRA_LIBRARY_PATH$annotations() {
        }

        private Companion() {
        }
    }

    public void onCreate() {
        super.onCreate();
        CrashGuard.INSTANCE.install();
        Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new PumpkinService$$ExternalSyntheticLambda1(this));
        Context context = this;
        SplitCompat.installActivity(context);
        LogManager.INSTANCE.init(context);
        startForegroundService();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(PumpkinService pumpkinService, Thread thread, Throwable th) {
        Log.e(TAG, "Uncaught exception in server process on thread '" + thread.getName() + "'", th);
        try {
            Intent intent = new Intent(ACTION_SERVER_CRASHED);
            intent.setPackage(pumpkinService.getPackageName());
            intent.putExtra(EXTRA_CRASH_MESSAGE, th.toString());
            pumpkinService.sendBroadcast(intent);
        } catch (Exception unused) {
        }
        Process.killProcess(Process.myPid());
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Intent intent2 = intent;
        if (Intrinsics.areEqual((Object) intent2 != null ? intent2.getAction() : null, (Object) ACTION_STOP_SERVER)) {
            Log.d(TAG, "Stop action received from notification");
            stopServerAndCleanup();
            return 2;
        }
        if (Intrinsics.areEqual((Object) intent2 != null ? intent2.getAction() : null, (Object) ACTION_EXECUTE_COMMAND)) {
            String stringExtra = intent2.getStringExtra(EXTRA_COMMAND);
            CharSequence charSequence = stringExtra;
            if (charSequence != null && !StringsKt.isBlank(charSequence)) {
                if (!PumpkinServer.Companion.isLoaded()) {
                    Log.w(TAG, "Cannot execute command: native library not loaded");
                    return 2;
                }
                Log.d(TAG, "Executing command: " + stringExtra);
                try {
                    this.server.executeCommand(stringExtra);
                } catch (Throwable th) {
                    Log.e(TAG, "Failed to execute command", th);
                }
            }
            return 2;
        }
        String stringExtra2 = intent2 != null ? intent2.getStringExtra(EXTRA_MODULE_NAME) : null;
        String stringExtra3 = intent2 != null ? intent2.getStringExtra(EXTRA_LIBRARY_PATH) : null;
        int i3 = -1;
        if (intent2 != null) {
            i3 = intent2.getIntExtra(EXTRA_SERVER_ID, -1);
        }
        this.currentServerId = i3;
        CharSequence charSequence2 = stringExtra2;
        boolean z2 = false;
        if (charSequence2 == null || charSequence2.length() == 0) {
            CharSequence charSequence3 = stringExtra3;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                Log.d(TAG, "Loading library from path: " + stringExtra3);
                z = PumpkinServer.Companion.loadLibrary(stringExtra3);
            } else {
                Log.e(TAG, "No module name or library path provided, cannot start server");
                stopSelf();
                return 2;
            }
        } else {
            Log.d(TAG, "Loading library from module: " + stringExtra2);
            z = PumpkinServer.Companion.loadLibraryFromModule$default(PumpkinServer.Companion, this, stringExtra2, (String) null, 4, (Object) null);
        }
        if (!z) {
            Log.e(TAG, "Failed to load native library");
            stopSelf();
            return 2;
        }
        CrashGuard.INSTANCE.reinstall();
        if (intent2 == null || (str = intent2.getStringExtra("serverPath")) == null) {
            str = getFilesDir().getAbsolutePath();
        }
        if (intent2 == null || (str2 = intent2.getStringExtra("ip")) == null) {
            str2 = "0.0.0.0";
        }
        int i4 = 25565;
        if (intent2 != null) {
            i4 = intent2.getIntExtra("port", 25565);
        }
        int i5 = 10;
        int intExtra = intent2 != null ? intent2.getIntExtra("viewDistance", 10) : 10;
        if (intent2 != null) {
            i5 = intent2.getIntExtra("simulationDistance", 10);
        }
        int i6 = 100;
        if (intent2 != null) {
            i6 = intent2.getIntExtra("maxPlayers", 100);
        }
        if (intent2 == null || (str3 = intent2.getStringExtra("seed")) == null) {
            str3 = "";
        }
        if (intent2 == null || (str4 = intent2.getStringExtra("motd")) == null) {
            str4 = "A Blazing fast Pumpkin Server!";
        }
        if (intent2 == null || (str5 = intent2.getStringExtra("defaultDifficulty")) == null) {
            str5 = "Normal";
        }
        if (intent2 == null || (str6 = intent2.getStringExtra("defaultGamemode")) == null) {
            str6 = "Survival";
        }
        boolean booleanExtra = intent2 != null ? intent2.getBooleanExtra("onlineMode", true) : true;
        boolean booleanExtra2 = intent2 != null ? intent2.getBooleanExtra("hardcore", false) : false;
        boolean booleanExtra3 = intent2 != null ? intent2.getBooleanExtra("whiteList", false) : false;
        if (intent2 != null) {
            z2 = intent2.getBooleanExtra("enforceWhitelist", false);
        }
        String stringExtra4 = (!booleanExtra3 || intent2 == null) ? null : intent2.getStringExtra("whitelistEntries");
        Log.d(TAG, "whitelistEntries: " + stringExtra4);
        updateNotificationWithActions();
        ThreadsKt.thread$default(true, false, (ClassLoader) null, "PumpkinThread", 0, new PumpkinService$$ExternalSyntheticLambda2(this, str, str2, i4, intExtra, i5, i6, str3, str4, str5, str6, booleanExtra, booleanExtra2, booleanExtra3, z2, stringExtra4), 22, (Object) null);
        this.isServerRunning = true;
        startMemoryWatchdog();
        return 2;
    }

    /* access modifiers changed from: private */
    public static final Unit onStartCommand$lambda$2(PumpkinService pumpkinService, String str, String str2, int i, int i2, int i3, int i4, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, boolean z4, String str7) {
        PumpkinService pumpkinService2 = pumpkinService;
        PumpkinServer pumpkinServer = pumpkinService2.server;
        Intrinsics.checkNotNull(str);
        String lowerCase = str5.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = str6.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        pumpkinServer.startServer(str, str2, i, i2, i3, i4, str3, str4, lowerCase, lowerCase2, z, z2, z3, z4, str7);
        Log.d(TAG, "Server stopped, cleaning up...");
        pumpkinService2.onServerStopped();
        return Unit.INSTANCE;
    }

    private final void startMemoryWatchdog() {
        ThreadsKt.thread$default(true, false, (ClassLoader) null, "MemoryWatchdog", 0, new PumpkinService$$ExternalSyntheticLambda3(this), 22, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit startMemoryWatchdog$lambda$3(PumpkinService pumpkinService) {
        Object systemService = pumpkinService.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long coerceAtMost = RangesKt.coerceAtMost(Math.max(memoryInfo.threshold * ((long) 3), 419430400), 734003200);
        long j = (long) 1048576;
        long j2 = coerceAtMost / j;
        Log.i(TAG, "Memory watchdog started. Will stop server if available RAM drops below " + j2 + "MB");
        while (true) {
            if (!pumpkinService.isServerRunning) {
                break;
            }
            try {
                Thread.sleep(2000);
                if (!pumpkinService.isServerRunning) {
                    break;
                }
                activityManager.getMemoryInfo(memoryInfo);
                long j3 = memoryInfo.availMem / j;
                if (memoryInfo.availMem < coerceAtMost) {
                    Log.w(TAG, "Memory watchdog triggered: only " + j3 + "MB available (threshold " + j2 + "MB). Stopping server.");
                    pumpkinService.lowMemoryStop = true;
                    try {
                        pumpkinService.server.stopServer();
                        break;
                    } catch (Exception e) {
                        Log.e(TAG, "Failed to stop server in memory watchdog, killing process", e);
                        Process.killProcess(Process.myPid());
                    }
                }
            } catch (InterruptedException unused) {
            }
        }
        Log.d(TAG, "Memory watchdog stopped");
        return Unit.INSTANCE;
    }

    private final void onServerStopped() {
        this.isServerRunning = false;
        Log.d(TAG, "Server stopped, updating state for server ID: " + this.currentServerId);
        if (this.currentServerId != -1) {
            try {
                Context applicationContext = getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                ServerRepository serverRepository = new ServerRepository(applicationContext);
                serverRepository.updateServerStatus(this.currentServerId, false);
                serverRepository.resetTunnelState(this.currentServerId);
                Log.d(TAG, "Updated server status to offline for server ID: " + this.currentServerId);
            } catch (Exception e) {
                Log.e(TAG, "Failed to update server status", e);
            }
        }
        Intent intent = new Intent(ACTION_SERVER_STOPPED);
        intent.setPackage(getPackageName());
        intent.putExtra(EXTRA_SERVER_ID, this.currentServerId);
        if (this.lowMemoryStop) {
            intent.putExtra(EXTRA_LOW_MEMORY, true);
        }
        sendBroadcast(intent);
        stopForeground(1);
        stopSelf();
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new PumpkinService$$ExternalSyntheticLambda0(), 31, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit onServerStopped$lambda$5() {
        Thread.sleep(300);
        Process.killProcess(Process.myPid());
        return Unit.INSTANCE;
    }

    public void onDestroy() {
        this.isServerRunning = false;
        if (PumpkinServer.Companion.isLoaded()) {
            this.server.stopServer();
        }
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    private final void stopServerAndCleanup() {
        Log.d(TAG, "Stopping server via notification for server ID: " + this.currentServerId);
        if (!PumpkinServer.Companion.isLoaded()) {
            Log.w(TAG, "Native library not loaded, nothing to stop — stopping service");
            stopSelf();
            return;
        }
        this.server.stopServer();
    }

    private final void startForegroundService() {
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Pumpkin Server", 2);
        notificationChannel.setDescription("Notification for Pumpkin server status");
        notificationChannel.setShowBadge(false);
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        Notification createNotificationWithActions = createNotificationWithActions();
        if (Build.VERSION.SDK_INT >= 29) {
            startForeground(1, createNotificationWithActions, 1073741824);
        } else {
            startForeground(1, createNotificationWithActions);
        }
    }

    private final void updateNotificationWithActions() {
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(1, createNotificationWithActions());
    }

    private final Notification createNotificationWithActions() {
        Context context = this;
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        Intent intent2 = new Intent(context, PumpkinService.class);
        intent2.setAction(ACTION_STOP_SERVER);
        Notification build = new NotificationCompat.Builder(context, CHANNEL_ID).setContentTitle("Pumpkin Server").setContentText("Server is running in the background").setSmallIcon(R.drawable.logo_transparent).setOngoing(true).setContentIntent(activity).addAction(17301591, "Open", activity).addAction(17301539, "Stop", PendingIntent.getService(context, 1, intent2, 201326592)).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}
