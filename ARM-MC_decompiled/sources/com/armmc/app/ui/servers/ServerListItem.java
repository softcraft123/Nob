package com.armmc.app.ui.servers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/armmc/app/ui/servers/ServerListItem;", "", "server", "Lcom/armmc/app/ui/servers/Server;", "serverData", "Lcom/armmc/app/ui/servers/ServerData;", "<init>", "(Lcom/armmc/app/ui/servers/Server;Lcom/armmc/app/ui/servers/ServerData;)V", "getServer", "()Lcom/armmc/app/ui/servers/Server;", "getServerData", "()Lcom/armmc/app/ui/servers/ServerData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServerAdapter.kt */
public final class ServerListItem {
    private final Server server;
    private final ServerData serverData;

    public static /* synthetic */ ServerListItem copy$default(ServerListItem serverListItem, Server server2, ServerData serverData2, int i, Object obj) {
        if ((i & 1) != 0) {
            server2 = serverListItem.server;
        }
        if ((i & 2) != 0) {
            serverData2 = serverListItem.serverData;
        }
        return serverListItem.copy(server2, serverData2);
    }

    public final Server component1() {
        return this.server;
    }

    public final ServerData component2() {
        return this.serverData;
    }

    public final ServerListItem copy(Server server2, ServerData serverData2) {
        Intrinsics.checkNotNullParameter(server2, "server");
        Intrinsics.checkNotNullParameter(serverData2, "serverData");
        return new ServerListItem(server2, serverData2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServerListItem)) {
            return false;
        }
        ServerListItem serverListItem = (ServerListItem) obj;
        return Intrinsics.areEqual((Object) this.server, (Object) serverListItem.server) && Intrinsics.areEqual((Object) this.serverData, (Object) serverListItem.serverData);
    }

    public int hashCode() {
        return (this.server.hashCode() * 31) + this.serverData.hashCode();
    }

    public String toString() {
        Server server2 = this.server;
        return "ServerListItem(server=" + server2 + ", serverData=" + this.serverData + ")";
    }

    public ServerListItem(Server server2, ServerData serverData2) {
        Intrinsics.checkNotNullParameter(server2, "server");
        Intrinsics.checkNotNullParameter(serverData2, "serverData");
        this.server = server2;
        this.serverData = serverData2;
    }

    public final Server getServer() {
        return this.server;
    }

    public final ServerData getServerData() {
        return this.serverData;
    }
}
