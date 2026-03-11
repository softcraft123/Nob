package com.armmc.app.billing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.billing.BillingManager$refreshSubscriptionStatus$1", f = "BillingManager.kt", i = {}, l = {450, 456}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BillingManager.kt */
final class BillingManager$refreshSubscriptionStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FirebaseUser $currentUser;
    int label;
    final /* synthetic */ BillingManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingManager$refreshSubscriptionStatus$1(FirebaseUser firebaseUser, BillingManager billingManager, Continuation<? super BillingManager$refreshSubscriptionStatus$1> continuation) {
        super(2, continuation);
        this.$currentUser = firebaseUser;
        this.this$0 = billingManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BillingManager$refreshSubscriptionStatus$1(this.$currentUser, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BillingManager$refreshSubscriptionStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        if (r11 == r2) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.String r0 = "Subscription refreshed: isSupporter="
            java.lang.String r1 = "Failed to refresh subscription: "
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r10.label
            r4 = 2
            r5 = 1
            java.lang.String r6 = "BillingManager"
            if (r3 == 0) goto L_0x0027
            if (r3 == r5) goto L_0x0020
            if (r3 != r4) goto L_0x0018
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0024 }
            goto L_0x006e
        L_0x0018:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0042
        L_0x0024:
            r11 = move-exception
            goto L_0x00cb
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r11)
            com.google.firebase.auth.FirebaseUser r11 = r10.$currentUser     // Catch:{ Exception -> 0x0024 }
            r3 = 0
            com.google.android.gms.tasks.Task r11 = r11.getIdToken(r3)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r3 = "getIdToken(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r3)     // Catch:{ Exception -> 0x0024 }
            r3 = r10
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ Exception -> 0x0024 }
            r10.label = r5     // Catch:{ Exception -> 0x0024 }
            java.lang.Object r11 = kotlinx.coroutines.tasks.TasksKt.await(r11, r3)     // Catch:{ Exception -> 0x0024 }
            if (r11 != r2) goto L_0x0042
            goto L_0x006d
        L_0x0042:
            com.google.firebase.auth.GetTokenResult r11 = (com.google.firebase.auth.GetTokenResult) r11     // Catch:{ Exception -> 0x0024 }
            java.lang.String r11 = r11.getToken()     // Catch:{ Exception -> 0x0024 }
            if (r11 != 0) goto L_0x0052
            java.lang.String r11 = "Failed to get ID token for refresh"
            android.util.Log.e(r6, r11)     // Catch:{ Exception -> 0x0024 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0024 }
            return r11
        L_0x0052:
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x0024 }
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3     // Catch:{ Exception -> 0x0024 }
            com.armmc.app.billing.BillingManager$refreshSubscriptionStatus$1$response$1 r7 = new com.armmc.app.billing.BillingManager$refreshSubscriptionStatus$1$response$1     // Catch:{ Exception -> 0x0024 }
            com.armmc.app.billing.BillingManager r8 = r10.this$0     // Catch:{ Exception -> 0x0024 }
            r9 = 0
            r7.<init>(r8, r11, r9)     // Catch:{ Exception -> 0x0024 }
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ Exception -> 0x0024 }
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ Exception -> 0x0024 }
            r10.label = r4     // Catch:{ Exception -> 0x0024 }
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r3, r7, r11)     // Catch:{ Exception -> 0x0024 }
            if (r11 != r2) goto L_0x006e
        L_0x006d:
            return r2
        L_0x006e:
            com.armmc.app.api.SubscriptionApiService$VerifySubscriptionResponse r11 = (com.armmc.app.api.SubscriptionApiService.VerifySubscriptionResponse) r11     // Catch:{ Exception -> 0x0024 }
            boolean r2 = r11.getSuccess()     // Catch:{ Exception -> 0x0024 }
            if (r2 == 0) goto L_0x00b6
            com.armmc.app.billing.BillingManager r1 = r10.this$0     // Catch:{ Exception -> 0x0024 }
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1._isSupporter     // Catch:{ Exception -> 0x0024 }
            boolean r2 = r11.isSupporter()     // Catch:{ Exception -> 0x0024 }
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)     // Catch:{ Exception -> 0x0024 }
            r1.setValue(r2)     // Catch:{ Exception -> 0x0024 }
            boolean r1 = r11.isSupporter()     // Catch:{ Exception -> 0x0024 }
            if (r1 == 0) goto L_0x00a1
            com.armmc.app.billing.BillingManager$Companion r1 = com.armmc.app.billing.BillingManager.Companion     // Catch:{ Exception -> 0x0024 }
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch:{ Exception -> 0x0024 }
            com.armmc.app.billing.BillingManager.cachedSupporterStatus = r1     // Catch:{ Exception -> 0x0024 }
            com.armmc.app.billing.BillingManager$Companion r1 = com.armmc.app.billing.BillingManager.Companion     // Catch:{ Exception -> 0x0024 }
            com.google.firebase.auth.FirebaseUser r1 = r10.$currentUser     // Catch:{ Exception -> 0x0024 }
            java.lang.String r1 = r1.getUid()     // Catch:{ Exception -> 0x0024 }
            com.armmc.app.billing.BillingManager.cachedUserId = r1     // Catch:{ Exception -> 0x0024 }
        L_0x00a1:
            boolean r11 = r11.isSupporter()     // Catch:{ Exception -> 0x0024 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0024 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0024 }
            java.lang.StringBuilder r11 = r1.append(r11)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0024 }
            android.util.Log.d(r6, r11)     // Catch:{ Exception -> 0x0024 }
            goto L_0x00d2
        L_0x00b6:
            java.lang.String r11 = r11.getError()     // Catch:{ Exception -> 0x0024 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0024 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0024 }
            java.lang.StringBuilder r11 = r0.append(r11)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0024 }
            android.util.Log.e(r6, r11)     // Catch:{ Exception -> 0x0024 }
            goto L_0x00d2
        L_0x00cb:
            java.lang.String r0 = "Error refreshing subscription"
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.e(r6, r0, r11)
        L_0x00d2:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.billing.BillingManager$refreshSubscriptionStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
