package com.armmc.app.ui.onboarding;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.credentials.CredentialManager;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialException;
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
@DebugMetadata(c = "com.armmc.app.ui.onboarding.OnboardingFragment$signInWithGoogle$1", f = "OnboardingFragment.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OnboardingFragment.kt */
final class OnboardingFragment$signInWithGoogle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetCredentialRequest $request;
    int label;
    final /* synthetic */ OnboardingFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnboardingFragment$signInWithGoogle$1(OnboardingFragment onboardingFragment, GetCredentialRequest getCredentialRequest, Continuation<? super OnboardingFragment$signInWithGoogle$1> continuation) {
        super(2, continuation);
        this.this$0 = onboardingFragment;
        this.$request = getCredentialRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingFragment$signInWithGoogle$1(this.this$0, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingFragment$signInWithGoogle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CredentialManager access$getCredentialManager$p = this.this$0.credentialManager;
            if (access$getCredentialManager$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("credentialManager");
                access$getCredentialManager$p = null;
            }
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            this.label = 1;
            obj = access$getCredentialManager$p.getCredential(requireContext, this.$request, (Continuation<? super GetCredentialResponse>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (GetCredentialException e) {
                Log.e("OnboardingFragment", "Google Sign-In failed", e);
                if (this.this$0.isAdded()) {
                    Toast.makeText(this.this$0.requireContext(), "Google Sign-In failed: " + e.getMessage(), 0).show();
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.handleSignInResult((GetCredentialResponse) obj);
        return Unit.INSTANCE;
    }
}
