package com.armmc.app.ui.servers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.armmc.app.LogManager;
import com.armmc.app.PumpkinService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/armmc/app/ui/servers/ServersFragment$serverStoppedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServersFragment.kt */
public final class ServersFragment$serverStoppedReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ ServersFragment this$0;

    ServersFragment$serverStoppedReceiver$1(ServersFragment serversFragment) {
        this.this$0 = serversFragment;
    }

    public void onReceive(Context context, Intent intent) {
        int intExtra = intent != null ? intent.getIntExtra(PumpkinService.EXTRA_SERVER_ID, -1) : -1;
        Log.d("ServersFragment", "Received server stopped broadcast for server ID: " + intExtra);
        this.this$0.stoppedViaNotification = true;
        if (intent != null && intent.getBooleanExtra(PumpkinService.EXTRA_LOW_MEMORY, false)) {
            LogManager.INSTANCE.addCrashLog("Server stopped: device ran out of memory. Free up RAM before restarting.");
            ServersFragment serversFragment = this.this$0;
            boolean unused = serversFragment.runOnUiThreadSafe(new ServersFragment$serverStoppedReceiver$1$$ExternalSyntheticLambda0(serversFragment));
        }
        if (intExtra != -1) {
            ServerRepository access$getServerRepository$p = this.this$0.serverRepository;
            if (access$getServerRepository$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                access$getServerRepository$p = null;
            }
            access$getServerRepository$p.updateServerStatus(intExtra, false);
        }
        this.this$0.currentlyRunningServerId = null;
        this.this$0.stoppingServers.remove(Integer.valueOf(intExtra));
        ResourceMonitor.INSTANCE.stopMonitoring(intExtra);
        Object access$getFrpLock$p = this.this$0.frpLock;
        ServersFragment serversFragment2 = this.this$0;
        synchronized (access$getFrpLock$p) {
            serversFragment2.currentFrpParams = null;
            serversFragment2.isReconnecting = false;
            serversFragment2.currentRetryAttempt = 0;
            Unit unit = Unit.INSTANCE;
        }
        if (this.this$0.isBoundToService) {
            if (context != null) {
                try {
                    context.unbindService(this.this$0.serviceConnection);
                } catch (Exception e) {
                    Log.w("ServersFragment", "Error unbinding from PumpkinService", e);
                }
            }
            this.this$0.isBoundToService = false;
        }
        if (this.this$0.isAdded()) {
            this.this$0.loadServers();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onReceive$lambda$0(ServersFragment serversFragment) {
        Toast.makeText(serversFragment.requireContext(), "Server stopped: not enough free RAM. Close other apps and restart.", 1).show();
        return Unit.INSTANCE;
    }
}
