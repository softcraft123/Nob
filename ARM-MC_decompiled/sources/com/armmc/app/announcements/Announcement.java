package com.armmc.app.announcements;

import com.armmc.app.LogManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\b\u0018\u0000 (2\u00020\u0001:\u0002'(BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\rHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/armmc/app/announcements/Announcement;", "", "id", "", "title", "message", "type", "Lcom/armmc/app/announcements/Announcement$AnnouncementType;", "isActive", "", "createdAt", "", "priority", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/armmc/app/announcements/Announcement$AnnouncementType;ZJI)V", "getId", "()Ljava/lang/String;", "getTitle", "getMessage", "getType", "()Lcom/armmc/app/announcements/Announcement$AnnouncementType;", "()Z", "getCreatedAt", "()J", "getPriority", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "AnnouncementType", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: Announcement.kt */
public final class Announcement {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final long createdAt;
    private final String id;
    private final boolean isActive;
    private final String message;
    private final int priority;
    private final String title;
    private final AnnouncementType type;

    public Announcement() {
        this((String) null, (String) null, (String) null, (AnnouncementType) null, false, 0, 0, WorkQueueKt.MASK, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Announcement copy$default(Announcement announcement, String str, String str2, String str3, AnnouncementType announcementType, boolean z, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = announcement.id;
        }
        if ((i2 & 2) != 0) {
            str2 = announcement.title;
        }
        if ((i2 & 4) != 0) {
            str3 = announcement.message;
        }
        if ((i2 & 8) != 0) {
            announcementType = announcement.type;
        }
        if ((i2 & 16) != 0) {
            z = announcement.isActive;
        }
        if ((i2 & 32) != 0) {
            j = announcement.createdAt;
        }
        if ((i2 & 64) != 0) {
            i = announcement.priority;
        }
        int i3 = i;
        long j2 = j;
        AnnouncementType announcementType2 = announcementType;
        boolean z2 = z;
        return announcement.copy(str, str2, str3, announcementType2, z2, j2, i3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.message;
    }

    public final AnnouncementType component4() {
        return this.type;
    }

    public final boolean component5() {
        return this.isActive;
    }

    public final long component6() {
        return this.createdAt;
    }

    public final int component7() {
        return this.priority;
    }

    public final Announcement copy(String str, String str2, String str3, AnnouncementType announcementType, boolean z, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, LogManager.EXTRA_MESSAGE);
        Intrinsics.checkNotNullParameter(announcementType, "type");
        return new Announcement(str, str2, str3, announcementType, z, j, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Announcement)) {
            return false;
        }
        Announcement announcement = (Announcement) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) announcement.id) && Intrinsics.areEqual((Object) this.title, (Object) announcement.title) && Intrinsics.areEqual((Object) this.message, (Object) announcement.message) && this.type == announcement.type && this.isActive == announcement.isActive && this.createdAt == announcement.createdAt && this.priority == announcement.priority;
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.message.hashCode()) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31) + Long.hashCode(this.createdAt)) * 31) + Integer.hashCode(this.priority);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.title;
        String str3 = this.message;
        AnnouncementType announcementType = this.type;
        boolean z = this.isActive;
        long j = this.createdAt;
        return "Announcement(id=" + str + ", title=" + str2 + ", message=" + str3 + ", type=" + announcementType + ", isActive=" + z + ", createdAt=" + j + ", priority=" + this.priority + ")";
    }

    public Announcement(String str, String str2, String str3, AnnouncementType announcementType, boolean z, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, LogManager.EXTRA_MESSAGE);
        Intrinsics.checkNotNullParameter(announcementType, "type");
        this.id = str;
        this.title = str2;
        this.message = str3;
        this.type = announcementType;
        this.isActive = z;
        this.createdAt = j;
        this.priority = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Announcement(java.lang.String r2, java.lang.String r3, java.lang.String r4, com.armmc.app.announcements.Announcement.AnnouncementType r5, boolean r6, long r7, int r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0007
            r2 = r0
        L_0x0007:
            r11 = r10 & 2
            if (r11 == 0) goto L_0x000c
            r3 = r0
        L_0x000c:
            r11 = r10 & 4
            if (r11 == 0) goto L_0x0011
            r4 = r0
        L_0x0011:
            r11 = r10 & 8
            if (r11 == 0) goto L_0x0017
            com.armmc.app.announcements.Announcement$AnnouncementType r5 = com.armmc.app.announcements.Announcement.AnnouncementType.INFO
        L_0x0017:
            r11 = r10 & 16
            r0 = 0
            if (r11 == 0) goto L_0x001d
            r6 = r0
        L_0x001d:
            r11 = r10 & 32
            if (r11 == 0) goto L_0x0023
            r7 = 0
        L_0x0023:
            r10 = r10 & 64
            if (r10 == 0) goto L_0x0029
            r10 = r0
            goto L_0x002a
        L_0x0029:
            r10 = r9
        L_0x002a:
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.announcements.Announcement.<init>(java.lang.String, java.lang.String, java.lang.String, com.armmc.app.announcements.Announcement$AnnouncementType, boolean, long, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final AnnouncementType getType() {
        return this.type;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final int getPriority() {
        return this.priority;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/armmc/app/announcements/Announcement$AnnouncementType;", "", "<init>", "(Ljava/lang/String;I)V", "INFO", "WARNING", "CRITICAL", "SUCCESS", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: Announcement.kt */
    public enum AnnouncementType {
        INFO,
        WARNING,
        CRITICAL,
        SUCCESS;

        public static EnumEntries<AnnouncementType> getEntries() {
            return $ENTRIES;
        }

        static {
            AnnouncementType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¨\u0006\n"}, d2 = {"Lcom/armmc/app/announcements/Announcement$Companion;", "", "<init>", "()V", "fromMap", "Lcom/armmc/app/announcements/Announcement;", "id", "", "map", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: Announcement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
            if (r0 == null) goto L_0x0050;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.armmc.app.announcements.Announcement fromMap(java.lang.String r13, java.util.Map<java.lang.String, ? extends java.lang.Object> r14) {
            /*
                r12 = this;
                java.lang.String r0 = "id"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                java.lang.String r0 = "map"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                java.lang.String r0 = "title"
                java.lang.Object r0 = r14.get(r0)
                boolean r1 = r0 instanceof java.lang.String
                r2 = 0
                if (r1 == 0) goto L_0x0018
                java.lang.String r0 = (java.lang.String) r0
                goto L_0x0019
            L_0x0018:
                r0 = r2
            L_0x0019:
                java.lang.String r1 = ""
                if (r0 != 0) goto L_0x001f
                r5 = r1
                goto L_0x0020
            L_0x001f:
                r5 = r0
            L_0x0020:
                java.lang.String r0 = "message"
                java.lang.Object r0 = r14.get(r0)
                boolean r3 = r0 instanceof java.lang.String
                if (r3 == 0) goto L_0x002d
                java.lang.String r0 = (java.lang.String) r0
                goto L_0x002e
            L_0x002d:
                r0 = r2
            L_0x002e:
                if (r0 != 0) goto L_0x0032
                r6 = r1
                goto L_0x0033
            L_0x0032:
                r6 = r0
            L_0x0033:
                java.lang.String r0 = "type"
                java.lang.Object r0 = r14.get(r0)     // Catch:{ IllegalArgumentException -> 0x0057 }
                boolean r1 = r0 instanceof java.lang.String     // Catch:{ IllegalArgumentException -> 0x0057 }
                if (r1 == 0) goto L_0x0040
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ IllegalArgumentException -> 0x0057 }
                goto L_0x0041
            L_0x0040:
                r0 = r2
            L_0x0041:
                if (r0 == 0) goto L_0x0050
                java.util.Locale r1 = java.util.Locale.ROOT     // Catch:{ IllegalArgumentException -> 0x0057 }
                java.lang.String r0 = r0.toUpperCase(r1)     // Catch:{ IllegalArgumentException -> 0x0057 }
                java.lang.String r1 = "toUpperCase(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ IllegalArgumentException -> 0x0057 }
                if (r0 != 0) goto L_0x0052
            L_0x0050:
                java.lang.String r0 = "INFO"
            L_0x0052:
                com.armmc.app.announcements.Announcement$AnnouncementType r0 = com.armmc.app.announcements.Announcement.AnnouncementType.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x0057 }
                goto L_0x0059
            L_0x0057:
                com.armmc.app.announcements.Announcement$AnnouncementType r0 = com.armmc.app.announcements.Announcement.AnnouncementType.INFO
            L_0x0059:
                r7 = r0
                java.lang.String r0 = "isActive"
                java.lang.Object r0 = r14.get(r0)
                boolean r1 = r0 instanceof java.lang.Boolean
                if (r1 == 0) goto L_0x0067
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                goto L_0x0068
            L_0x0067:
                r0 = r2
            L_0x0068:
                r1 = 0
                if (r0 == 0) goto L_0x0071
                boolean r0 = r0.booleanValue()
                r8 = r0
                goto L_0x0072
            L_0x0071:
                r8 = r1
            L_0x0072:
                java.lang.String r0 = "createdAt"
                java.lang.Object r3 = r14.get(r0)
                boolean r4 = r3 instanceof java.lang.Long
                if (r4 == 0) goto L_0x007f
                java.lang.Long r3 = (java.lang.Long) r3
                goto L_0x0080
            L_0x007f:
                r3 = r2
            L_0x0080:
                if (r3 == 0) goto L_0x0088
                long r3 = r3.longValue()
            L_0x0086:
                r9 = r3
                goto L_0x00ab
            L_0x0088:
                java.lang.Object r0 = r14.get(r0)
                boolean r3 = r0 instanceof java.lang.Double
                if (r3 == 0) goto L_0x0093
                java.lang.Double r0 = (java.lang.Double) r0
                goto L_0x0094
            L_0x0093:
                r0 = r2
            L_0x0094:
                if (r0 == 0) goto L_0x00a0
                double r3 = r0.doubleValue()
                long r3 = (long) r3
                java.lang.Long r0 = java.lang.Long.valueOf(r3)
                goto L_0x00a1
            L_0x00a0:
                r0 = r2
            L_0x00a1:
                if (r0 == 0) goto L_0x00a8
                long r3 = r0.longValue()
                goto L_0x0086
            L_0x00a8:
                r3 = 0
                goto L_0x0086
            L_0x00ab:
                java.lang.String r0 = "priority"
                java.lang.Object r3 = r14.get(r0)
                boolean r4 = r3 instanceof java.lang.Long
                if (r4 == 0) goto L_0x00b8
                java.lang.Long r3 = (java.lang.Long) r3
                goto L_0x00b9
            L_0x00b8:
                r3 = r2
            L_0x00b9:
                if (r3 == 0) goto L_0x00c2
                long r0 = r3.longValue()
                int r1 = (int) r0
            L_0x00c0:
                r11 = r1
                goto L_0x00d5
            L_0x00c2:
                java.lang.Object r14 = r14.get(r0)
                boolean r0 = r14 instanceof java.lang.Double
                if (r0 == 0) goto L_0x00cd
                r2 = r14
                java.lang.Double r2 = (java.lang.Double) r2
            L_0x00cd:
                if (r2 == 0) goto L_0x00c0
                double r0 = r2.doubleValue()
                int r1 = (int) r0
                goto L_0x00c0
            L_0x00d5:
                com.armmc.app.announcements.Announcement r3 = new com.armmc.app.announcements.Announcement
                r4 = r13
                r3.<init>(r4, r5, r6, r7, r8, r9, r11)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.announcements.Announcement.Companion.fromMap(java.lang.String, java.util.Map):com.armmc.app.announcements.Announcement");
        }
    }
}
