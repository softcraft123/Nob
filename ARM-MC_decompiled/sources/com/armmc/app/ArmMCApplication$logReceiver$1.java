package com.armmc.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/armmc/app/WitherHostApplication$logReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: WitherHostApplication.kt */
public final class WitherHostApplication$logReceiver$1 extends BroadcastReceiver {
    WitherHostApplication$logReceiver$1() {
    }

    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        Log.d("WitherHostApplication", "Broadcast received");
        if (intent != null && (stringExtra = intent.getStringExtra(LogManager.EXTRA_MESSAGE)) != null) {
            Log.d("WitherHostApplication", "Processing log: " + stringExtra);
            LogManager.INSTANCE.receiveLogFromBroadcast(stringExtra);
        }
    }
}
