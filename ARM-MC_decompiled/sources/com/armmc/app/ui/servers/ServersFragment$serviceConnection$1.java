package com.armmc.app.ui.servers;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/armmc/app/ui/servers/ServersFragment$serviceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServersFragment.kt */
public final class ServersFragment$serviceConnection$1 implements ServiceConnection {
    final /* synthetic */ ServersFragment this$0;

    ServersFragment$serviceConnection$1(ServersFragment serversFragment) {
        this.this$0 = serversFragment;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("ServersFragment", "Bound to PumpkinService process");
        this.this$0.isBoundToService = true;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Log.e("ServersFragment", "PumpkinService process died (native crash detected)");
        if (this.this$0.isBoundToService) {
            try {
                Context context = this.this$0.getContext();
                if (context != null) {
                    context.unbindService(this);
                }
            } catch (Exception e) {
                Log.w("ServersFragment", "Error unbinding from PumpkinService in onServiceDisconnected", e);
            }
        }
        this.this$0.isBoundToService = false;
        new Handler(Looper.getMainLooper()).postDelayed(new ServersFragment$serviceConnection$1$$ExternalSyntheticLambda0(this.this$0), 200);
    }

    /* access modifiers changed from: private */
    public static final void onServiceDisconnected$lambda$0(ServersFragment serversFragment) {
        serversFragment.handleServerProcessCrash("Server process terminated unexpectedly (native crash)");
    }
}
