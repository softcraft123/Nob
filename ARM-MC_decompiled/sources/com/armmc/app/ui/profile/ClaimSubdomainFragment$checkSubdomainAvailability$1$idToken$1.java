package com.armmc.app.ui.profile;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.profile.ClaimSubdomainFragment$checkSubdomainAvailability$1$idToken$1", f = "ClaimSubdomainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ClaimSubdomainFragment.kt */
final class ClaimSubdomainFragment$checkSubdomainAvailability$1$idToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ FirebaseUser $user;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClaimSubdomainFragment$checkSubdomainAvailability$1$idToken$1(FirebaseUser firebaseUser, Continuation<? super ClaimSubdomainFragment$checkSubdomainAvailability$1$idToken$1> continuation) {
        super(2, continuation);
        this.$user = firebaseUser;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClaimSubdomainFragment$checkSubdomainAvailability$1$idToken$1(this.$user, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ClaimSubdomainFragment$checkSubdomainAvailability$1$idToken$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GetTokenResult getTokenResult = (GetTokenResult) Tasks.await(this.$user.getIdToken(false));
            if (getTokenResult != null) {
                return getTokenResult.getToken();
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
