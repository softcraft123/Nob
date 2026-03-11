package com.armmc.app.ui.servers;

import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/armmc/app/ui/servers/WhitelistEntry;", "", "name", "", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUuid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: WhitelistEntry.kt */
public final class WhitelistEntry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Gson gson = new Gson();
    private final String name;
    private final String uuid;

    public static /* synthetic */ WhitelistEntry copy$default(WhitelistEntry whitelistEntry, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = whitelistEntry.name;
        }
        if ((i & 2) != 0) {
            str2 = whitelistEntry.uuid;
        }
        return whitelistEntry.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.uuid;
    }

    public final WhitelistEntry copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "uuid");
        return new WhitelistEntry(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhitelistEntry)) {
            return false;
        }
        WhitelistEntry whitelistEntry = (WhitelistEntry) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) whitelistEntry.name) && Intrinsics.areEqual((Object) this.uuid, (Object) whitelistEntry.uuid);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.uuid.hashCode();
    }

    public String toString() {
        String str = this.name;
        return "WhitelistEntry(name=" + str + ", uuid=" + this.uuid + ")";
    }

    public WhitelistEntry(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "uuid");
        this.name = str;
        this.uuid = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUuid() {
        return this.uuid;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/armmc/app/ui/servers/WhitelistEntry$Companion;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "toJson", "", "entries", "", "Lcom/armmc/app/ui/servers/WhitelistEntry;", "fromJson", "json", "formatUuid", "uuid", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: WhitelistEntry.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toJson(List<WhitelistEntry> list) {
            Intrinsics.checkNotNullParameter(list, "entries");
            if (list.isEmpty()) {
                return null;
            }
            return WhitelistEntry.gson.toJson((Object) list);
        }

        public final List<WhitelistEntry> fromJson(String str) {
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                return CollectionsKt.emptyList();
            }
            try {
                List<WhitelistEntry> list = (List) WhitelistEntry.gson.fromJson(str, new WhitelistEntry$Companion$fromJson$type$1().getType());
                return list == null ? CollectionsKt.emptyList() : list;
            } catch (Exception unused) {
                return CollectionsKt.emptyList();
            }
        }

        public final String formatUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "uuid");
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "-", false, 2, (Object) null) || str.length() != 32) {
                return str;
            }
            String substring = str.substring(0, 8);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = str.substring(8, 12);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            String substring3 = str.substring(12, 16);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            String substring4 = str.substring(16, 20);
            Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
            String substring5 = str.substring(20);
            Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
            return substring + "-" + substring2 + "-" + substring3 + "-" + substring4 + "-" + substring5;
        }
    }
}
