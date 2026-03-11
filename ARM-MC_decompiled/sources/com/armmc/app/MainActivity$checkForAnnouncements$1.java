package com.armmc.app;

import com.armmc.app.announcements.AnnouncementManager;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.MainActivity$checkForAnnouncements$1", f = "MainActivity.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainActivity.kt */
final class MainActivity$checkForAnnouncements$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$checkForAnnouncements$1(MainActivity mainActivity, Continuation<? super MainActivity$checkForAnnouncements$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$checkForAnnouncements$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$checkForAnnouncements$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnnouncementManager access$getAnnouncementManager$p = this.this$0.announcementManager;
            if (access$getAnnouncementManager$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("announcementManager");
                access$getAnnouncementManager$p = null;
            }
            this.label = 1;
            obj = access$getAnnouncementManager$p.getUnseenAnnouncements(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Collection collection = (List) obj;
        if (!collection.isEmpty()) {
            this.this$0.pendingAnnouncements.clear();
            this.this$0.pendingAnnouncements.addAll(collection);
            this.this$0.showNextAnnouncement();
        }
        return Unit.INSTANCE;
    }
}
