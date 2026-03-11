package com.armmc.app.ui.servers;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000bJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000bJ\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ \u0010 \u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u0017J*\u0010$\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u0017J \u0010%\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010&\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010'\u001a\u00020\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/armmc/app/ui/servers/ServerRepository;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "gson", "Lcom/google/gson/Gson;", "hasAcceptedAlphaWarning", "", "setAlphaWarningAccepted", "", "accepted", "hasCompletedPermissionSetup", "setPermissionSetupCompleted", "completed", "getAllServers", "", "Lcom/armmc/app/ui/servers/ServerData;", "getServerById", "id", "", "saveServer", "serverData", "deleteServer", "updateServerStatus", "isOnline", "updateServerTunnelAddress", "tunnelAddress", "", "updateTunnelStatus", "status", "Lcom/armmc/app/ui/servers/TunnelStatus;", "reconnectAttempts", "updateTunnelInfo", "updateServerStatusAndTunnel", "resetTunnelState", "saveServers", "servers", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServerRepository.kt */
public final class ServerRepository {
    private static final String ALPHA_WARNING_ACCEPTED_KEY = "alpha_warning_accepted";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NEXT_ID_KEY = "next_id";
    private static final String SERVERS_KEY = "servers";
    private static final String SETUP_PERMISSIONS_COMPLETED_KEY = "setup_permissions_completed";
    private final Gson gson = new Gson();
    private final SharedPreferences prefs;

    public ServerRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("server_prefs", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/armmc/app/ui/servers/ServerRepository$Companion;", "", "<init>", "()V", "SERVERS_KEY", "", "NEXT_ID_KEY", "ALPHA_WARNING_ACCEPTED_KEY", "SETUP_PERMISSIONS_COMPLETED_KEY", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ServerRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean hasAcceptedAlphaWarning() {
        return this.prefs.getBoolean(ALPHA_WARNING_ACCEPTED_KEY, false);
    }

    public final void setAlphaWarningAccepted(boolean z) {
        this.prefs.edit().putBoolean(ALPHA_WARNING_ACCEPTED_KEY, z).apply();
    }

    public final boolean hasCompletedPermissionSetup() {
        return this.prefs.getBoolean(SETUP_PERMISSIONS_COMPLETED_KEY, false);
    }

    public final void setPermissionSetupCompleted(boolean z) {
        this.prefs.edit().putBoolean(SETUP_PERMISSIONS_COMPLETED_KEY, z).apply();
    }

    public final List<ServerData> getAllServers() {
        String string = this.prefs.getString(SERVERS_KEY, (String) null);
        if (string == null) {
            return CollectionsKt.emptyList();
        }
        Object fromJson = this.gson.fromJson(string, new ServerRepository$getAllServers$type$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        Iterable<ServerData> iterable = (List) fromJson;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ServerData serverData : iterable) {
            TunnelStatus tunnelStatus = serverData.getTunnelStatus();
            if (tunnelStatus == null) {
                tunnelStatus = TunnelStatus.DISCONNECTED;
            }
            TunnelStatus tunnelStatus2 = tunnelStatus;
            Integer reconnectAttempts = serverData.getReconnectAttempts();
            boolean z = false;
            Integer valueOf = Integer.valueOf(reconnectAttempts != null ? reconnectAttempts.intValue() : 0);
            Boolean whitelistEnabled = serverData.getWhitelistEnabled();
            if (whitelistEnabled != null) {
                z = whitelistEnabled.booleanValue();
            }
            arrayList.add(ServerData.copy$default(serverData, 0, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, false, false, false, false, 0, (String) null, tunnelStatus2, valueOf, (String) null, (String) null, Boolean.valueOf(z), serverData.getWhitelistEntries(), 6815743, (Object) null));
        }
        return (List) arrayList;
    }

