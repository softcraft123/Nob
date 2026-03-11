package com.armmc.app.announcements;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnouncementManager.kt */
/* MODIFIED: Firebase Firestore removed, announcements disabled */
public final class AnnouncementManager {
    private static final String COLLECTION_ANNOUNCEMENTS = "announcements";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SEEN_ANNOUNCEMENTS = "seen_announcement_ids";
    private static final String PREFS_NAME = "announcement_prefs";
    private static final String TAG = "AnnouncementManager";
    private final Context context;
    private final SharedPreferences prefs;

    public AnnouncementManager(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.prefs = context2.getSharedPreferences(PREFS_NAME, 0);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
        private Companion() {
        }
    }

    /* MODIFIED: Returns empty list instead of querying Firebase Firestore */
    public final Object getUnseenAnnouncements(kotlin.coroutines.Continuation<? super List<Announcement>> continuation) {
        Log.d(TAG, "getUnseenAnnouncements - Firebase removed, returning empty list");
        return CollectionsKt.emptyList();
    }

    public final void markAsSeen(String str) {
        Intrinsics.checkNotNullParameter(str, "announcementId");
        Set mutableSet = CollectionsKt.toMutableSet(getSeenAnnouncementIds());
        mutableSet.add(str);
        this.prefs.edit().putStringSet(KEY_SEEN_ANNOUNCEMENTS, mutableSet).apply();
        Log.d(TAG, "Marked announcement " + str + " as seen");
    }

    public final void markAllAsSeen(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "announcementIds");
        Set mutableSet = CollectionsKt.toMutableSet(getSeenAnnouncementIds());
        mutableSet.addAll(list);
        this.prefs.edit().putStringSet(KEY_SEEN_ANNOUNCEMENTS, mutableSet).apply();
    }

    private final Set<String> getSeenAnnouncementIds() {
        Set<String> stringSet = this.prefs.getStringSet(KEY_SEEN_ANNOUNCEMENTS, SetsKt.emptySet());
        return stringSet != null ? stringSet : SetsKt.emptySet();
    }

    public final void clearSeenAnnouncements() {
        this.prefs.edit().remove(KEY_SEEN_ANNOUNCEMENTS).apply();
    }
}
