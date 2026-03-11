package com.armmc.app.ui.servers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.armmc.app.LogManager;
import com.armmc.app.PumpkinService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/armmc/app/ui/servers/ServersFragment$crashReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServersFragment.kt */
public final class ServersFragment$crashReceiver$1 extends BroadcastReceiver {
    ServersFragment$crashReceiver$1() {
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent == null || (str = intent.getStringExtra(PumpkinService.EXTRA_CRASH_MESSAGE)) == null) {
            str = "Unknown error";
        }
        Log.e("ServersFragment", "Received crash broadcast: " + str);
        LogManager.INSTANCE.addCrashLog("Server crashed: " + str);
    }
}
