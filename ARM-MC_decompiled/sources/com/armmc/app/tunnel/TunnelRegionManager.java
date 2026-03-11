package com.armmc.app.tunnel;

import android.content.Context;
import android.content.SharedPreferences;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/armmc/app/tunnel/TunnelRegionManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "value", "Lcom/armmc/app/tunnel/TunnelRegion;", "selectedRegion", "getSelectedRegion", "()Lcom/armmc/app/tunnel/TunnelRegion;", "setSelectedRegion", "(Lcom/armmc/app/tunnel/TunnelRegion;)V", "isTunnelingEnabled", "", "()Z", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: TunnelRegionManager.kt */
public final class TunnelRegionManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_REGION = "selected_region";
    private static final String PREFS_NAME = "tunnel_prefs";
    private final SharedPreferences prefs;

    public TunnelRegionManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
    }

    public final TunnelRegion getSelectedRegion() {
        TunnelRegion tunnelRegion;
        String string = this.prefs.getString(KEY_REGION, TunnelRegion.LOCAL.getCode());
        if (string == null) {
            string = TunnelRegion.LOCAL.getCode();
        }
        TunnelRegion[] values = TunnelRegion.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                tunnelRegion = null;
                break;
            }
            tunnelRegion = values[i];
            if (Intrinsics.areEqual((Object) tunnelRegion.getCode(), (Object) string)) {
                break;
            }
            i++;
        }
        return tunnelRegion == null ? TunnelRegion.LOCAL : tunnelRegion;
    }

    public final void setSelectedRegion(TunnelRegion tunnelRegion) {
        Intrinsics.checkNotNullParameter(tunnelRegion, "value");
        this.prefs.edit().putString(KEY_REGION, tunnelRegion.getCode()).apply();
    }

    public final boolean isTunnelingEnabled() {
        return getSelectedRegion() != TunnelRegion.LOCAL;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/armmc/app/tunnel/TunnelRegionManager$Companion;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_REGION", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: TunnelRegionManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
