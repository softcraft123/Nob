package com.armmc.app.ui.profile;

import com.google.firebase.auth.FirebaseUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.profile.ClaimSubdomainFragment$claimSubdomain$1", f = "ClaimSubdomainFragment.kt", i = {}, l = {208, 218}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ClaimSubdomainFragment.kt */
final class ClaimSubdomainFragment$claimSubdomain$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FirebaseUser $user;
    int label;
    final /* synthetic */ ClaimSubdomainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClaimSubdomainFragment$claimSubdomain$1(ClaimSubdomainFragment claimSubdomainFragment, FirebaseUser firebaseUser, Continuation<? super ClaimSubdomainFragment$claimSubdomain$1> continuation) {
        super(2, continuation);
        this.this$0 = claimSubdomainFragment;
        this.$user = firebaseUser;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClaimSubdomainFragment$claimSubdomain$1(this.this$0, this.$user, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClaimSubdomainFragment$claimSubdomain$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        if (r7 == r0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x0098 }
            goto L_0x006b
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x0098 }
            goto L_0x003d
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x0098 }
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7     // Catch:{ Exception -> 0x0098 }
            com.armmc.app.ui.profile.ClaimSubdomainFragment$claimSubdomain$1$idToken$1 r1 = new com.armmc.app.ui.profile.ClaimSubdomainFragment$claimSubdomain$1$idToken$1     // Catch:{ Exception -> 0x0098 }
            com.google.firebase.auth.FirebaseUser r5 = r6.$user     // Catch:{ Exception -> 0x0098 }
            r1.<init>(r5, r2)     // Catch:{ Exception -> 0x0098 }
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch:{ Exception -> 0x0098 }
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ Exception -> 0x0098 }
            r6.label = r4     // Catch:{ Exception -> 0x0098 }
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r5)     // Catch:{ Exception -> 0x0098 }
            if (r7 != r0) goto L_0x003d
            goto L_0x006a
        L_0x003d:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0098 }
            if (r7 != 0) goto L_0x0050
            com.armmc.app.ui.profile.ClaimSubdomainFragment r7 = r6.this$0     // Catch:{ Exception -> 0x0098 }
            java.lang.String r0 = "Authentication error. Please try again."
            r7.showError(r0)     // Catch:{ Exception -> 0x0098 }
            com.armmc.app.ui.profile.ClaimSubdomainFragment r7 = r6.this$0     // Catch:{ Exception -> 0x0098 }
            r7.resetLoadingState()     // Catch:{ Exception -> 0x0098 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0098 }
            return r7
        L_0x0050:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x0098 }
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch:{ Exception -> 0x0098 }
            com.armmc.app.ui.profile.ClaimSubdomainFragment$claimSubdomain$1$result$1 r4 = new com.armmc.app.ui.profile.ClaimSubdomainFragment$claimSubdomain$1$result$1     // Catch:{ Exception -> 0x0098 }
            com.armmc.app.ui.profile.ClaimSubdomainFragment r5 = r6.this$0     // Catch:{ Exception -> 0x0098 }
            r4.<init>(r5, r7, r2)     // Catch:{ Exception -> 0x0098 }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ Exception -> 0x0098 }
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ Exception -> 0x0098 }
            r6.label = r3     // Catch:{ Exception -> 0x0098 }
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r7)     // Catch:{ Exception -> 0x0098 }
            if (r7 != r0) goto L_0x006b
        L_0x006a:
            return r0
        L_0x006b:
            com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse r7 = (com.armmc.app.api.SubdomainApiService.SubdomainClaimResponse) r7     // Catch:{ Exception -> 0x0098 }
            boolean r0 = r7.getSuccess()     // Catch:{ Exception -> 0x0098 }
            if (r0 == 0) goto L_0x0085
            com.armmc.app.ui.profile.ClaimSubdomainFragment r0 = r6.this$0     // Catch:{ Exception -> 0x0098 }
            java.lang.String r7 = r7.getSubdomain()     // Catch:{ Exception -> 0x0098 }
            if (r7 != 0) goto L_0x0081
            com.armmc.app.ui.profile.ClaimSubdomainFragment r7 = r6.this$0     // Catch:{ Exception -> 0x0098 }
            java.lang.String r7 = r7.currentSubdomain     // Catch:{ Exception -> 0x0098 }
        L_0x0081:
            r0.showSuccessDialog(r7)     // Catch:{ Exception -> 0x0098 }
            goto L_0x00a4
        L_0x0085:
            com.armmc.app.ui.profile.ClaimSubdomainFragment r0 = r6.this$0     // Catch:{ Exception -> 0x0098 }
            java.lang.String r7 = r7.getError()     // Catch:{ Exception -> 0x0098 }
            if (r7 != 0) goto L_0x008f
            java.lang.String r7 = "Failed to claim subdomain"
        L_0x008f:
            r0.showError(r7)     // Catch:{ Exception -> 0x0098 }
            com.armmc.app.ui.profile.ClaimSubdomainFragment r7 = r6.this$0     // Catch:{ Exception -> 0x0098 }
            r7.resetLoadingState()     // Catch:{ Exception -> 0x0098 }
            goto L_0x00a4
        L_0x0098:
            com.armmc.app.ui.profile.ClaimSubdomainFragment r7 = r6.this$0
            java.lang.String r0 = "Network error. Please try again."
            r7.showError(r0)
            com.armmc.app.ui.profile.ClaimSubdomainFragment r7 = r6.this$0
            r7.resetLoadingState()
        L_0x00a4:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.profile.ClaimSubdomainFragment$claimSubdomain$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
