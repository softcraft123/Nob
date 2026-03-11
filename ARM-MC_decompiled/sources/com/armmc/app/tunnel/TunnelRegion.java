package com.armmc.app.tunnel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/armmc/app/tunnel/TunnelRegion;", "", "code", "", "displayName", "available", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getCode", "()Ljava/lang/String;", "getDisplayName", "getAvailable", "()Z", "EUROPE", "LOCAL", "AMERICA", "ASIA", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: TunnelRegionManager.kt */
public enum TunnelRegion {
    EUROPE("EU", "Europe", true),
    LOCAL("LOCAL", "Local", true),
    AMERICA("US", "America", false),
    ASIA("AS", "Asia", false);
    
    private final boolean available;
    private final String code;
    private final String displayName;

    public static EnumEntries<TunnelRegion> getEntries() {
        return $ENTRIES;
    }

    private TunnelRegion(String str, String str2, boolean z) {
        this.code = str;
        this.displayName = str2;
        this.available = z;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    static {
        TunnelRegion[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
