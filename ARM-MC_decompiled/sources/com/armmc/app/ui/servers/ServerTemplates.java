package com.armmc.app.ui.servers;

import com.armmc.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/armmc/app/ui/servers/ServerTemplates;", "", "<init>", "()V", "TEMPLATES", "", "Lcom/armmc/app/ui/servers/ServerTemplate;", "getTEMPLATES", "()Ljava/util/List;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServerTemplates.kt */
public final class ServerTemplates {
    public static final ServerTemplates INSTANCE = new ServerTemplates();
    private static final List<ServerTemplate> TEMPLATES = CollectionsKt.listOf(new ServerTemplate("island_survival", "Island Survival", "A survival world with a lush island starting area. Explore the seas and build your home.", R.drawable.island_survival, "5877197513718532482", "Normal", "Survival", 10, 10, 5, true, false, Integer.valueOf(R.drawable.island_survival_favicon)));

    private ServerTemplates() {
    }

    public final List<ServerTemplate> getTEMPLATES() {
        return TEMPLATES;
    }
}
