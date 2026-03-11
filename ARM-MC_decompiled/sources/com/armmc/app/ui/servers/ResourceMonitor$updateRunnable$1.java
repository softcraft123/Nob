package com.armmc.app.ui.servers;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/armmc/app/ui/servers/ResourceMonitor$updateRunnable$1", "Ljava/lang/Runnable;", "run", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ResourceMonitor.kt */
public final class ResourceMonitor$updateRunnable$1 implements Runnable {
    ResourceMonitor$updateRunnable$1() {
    }

    public void run() {
        Handler access$getBackgroundHandler$p;
        Handler access$getBackgroundHandler$p2;
        Context context;
        if (ResourceMonitor.isMonitoring && ResourceMonitor.isAppInForeground) {
            Integer access$getActiveServerId$p = ResourceMonitor.activeServerId;
            if (access$getActiveServerId$p != null) {
                int intValue = access$getActiveServerId$p.intValue();
                WeakReference access$getContextRef$p = ResourceMonitor.contextRef;
                if (!(access$getContextRef$p == null || (context = (Context) access$getContextRef$p.get()) == null)) {
                    ResourceMonitor.INSTANCE.updateResourceData(intValue, context);
                }
            }
            if (ResourceMonitor.isMonitoring && (access$getBackgroundHandler$p2 = ResourceMonitor.backgroundHandler) != null) {
                access$getBackgroundHandler$p2.postDelayed(this, 300);
            }
        } else if (ResourceMonitor.isMonitoring && (access$getBackgroundHandler$p = ResourceMonitor.backgroundHandler) != null) {
            access$getBackgroundHandler$p.postDelayed(this, 300);
        }
    }
}
