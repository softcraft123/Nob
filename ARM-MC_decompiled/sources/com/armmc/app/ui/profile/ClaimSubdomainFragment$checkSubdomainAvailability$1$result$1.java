package com.armmc.app.ui.profile;

import com.armmc.app.api.SubdomainApiService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/armmc/app/api/SubdomainApiService$SubdomainAvailabilityResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.profile.ClaimSubdomainFragment$checkSubdomainAvailability$1$result$1", f = "ClaimSubdomainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ClaimSubdomainFragment.kt */
final class ClaimSubdomainFragment$checkSubdomainAvailability$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SubdomainApiService.SubdomainAvailabilityResponse>, Object> {
    final /* synthetic */ String $idToken;
    final /* synthetic */ String $subdomain;
    int label;
    final /* synthetic */ ClaimSubdomainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClaimSubdomainFragment$checkSubdomainAvailability$1$result$1(ClaimSubdomainFragment claimSubdomainFragment, String str, String str2, Continuation<? super ClaimSubdomainFragment$checkSubdomainAvailability$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = claimSubdomainFragment;
        this.$idToken = str;
        this.$subdomain = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClaimSubdomainFragment$checkSubdomainAvailability$1$result$1(this.this$0, this.$idToken, this.$subdomain, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SubdomainApiService.SubdomainAvailabilityResponse> continuation) {
        return ((ClaimSubdomainFragment$checkSubdomainAvailability$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.subdomainApi.checkSubdomainAvailability(this.$idToken, this.$subdomain);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
