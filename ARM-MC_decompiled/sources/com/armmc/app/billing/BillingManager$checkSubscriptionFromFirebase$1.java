package com.armmc.app.billing;

import android.util.Log;
import com.armmc.app.billing.BillingManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1", f = "BillingManager.kt", i = {}, l = {391, 397}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BillingManager.kt */
final class BillingManager$checkSubscriptionFromFirebase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ FirebaseUser $currentUser;
    int label;
    final /* synthetic */ BillingManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingManager$checkSubscriptionFromFirebase$1(FirebaseUser firebaseUser, Function1<? super Boolean, Unit> function1, BillingManager billingManager, Continuation<? super BillingManager$checkSubscriptionFromFirebase$1> continuation) {
        super(2, continuation);
        this.$currentUser = firebaseUser;
        this.$callback = function1;
        this.this$0 = billingManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BillingManager$checkSubscriptionFromFirebase$1(this.$currentUser, this.$callback, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BillingManager$checkSubscriptionFromFirebase$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        if (r11 == r1) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.String r0 = "Cached supporter status for user: "
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            java.lang.String r3 = "BillingManager"
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0026
            if (r2 == r6) goto L_0x001f
            if (r2 != r4) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0070
        L_0x0017:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0040
        L_0x0023:
            r11 = move-exception
            goto L_0x0104
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r11)
            com.google.firebase.auth.FirebaseUser r11 = r10.$currentUser     // Catch:{ Exception -> 0x0023 }
            com.google.android.gms.tasks.Task r11 = r11.getIdToken(r5)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = "getIdToken(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)     // Catch:{ Exception -> 0x0023 }
            r2 = r10
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ Exception -> 0x0023 }
            r10.label = r6     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r11 = kotlinx.coroutines.tasks.TasksKt.await(r11, r2)     // Catch:{ Exception -> 0x0023 }
            if (r11 != r1) goto L_0x0040
            goto L_0x006f
        L_0x0040:
            com.google.firebase.auth.GetTokenResult r11 = (com.google.firebase.auth.GetTokenResult) r11     // Catch:{ Exception -> 0x0023 }
            java.lang.String r11 = r11.getToken()     // Catch:{ Exception -> 0x0023 }
            if (r11 != 0) goto L_0x0054
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r11 = r10.$callback     // Catch:{ Exception -> 0x0023 }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch:{ Exception -> 0x0023 }
            r11.invoke(r0)     // Catch:{ Exception -> 0x0023 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0023 }
            return r11
        L_0x0054:
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x0023 }
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch:{ Exception -> 0x0023 }
            com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1$response$1 r7 = new com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1$response$1     // Catch:{ Exception -> 0x0023 }
            com.armmc.app.billing.BillingManager r8 = r10.this$0     // Catch:{ Exception -> 0x0023 }
            r9 = 0
            r7.<init>(r8, r11, r9)     // Catch:{ Exception -> 0x0023 }
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ Exception -> 0x0023 }
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ Exception -> 0x0023 }
            r10.label = r4     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r2, r7, r11)     // Catch:{ Exception -> 0x0023 }
            if (r11 != r1) goto L_0x0070
        L_0x006f:
            return r1
        L_0x0070:
            com.armmc.app.api.SubscriptionApiService$SubscriptionStatusResponse r11 = (com.armmc.app.api.SubscriptionApiService.SubscriptionStatusResponse) r11     // Catch:{ Exception -> 0x0023 }
            boolean r1 = r11.getSuccess()     // Catch:{ Exception -> 0x0023 }
            if (r1 == 0) goto L_0x00c7
            com.armmc.app.billing.BillingManager r1 = r10.this$0     // Catch:{ Exception -> 0x0023 }
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1._isSupporter     // Catch:{ Exception -> 0x0023 }
            boolean r2 = r11.isSupporter()     // Catch:{ Exception -> 0x0023 }
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)     // Catch:{ Exception -> 0x0023 }
            r1.setValue(r2)     // Catch:{ Exception -> 0x0023 }
            boolean r1 = r11.isSupporter()     // Catch:{ Exception -> 0x0023 }
            if (r1 == 0) goto L_0x00b9
            com.armmc.app.billing.BillingManager$Companion r1 = com.armmc.app.billing.BillingManager.Companion     // Catch:{ Exception -> 0x0023 }
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch:{ Exception -> 0x0023 }
            com.armmc.app.billing.BillingManager.cachedSupporterStatus = r1     // Catch:{ Exception -> 0x0023 }
            com.armmc.app.billing.BillingManager$Companion r1 = com.armmc.app.billing.BillingManager.Companion     // Catch:{ Exception -> 0x0023 }
            com.google.firebase.auth.FirebaseUser r1 = r10.$currentUser     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = r1.getUid()     // Catch:{ Exception -> 0x0023 }
            com.armmc.app.billing.BillingManager.cachedUserId = r1     // Catch:{ Exception -> 0x0023 }
            com.google.firebase.auth.FirebaseUser r1 = r10.$currentUser     // Catch:{ Exception -> 0x0023 }
            java.lang.String r1 = r1.getUid()     // Catch:{ Exception -> 0x0023 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0023 }
            java.lang.StringBuilder r0 = r2.append(r1)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0023 }
            android.util.Log.d(r3, r0)     // Catch:{ Exception -> 0x0023 }
        L_0x00b9:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r0 = r10.$callback     // Catch:{ Exception -> 0x0023 }
            boolean r11 = r11.isSupporter()     // Catch:{ Exception -> 0x0023 }
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)     // Catch:{ Exception -> 0x0023 }
            r0.invoke(r11)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0114
        L_0x00c7:
            com.armmc.app.billing.BillingManager r11 = r10.this$0     // Catch:{ Exception -> 0x0023 }
            com.google.firebase.firestore.FirebaseFirestore r11 = r11.firestore     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = "users"
            com.google.firebase.firestore.CollectionReference r11 = r11.collection(r0)     // Catch:{ Exception -> 0x0023 }
            com.google.firebase.auth.FirebaseUser r0 = r10.$currentUser     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = r0.getUid()     // Catch:{ Exception -> 0x0023 }
            com.google.firebase.firestore.DocumentReference r11 = r11.document(r0)     // Catch:{ Exception -> 0x0023 }
            com.google.android.gms.tasks.Task r11 = r11.get()     // Catch:{ Exception -> 0x0023 }
            com.armmc.app.billing.BillingManager r0 = r10.this$0     // Catch:{ Exception -> 0x0023 }
            com.google.firebase.auth.FirebaseUser r1 = r10.$currentUser     // Catch:{ Exception -> 0x0023 }
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r2 = r10.$callback     // Catch:{ Exception -> 0x0023 }
            com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda0 r4 = new com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x0023 }
            r4.<init>(r0, r1, r2)     // Catch:{ Exception -> 0x0023 }
            com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda1 r0 = new com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda1     // Catch:{ Exception -> 0x0023 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0023 }
            com.google.android.gms.tasks.Task r11 = r11.addOnSuccessListener(r0)     // Catch:{ Exception -> 0x0023 }
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r0 = r10.$callback     // Catch:{ Exception -> 0x0023 }
            com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda2 r1 = new com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda2     // Catch:{ Exception -> 0x0023 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0023 }
            com.google.android.gms.tasks.Task r11 = r11.addOnFailureListener(r1)     // Catch:{ Exception -> 0x0023 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0114
        L_0x0104:
            java.lang.String r0 = "Error checking subscription status"
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.e(r3, r0, r11)
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r11 = r10.$callback
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r11.invoke(r0)
        L_0x0114:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(BillingManager billingManager, FirebaseUser firebaseUser, Function1 function1, DocumentSnapshot documentSnapshot) {
        Boolean bool = documentSnapshot.getBoolean(UserSubscriptionManager.FIELD_IS_SUPPORTER);
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        billingManager._isSupporter.setValue(Boolean.valueOf(booleanValue));
        if (booleanValue) {
            BillingManager.Companion companion = BillingManager.Companion;
            BillingManager.cachedSupporterStatus = true;
            BillingManager.Companion companion2 = BillingManager.Companion;
            BillingManager.cachedUserId = firebaseUser.getUid();
            Log.d("BillingManager", "Cached supporter status from Firestore for user: " + firebaseUser.getUid());
        }
        function1.invoke(Boolean.valueOf(booleanValue));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2(Function1 function1, Exception exc) {
        Log.e("BillingManager", "Failed to fetch subscription status", exc);
        function1.invoke(false);
    }
}
