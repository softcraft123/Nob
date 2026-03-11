package com.armmc.app.announcements;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.announcements.AnnouncementManager", f = "AnnouncementManager.kt", i = {0}, l = {35}, m = "getUnseenAnnouncements", n = {"seenIds"}, s = {"L$0"})
/* compiled from: AnnouncementManager.kt */
final class AnnouncementManager$getUnseenAnnouncements$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnnouncementManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnnouncementManager$getUnseenAnnouncements$1(AnnouncementManager announcementManager, Continuation<? super AnnouncementManager$getUnseenAnnouncements$1> continuation) {
        super(continuation);
        this.this$0 = announcementManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getUnseenAnnouncements(this);
    }
}
