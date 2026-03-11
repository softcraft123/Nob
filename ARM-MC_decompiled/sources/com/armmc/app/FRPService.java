package com.armmc.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.armmc.app.frp.FRPClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J8\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0017H\u0002J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0017H\u0002J\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/armmc/app/FRPService;", "Landroid/app/Service;", "<init>", "()V", "frpClient", "Lcom/armmc/app/frp/FRPClient;", "isRunning", "", "binder", "Lcom/armmc/app/FRPService$LocalBinder;", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", "onDestroy", "startTunnel", "serverAddr", "", "serverPort", "authToken", "localIP", "localPort", "remotePort", "stopTunnel", "createNotificationChannel", "createNotification", "Landroid/app/Notification;", "status", "updateNotification", "getStatusText", "message", "isConnected", "getClient", "Companion", "LocalBinder", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FRPService.kt */
public final class FRPService extends Service {
    public static final String ACTION_START = "com.arm_mc.app.action.START_TUNNEL";
    public static final String ACTION_STOP = "com.arm_mc.app.action.STOP_TUNNEL";
    private static final String CHANNEL_ID = "frp_tunnel_channel";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_AUTH_TOKEN = "auth_token";
    public static final String EXTRA_LOCAL_IP = "local_ip";
    public static final String EXTRA_LOCAL_PORT = "local_port";
    public static final String EXTRA_REMOTE_PORT = "remote_port";
    public static final String EXTRA_SERVER_ADDR = "server_addr";
    public static final String EXTRA_SERVER_PORT = "server_port";
    private static final int NOTIFICATION_ID = 1001;
    private static final String TAG = "FRPService";
    private final LocalBinder binder = new LocalBinder();
    private FRPClient frpClient;
    private boolean isRunning;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/armmc/app/FRPService$Companion;", "", "<init>", "()V", "TAG", "", "NOTIFICATION_ID", "", "CHANNEL_ID", "ACTION_START", "ACTION_STOP", "EXTRA_SERVER_ADDR", "EXTRA_SERVER_PORT", "EXTRA_AUTH_TOKEN", "EXTRA_LOCAL_IP", "EXTRA_LOCAL_PORT", "EXTRA_REMOTE_PORT", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FRPService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/armmc/app/FRPService$LocalBinder;", "Landroid/os/Binder;", "<init>", "(Lcom/armmc/app/FRPService;)V", "getService", "Lcom/armmc/app/FRPService;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FRPService.kt */
    public final class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public final FRPService getService() {
            return FRPService.this;
        }
    }

    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
        this.frpClient = FRPClient.Companion.getInstance();
        createNotificationChannel();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        String str2;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1115363864) {
                if (hashCode == -119548926 && str.equals(ACTION_STOP)) {
                    stopTunnel();
                    stopForeground(1);
                    stopSelf();
                }
            } else if (str.equals(ACTION_START)) {
                String stringExtra = intent.getStringExtra(EXTRA_SERVER_ADDR);
                String str3 = stringExtra == null ? "" : stringExtra;
                int intExtra = intent.getIntExtra(EXTRA_SERVER_PORT, 7000);
                String stringExtra2 = intent.getStringExtra(EXTRA_AUTH_TOKEN);
                if (stringExtra2 == null) {
                    str2 = "";
                } else {
                    str2 = stringExtra2;
                }
                String stringExtra3 = intent.getStringExtra(EXTRA_LOCAL_IP);
                if (stringExtra3 == null) {
                    stringExtra3 = "127.0.0.1";
                }
                startTunnel(str3, intExtra, str2, stringExtra3, intent.getIntExtra(EXTRA_LOCAL_PORT, 25565), intent.getIntExtra(EXTRA_REMOTE_PORT, 25565));
            }
        }
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");
        stopTunnel();
    }

    private final void startTunnel(String str, int i, String str2, String str3, int i2, int i3) {
        FRPClient fRPClient;
        if (this.isRunning) {
            Log.w(TAG, "Tunnel already running");
            return;
        }
        Log.i(TAG, "Starting tunnel to " + str + ":" + i);
        startForeground(1001, createNotification("Connecting..."));
        FRPClient fRPClient2 = this.frpClient;
        FRPClient fRPClient3 = null;
        if (fRPClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frpClient");
            fRPClient2 = null;
        }
        fRPClient2.setStatusListener(new FRPService$$ExternalSyntheticLambda0(this));
        FRPClient fRPClient4 = this.frpClient;
        if (fRPClient4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frpClient");
            fRPClient = null;
        } else {
            fRPClient = fRPClient4;
        }
        if (!fRPClient.configureSimple(str, i, str2, str3, i2, i3)) {
            FRPClient fRPClient5 = this.frpClient;
            if (fRPClient5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frpClient");
                fRPClient5 = null;
            }
            Log.e(TAG, "Failed to configure: " + fRPClient5.getLastError());
            FRPClient fRPClient6 = this.frpClient;
            if (fRPClient6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frpClient");
            } else {
                fRPClient3 = fRPClient6;
            }
            updateNotification("Configuration failed: " + fRPClient3.getLastError());
            return;
        }
        new Thread(new FRPService$$ExternalSyntheticLambda1(this)).start();
    }

    /* access modifiers changed from: private */
    public static final Unit startTunnel$lambda$0(FRPService fRPService, int i, String str) {
        Intrinsics.checkNotNullParameter(str, LogManager.EXTRA_MESSAGE);
        fRPService.updateNotification(fRPService.getStatusText(i, str));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void startTunnel$lambda$1(FRPService fRPService) {
        FRPClient fRPClient = fRPService.frpClient;
        FRPClient fRPClient2 = null;
        if (fRPClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frpClient");
            fRPClient = null;
        }
        if (fRPClient.start()) {
            fRPService.isRunning = true;
            Log.i(TAG, "Tunnel started successfully");
            return;
        }
        FRPClient fRPClient3 = fRPService.frpClient;
        if (fRPClient3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frpClient");
            fRPClient3 = null;
        }
        Log.e(TAG, "Failed to start: " + fRPClient3.getLastError());
        FRPClient fRPClient4 = fRPService.frpClient;
        if (fRPClient4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frpClient");
        } else {
            fRPClient2 = fRPClient4;
        }
        fRPService.updateNotification("Failed to start: " + fRPClient2.getLastError());
    }

    private final void stopTunnel() {
        if (this.isRunning) {
            Log.i(TAG, "Stopping tunnel");
            FRPClient fRPClient = this.frpClient;
            if (fRPClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frpClient");
                fRPClient = null;
            }
            fRPClient.stop();
            this.isRunning = false;
        }
    }

    private final void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "FRP Tunnel", 2);
        notificationChannel.setDescription("Notification for FRP tunnel status");
        notificationChannel.setShowBadge(false);
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }

    private final Notification createNotification(String str) {
        Context context = this;
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(536870912);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        Intent intent2 = new Intent(context, FRPService.class);
        intent2.setAction(ACTION_STOP);
        Notification build = new NotificationCompat.Builder(context, CHANNEL_ID).setContentTitle("FRP Tunnel").setContentText(str).setSmallIcon(17301586).setOngoing(true).setContentIntent(activity).addAction(17301533, "Stop", PendingIntent.getService(context, 0, intent2, 201326592)).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final void updateNotification(String str) {
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(1001, createNotification(str));
    }

    private final String getStatusText(int i, String str) {
        switch (i) {
            case 0:
                return "Stopped";
            case 1:
                return "Starting...";
            case 2:
                return "Connected - Tunnel Active";
            case 3:
                return "Stopping...";
            case 4:
                return "Error: " + str;
            case 5:
                return "Connecting...";
            case 6:
                return "Reconnecting...";
            default:
                return str;
        }
    }

    public final boolean isConnected() {
        FRPClient fRPClient = this.frpClient;
        if (fRPClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frpClient");
            fRPClient = null;
        }
        return fRPClient.isRunning();
    }

    public final FRPClient getClient() {
        FRPClient fRPClient = this.frpClient;
        if (fRPClient != null) {
            return fRPClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("frpClient");
        return null;
    }
}
