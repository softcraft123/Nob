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
@DebugMetadata(c = "com.armmc.app.ui.profile.ClaimSubdomainFragment$checkSubdomainAvailability$1", f = "ClaimSubdomainFragment.kt", i = {}, l = {124, 133}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ClaimSubdomainFragment.kt */
final class ClaimSubdomainFragment$checkSubdomainAvailability$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subdomain;
    final /* synthetic */ FirebaseUser $user;
    int label;
    final /* synthetic */ ClaimSubdomainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClaimSubdomainFragment$checkSubdomainAvailability$1(ClaimSubdomainFragment claimSubdomainFragment, String str, FirebaseUser firebaseUser, Continuation<? super ClaimSubdomainFragment$checkSubdomainAvailability$1> continuation) {
        super(2, continuation);
        this.this$0 = claimSubdomainFragment;
        this.$subdomain = str;
        this.$user = firebaseUser;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClaimSubdomainFragment$checkSubdomainAvailability$1(this.this$0, this.$subdomain, this.$user, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClaimSubdomainFragment$checkSubdomainAvailability$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r9 == r0) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x00ba }
            goto L_0x0068
        L_0x0013:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x00ba }
            goto L_0x003d
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x00ba }
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9     // Catch:{ Exception -> 0x00ba }
            com.armmc.app.ui.profile.ClaimSubdomainFragment$checkSubdomainAvailability$1$idToken$1 r1 = new com.armmc.app.ui.profile.ClaimSubdomainFragment$checkSubdomainAvailability$1$idToken$1     // Catch:{ Exception -> 0x00ba }
            com.google.firebase.auth.FirebaseUser r5 = r8.$user     // Catch:{ Exception -> 0x00ba }
            r1.<init>(r5, r2)     // Catch:{ Exception -> 0x00ba }
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch:{ Exception -> 0x00ba }
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ Exception -> 0x00ba }
            r8.label = r4     // Catch:{ Exception -> 0x00ba }
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r1, r5)     // Catch:{ Exception -> 0x00ba }
            if (r9 != r0) goto L_0x003d
            goto L_0x0067
        L_0x003d:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x00ba }
            if (r9 != 0) goto L_0x004b
            com.armmc.app.ui.profile.ClaimSubdomainFragment r9 = r8.this$0     // Catch:{ Exception -> 0x00ba }
            java.lang.String r0 = "Authentication error"
            r9.showValidationError(r0)     // Catch:{ Exception -> 0x00ba }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00ba }
            return r9
        L_0x004b:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x00ba }
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch:{ Exception -> 0x00ba }
            com.armmc.app.ui.profile.ClaimSubdomainFragment$checkSubdomainAvailability$1$result$1 r5 = new com.armmc.app.ui.profile.ClaimSubdomainFragment$checkSubdomainAvailability$1$result$1     // Catch:{ Exception -> 0x00ba }
            com.armmc.app.ui.profile.ClaimSubdomainFragment r6 = r8.this$0     // Catch:{ Exception -> 0x00ba }
            java.lang.String r7 = r8.$subdomain     // Catch:{ Exception -> 0x00ba }
            r5.<init>(r6, r9, r7, r2)     // Catch:{ Exception -> 0x00ba }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ Exception -> 0x00ba }
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ Exception -> 0x00ba }
            r8.label = r3     // Catch:{ Exception -> 0x00ba }
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r5, r9)     // Catch:{ Exception -> 0x00ba }
            if (r9 != r0) goto L_0x0068
        L_0x0067:
            return r0
        L_0x0068:
            com.armmc.app.api.SubdomainApiService$SubdomainAvailabilityResponse r9 = (com.armmc.app.api.SubdomainApiService.SubdomainAvailabilityResponse) r9     // Catch:{ Exception -> 0x00ba }
            java.lang.String r0 = r8.$subdomain     // Catch:{ Exception -> 0x00ba }
            com.armmc.app.ui.profile.ClaimSubdomainFragment r1 = r8.this$0     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = r1.currentSubdomain     // Catch:{ Exception -> 0x00ba }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x00ba }
            if (r0 != 0) goto L_0x007b
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00ba }
            return r9
        L_0x007b:
            boolean r0 = r9.getAvailable()     // Catch:{ Exception -> 0x00ba }
            if (r0 == 0) goto L_0x00a1
            com.armmc.app.ui.profile.ClaimSubdomainFragment r9 = r8.this$0     // Catch:{ Exception -> 0x00ba }
            java.lang.String r0 = r8.$subdomain     // Catch:{ Exception -> 0x00ba }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r1.<init>()     // Catch:{ Exception -> 0x00ba }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = ".witherhost.com is available!"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00ba }
            r9.showAvailabilitySuccess(r0)     // Catch:{ Exception -> 0x00ba }
            com.armmc.app.ui.profile.ClaimSubdomainFragment r9 = r8.this$0     // Catch:{ Exception -> 0x00ba }
            r9.isSubdomainAvailable = r4     // Catch:{ Exception -> 0x00ba }
            goto L_0x00b4
        L_0x00a1:
            com.armmc.app.ui.profile.ClaimSubdomainFragment r0 = r8.this$0     // Catch:{ Exception -> 0x00ba }
            java.lang.String r9 = r9.getReason()     // Catch:{ Exception -> 0x00ba }
            if (r9 != 0) goto L_0x00ab
            java.lang.String r9 = "Subdomain not available"
        L_0x00ab:
            r0.showValidationError(r9)     // Catch:{ Exception -> 0x00ba }
            com.armmc.app.ui.profile.ClaimSubdomainFragment r9 = r8.this$0     // Catch:{ Exception -> 0x00ba }
            r0 = 0
            r9.isSubdomainAvailable = r0     // Catch:{ Exception -> 0x00ba }
        L_0x00b4:
            com.armmc.app.ui.profile.ClaimSubdomainFragment r9 = r8.this$0     // Catch:{ Exception -> 0x00ba }
            r9.updateClaimButtonState()     // Catch:{ Exception -> 0x00ba }
            goto L_0x00cf
        L_0x00ba:
            java.lang.String r9 = r8.$subdomain
            com.armmc.app.ui.profile.ClaimSubdomainFragment r0 = r8.this$0
            java.lang.String r0 = r0.currentSubdomain
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r0)
            if (r9 == 0) goto L_0x00cf
            com.armmc.app.ui.profile.ClaimSubdomainFragment r9 = r8.this$0
            java.lang.String r0 = "Could not check availability"
            r9.showValidationError(r0)
        L_0x00cf:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.profile.ClaimSubdomainFragment$checkSubdomainAvailability$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