    public final ServerData getServerById(int i) {
        Object obj;
        Iterator it = getAllServers().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ServerData) obj).getId() == i) {
                break;
            }
        }
        return (ServerData) obj;
    }

    public final ServerData saveServer(ServerData serverData) {
        ServerData serverData2;
        ServerData serverData3 = serverData;
        Intrinsics.checkNotNullParameter(serverData3, "serverData");
        List mutableList = CollectionsKt.toMutableList(getAllServers());
        if (serverData3.getId() == -1) {
            int i = this.prefs.getInt(NEXT_ID_KEY, 1);
            this.prefs.edit().putInt(NEXT_ID_KEY, i + 1).apply();
            serverData2 = ServerData.copy$default(serverData3, i, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, false, false, false, false, 0, (String) null, (TunnelStatus) null, (Integer) null, (String) null, (String) null, (Boolean) null, (String) null, 33554430, (Object) null);
        } else {
            serverData2 = serverData;
        }
        CollectionsKt.removeAll(mutableList, new ServerRepository$$ExternalSyntheticLambda0(serverData2));
        mutableList.add(serverData2);
        saveServers(mutableList);
        return serverData2;
    }

    /* access modifiers changed from: private */
    public static final boolean saveServer$lambda$2(ServerData serverData, ServerData serverData2) {
        Intrinsics.checkNotNullParameter(serverData2, "it");
        return serverData2.getId() == serverData.getId();
    }

    public final void deleteServer(int i) {
        List mutableList = CollectionsKt.toMutableList(getAllServers());
        CollectionsKt.removeAll(mutableList, new ServerRepository$$ExternalSyntheticLambda1(i));
        saveServers(mutableList);
    }

    /* access modifiers changed from: private */
    public static final boolean deleteServer$lambda$3(int i, ServerData serverData) {
        Intrinsics.checkNotNullParameter(serverData, "it");
        return serverData.getId() == i;
    }

    public final void updateServerStatus(int i, boolean z) {
        List mutableList = CollectionsKt.toMutableList(getAllServers());
        Iterator it = mutableList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((ServerData) it.next()).getId() == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            mutableList.set(i2, ServerData.copy$default((ServerData) mutableList.get(i2), 0, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, false, false, false, z, 0, (String) null, (TunnelStatus) null, (Integer) null, (String) null, (String) null, (Boolean) null, (String) null, 33488895, (Object) null));
            saveServers(mutableList);
            return;
        }
    }

    public final void updateServerTunnelAddress(int i, String str) {
        List mutableList = CollectionsKt.toMutableList(getAllServers());
        Iterator it = mutableList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((ServerData) it.next()).getId() == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            mutableList.set(i2, ServerData.copy$default((ServerData) mutableList.get(i2), 0, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, false, false, false, false, 0, str, (TunnelStatus) null, (Integer) null, (String) null, (String) null, (Boolean) null, (String) null, 33292287, (Object) null));
            saveServers(mutableList);
            return;
        }
    }

    public static /* synthetic */ void updateTunnelStatus$default(ServerRepository serverRepository, int i, TunnelStatus tunnelStatus, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        serverRepository.updateTunnelStatus(i, tunnelStatus, i2);
    }

    public final void updateTunnelStatus(int i, TunnelStatus tunnelStatus, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(tunnelStatus, NotificationCompat.CATEGORY_STATUS);
        List mutableList = CollectionsKt.toMutableList(getAllServers());
        Iterator it = mutableList.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (((ServerData) it.next()).getId() == i) {
                i3 = i4;
                break;
            } else {
                i4++;
            }
        }
        if (i3 != -1) {
            mutableList.set(i3, ServerData.copy$default((ServerData) mutableList.get(i3), 0, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, false, false, false, false, 0, (String) null, tunnelStatus, Integer.valueOf(i2), (String) null, (String) null, (Boolean) null, (String) null, 31981567, (Object) null));
            saveServers(mutableList);
            return;
        }
    }

    public static /* synthetic */ void updateTunnelInfo$default(ServerRepository serverRepository, int i, String str, TunnelStatus tunnelStatus, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        serverRepository.updateTunnelInfo(i, str, tunnelStatus, i2);
    }

    public final void updateTunnelInfo(int i, String str, TunnelStatus tunnelStatus, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(tunnelStatus, NotificationCompat.CATEGORY_STATUS);
        List mutableList = CollectionsKt.toMutableList(getAllServers());
        Iterator it = mutableList.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (((ServerData) it.next()).getId() == i) {
                i3 = i4;
                break;
            } else {
                i4++;
            }
        }
        if (i3 != -1) {
            int i5 = i3;
            mutableList.set(i5, ServerData.copy$default((ServerData) mutableList.get(i3), 0, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, false, false, false, false, 0, str, tunnelStatus, Integer.valueOf(i2), (String) null, (String) null, (Boolean) null, (String) null, 31719423, (Object) null));
            saveServers(mutableList);
            return;
        }
    }

    public final void updateServerStatusAndTunnel(int i, boolean z, String str) {
        List mutableList = CollectionsKt.toMutableList(getAllServers());
        Iterator it = mutableList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((ServerData) it.next()).getId() == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            mutableList.set(i2, ServerData.copy$default((ServerData) mutableList.get(i2), 0, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, false, false, false, z, 0, str, (TunnelStatus) null, (Integer) null, (String) null, (String) null, (Boolean) null, (String) null, 33226751, (Object) null));
            saveServers(mutableList);
            return;
        }
    }

    public final void resetTunnelState(int i) {
        List mutableList = CollectionsKt.toMutableList(getAllServers());
        Iterator it = mutableList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((ServerData) it.next()).getId() == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            mutableList.set(i2, ServerData.copy$default((ServerData) mutableList.get(i2), 0, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, false, false, false, false, 0, (String) null, TunnelStatus.DISCONNECTED, 0, (String) null, (String) null, (Boolean) null, (String) null, 31719423, (Object) null));
            saveServers(mutableList);
            return;
        }
    }

    private final void saveServers(List<ServerData> list) {
        this.prefs.edit().putString(SERVERS_KEY, this.gson.toJson((Object) list)).apply();
    }
}
